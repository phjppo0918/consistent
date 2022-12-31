package euclidean.bj1934;

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
    
        int testCase = Integer.parseInt(st.nextToken());

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            int yaksu = getYaksu(num1, num2);
            result.append(num1 * num2 / yaksu);
            result.append("\n");
        }
        
        bw.write(result.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }

    public static int getYaksu(int num1, int num2) {
        int n1 = num1, n2 = num2;
        if (num1 < num2) {
            n1 = num2;
            n2 = num1;
        }
        while (true) {
            int temp = n1%n2;
            if(temp == 0) {
                return n2;
            }
            n1 = n2;
            n2 = temp;
        }
    }
}
