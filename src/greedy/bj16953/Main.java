package greedy.bj16953;

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

        int before = Integer.parseInt(st.nextToken());
        int after = Integer.parseInt(st.nextToken());

        int count = 1;
        while (true) {
            while (after%2 == 0) {
                if(before == after) {
                    break;
                }
                count++;
                after/=2;
            }

            if(after == before) {
                break;
            }

            if(after%10 != 1) {
                count = -1;
                break;
            }

            after/=10;
            count++;

            if(after < before) {
                count = -1;
                break;
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
