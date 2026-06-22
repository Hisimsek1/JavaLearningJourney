public class DecoratorPattern {

    interface Coffee {
        String getDescription();
        double getCost();
    }

    static class SimpleCoffee implements Coffee {
        public String getDescription() { return "Coffee"; }
        public double getCost() { return 10.0; }
    }

    static abstract class CoffeeDecorator implements Coffee {
        protected Coffee coffee;

        CoffeeDecorator(Coffee coffee) {
            this.coffee = coffee;
        }

        public String getDescription() { return coffee.getDescription(); }
        public double getCost() { return coffee.getCost(); }
    }

    static class MilkDecorator extends CoffeeDecorator {
        MilkDecorator(Coffee coffee) { super(coffee); }

        public String getDescription() { return coffee.getDescription() + ", Milk"; }
        public double getCost() { return coffee.getCost() + 3.0; }
    }

    static class SugarDecorator extends CoffeeDecorator {
        SugarDecorator(Coffee coffee) { super(coffee); }

        public String getDescription() { return coffee.getDescription() + ", Sugar"; }
        public double getCost() { return coffee.getCost() + 1.5; }
    }

    static class VanillaDecorator extends CoffeeDecorator {
        VanillaDecorator(Coffee coffee) { super(coffee); }

        public String getDescription() { return coffee.getDescription() + ", Vanilla"; }
        public double getCost() { return coffee.getCost() + 5.0; }
    }

    static class WhipDecorator extends CoffeeDecorator {
        WhipDecorator(Coffee coffee) { super(coffee); }

        public String getDescription() { return coffee.getDescription() + ", Whip"; }
        public double getCost() { return coffee.getCost() + 4.0; }
    }

    static void printOrder(Coffee c) {
        System.out.printf("%-45s -> %.1f TL%n", c.getDescription(), c.getCost());
    }

    public static void main(String[] args) {
        Coffee plain = new SimpleCoffee();
        printOrder(plain);

        Coffee latte = new MilkDecorator(new SugarDecorator(new SimpleCoffee()));
        printOrder(latte);

        Coffee fancy = new WhipDecorator(new VanillaDecorator(new MilkDecorator(new SugarDecorator(new SimpleCoffee()))));
        printOrder(fancy);

        Coffee doubleVanilla = new VanillaDecorator(new VanillaDecorator(new SimpleCoffee()));
        printOrder(doubleVanilla);
    }
}
