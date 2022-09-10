package euclidean.bj1033;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static List<Ratio>[] coctails;
    public static long[] ingreValue;
    public static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ingreSize = Integer.parseInt(st.nextToken());
        coctails = new ArrayList[ingreSize];
        ingreValue = new long[ingreSize];
        visited = new boolean[ingreSize];
        for (int i = 0; i < ingreSize; i++) {
            coctails[i] = new ArrayList<>();
        }

        long yaksu = 1;

        for (int i = 0; i < ingreSize - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());
            int nextNode = Integer.parseInt(st.nextToken());
            int targetValue = Integer.parseInt(st.nextToken());
            int nextNodeValue = Integer.parseInt(st.nextToken());
            coctails[target].add(new Ratio(nextNode, targetValue, nextNodeValue));
            coctails[nextNode].add(new Ratio(target, nextNodeValue, targetValue));

            yaksu *= (targetValue * nextNodeValue / getMinYaksu(targetValue, nextNodeValue));
        }

        ingreValue[0] = yaksu;
        dfs(0);
        long mgInre = ingreValue[0];

        for (int i = 1; i < ingreSize; i++) {
            mgInre = getMinYaksu(mgInre, ingreValue[i]);
        }
        for (int i = 0; i < ingreSize; i++) {
            result.append(ingreValue[i]/mgInre);
            result.append(" ");
        }

        result.append("\n");

        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int node) {
        visited[node] = true;
        for (Ratio r : coctails[node]) {
            int next = r.nextNode;
            if (!visited[next]) {
                ingreValue[next] = ingreValue[node] * r.nextNodeValue / r.targetValue;
                dfs(next);
            }
        }
    }

    public static long getMinYaksu(long num1, long num2) {
        long n1 = num1; // 작
        long n2 = num2; // 큰

        if (num2 < num1) {
            n1 = num2;
            n2 = num1;
        }

        while (n2 % n1 != 0) {
            long temp = n2 % n1;
            n2 = n1;
            n1 = temp;
        }

        return n1;
    }

}


class Ratio {
    int nextNode;
    int targetValue;
    int nextNodeValue;

    public Ratio(int nextNode, int targetValue, int nextNodeValue) {
        this.nextNode = nextNode;
        this.targetValue = targetValue;
        this.nextNodeValue = nextNodeValue;
    }
}