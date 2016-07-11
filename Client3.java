import java.util.*;
import java.io.*;

public class Client3 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("scores_DON_3.txt");
        Scanner scan = new Scanner(f);

        ArrayList<Class> classes = new ArrayList<Class>();

        while (scan.hasNextLine()) {
            try {
                String[] classInfo = scan.nextLine().split("\\s+");
                System.out.println(Arrays.toString(classInfo));
                String name = classInfo[3];
                int lastIndex = classInfo.length - 1;
                System.out.println(lastIndex);
                int score = Integer.parseInt(classInfo[lastIndex - 2]);
                int level = Integer.parseInt(classInfo[lastIndex - 5]);
                double yearsTaken = Double.parseDouble(classInfo[lastIndex]);

                Class currentClass = new Class(name, score, level, yearsTaken);
                classes.add(currentClass);
                System.out.println(currentClass);
            } catch (Exception e) {
                System.out.println("Empy input line.");
            }
        }

        System.out.println("\n");
        printGPAInfo(classes);
    }

    public static void printGPAInfo(ArrayList<Class> classes) {
        double totalYearsTaken = 0.0;
        double totalWeightedCredits = 0.0;
        double totalMaxPotentialWeightedCredits = 0.0;

        for (Class c : classes) {
            totalYearsTaken += c.getYearsTaken();
            totalWeightedCredits += c.getWeightedCredits();
            totalMaxPotentialWeightedCredits += c.getMaxPotentialWeightedCredits();
        }

        System.out.printf("%28s%5.3f%n", "Weighted GPA: ", totalWeightedCredits / totalYearsTaken);
        System.out.printf("%28s%5.3f%n", "Max Potential Weighted GPA: ", totalMaxPotentialWeightedCredits / totalYearsTaken);
    }
}