public class SingletonPattern {

    static class DatabaseConnection {
        private static DatabaseConnection instance;
        private String connectionUrl;

        private DatabaseConnection(String url) {
            this.connectionUrl = url;
        }

        public static DatabaseConnection getInstance() {
            if (instance == null) {
                synchronized (DatabaseConnection.class) {
                    if (instance == null) {
                        instance = new DatabaseConnection("jdbc:mysql://localhost:3306/mydb");
                    }
                }
            }
            return instance;
        }

        public String getUrl() {
            return connectionUrl;
        }

        public void query(String sql) {
            System.out.println("[" + connectionUrl + "] Executing: " + sql);
        }
    }

    public static void main(String[] args) {
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();

        System.out.println("Same instance: " + (db1 == db2));
        db1.query("SELECT * FROM users");
        db2.query("INSERT INTO orders VALUES (1, 'item')");
        System.out.println("URL: " + db1.getUrl());
    }
}
