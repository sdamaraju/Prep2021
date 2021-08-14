import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MeetingProblemSolution {

    static class Meeting implements Comparable{
        Long start;
        Long end;
        List<Integer> users;
        Meeting(Long start, Long end, List<Integer> users){
            this.start = start;
            this.end = end;
            this.users = users;
        }

        @Override
        public int compareTo(Object o) {
            Meeting x = (Meeting)o;
            return x.start.compareTo(((Meeting) o).start);
        }
    }

    static HashMap<Integer, List<Meeting>> bookings;
    static HashMap<Integer, List<Meeting>> userBookings;
    public static void main(String[] args) {
        bookings = new HashMap<>();
        userBookings = new HashMap<>();
    }

    public synchronized void book(Long start, Long end, List<Integer> users){
        int roomId = -1;
        for(Map.Entry<Integer, List<Meeting>> entry : bookings.entrySet()){
            boolean isSlotAvailableForRoom = isSlotAvailable(entry.getValue(),start,end);
            if(isSlotAvailableForRoom){
                roomId = entry.getKey();
                break;
            }else continue;
        }
        Meeting meet = new Meeting(start, end, users);
        bookings.get(roomId).add(meet);
        for(int userId: users) userBookings.get(userId).add(meet);
    }

    public List<Meeting> getUserMeetings(int userId){
        return userBookings.get(userId);
    }

    public synchronized Long getNextAvailableTimeSlot(List<Meeting> meetings, Long start, Long duration){
        Long nextSlot = null;
        Integer index = null;
        boolean meetAtSameTimeExists = false;
        try {
            index = search(0, meetings.size(), start, meetings);
        } catch (Exception e){
            index = Integer.parseInt(e.getMessage().substring(e.getMessage().length()-1));
            meetAtSameTimeExists = true;
        }
        if(meetAtSameTimeExists){
                Meeting prev = meetings.get(index);
                for(int i=index+1;i<meetings.size();i++){
                    if((prev.end + duration) < meetings.get(i).start){
                        return prev.end;
                    } else {
                        prev = meetings.get(i);
                        continue;
                    }
                }
            return meetings.get(meetings.size()-1).end;
        } else {
            Meeting prev;
            if(index == -1) {
                if (start + duration < meetings.get(0).start) return start;
                prev = meetings.get(0);
            } else if (index == meetings.size()-1){
                return meetings.get(meetings.size()-1).end;
            } else {
                prev = meetings.get(index);
            }
            for (int i = index+1; i < meetings.size(); i++) {
                Meeting meet = meetings.get(i);
                if(prev.end + duration < meet.start) return prev.end;
                else {
                    prev = meet;
                    continue;
                }
            }
        }
        return meetings.get(meetings.size()-1).end;
    }

    private synchronized boolean isSlotAvailable(List<Meeting> meetings, Long start, Long end) {
        try {
            int index = search(0,meetings.size(),start, meetings);
            if(index != -1){
                Meeting prev = meetings.get(index);
                if(prev.end > start) return false;
            }
            if(index+1 < meetings.size()) {
                Meeting next = meetings.get(index + 1);
                if(end > next.start) return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private static int search(int l, int r, Long key, List<Meeting> list) throws Exception {
        if(l>r) return l-1;
        int mid = (l + r)/2;
        Long midV = list.get(mid).start;
        if(midV == key) throw new Exception("Slot already taken at index " +mid);
        if(midV > key){
            return search(l, mid-1, key, list);
        } else return search(mid+1, r, key, list);
    }

}













/*
    Build the concept of a meeting room that is bookable for people at times.
        Constraint:
        a) one meeting be booked per time slot
        b) a meeting can multiple participants



        API needs to allow booking of meetings.


        retrieve of meetings by person.
*/
