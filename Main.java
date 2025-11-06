import javax.swing.*;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String[] choices = {"View all laptops", "Set search criteria", "Exit and think more"};
        ImageIcon icon = new ImageIcon("images/notebook.png");

        String selection = (String) JOptionPane.showInputDialog(
                null,
                "Choose an option",
                "Welcome to the Laptop Store",
                JOptionPane.QUESTION_MESSAGE,
                icon,
                choices,
                choices[1]
        );

        if (selection == null) return;

        Set<Notebook> laptops = NoteCatalog.fill();

        switch (selection) {
            case "Exit and think more" -> {
                JOptionPane.showMessageDialog(null,
                        "The laptop store awaits your return!",
                        "See you soon!",
                        JOptionPane.INFORMATION_MESSAGE,
                        icon);
            }
            case "View all laptops" -> {
                System.out.println("Available laptops:");
                printLaptops(laptops);
                System.out.printf("Found %d of %d laptops%n", NoteCatalog.totalNotebook, NoteCatalog.totalNotebook);
            }
            case "Set search criteria" -> {
                Set<Notebook> filtered = NoteCustomer.filter(laptops);
                if (filtered == null) return;
                int count = filtered.size();
                if (count == 0) {
                    System.out.println("No laptops found matching criteria.");
                } else {
                    printLaptops(filtered);
                    System.out.printf("Found %d of %d laptops%n", count, NoteCatalog.totalNotebook);
                }
            }
        }
    }

    /**
     * Prints a list of laptops with their specifications.
     *
     * @param laptops the set of laptops to print
     */
    private static void printLaptops(Set<Notebook> laptops) {
        laptops.forEach(System.out::println);
    }
}

// javac NoteCatalog.java Notebook.java NoteCustomer.java Main.java