package org.example.structure.bj1525;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static String target = "123456780";
    static Map<String, Integer> map = new HashMap<>();
    //상하좌우 pivot         하  상  좌  우
    static int xPivot[] = {1, -1, 0, 0};
    static int yPivot[] = {0, 0, -1, 1};
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        String init = "";
        for (int i = 0; i < 3; i++) {
            init += br.readLine().replace(" ", "");
        }

        sb.append(bfs(init));
        
        bw.write(sb.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
    public static int bfs(String init) {
        Queue<String> queue = new LinkedList<>();
        map.put(init, 0);
        queue.add(init);

        while (!queue.isEmpty()) {
            String now = queue.poll();
            if(now.equals(target)) {
                return map.get(now);
            }
            int count = map.get(now);

            int blankIndex = now.indexOf('0');
            int blankX = blankIndex%3;
            int blankY = blankIndex/3;
            for (int i = 0; i < 4; i++) {
                int nextX = blankX + xPivot[i];
                int nextY = blankY + yPivot[i];
                if(nextX < 0 || nextY < 0 || nextX > 2 || nextY > 2) {
                    continue;
                }
                int nextPivot = nextY * 3 + nextX;
                char change = now.charAt(nextPivot);
                String next = now.replace(change, 'c');
                next = next.replace('0', change);
                next = next.replace('c', '0');
                if(!map.containsKey(next)) {
                    map.put(next, count + 1);
                    queue.add(next);
                }
            }
        }


        return -1;
    }
}
