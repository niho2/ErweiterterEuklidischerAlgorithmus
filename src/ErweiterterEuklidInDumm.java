import java.util.Scanner;

@SuppressWarnings("StringTemplateMigration")
public static void main() {
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Maximale Anzahl der Iterationen: ");
    int maxIterationen = Integer.parseInt(scanner.nextLine());
    
    // Arrays für die einzelnen Werte
    int[] a_array = new int[maxIterationen];
    int[] b_array = new int[maxIterationen];
    int[] q_array = new int[maxIterationen];
    int[] r_array = new int[maxIterationen];
    int anzahlIteration = 0;

    System.out.println("a: ");
    int a = Integer.parseInt(scanner.nextLine());
    System.out.println("b: ");
    int b = Integer.parseInt(scanner.nextLine());

    while (b != 0 && anzahlIteration < maxIterationen) {
        int r = a % b;
        int q = (int) Math.floor((double) a / b);
        
        // Speichern der Werte in den Arrays
        a_array[anzahlIteration] = a;
        b_array[anzahlIteration] = b;
        q_array[anzahlIteration] = q;
        r_array[anzahlIteration] = r;
        
        a = b;
        b = r;
        anzahlIteration++;
    }

    System.out.println("ggT = " + a);
    System.out.println("\nTabelle der Iterationen:");
    System.out.println(" a  | b   | q  | r  ");
    System.out.println("------------------");
    for (int i = 0; i < anzahlIteration; i++) {
        System.out.printf("%-3d | %-3d | %-3d | %-3d%n", 
            a_array[i], b_array[i], q_array[i], r_array[i]);
    }
    System.out.println("\nAnzahl der Iterationen: " + anzahlIteration);

    // Arrays für x und y
    int[] x_array = new int[maxIterationen];
    int[] y_array = new int[maxIterationen];

    for (int i = anzahlIteration - 1; i >= 0; i--) {
        if (i == anzahlIteration - 1) {
            x_array[i] = 0;
            y_array[i] = 1;
        } else {
            x_array[i] = y_array[i + 1];
            y_array[i] = x_array[i + 1] - q_array[i] * y_array[i + 1];
        }
    }

    System.out.println("\nErweiterter Euklid:");
    System.out.println(" a  | b   | q  | r  | x | y");
    System.out.println("---------------------------");
    for (int i = 0; i < anzahlIteration; i++) {
        System.out.printf("%-3d | %-3d | %-3d | %-3d | %-3d | %-3d%n", 
            a_array[i], b_array[i], q_array[i], r_array[i], x_array[i], y_array[i]);
    }
    
    System.out.println("\nx: " + x_array[0]);
    System.out.println("y: " + y_array[0]);
    System.out.println("\nggt(" + a_array[0] + "," + b_array[0] + ") = " + 
        a_array[0] + " * " + x_array[0] + " + " + b_array[0] + " * " + y_array[0]);

    scanner.close();
}
