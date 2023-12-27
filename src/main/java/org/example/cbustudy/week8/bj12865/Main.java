package org.example.cbustudy.week8.bj12865;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //목표 : 가치의 최대값 구하기

        final int itemSize = Integer.parseInt(st.nextToken());
        final int maxWeight = Integer.parseInt(st.nextToken());

        //물건을 무게순 or 가치순으로 정렬

        int[][] dp = new int[itemSize][ maxWeight + 1];

        List<Item> items = new ArrayList<>();

        for (int i = 0; i < itemSize; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            items.add(new Item(weight, value));
        }

        for (int i = 1; i <= maxWeight; i++) {
            if(i >= items.get(0).weight) {
                dp[0][i] = items.get(0).value;
            }
            for (int j = 1; j < itemSize; j++) {
                Item now = items.get(j);

                dp[j][i] = dp[j-1][i];
                if(i >= now.weight) {
                    if(i - now.weight < 0) {
                        dp[j][i] = Math.max(dp[j][i], now.value);
                    }else {
                        dp[j][i] = Math.max(dp[j][i], now.value + dp[j-1][i-now.weight]);
                    }
                }
            }
        }

        sb.append(dp[itemSize-1][maxWeight]);




        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}

class Item {
    int weight;
    int value;

    public Item(final int weight, final int value) {
        this.weight = weight;
        this.value = value;
    }
}
