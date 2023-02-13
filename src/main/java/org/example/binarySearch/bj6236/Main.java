package org.example.binarySearch.bj6236;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static int[] use;
    static int chargeCount;
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int useSize = Integer.parseInt(st.nextToken());
        chargeCount = Integer.parseInt(st.nextToken());
        use = new int[useSize];
        for (int i = 0; i < useSize; i++) {
            use[i] = Integer.parseInt(br.readLine());
        }
        long minPivot = 1L;
        long maxPivot = Long.MAX_VALUE - 1;
        long answer = 0;
        while (minPivot <= maxPivot) {
            long mid = (minPivot + maxPivot) / 2;
            if(canUse(mid)) {
                answer = mid;
                maxPivot = mid - 1;
            }else {
                minPivot = mid + 1;
            }
        }

        sb.append(answer);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
    private static boolean canUse(long chargeMoney) {
        long money = 0;
        int nowCount = 0;
        for (int j : use) {
            if (money < j) {
                money = chargeMoney;
                nowCount++;
            }
            money -= j;
            if(money < 0) {
                return false;
            }
        }
        return  nowCount <= chargeCount;
    }
}
