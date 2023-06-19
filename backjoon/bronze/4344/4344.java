import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int count = Integer.parseInt(st.nextToken());

            ArrayList<Integer> list = new ArrayList<>();
            int sum = 0;

            while(st.hasMoreTokens()) {
                int temp = Integer.parseInt(st.nextToken());
                list.add(temp);
                sum += temp;
            }

            double avg = (double) sum / count;

            int over = 0;
            for (int temp : list) {
                if(temp > avg)
                    over++;
            }

            System.out.printf("%.3f%%\n", (double) over/count*100);
        }
    }
}