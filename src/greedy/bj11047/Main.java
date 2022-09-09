package greedy.bj11047;

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

        int coinSize = Integer.parseInt(st.nextToken());
        int totalPrice = Integer.parseInt(st.nextToken());
        int[] coin = new int[coinSize];
        for (int i = 0; i < coinSize; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        long answer = 0;

        for (int i = coinSize - 1; i >= 0; i--) {
            while (totalPrice >= coin[i]) {
                answer++;
                totalPrice -= coin[i];
            }
        }
        result.append(answer);
        result.append("\n");

        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
