import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class NoteCatalog {
    private static final Random random = new Random();

    private static final String[] RAMS = {"4", "8", "12", "16", "32"};
    private static final String[] DRIVES = {"SSD", "HDD"};
    private static final String[] SCREENS = {"11.6", "13.0", "14.0", "15.6", "17.0"};
    private static final String[] BRANDS = {"Sony", "Lenovo", "Fujitsu", "HP", "Toshiba"};
    private static final String[] OS_LIST = {"Windows", "Ubuntu", "Fedora", "Chrome OS", "Solaris"};
    private static final String[] COLORS = {"black", "white", "red", "silver", "gold"};

    public static final int totalNotebook = 170;

    public static Set<Notebook> fill() {
        Set<Notebook> catalog = new HashSet<>();
        for (int i = 0; i < totalNotebook; i++) {
            catalog.add(new Notebook(
                    Integer.parseInt(sample(RAMS)),
                    sample(DRIVES),
                    Double.parseDouble(sample(SCREENS)),
                    sample(BRANDS),
                    sample(OS_LIST),
                    sample(COLORS)
            ));
        }
        return catalog;
    }

    private static String sample(String[] arr) {
        return arr[random.nextInt(arr.length)];
    }
}