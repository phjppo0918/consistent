package org.example.dp.bj2579;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());

        int[] dp = new int[size + 3];
        int[] value = new int[size + 1];

        for (int i = 1; i <= size; i++) {
            value[i] = Integer.parseInt(br.readLine());
        }
        if(size == 1) {
            sb.append(value[1]);
        }else if(size == 2) {
            sb.append(value[1] + value[2]);
        }else {
            dp[1] = value[1];
            dp[2] = value[2] + value[1];
            for (int i = 3; i <= size; i++) {
                dp[i] = Math.max(dp[i-2], dp[i-3] + value[i-1]);
                dp[i] += value[i];
            }

            sb.append(dp[size]);
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}

class Animal {
    public Animal speak() {
        System.out.println("Animal speaks");
        return new Animal();
    }
}

class Cat extends Animal {
    @Override
    public Cat speak() {
        System.out.println("Cat speaks");
        return new Cat();
    }
}