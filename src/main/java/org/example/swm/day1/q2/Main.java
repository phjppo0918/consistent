package org.example.swm.day1.q2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int size = Integer.parseInt(st.nextToken());

        final int[] card = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] score = new int[size];

        int[] board = new int [1_000_001];
        Arrays.fill(board, -1);
        for (int i = 0; i < size; i++) {
            board[card[i]] = i;
        }


        for (int i = 1; i < 1_000_001; i++) {
            if(board[i] != -1) {
                int winner = board[i];

                for (int j = 1; j*i <= 1_000_000; j++) {
                    if(board[i*j] != -1) {
                        score[winner]++;
                        score[board[i*j]]--;
                    }
                }
            }
        }

        Arrays.stream(score).forEach(s -> {
            sb.append(s).append(" ");
        });


        
        bw.write(sb.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
}

