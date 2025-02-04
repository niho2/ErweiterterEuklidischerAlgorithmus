import java.util.ArrayList;
import java.util.Scanner;

public void main() {
    ArrayList<Integer> a = new ArrayList<>(), b = new ArrayList<>(), r = new ArrayList<>(), q, x, y;

    Scanner scanner = new Scanner(System.in);

    System.out.println("a: ");
    a.add(Integer.parseInt(scanner.nextLine()));
    System.out.println("b: ");
    b.add(Integer.parseInt(scanner.nextLine()));

    r.add(99);

    int i = 0;
    while (r.get(i) != 0){
        r.add(a.get(i) % b.get(i));
        a.add(b.get(i));
        b.add(r.get(i));
        i++;
    }

    System.out.println("ggt = "+ r.get(i-1));
    System.out.println(r);
}
