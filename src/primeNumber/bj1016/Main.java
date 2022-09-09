package primeNumber.bj1016;

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

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean isNotPick[] = new boolean[(int)(max - min + 1)];

        for (long i = 2; i * i <= max; i++) {
            long temp = i * i;
            long start = min / temp;
            if(min % temp != 0) {
                start++;
            }

            while (temp * start <= max) {
                isNotPick[(int)(temp*start - min)] = true;
                start++;
            }

        }
        long answer = 0;
        for (boolean k: isNotPick) {
            if(!k) {
                answer++;
            }
        }
        result.append(answer);
        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
