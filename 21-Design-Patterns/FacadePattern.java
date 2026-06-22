public class FacadePattern {

    static class CPU {
        void freeze() { System.out.println("CPU: freeze"); }
        void jump(long position) { System.out.println("CPU: jump to " + position); }
        void execute() { System.out.println("CPU: execute"); }
    }

    static class Memory {
        void load(long position, byte[] data) {
            System.out.println("Memory: load " + data.length + " bytes at position " + position);
        }
    }

    static class HardDrive {
        byte[] read(long lba, int size) {
            System.out.println("HardDrive: read " + size + " bytes from sector " + lba);
            return new byte[size];
        }
    }

    static class ComputerFacade {
        private CPU cpu;
        private Memory memory;
        private HardDrive hardDrive;

        private static final long BOOT_ADDRESS = 0x00L;
        private static final long BOOT_SECTOR = 0L;
        private static final int SECTOR_SIZE = 512;

        ComputerFacade() {
            cpu = new CPU();
            memory = new Memory();
            hardDrive = new HardDrive();
        }

        void start() {
            System.out.println("=== Computer Starting ===");
            cpu.freeze();
            byte[] bootData = hardDrive.read(BOOT_SECTOR, SECTOR_SIZE);
            memory.load(BOOT_ADDRESS, bootData);
            cpu.jump(BOOT_ADDRESS);
            cpu.execute();
            System.out.println("=== Boot Complete ===");
        }

        void shutdown() {
            System.out.println("=== Shutting down ===");
            System.out.println("Saving state...");
            System.out.println("Flushing buffers...");
            cpu.freeze();
            System.out.println("=== Off ===");
        }
    }

    static class HomeTheaterFacade {
        private String amplifier = "Amplifier";
        private String tuner = "Tuner";
        private String dvdPlayer = "DVD Player";
        private String projector = "Projector";
        private String lights = "Lights";

        void watchMovie(String movie) {
            System.out.println("=== Get ready to watch: " + movie + " ===");
            System.out.println(lights + ": dimming to 10%");
            System.out.println(projector + ": turning on");
            System.out.println(amplifier + ": turning on, volume 5");
            System.out.println(dvdPlayer + ": playing " + movie);
        }

        void endMovie() {
            System.out.println("=== Shutting down theater ===");
            System.out.println(dvdPlayer + ": stopping");
            System.out.println(amplifier + ": turning off");
            System.out.println(projector + ": turning off");
            System.out.println(lights + ": turning on");
        }
    }

    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.start();
        System.out.println();
        computer.shutdown();

        System.out.println();

        HomeTheaterFacade theater = new HomeTheaterFacade();
        theater.watchMovie("Inception");
        System.out.println();
        theater.endMovie();
    }
}
