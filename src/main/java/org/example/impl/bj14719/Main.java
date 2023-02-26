package org.example.impl.bj14719;

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
    
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean[] max = new boolean[width];
        int answer = 0;
        for (int h = 1; h <= height; h++) {
            for (int i = 1; i < width - 1; i++) {
                if(!max[i] && arr[i] < h && arr[i-1] >= h) {
                    int countTemp = 1;
                    boolean isCap = true;
                    for (int j = i+ 1; j < width; j++) {
                        if(max[j]) {
                            for (int k = i; k <= j; k++) {
                                max[k] = true;
                            }
                            i = j;
                            isCap = false;
                            break;
                        }else if(arr[j] >= h) {
                            i = j;
                            break;
                        }
                        countTemp++;
                        if(j == width - 1) {
                            for (int k = i; k <= j; k++) {
                                max[k] = true;
                            }
                            i = j;
                            isCap = false;
                        }
                    }
                    if(isCap) {
                        answer += countTemp;
                    }
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
