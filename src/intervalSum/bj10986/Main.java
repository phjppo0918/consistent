package intervalSum.bj10986;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numSize = Integer.parseInt(st.nextToken());
        int divideNum = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int arr[] = new int[numSize + 1];
        long numCount[] = new long[divideNum];
        for (int i = 1; i <= numSize; i++) {
            arr[i] = (arr[i - 1] + Integer.parseInt(st.nextToken())) % divideNum;
            numCount[arr[i]]++;
        }

        long resultCount = numCount[0];

        for (int i = 0; i < divideNum; i++) {
            if (numCount[i] > 1) {
                resultCount += (numCount[i] * (numCount[i] - 1) / 2);
            }
        }
        result.append(resultCount);

        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }

}
