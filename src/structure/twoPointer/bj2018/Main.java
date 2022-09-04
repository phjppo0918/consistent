package structure.twoPointer.bj2018;

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
    
        int num = Integer.parseInt(st.nextToken());
        int caseCount = 1;

        int endPivot = 1;

        while (endPivot != num) {
            int startPivot = endPivot;
            int sum = 0;
            while (sum < num) {
                sum += startPivot;
                startPivot++;
            }
            if(sum == num) {
                caseCount++;
            }
            endPivot++;
        }

        result.append(caseCount);
        bw.write(result.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
}
