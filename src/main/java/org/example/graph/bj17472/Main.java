package graph.bj17472;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int inputRow;
    public static int inputCol;
    public static int graph[][];
    public static int parent[];
    public static Queue<Bridge> pq = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        inputRow = Integer.parseInt(st.nextToken());
        inputCol = Integer.parseInt(st.nextToken());

        graph = new int[inputRow + 1][inputCol + 1];
        for (int i = 1; i <= inputRow; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= inputCol; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    graph[i][j] = -1;
                } else {
                    graph[i][j] = 0;
                }
            }
        }

        int islandCount = 0;

        for (int i = 1; i <= inputRow; i++) {
            for (int j = 1; j <= inputCol; j++) {
                if (graph[i][j] == -1) {
                    islandCount++;
                    setIsland(i, j, islandCount);
                }
            }
        }

        for (int i = 1; i <= inputRow; i++) {
            for (int j = 1; j <= inputCol; j++) {
                if (graph[i][j] != 0) {
                    createRowBridge(graph[i][j], i, j, 0);
                    createColBridge(graph[i][j], i, j, 0);
                }
            }
        }

        parent = new int[islandCount + 1];
        for (int i = 1; i <= islandCount; i++) {
            parent[i] = i;
        }
        int visitCount = 2;
        int answer = -1;
        if(!pq.isEmpty()) {
            Bridge startBridge = pq.poll();
            answer = startBridge.value;
            union(startBridge.island1, startBridge.island2);
        }

        while (!pq.isEmpty() && visitCount < islandCount) {
            Bridge now = pq.poll();
            if (isSameParent(now.island1, now.island2)) {
                continue;
            }

            union(now.island1, now.island2);
            answer += now.value;
            visitCount++;
        }

        if (visitCount < islandCount) {
            result.append(-1);
        } else {
            result.append(answer);
        }


        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    public static void union(int node1, int node2) {
        parent[getParent(node2)] = parent[node1];
    }
    public static int getParent(int node) {
        if(node == parent[node]) {
            return node;
        }

        return parent[node] = getParent(parent[node]);
    }

    public static boolean isSameParent(int node1, int node2) {
        return getParent(node1) == getParent(node2);

    }

    public static void setIsland(int row, int col, int id) {
        if (row < 1 || col < 1 || row > inputRow || col > inputCol) {
            return;
        }

        if (graph[row][col] != -1) {
            return;
        }

        graph[row][col] = id;
        setIsland(row + 1, col, id);
        setIsland(row - 1, col, id);
        setIsland(row, col + 1, id);
        setIsland(row, col - 1, id);

    }

    public static void createRowBridge(int startIsoId, int row, int col, int count) {
        try {
            if (graph[row][col + 1] == 0) {
                count++;
                createRowBridge(startIsoId, row, col + 1, count);
            } else {
                if (graph[row][col + 1] == startIsoId || count < 2) {
                    return;
                }

                pq.add(new Bridge(startIsoId, graph[row][col + 1], count));
            }
        } catch (IndexOutOfBoundsException e) {

        }
    }

    public static void createColBridge(int startIsoId, int row, int col, int count) {
        try {
            if (graph[row + 1][col] == 0) {
                count++;
                createColBridge(startIsoId, row + 1, col, count);
            } else {
                if (graph[row + 1][col] == startIsoId || count < 2) {
                    return;
                }

                pq.add(new Bridge(startIsoId, graph[row + 1][col], count));
            }
        } catch (IndexOutOfBoundsException e) {

        }
    }


}

class Bridge implements Comparable<Bridge> {
    int island1;
    int island2;
    int value;

    public Bridge(int island1, int island2, int value) {
        this.island1 = island1;
        this.island2 = island2;
        this.value = value;


    }

    @Override
    public int compareTo(Bridge o) {
        return this.value - o.value;
    }
}
