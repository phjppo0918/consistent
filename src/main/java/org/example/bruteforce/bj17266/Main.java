package org.example.bruteforce.bj17266;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int []lamp;
    static int load;
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        load = Integer.parseInt(st.nextToken());
        int lampCount = Integer.parseInt(br.readLine());

        lamp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int answer = 100_000;
        int heightStart = 0;
        int heightFinish = 100_000;
        while (heightStart <= heightFinish) {
            int mid = (heightStart + heightFinish) / 2;
            if(check(mid)) {
                answer = Math.min(answer, mid);
                heightFinish = mid - 1;
            }else {
                heightStart = mid + 1;
            }
        }
        sb.append(answer);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean check(int light) {
        int loadPivot = 0;
        for (int i = 0; i < lamp.length; i++) {
            if (lamp[i] - light > loadPivot) {
                return false;
            }
            loadPivot = lamp[i] + light;
        }

        return loadPivot >= load;
    }
}
