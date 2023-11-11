package org.example.swm.day8.bj1106;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int minMember = Integer.parseInt(st.nextToken());
        int citySize = Integer.parseInt(st.nextToken());

        List<City> cities = new ArrayList<>();
        for (int i = 0; i < citySize; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int member = Integer.parseInt(st.nextToken());
            cities.add(new City(cost, member));
        }

        int[][] dp = new int[citySize][22];
        

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}

class City implements Comparable<City> {
    int cost;
    int member;

    @Override
    public int compareTo(final City o) {
        if (this.member == o.member) {
            return this.cost - o.cost;
        }
        return this.member - o.member;
    }

    public City(final int cost, final int member) {
        this.cost = cost;
        this.member = member;
    }
}