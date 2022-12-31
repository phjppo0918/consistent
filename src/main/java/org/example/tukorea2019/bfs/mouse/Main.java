package tukorea2019.bfs.mouse;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static boolean[][] visited;

    public static boolean clear = false;
    private static int row;
    private static int col;
    private static char[][] graph;
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        graph = new char[row][];
        for (int i = 0; i < row; i++) {
            graph[i] = br.readLine().toCharArray();
        }
        visited = new boolean[row][col];
        boolean isSearch = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(graph[i][j] == 'M') {
                    bfs(new Node(i, j));
                    graph[i][j] = 'M';
                    isSearch = true;
                    break;
                }
            }
            if(isSearch) break;
        }

        if(clear) {
            result.append("YES\n");
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    result.append(graph[i][j]);
                }
                result.append("\n");
            }
        }else {
            result.append("NO");
        }

        
        bw.write(result.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
    private static void bfs(Node startNode) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(startNode);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if(graph[node.row][node.col] == 'D') {
                clear = true;
                while (node.before != null) {
                    Node now = node.before;
                    graph[now.row][now.col] = 'x';
                    node = now;
                }
                return;
            }
            int expectTop = node.row - 1;
            int expectBot = node.row + 1;
            int expectLeft = node.col - 1;
            int expectRight = node.col + 1;

            if(expectTop < 0) {
                expectTop = row -1;
            }
            if(expectBot >= row) {
                expectBot = 0;
            }
            if(expectLeft < 0) {
                expectLeft = col - 1;
            }
            if (expectRight >= col) {
                expectRight = 0;
            }
            //상
            if(graph[expectTop][node.col] != '#' && !visited[expectTop][node.col]) {
                visited[expectTop][node.col] = true;
                queue.add(new Node(expectTop, node.col, node));
            }
            //하
            if(graph[expectBot][node.col] != '#' && !visited[expectBot][node.col]) {
                visited[expectBot][node.col] = true;
                queue.add(new Node(expectBot, node.col, node));
            }
            //좌
            if(graph[node.row][expectLeft] != '#' && !visited[node.row][expectLeft]) {
                visited[node.row][expectLeft] = true;
                queue.add(new Node(node.row, expectLeft, node));
            }
            //우
            if(graph[node.row][expectRight] != '#' && !visited[node.row][expectRight]) {
                visited[node.row][expectRight] = true;
                queue.add(new Node(node.row, expectRight, node));
            }
        }
    }
}
class Node {
    int row;
    int col;

    Node before;

    public Node(int row, int col, Node before) {
        this.row = row;
        this.col = col;
        this.before = before;
    }

    public Node(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
