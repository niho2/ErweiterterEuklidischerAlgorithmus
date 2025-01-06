import java.util.Scanner;

public void main() {
    int a, b, r, rAlt;
    r = 99;

    Scanner scanner = new Scanner(System.in);

    System.out.println("a: ");
    a = Integer.parseInt(scanner.nextLine());
    System.out.println("b: ");
    b= Integer.parseInt(scanner.nextLine());

    rAlt = b;
    if ((a % b) == 0 ){
        r = 0;
    }

    while (r != 0){
        rAlt = r;
        r = a % b;
        a = b;
        b = r;
    }

    System.out.println("ggt = "+ rAlt);
}
