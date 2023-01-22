package org.example.greedy.bj1826;

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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int gasStationSize = Integer.parseInt(st.nextToken());
        Queue<GasStation> gasStations = new PriorityQueue<>();
        for (int i = 0; i < gasStationSize; i++) {
            st = new StringTokenizer(br.readLine());
            int location = Integer.parseInt(st.nextToken());
            int fuel = Integer.parseInt(st.nextToken());
            gasStations.add(new GasStation(location, fuel));
        }
        st = new StringTokenizer(br.readLine());
        int country = Integer.parseInt(st.nextToken());
        int pivot = Integer.parseInt(st.nextToken());
        int count = 0;
        Queue<Integer> fuels = new PriorityQueue<>(Collections.reverseOrder());
        while (pivot < country) {
            while (!gasStations.isEmpty() && gasStations.peek().location <= pivot) {
                fuels.add(gasStations.poll().fuel);
            }

            if(fuels.isEmpty()) {
                break;
            }

            pivot += fuels.poll();
            count++;
        }

        if(pivot < country) {
            sb.append(-1);
        }else {
            sb.append(count);
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}

class GasStation implements Comparable<GasStation> {
    int location;
    int fuel;

    public GasStation(int location, int fuel) {
        this.location = location;
        this.fuel = fuel;
    }

    @Override
    public int compareTo(GasStation o) {
        return location - o.location;
    }
}