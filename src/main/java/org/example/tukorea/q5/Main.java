package tukorea.q5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static char map[][] = new char[10][10];
    public static int point[][] = new int[10][10];
    public static boolean visited[][] = new boolean[10][10];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            String next = scanner.next();
            for (int j = 0; j < 10; j++) {
                map[i][j] = next.charAt(j);
            }
        }

        int cowCount = 0;
        boolean isEnd = false;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (map[i][j] == 'B') {
                    cowCount = bfs(i, j);
                    isEnd = true;
                    break;
                }
            }
            if (isEnd) {
                break;
            }
        }

        System.out.println(cowCount - 1);
    }

    public static int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        point[x][y] = 0;
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if(map[node.rows][node.cols] == 'L') {
                return point[node.rows][node.cols];
            }

            //상
            if (node.rows - 1 >= 0 && map[node.rows - 1][node.cols] != 'R' && !visited[node.rows - 1][node.cols]) {
                queue.add(new Node(node.rows - 1, node.cols));
                point[node.rows - 1][node.cols] = point[node.rows][node.cols] + 1;
                visited[node.rows - 1][node.cols] = true;
            }
            //하
            if (node.rows + 1 < 10 && map[node.rows + 1][node.cols] != 'R' && !visited[node.rows + 1][node.cols]) {
                queue.add(new Node(node.rows + 1, node.cols));
                point[node.rows + 1][node.cols] = point[node.rows][node.cols] + 1;
                visited[node.rows + 1][node.cols] = true;
            }

            //좌
            if (node.cols - 1 >= 0 && map[node.rows][node.cols-1] != 'R' && !visited[node.rows][node.cols -1]) {
                queue.add(new Node(node.rows, node.cols -1));
                point[node.rows][node.cols -1] = point[node.rows][node.cols] + 1;
                visited[node.rows][node.cols -1] = true;
            }
            //우

            if (node.cols + 1 < 10 && map[node.rows][node.cols+1] != 'R' && !visited[node.rows][node.cols +1]) {
                queue.add(new Node(node.rows, node.cols +1));
                point[node.rows][node.cols +1] = point[node.rows][node.cols] + 1;
                visited[node.rows][node.cols +1] = true;
            }
        }
        return -1;
    }
}

class Node {
    int rows;
    int cols;

    public Node(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }
}
