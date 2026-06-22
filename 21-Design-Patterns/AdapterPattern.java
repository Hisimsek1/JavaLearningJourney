public class AdapterPattern {

    interface TurkishSocket {
        void providePower220V();
    }

    interface AmericanSocket {
        void providePower110V();
    }

    static class TurkishOutlet implements TurkishSocket {
        public void providePower220V() {
            System.out.println("Turkish outlet: 220V AC power provided");
        }
    }

    static class PowerAdapter implements AmericanSocket {
        private TurkishSocket turkishSocket;

        PowerAdapter(TurkishSocket socket) {
            this.turkishSocket = socket;
        }

        public void providePower110V() {
            System.out.println("Adapter: converting 220V -> 110V");
            turkishSocket.providePower220V();
            System.out.println("Adapter: device receiving 110V");
        }
    }

    interface PaymentGateway {
        boolean pay(String cardNumber, double amount);
        boolean refund(String transactionId);
    }

    static class OldPaymentSystem {
        public int processCard(long cardNum, int amountCents) {
            System.out.println("OldSystem: processing card " + cardNum + " for " + amountCents + " cents");
            return (int) (Math.random() * 900000 + 100000);
        }

        public boolean reverseTransaction(int txId) {
            System.out.println("OldSystem: reversing transaction " + txId);
            return true;
        }
    }

    static class PaymentAdapter implements PaymentGateway {
        private OldPaymentSystem legacySystem;

        PaymentAdapter(OldPaymentSystem system) {
            this.legacySystem = system;
        }

        public boolean pay(String cardNumber, double amount) {
            long card = Long.parseLong(cardNumber.replaceAll("-", ""));
            int cents = (int) (amount * 100);
            int txId = legacySystem.processCard(card, cents);
            System.out.println("Payment successful, txId: " + txId);
            return txId > 0;
        }

        public boolean refund(String transactionId) {
            return legacySystem.reverseTransaction(Integer.parseInt(transactionId));
        }
    }

    public static void main(String[] args) {
        TurkishSocket socket = new TurkishOutlet();
        AmericanSocket adapter = new PowerAdapter(socket);
        adapter.providePower110V();

        System.out.println();

        PaymentGateway payment = new PaymentAdapter(new OldPaymentSystem());
        payment.pay("4111-1111-1111-1111", 199.99);
        payment.refund("123456");
    }
}
