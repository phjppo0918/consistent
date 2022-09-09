package eulersPhi.bj11689;

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
    
        long n = Long.parseLong(st.nextToken());
        long answer = n;
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                answer -= answer / i;
                while (n%i == 0) {
                    n /= i;
                }
            }
        }
        if(n > 1) {
            answer -= answer / n;
        }

        result.append(answer);
        result.append("\n");

        bw.write(result.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
}
