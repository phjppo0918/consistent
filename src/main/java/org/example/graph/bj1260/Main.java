package graph.bj1260;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static boolean[] dfsVisited;
    public static boolean[] bfsVisited;
    public static Stack<Integer> stack = new Stack<>();
    public static Queue<Integer> queue = new LinkedList<>();
    public static StringBuilder result;
    public static List<Integer>[] arr;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeSize = Integer.parseInt(st.nextToken());
        dfsVisited = new boolean[nodeSize + 1];
        bfsVisited = new boolean[nodeSize + 1];
        int edgeSize = Integer.parseInt(st.nextToken());
        int startPoint = Integer.parseInt(st.nextToken());

        arr = new ArrayList[nodeSize + 1];
        IntStream.range(0, nodeSize + 1).forEach(v -> arr[v] = new ArrayList<>());


        for (int i = 0; i < edgeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            arr[n1].add(n2);
            arr[n2].add(n1);
        }
        Arrays.stream(arr).forEach(Collections::sort);

        dfs(startPoint);
        result.append("\n");
        bfs(startPoint);

        bw.write(result.toString().trim());

        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int index) {

        dfsVisited[index] = true;
        result.append(index);
        result.append(" ");

        arr[index].forEach(e -> {
            if (!dfsVisited[e]) {
                dfs(e);
            }
        });

    }

    public static void bfs(int index) {
        if (bfsVisited[index]) {
            return;
        }
        bfsVisited[index] = true;
        result.append(index);
        result.append(" ");

        arr[index].forEach(e -> {
            if (!bfsVisited[e]) {
                queue.add(e);
            }
        });

        while (!queue.isEmpty()) {
            bfs(queue.poll());
        }

    }
}
