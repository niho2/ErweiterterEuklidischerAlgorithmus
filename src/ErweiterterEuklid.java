import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("StringTemplateMigration")
public static void main() {
    int a, b, r, q;
    List<int[]> iterationen = new ArrayList<>();
    int anzahlIteration = 0;

    Scanner scanner = new Scanner(System.in);

    System.out.println("a: ");
    a = Integer.parseInt(scanner.nextLine());
    System.out.println("b: ");
    b = Integer.parseInt(scanner.nextLine());

    while (b != 0) {
        r = a % b;
        q = (int) Math.floor((double) a / b);
        iterationen.add(new int[]{a, b, q, r});
        a = b;
        b = r;
        anzahlIteration++;
    }

    System.out.println("ggT = " + a);
    System.out.println("\nTabelle der Iterationen:");
    System.out.println(" a  | b   | q  | r  ");
    System.out.println("------------------");
    for (int[] iteration : iterationen) {
        System.out.printf("%-3d | %-3d | %-3d | %-3d%n", iteration[0], iteration[1], iteration[2], iteration[3]);
    }
    System.out.println("\nAnzahl der Iterationen: " + anzahlIteration);

    for (int i = iterationen.size(); i > 0; i--) {
        a = iterationen.get(i - 1)[0];
        b = iterationen.get(i - 1)[1];
        q = iterationen.get(i - 1)[2];
        r = iterationen.get(i - 1)[3];
        if (i == iterationen.size()) {
            iterationen.set(i - 1, new int[]{a, b, q, r, 0, 1});
        }
        if (i != iterationen.size()) {
            iterationen.set(i - 1, new int[]{a, b, q, r, iterationen.get(i)[5], iterationen.get(i)[4] - iterationen.get(i - 1)[2] * iterationen.get(i)[5]});
        }

    }

    System.out.println("\nErweiterter Euklid:");
    System.out.println(" a  | b   | q  | r  | x | y");
    System.out.println("---------------------------");
    for (int[] iteration : iterationen) {
        System.out.printf("%-3d | %-3d | %-3d | %-3d | %-3d | %-3d%n", iteration[0], iteration[1], iteration[2], iteration[3], iteration[4], iteration[5]);
    }
    System.out.println("\nx: " + iterationen.getFirst()[4]);
    System.out.println("y: " + iterationen.getFirst()[5]);
    System.out.println("\nggt(" + iterationen.getFirst()[0] + "," + iterationen.getFirst()[1] + ") = " + iterationen.getFirst()[0] + " * " + iterationen.getFirst()[4] + " + " + iterationen.getFirst()[1] + " * " + iterationen.getFirst()[5]);


    scanner.close();
}
