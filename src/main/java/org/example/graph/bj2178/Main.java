package graph.bj2178;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[][] arr;
    public static boolean[][] visited;
    public static int rows;
    public static StringBuilder result;
    public static Queue<Node> queue = new LinkedList<>();
    public static int cols;
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        result = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        rows = Integer.parseInt(st.nextToken());
        cols = Integer.parseInt(st.nextToken());

        arr = new int[rows + 1][cols + 1];
        visited = new boolean[rows + 1][cols + 1];
        for (int i = 1; i <= rows; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 1; j <= cols; j++) {
                arr[i][j] = temp[j-1] - '0';
            }
        }

        Node start = new Node(1,1,1);
        bfs(start);


        bw.write(result.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
    public static void bfs(Node node) {

        if(visited[node.row][node.col]) {
            return;
        }

        visited[node.row][node.col] = true;

        if(node.row == rows && node.col == cols) {
            result.append(node.count);
            result.append("\n");
            return;
        }

        addQueue(node.row + 1, node.col, node.count + 1);
        addQueue(node.row - 1, node.col, node.count + 1);
        addQueue(node.row, node.col + 1, node.count + 1);
        addQueue(node.row, node.col - 1, node.count + 1);

        while (!queue.isEmpty()) {
            Node next = queue.poll();
            bfs(next);
        }

        visited[node.row][node.col] = false;
    }
    public static void addQueue(int row, int col, int count) {
        try {
            if(arr[row][col] == 1 && !visited[row][col]) {
                Node n = new Node(row, col, count);
                queue.add(n);
            }
        }catch (ArrayIndexOutOfBoundsException ignored){
        }
    }
}

class Node {
    int row;
    int col;

    int count;

    public Node(int row, int col, int count) {
        this.row = row;
        this.col = col;
        this.count = count;
    }
}