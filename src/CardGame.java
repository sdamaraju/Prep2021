import java.util.*;

public class CardGame {

    public List<Card> deckOfCards = new ArrayList();

    static class Card implements Comparable {
        int number;
        char type;

        Card(int number, char type) {
            this.number = number;
            this.type = type;
        }

        public String toString() {
            return (this.number + " " + this.type + " ,");
        }

        @Override
        public int compareTo(Object o) {
            Card c = (Card) o;
            return this.number - ((Card) o).number;
        }
    }

    public List<Card> initializeCards(int numberOfDecks) {
        for (int k = 0; k < numberOfDecks; k++) {
            for (int i = 1; i < 14; i++) {
                for (int j = 0; j < 4; j++) {
                    deckOfCards.add(new Card(i, getCardType(j)));
                }
            }
        }
        return deckOfCards;
    }

    public Card deal(List<Card> deckOfCards) {
        return deckOfCards.remove(0);
    }

    public void shuffle(List<Card> deckOfCards) {
        Random rnd = new Random();
        for (int i = deckOfCards.size() - 1; i >= 0; i--) {
            swap(deckOfCards, i, rnd.nextInt(52));
        }
    }

    private void swap(List<Card> deckOfCards, int i, int randInt) {
        Card temp = deckOfCards.get(i);
        deckOfCards.set(i, deckOfCards.get(randInt));
        deckOfCards.set(randInt, temp);
    }

    private static char getCardType(int x) {
        if (x == 0) return 'c';
        else if (x == 1) return 's';
        else if (x == 2) return 'h';
        else return 'd';
    }

    static class BlackJack extends CardGame {
        Integer max = Integer.MIN_VALUE;
        static HashMap<Integer, List<Card>> playerAndCards = new HashMap();

        public static void main(String[] args) {
            BlackJack bj = new BlackJack();
            List<Card> cards = bj.initializeCards(1);
            bj.shuffle(cards);

            List<Integer> players = new ArrayList();
            players.add(1);
            players.add(2);
            boolean busted = bj.playBJ(cards, players);
            if (busted) return;
            bj.processAndGetWinners();
        }

        public boolean playBJ(List<Card> cards, List<Integer> players) {
            List<Card> playerCards = new ArrayList();
            playerCards.add(this.deal(cards));
            playerCards.add(this.deal(cards));
            playerAndCards.put(1, playerCards);
            List<Card> dealerCards = new ArrayList();
            dealerCards.add(this.deal(cards));
            dealerCards.add(this.deal(cards));
            playerAndCards.put(2, dealerCards);
            for (int i = 1; i <= 2; i++) {
                boolean stand = false;
                while (!stand) {
                    System.out.println("Player " + i + " Current Score is " + getCardsScore(playerAndCards.get(i)) + " " + playerAndCards.get(i));
                    System.out.println("Press 0 to hit and any other key to stand");
                    Scanner sc = new Scanner(System.in);
                    String input = sc.next();
                    if (input.equals("0")) {
                        playerAndCards.get(i).add(this.deal(cards));
                        if (getCardsScore(playerAndCards.get(i)) > 21) {
                            System.out.println("Busted, Other player wins");
                            return true;
                        }
                    } else {
                        stand = true;
                    }
                }
            }
            return false;
        }

        public void processAndGetWinners() {
            int p1 = 0, p2 = 0;
            for (Map.Entry entry : playerAndCards.entrySet()) {
                if (p1 == 0) p1 = this.getCardsScore((List<Card>) entry.getValue());
                else p2 = this.getCardsScore((List<Card>) entry.getValue());
            }
            if (p1 > p2) System.out.println("Player 1 wins");
            else if (p1 == p2) System.out.println("Tie");
            else System.out.println("Dealer wins");
        }

        public int getCardsScore(List<Card> cards) {
            int sum = 0;
            int countOf1s = 0;
            for (Card card : cards) {
                if (card.number == 1) {
                    countOf1s++;
                } else sum = sum + (card.number >= 10 ? 10 : card.number);
            }
            max = Integer.MIN_VALUE;
            if(countOf1s > 0) sum = getMaxPossibleSum(sum, countOf1s);
            return sum;
        }

        private int getMaxPossibleSum(int sum, int count) {
            if(sum > 10) return sum + count;
            if ((21 - sum) % 11 < count - 1) return sum + count;
            else return sum + 11 + count - 1;
        }
    }
}

