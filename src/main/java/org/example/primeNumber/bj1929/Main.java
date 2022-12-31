package primeNumber.bj1929;

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
    
        long start = Long.parseLong(st.nextToken());
        long end = Long.parseLong(st.nextToken());

        long count = 0;
        final int MAX_PIVOT = 10000000;

        boolean[] isNotPrime = new boolean[MAX_PIVOT + 1];
        for (int i = 2; i < MAX_PIVOT; i++) {
            if(!isNotPrime[i]) {
                int milti = 2;
                while (i * milti <= MAX_PIVOT) {
                    isNotPrime[i*milti] = true;
                    milti++;
                }

                double endTemp = end;

                double temp = i;
                while (i < start/temp) {
                    temp *= i;
                }

                while (i <= end/temp) {
                    count++;
                    temp *= i;
                }
            }
        }

        result.append(count);
        result.append("\n");
        
        bw.write(result.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
}
