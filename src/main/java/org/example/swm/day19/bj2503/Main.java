package org.example.swm.day19.bj2503;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        final int answerCount = Integer.parseInt(br.readLine());
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < answerCount; i++) {
            st = new StringTokenizer(br.readLine());
            final String line = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            balls.add(new Ball(line, strike, ball));
        }


        int guess = 0;
        for (int i = 111; i <= 999; i++) {
            String next = i + "";
            if(next.contains("0") || next.chars().distinct().count() < 3)  {
                continue;
            }
            int gCount = 0;
            for(Ball b : balls) {
                if(b.isSuccess(next)) {
                    gCount++;
                }
            }
            if(gCount == answerCount) {
                guess++;
            }
        }
        sb.append(guess);


        bw.write(sb.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
}

class Ball {
    String line;
    int strike;
    int ball;

    public Ball(final String line, final int strike, final int ball) {
        this.line = line;
        this.strike = strike;
        this.ball = ball;
    }

    public boolean isSuccess(String k) {
        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < 3; i++) {
            if(line.charAt(i) == k.charAt(i)) {
                strikeCount++;
            }
        }
        for (int i = 1; i <= 9; i++) {
            if(line.contains(i+"") && k.contains(i+"") ) {
                ballCount++;
            }
        }
        ballCount -= strikeCount;

        return strike == strikeCount && ballCount == ball;
    }
}
