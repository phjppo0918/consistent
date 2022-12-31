package sort.insertion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int manSize = Integer.parseInt(st.nextToken());
        Integer[] arr = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted()
                .toArray(Integer[]::new);
        long answer = 0;
        for (int i = 0; i < manSize; i++) {
            answer += (long) arr[i] * (manSize - i);
        }
        result.append(answer);
        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
