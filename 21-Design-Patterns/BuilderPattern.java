public class BuilderPattern {

    static class Pizza {
        private String size;
        private String crust;
        private String sauce;
        private boolean cheese;
        private boolean pepperoni;
        private boolean mushrooms;
        private boolean olives;
        private boolean extraCheese;

        private Pizza() {}

        public static class Builder {
            private Pizza pizza = new Pizza();

            public Builder size(String size) {
                pizza.size = size;
                return this;
            }

            public Builder crust(String crust) {
                pizza.crust = crust;
                return this;
            }

            public Builder sauce(String sauce) {
                pizza.sauce = sauce;
                return this;
            }

            public Builder cheese() {
                pizza.cheese = true;
                return this;
            }

            public Builder pepperoni() {
                pizza.pepperoni = true;
                return this;
            }

            public Builder mushrooms() {
                pizza.mushrooms = true;
                return this;
            }

            public Builder olives() {
                pizza.olives = true;
                return this;
            }

            public Builder extraCheese() {
                pizza.extraCheese = true;
                return this;
            }

            public Pizza build() {
                if (pizza.size == null) throw new IllegalStateException("Size required");
                if (pizza.crust == null) pizza.crust = "thin";
                if (pizza.sauce == null) pizza.sauce = "tomato";
                return pizza;
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(size).append(" pizza | crust: ").append(crust).append(" | sauce: ").append(sauce);
            sb.append(" | toppings:");
            if (cheese) sb.append(" cheese");
            if (pepperoni) sb.append(" pepperoni");
            if (mushrooms) sb.append(" mushrooms");
            if (olives) sb.append(" olives");
            if (extraCheese) sb.append(" extra-cheese");
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Pizza margherita = new Pizza.Builder()
            .size("medium")
            .crust("thin")
            .sauce("tomato")
            .cheese()
            .build();

        Pizza deluxe = new Pizza.Builder()
            .size("large")
            .crust("thick")
            .sauce("bbq")
            .cheese()
            .pepperoni()
            .mushrooms()
            .olives()
            .extraCheese()
            .build();

        Pizza simple = new Pizza.Builder()
            .size("small")
            .build();

        System.out.println(margherita);
        System.out.println(deluxe);
        System.out.println(simple);
    }
}
