package org.example.dbn.bj1713;

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

        int photoCount = Integer.parseInt(st.nextToken());
        int likeCount = Integer.parseInt(br.readLine());

        int[] count = new int[101];
        int[] photo = new int[photoCount + 1];
        int[] setTimes = new int[photoCount + 1];

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < likeCount; i++) {
            int now = arr[i];
            count[now]++;

            boolean present = Arrays.stream(photo).anyMatch(i2 -> i2 == now);
            if(present) {
                continue;
            }
            int nextPivot = 1;
            for (int j = 2; j <= photoCount; j++) {
                if(photo[j] == 0) {
                    nextPivot = j;
                    break;
                }

                if(count[photo[nextPivot]] > count[photo[j]]) {
                    nextPivot = j;
                }else if(count[photo[nextPivot]] == count[photo[j]] &&
                setTimes[nextPivot] > setTimes[j]) {
                    nextPivot = j;
                }
            }

            if(count[photo[nextPivot]] <= count[now]) {
                count[photo[nextPivot]] = 0;
                photo[nextPivot] = now;
                setTimes[nextPivot] = i;

            }
        }

        Arrays.sort(photo);
        Arrays.stream(photo).filter(i -> i != 0).forEach(i -> sb.append(i).append(" "));


        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

}
