package binarySearch.bj1920;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static Integer[] numArr;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numSize = Integer.parseInt(st.nextToken());
        numArr = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted()
                .toArray(Integer[]::new);

        st = new StringTokenizer(br.readLine());
        int testSize = Integer.parseInt(st.nextToken());
        Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt).forEach(i -> {
                    if(biSearch(i, 0, numSize - 1)) {
                        result.append(1);
                    }else {
                        result.append(0);
                    }
                    result.append("\n");
                });

        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean biSearch(int value, int start, int end) {
        if(start > end) {
            return false;
        }
        int center = (end - start) / 2 + start;

        if(value < numArr[center]) {
            return biSearch(value, start, center - 1);
        } else if (value > numArr[center]) {
            return biSearch(value, center+1, end);
        }

        return true;
    }
}
