package org.example.structure.bj19644;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int loadSize = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int range = Integer.parseInt(st.nextToken());
        int power = Integer.parseInt(st.nextToken());
        int bombSize = Integer.parseInt(br.readLine());
        Queue<Integer> zombie = new LinkedList<>();
        for (int i = 0; i < loadSize; i++) {
            zombie.add(Integer.parseInt(br.readLine()));
        }
        String answer = "YES";
        int leftPivot = 0;
        int rightPivot = 0;
        Queue<Integer> useBomb = new LinkedList<>();
        int bombCount = 0;
        while (!zombie.isEmpty()) {
            int nowZombie = zombie.poll();
            rightPivot++;
            if(rightPivot - leftPivot > range) {
                leftPivot++;
                if(!useBomb.isEmpty() && useBomb.peek() < leftPivot) {
                    useBomb.poll();
                }
            }

            int nowDamage = Math.max(power, (rightPivot - leftPivot- useBomb.size()) * power);
            if(nowDamage < nowZombie) {
                bombCount++;
                useBomb.add(rightPivot);
                if(bombCount > bombSize) {
                    answer = "NO";
                    break;
                }
            }
        }
        sb.append(answer);
        
        bw.write(sb.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
}
