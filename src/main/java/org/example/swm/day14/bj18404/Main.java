package org.example.swm.day14.bj18404;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static int[] px = {-2, -2, -1, -1, 1, 1, 2, 2};
    public static int[] py = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int boardSize = Integer.parseInt(st.nextToken());
        int targetCount = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        Pivot start = new Pivot(x, y);

        List<Pivot> pivs = new ArrayList<>();
        for (int i = 0; i < targetCount; i++) {
            st = new StringTokenizer(br.readLine());
            int tx = Integer.parseInt(st.nextToken());
            int ty = Integer.parseInt(st.nextToken());
            Pivot target = new Pivot(tx, ty);
            pivs.add(target);
        }

        boolean[][] visited = new boolean[boardSize + 1][boardSize + 1];
        int[][] minCount = new int[boardSize + 1][boardSize + 1];
        Queue<Pivot> queue = new LinkedList<>();
        queue.add(start);
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Pivot now = queue.poll();
            for (int j = 0; j < 8; j++) {
                int nextX = now.x + px[j];
                int nextY = now.y + py[j];
                Pivot next = new Pivot(nextX, nextY);
                if (next.isOver(boardSize) || visited[nextX][nextY]) {
                    continue;
                }
                visited[nextX][nextY] = true;
                minCount[nextX][nextY] = minCount[now.x][nextY] + 1;
                queue.add(next);
            }
        }
        for (Pivot p : pivs) {
            sb.append(minCount[p.x][p.y]).append(" ");
        }


        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}

class Pivot {
    int x;
    int y;

    public Pivot(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isOver(int size) {
        if (x <= 0 || y <= 0 || x > size || y > size) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Pivot pivot = (Pivot) o;
        return x == pivot.x && y == pivot.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
