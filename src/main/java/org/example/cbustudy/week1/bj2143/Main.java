package org.example.cbustudy.week1.bj2143;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int target = Integer.parseInt(st.nextToken());
        final int aSize = Integer.parseInt(br.readLine());
        int[] aArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        final int bSize = Integer.parseInt(br.readLine());
        int[] bArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        List<Long> sumA = new ArrayList<>();
        List<Long> sumB = new ArrayList<>();

        for (int i = 0; i < aSize; i++) {
            long next = aArr[i];
            sumA.add(next);
            long total = next;
            for (int j = i + 1; j < aSize; j++) {
                total += aArr[j];
                sumA.add(total);
            }
        }

        for (int i = 0; i < bSize; i++) {
            long next = bArr[i];
            sumB.add(next);
            long total = next;
            for (int j = i + 1; j < bSize; j++) {
                total += bArr[j];
                sumB.add(total);
            }
        }

        Collections.sort(sumA);
        sumB.sort(Collections.reverseOrder());

        int aPiv = 0;
        int bPiv = 0;

        long ansCount = 0;
        while (aPiv < sumA.size() && bPiv < sumB.size()) {
            long next = sumA.get(aPiv) + sumB.get(bPiv);

            if (next < target) {
                aPiv++;
            } else if (next > target) {
                bPiv++;
            } else {
                long currentA = sumA.get(aPiv);
                long currentB = sumB.get(bPiv);
                long aCount = 0;
                long bCount = 0;
                while (aPiv < sumA.size() && currentA == sumA.get(aPiv)) {
                    aCount++;
                    aPiv++;
                }
                while (bPiv < sumB.size() && currentB == sumB.get(bPiv)) {
                    bCount++;
                    bPiv++;
                }

                ansCount += aCount * bCount;
            }
        }

        sb.append(ansCount);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
