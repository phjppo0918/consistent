package org.example.kakao2.c1;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;

        Map<String, Integer> index = new HashMap<>();

        int[][] count = new int[friends.length][friends.length];
        int[] point = new int[friends.length];

        for (int i = 0; i < friends.length; i++) {
            index.put(friends[i], i);
        }


        for (String g : gifts) {
            final String[] split = g.split(" ");
            String sender = split[0];
            String receiver = split[1];
            count[index.get(sender)][index.get(receiver)]++;
            point[index.get(sender)]++;
            point[index.get(receiver)]--;
        }

        int[] newCount = new int[friends.length];

        for (int i = 0; i < friends.length -1; i++) {
            for (int j = i+1; j < friends.length; j++) {
                if(count[i][j] > count[j][i]) { // i 가 더 많이 선물했으면
                    newCount[i]++;
                    answer = Math.max(answer,  newCount[i]);
                }else if(count[i][j] < count[j][i]) {
                    newCount[j]++;
                    answer = Math.max(answer,  newCount[j]);
                }else {
                    if (point[i] > point[j]) {
                        newCount[i]++;
                        answer = Math.max(answer,  newCount[i]);
                    }else if(point[i] < point[j]) {
                        newCount[j]++;
                        answer = Math.max(answer,  newCount[j]);
                    }
                }
            }
        }



        return answer;

    }


}
