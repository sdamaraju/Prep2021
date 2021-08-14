package CoreJavaPreparation;

public class EqualsContracts {

    class Money {
        int amount;
        String currencyCode;

        Money(int amount, String cc) {
            this.amount = amount;
            this.currencyCode = cc;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this)
                return true;
            if (!(o instanceof Money))
                return false;
            Money other = (Money) o;
            boolean currencyCodeEquals = (this.currencyCode == null && other.currencyCode == null)
                    || (this.currencyCode != null && this.currencyCode.equals(other.currencyCode));
            return this.amount == other.amount && currencyCodeEquals;
        }
    }

    class WrongVoucher extends Money {

        private String store;

        WrongVoucher(int amount, String cc, String store) {
            super(amount, cc);
            this.store = store;
        }


        @Override
        public boolean equals(Object o) {
            if (o == this)
                return true;
            if (!(o instanceof WrongVoucher)) {
                return false;
            }
            WrongVoucher other = (WrongVoucher) o;
            boolean currencyCodeEquals = (this.currencyCode == null && other.currencyCode == null)
                    || (this.currencyCode != null && this.currencyCode.equals(other.currencyCode));
            boolean storeEquals = (this.store == null && other.store == null)
                    || (this.store != null && this.store.equals(other.store));
            return this.amount == other.amount && currencyCodeEquals && storeEquals;
        }

        // other methods
    }

    class Money_Fix {
        int amount;
        String currencyCode;

        Money_Fix(int amount, String cc) {
            this.amount = amount;
            this.currencyCode = cc;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this)
                return true;
            if (!(o instanceof Money))
                return false;
            Money other = (Money) o;
            boolean currencyCodeEquals = (this.currencyCode == null && other.currencyCode == null)
                    || (this.currencyCode != null && this.currencyCode.equals(other.currencyCode));
            return this.amount == other.amount && currencyCodeEquals;
        }
    }

    class WrongVoucher_Fix {

        private Money_Fix value;
        private String store;

        WrongVoucher_Fix(int amount, String cc, String store) {
            this.value = new Money_Fix(amount,cc);
            this.store = store;
        }


        @Override
        public boolean equals(Object o) {
            if (o == this)
                return true;
            if (!(o instanceof WrongVoucher_Fix)) {
                return false;
            }
            WrongVoucher_Fix other = (WrongVoucher_Fix) o;
            boolean valueEquals = (this.value == null && other.value == null)
                    || (this.value != null && this.value.equals(other.value));
            boolean storeEquals = (this.store == null && other.store == null)
                    || (this.store != null && this.store.equals(other.store));
            return valueEquals && storeEquals;
        }

        // other methods
    }

    public static void main(String[] args) {
        EqualsContracts impl = new EqualsContracts();
        Money cash = impl.new Money(42, "USD");
        WrongVoucher voucher = impl.new WrongVoucher(42, "USD", "Amazon");

        System.out.println(voucher.equals(cash));
        System.out.println(cash.equals(voucher));
        System.out.println(voucher instanceof Money);
        System.out.println("Equals contract failed..");

        Money_Fix cash2 = impl.new Money_Fix(42, "USD");
        WrongVoucher_Fix voucher2 = impl.new WrongVoucher_Fix(42, "USD", "Amazon");

        System.out.println(voucher2.equals(cash2));
        System.out.println(cash2.equals(voucher2));
        System.out.println("Equals contract survives..");
    }


}
