import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int gcd = gcd(a, b);

        System.out.println(gcd);
        System.out.println(a*b/gcd);
    }

    static int gcd(int a, int b) {
        return a%b == 0 ? b : gcd(b, a%b);
    }
}