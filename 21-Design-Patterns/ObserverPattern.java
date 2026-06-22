import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {

    interface Observer {
        void update(String event, Object data);
    }

    interface Subject {
        void subscribe(Observer o);
        void unsubscribe(Observer o);
        void notify(String event, Object data);
    }

    static class StockMarket implements Subject {
        private List<Observer> observers = new ArrayList<>();
        private String symbol;
        private double price;

        StockMarket(String symbol, double price) {
            this.symbol = symbol;
            this.price = price;
        }

        public void subscribe(Observer o) {
            observers.add(o);
        }

        public void unsubscribe(Observer o) {
            observers.remove(o);
        }

        public void notify(String event, Object data) {
            for (Observer o : observers) {
                o.update(event, data);
            }
        }

        public void setPrice(double newPrice) {
            double change = newPrice - price;
            price = newPrice;
            notify("PRICE_CHANGE", symbol + " -> " + newPrice + " (" + (change > 0 ? "+" : "") + String.format("%.2f", change) + ")");
        }
    }

    static class EmailAlert implements Observer {
        private String email;

        EmailAlert(String email) {
            this.email = email;
        }

        public void update(String event, Object data) {
            System.out.println("[EMAIL -> " + email + "] " + event + ": " + data);
        }
    }

    static class SmsAlert implements Observer {
        private String phone;

        SmsAlert(String phone) {
            this.phone = phone;
        }

        public void update(String event, Object data) {
            System.out.println("[SMS -> " + phone + "] " + event + ": " + data);
        }
    }

    public static void main(String[] args) {
        StockMarket apple = new StockMarket("AAPL", 150.0);

        EmailAlert emailUser = new EmailAlert("investor@mail.com");
        SmsAlert smsUser = new SmsAlert("+905001234567");

        apple.subscribe(emailUser);
        apple.subscribe(smsUser);

        apple.setPrice(155.50);
        apple.setPrice(148.75);

        apple.unsubscribe(smsUser);
        apple.setPrice(160.00);
    }
}
