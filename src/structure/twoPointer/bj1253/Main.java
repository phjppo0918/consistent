package structure.twoPointer.bj1253;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numCount = Integer.parseInt(st.nextToken());
        Long arr[] = Arrays.stream(br.readLine().split(" "))
                .map(Long::parseLong)
                .sorted(Comparator.comparing(x -> x))
                .toArray(Long[]::new);
        long answer = 0;
        boolean isNext = false;
        for (int i = 0; i < numCount; i++) {
            int firstPivot = 0;
            int lastPivot = numCount - 1;
            while (firstPivot < lastPivot) {
                long sum = arr[firstPivot] + arr[lastPivot];
                if(sum > arr[i] || lastPivot == i) {
                    lastPivot--;
                }else if (sum < arr[i] || firstPivot == i) {
                    firstPivot++;
                } else {
                    answer++;
                    break;
                }
            }
        }

        result.append(answer);

        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
