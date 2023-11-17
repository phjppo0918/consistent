package org.example.cbustudy.week5.bj9252;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        String line = br.readLine();
        String sample = br.readLine();

        int[][] lcs = new int[sample.length() + 1][line.length() + 1];

        for (int i = 1; i <= sample.length(); i++) {
            for (int j = 1; j <= line.length(); j++) {
                if (sample.charAt(i - 1) == line.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }

        int count = lcs[sample.length()][line.length()];
        List<Character> list = new ArrayList<>();

        int i = sample.length();
        int j = line.length();
        while (count > 0) {
            while (lcs[i][j - 1] == count) {
                j--;
            }
            while (lcs[i-1][j] == count) {
                i--;
            }

            list.add(line.charAt(j - 1));
            i--;
            j--;
            count--;
        }

        sb.append(list.size()).append("\n");
        for (int k = list.size() - 1; k >= 0; k--) {
            sb.append(list.get(k));
        }


        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
