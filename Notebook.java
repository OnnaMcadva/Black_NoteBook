public class Notebook {
    private final int ram;
    private final String drive;
    private final double screenSize;
    private final String brand;
    private final String os;
    private final String color;

    // ANSI color codes
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";

    public Notebook(int ram, String drive, double screenSize, String brand, String os, String color) {
        this.ram = ram;
        this.drive = drive;
        this.screenSize = screenSize;
        this.brand = brand;
        this.os = os;
        this.color = color;
    }

    public int getRam() { return ram; }
    public String getDrive() { return drive; }
    public double getScreenSize() { return screenSize; }
    public String getBrand() { return brand; }
    public String getOs() { return os; }
    public String getColor() { return color; }

    @Override
    public String toString() {
        return String.format(
                BLUE + "Laptop {" + RESET +
                " OS: " + GREEN + "'%s'" + RESET +
                ", RAM: " + YELLOW + "%d GB" + RESET +
                ", Drive: " + CYAN + "%s" + RESET +
                ", Screen: " + PURPLE + "%.1f\"" + RESET +
                ", Brand: '%s'" +
                ", Color: '%s'" +
                " }",
                os, ram, drive, screenSize, brand, color
        );
    }

    public static void main(String[] args) {
        Notebook n = new Notebook(16, "SSD", 15.6, "Dell", "Windows", "Black");
        System.out.println(n);
    }
}


// public class Notebook {
//     private final int ram;
//     private final String drive;
//     private final double screenSize;
//     private final String brand;
//     private final String os;
//     private final String color;

//     public Notebook(int ram, String drive, double screenSize, String brand, String os, String color) {
//         this.ram = ram;
//         this.drive = drive;
//         this.screenSize = screenSize;
//         this.brand = brand;
//         this.os = os;
//         this.color = color;
//     }

//     public int getRam() { return ram; }
//     public String getDrive() { return drive; }
//     public double getScreenSize() { return screenSize; }
//     public String getBrand() { return brand; }
//     public String getOs() { return os; }
//     public String getColor() { return color; }

//     @Override
//     public String toString() {
//         return String.format("Laptop { OS: '%s', RAM: %d GB, Drive: %s, Screen: %.1f\", Brand: '%s', Color: '%s' }",
//                 os, ram, drive, screenSize, brand, color);
//     }
// }