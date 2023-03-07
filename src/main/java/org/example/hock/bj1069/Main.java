package org.example.hock.bj1069;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int move = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());

        double length = Math.sqrt(x * x + (double)y * y);
        double answer = length;
        if ((double)move / time > 1) {


            int count = (int) length / move;
            double jumpWalk = count * time;
            jumpWalk += length % move;

            double onlyJump = Double.MAX_VALUE;
            if(count !=0 &&length > move * count) {
                onlyJump = (count + 1) * time;
            }

            double doubleJump = Double.MAX_VALUE;
            if(count <= 1|| move * 2 >= length) {
                doubleJump = time * 2;
            }

            double overJump = (count + 1) * time;
            overJump += (double) move *(count+ 1) - length;

            answer = Math.min(onlyJump, answer);
            answer = Math.min(jumpWalk, answer);
            answer = Math.min(overJump, answer);
            answer = Math.min(doubleJump, answer);
        }
        sb.append(answer);
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
