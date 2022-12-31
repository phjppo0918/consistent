package euclidean.bj1850;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long num1 = Long.parseLong(st.nextToken());
        long num2 = Long.parseLong(st.nextToken());

        long yaksu = getYaksu(num1, num2);
        result.append(getNum(yaksu));
        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    public static long getYaksu(long num1, long num2) {
        long n1 = num1, n2 = num2;
        if (num1 < num2) {
            n1 = num2;
            n2 = num1;
        }
        while (true) {
            long temp = n1%n2;
            if(temp == 0) {
                return n2;
            }
            n1 = n2;
            n2 = temp;
        }
    }
    public static String getNum(long count) {
        StringBuilder str = new StringBuilder();
        for (long i = 0; i < count; i++) {
            str.append(1);
        }
        return str.toString();
    }
}
