abstract class Sekil {
    abstract double alan();
    abstract double cevre();

    void bilgiGoster() {
        System.out.printf("%-12s | Alan: %8.2f | Çevre: %8.2f%n",
                getClass().getSimpleName(), alan(), cevre());
    }
}

class Daire extends Sekil {
    double yaricap;
    Daire(double yaricap) { this.yaricap = yaricap; }

    @Override
    double alan() { return Math.PI * yaricap * yaricap; }

    @Override
    double cevre() { return 2 * Math.PI * yaricap; }
}

class Dikdortgen extends Sekil {
    double en, boy;
    Dikdortgen(double en, double boy) { this.en = en; this.boy = boy; }

    @Override
    double alan() { return en * boy; }

    @Override
    double cevre() { return 2 * (en + boy); }
}

class Ucgen extends Sekil {
    double a, b, c;
    Ucgen(double a, double b, double c) { this.a = a; this.b = b; this.c = c; }

    @Override
    double alan() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    double cevre() { return a + b + c; }
}

public class SekilleriHesapla {
    public static void main(String[] args) {
        Sekil[] sekiller = {
            new Daire(5),
            new Dikdortgen(4, 6),
            new Ucgen(3, 4, 5)
        };

        System.out.println("Şekil        | Alan     | Çevre");
        System.out.println("-------------|----------|----------");
        for (Sekil s : sekiller) {
            s.bilgiGoster();
        }
    }
}
