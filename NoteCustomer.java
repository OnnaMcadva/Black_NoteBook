import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class NoteCustomer {

    /**
     * @apiNote Filters the list of all laptops.
     * @param notebooks list of all laptops.
     * @return filtered list of laptops matching customer request.
     */
    public static Set<Notebook> filter(Set<Notebook> notebooks) {
        String[] options = {"Windows", "Ubuntu", "Fedora", "Chrome OS", "Solaris"};
        ImageIcon icon = new ImageIcon("images/notebook.png");
        ImageIcon iconCat = new ImageIcon("images/cat.png");

        int x = JOptionPane.showOptionDialog(null, "Choose from the options",
                "Operating System",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, options, options[1]);

        if (x == -1) { return null; }

        String ramInput = null;
        String screenSizeInput = null;
        boolean valid = false;
        int attempts = 0;

        while (!valid) {
            ramInput = JOptionPane.showInputDialog(null, "Enter minimum integer value [4 - 32]",
                    "RAM", JOptionPane.INFORMATION_MESSAGE);
            if (!isValidIntInRange(ramInput, 4, 32)) {
                attempts++;
                if (attempts == 2) {
                    JOptionPane.showMessageDialog(null, "Why so stubborn?", "No laptop for you!", JOptionPane.INFORMATION_MESSAGE, iconCat);
                    return null;
                }
            } else {
                valid = true;
            }
        }

        attempts = 0;
        valid = false;
        while (!valid) {
            screenSizeInput = JOptionPane.showInputDialog(null, "Enter minimum integer value [11 - 17]",
                    "Screen Size", JOptionPane.INFORMATION_MESSAGE);
            if (!isValidIntInRange(screenSizeInput, 11, 17)) {
                attempts++;
                if (attempts == 2) {
                    JOptionPane.showMessageDialog(null, "I told you!", "No laptop for you!", JOptionPane.INFORMATION_MESSAGE, iconCat);
                    return null;
                }
            } else {
                valid = true;
            }
        }

        int ram = Integer.parseInt(ramInput);
        double screenSize = Double.parseDouble(screenSizeInput);
        Set<Notebook> filtered = new HashSet<>();

        for (Notebook notebook : notebooks) {
            if (ram <= notebook.getRam()
                    && options[x].equalsIgnoreCase(notebook.getOs())
                    && screenSize <= notebook.getScreenSize()) {
                filtered.add(new Notebook(
                        notebook.getRam(),
                        notebook.getDrive(),
                        notebook.getScreenSize(),
                        notebook.getBrand(),
                        notebook.getOs(),
                        notebook.getColor()
                ));
            }
        }
        return filtered;
    }

    // Checks if input is an integer in the given range
    private static boolean isValidIntInRange(String s, int min, int max) {
        if (s == null) return false;
        try {
            int value = Integer.parseInt(s);
            if (value < min || value > max) {
                JOptionPane.showMessageDialog(null,
                        "Please enter a number in range [" + min + " - " + max + "]",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Invalid input",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    // /**
    //  * @param s input string from dialog
    //  * @return true if it's a valid integer
    //  * @apiNote Checks if the input is a whole number
    //  */
    // private static boolean isValidInt(String s) {
    //     if (s == null) return false;
    //     try {
    //         Integer.parseInt(s);
    //         return true;
    //     } catch (NumberFormatException e) {
    //         JOptionPane.showMessageDialog(null,
    //                 "Invalid input",
    //                 "ERROR",
    //                 JOptionPane.ERROR_MESSAGE);
    //         return false;
    //     }
    // }
}