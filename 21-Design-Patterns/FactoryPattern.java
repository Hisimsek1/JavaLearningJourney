public class FactoryPattern {

    interface Shape {
        double area();
        double perimeter();
        void draw();
    }

    static class Circle implements Shape {
        private double radius;

        Circle(double radius) {
            this.radius = radius;
        }

        public double area() {
            return Math.PI * radius * radius;
        }

        public double perimeter() {
            return 2 * Math.PI * radius;
        }

        public void draw() {
            System.out.printf("Circle(r=%.1f) -> area=%.2f, perimeter=%.2f%n", radius, area(), perimeter());
        }
    }

    static class Rectangle implements Shape {
        private double width, height;

        Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        public double area() {
            return width * height;
        }

        public double perimeter() {
            return 2 * (width + height);
        }

        public void draw() {
            System.out.printf("Rectangle(%.1fx%.1f) -> area=%.2f, perimeter=%.2f%n", width, height, area(), perimeter());
        }
    }

    static class Triangle implements Shape {
        private double a, b, c;

        Triangle(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public double area() {
            double s = (a + b + c) / 2;
            return Math.sqrt(s * (s - a) * (s - b) * (s - c));
        }

        public double perimeter() {
            return a + b + c;
        }

        public void draw() {
            System.out.printf("Triangle(%.1f,%.1f,%.1f) -> area=%.2f, perimeter=%.2f%n", a, b, c, area(), perimeter());
        }
    }

    static class ShapeFactory {
        public static Shape create(String type, double... params) {
            switch (type.toLowerCase()) {
                case "circle":    return new Circle(params[0]);
                case "rectangle": return new Rectangle(params[0], params[1]);
                case "triangle":  return new Triangle(params[0], params[1], params[2]);
                default: throw new IllegalArgumentException("Unknown shape: " + type);
            }
        }
    }

    public static void main(String[] args) {
        Shape[] shapes = {
            ShapeFactory.create("circle", 5),
            ShapeFactory.create("rectangle", 4, 6),
            ShapeFactory.create("triangle", 3, 4, 5)
        };

        for (Shape s : shapes) {
            s.draw();
        }
    }
}
