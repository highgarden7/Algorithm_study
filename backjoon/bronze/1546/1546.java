import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] numArr = br.readLine().split(" ");
        double maxNumber = -1;

        double total = 0;

        for (String num : numArr) {
            double number = Double.parseDouble(num);
            total += number;
            if (number > maxNumber) {
                maxNumber = number;
            }
        }

        System.out.print(total / maxNumber / n * 100);
    }
}