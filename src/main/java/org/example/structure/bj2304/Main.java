package org.example.structure.bj2304;

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
    
        int stickSize = Integer.parseInt(st.nextToken());
        int topSize = -1;
        int topPivot = -1;
        Stick[] stickArr = new Stick[stickSize];
        for (int i = 0; i < stickSize; i++) {
            st = new StringTokenizer(br.readLine());
            int location = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());

            stickArr[i] = new Stick(location, size);
        }
        Arrays.sort(stickArr);
        for (int i = 0; i < stickSize; i++) {
            int size = stickArr[i].size;
            if (topSize < size) {
                topSize = size;
                topPivot = i;
            }
        }
        int total = 0;
        Stick minStick = stickArr[0];
        for (int i = 1; i < topPivot; i++) {
            if(minStick.size < stickArr[i].size) {
                total += minStick.size * (stickArr[i].location - minStick.location);
                minStick = stickArr[i];
            }
        }
        total += minStick.size * (stickArr[topPivot].location - minStick.location);
        minStick = stickArr[stickSize - 1];
        for (int i = stickSize-1; i > topPivot; i--) {
            if(minStick.size < stickArr[i].size) {
                total += minStick.size * (minStick.location - stickArr[i].location);
                minStick = stickArr[i];
            }
        }
        total += stickArr[topPivot].size;
        total += minStick.size * (minStick.location - stickArr[topPivot].location);
        sb.append(total);
        
        bw.write(sb.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
}

class Stick implements Comparable<Stick>{
    int location;
    int size;

    public Stick(int location, int size) {
        this.location = location;
        this.size = size;
    }

    @Override
    public int compareTo(Stick o) {
        return location - o.location;
    }
}
