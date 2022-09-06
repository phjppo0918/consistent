package graph.dfs.bj2023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static Integer numSize;
    public static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        numSize = Integer.parseInt(st.nextToken());


        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);


        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int number, int size) {
        if (size == numSize) {
            if (isSosu(number)) {
                result.append(number);
                result.append("\n");
            }
            return;
        }

        for (int i = 1; i < 10; i++) {
            if (isSosu(number * 10 + i)) {
                dfs(number * 10 + i, size + 1);
            }
        }
    }

    public static boolean isSosu(int n) {
        for (int i = 2; i < n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

}
