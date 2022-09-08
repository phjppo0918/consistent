package binarySearch.bj1300;

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
    
        int arrSize = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int searchNum = Integer.parseInt(st.nextToken());

        long startPivot = 1;
        long endPivot = searchNum;
        long answer = 0;
        while (startPivot <= endPivot) {
            long center = (startPivot + endPivot) / 2;
            long cnt = 0;
            for (int i = 1; i <= arrSize; i++) {
                cnt += Math.min(center/i, arrSize);
            }

            if(cnt < searchNum) {
                startPivot = center + 1;
            }else {
                answer = center;
                endPivot = center - 1;
            }
        }

        result.append(answer);
        bw.write(result.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
}
