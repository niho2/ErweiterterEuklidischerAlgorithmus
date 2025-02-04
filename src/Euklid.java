import java.util.Scanner;

public void main() {
    int a, b, r;

    Scanner scanner = new Scanner(System.in);

    System.out.println("a: ");
    a = Integer.parseInt(scanner.nextLine());
    System.out.println("b: ");
    b= Integer.parseInt(scanner.nextLine());

    while (b != 0){
        r = a % b;
        a = b;
        b = r;
    }

    System.out.println("ggt = "+ a);
}
