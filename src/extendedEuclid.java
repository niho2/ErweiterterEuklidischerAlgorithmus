import java.util.Scanner;

public static int[] extendedEuclid(int a, int b) {
    if (b == 0) {
        return new int[] {a, 1, 0};
    } else {
        int[] values = extendedEuclid(b, a % b);
        int d = values[0];
        int s = values[2];
        int t = values[1] - (a / b) * values[2];
        return new int[] {d, s, t};
    }
}

@SuppressWarnings("StringTemplateMigration")
public void main() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("1. Zahl:");
    int ersteZahl = Integer.parseInt(scanner.next());

    System.out.println("2. Zahl:");
    int zweiteZahl = Integer.parseInt(scanner.next());
    scanner.close();

    int[] result = extendedEuclid(ersteZahl, zweiteZahl);
    System.out.println("ggt = "+result[0]);
    System.out.println("x = "+result[1]);
    System.out.println("y = "+result[2]);
}
