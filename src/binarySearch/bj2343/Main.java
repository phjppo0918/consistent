package binarySearch.bj2343;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static Integer[] arr;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int caseSize = Integer.parseInt(st.nextToken());
        int boxCount = Integer.parseInt(st.nextToken());

        arr = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        long lastPivot = 0;
        long firstPivot = 0;
        for (int i : arr) {
            lastPivot += i;
            if (firstPivot < i) {
                firstPivot = i;
            }
        }

        while (firstPivot < lastPivot) {
            long center = (lastPivot - firstPivot) / 2 + firstPivot;
            if (inputBox(center, boxCount)) {
                lastPivot = center;
            } else {
                firstPivot = center + 1;
            }

            // 9    45
        }

        result.append(lastPivot);
        result.append("\n");

        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    public static boolean inputBox(long boxSize, int boxCount) {
        int useBox = 1;
        long temp = boxSize;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= temp) {
                temp -= arr[i];
            } else {
                useBox++;
                if (boxCount < useBox) {
                    return false;
                }
                temp = boxSize - arr[i];
            }
        }

        return true;
    }
}
