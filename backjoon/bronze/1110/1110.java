import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int a = 0;
        int b = 0;

        if (n < 10) {
            b = n;
        } else {
            a = n/10;
            b = n%10;
        }

        int cycle = 1;

        int temp = 0;
        while(true) {
            temp = (a + b)%10;
            if((b*10 + temp) == n) {
                break;
            }
            a = b;
            b = temp;
            cycle++;
        }
        System.out.print(cycle);
    }
}
