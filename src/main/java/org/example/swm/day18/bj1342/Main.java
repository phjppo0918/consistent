package org.example.swm.day18.bj1342;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        Map<Character, Integer> counts = new HashMap<>();

        input.chars().forEach(c -> counts.put((char) c, counts.getOrDefault((char) c, 0) + 1));
        int answer = getCount('0', counts);

        sb.append(answer);
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    private static int getCount(char before, Map<Character, Integer> counts) {
        int result = 0;
        for (char i :counts.keySet()) {
            if(before == i) {
                continue;
            }
            int pacCount = 0;
            if(counts.get(i) == 1) {
                pacCount++;
            }else if(counts.get(i) == 0) {
                
            }
        }
        for (char i :counts.keySet()) {
            if (i != before && counts.get(i) > 0) {
                Map<Character, Integer> copy = new HashMap<>(counts);
                copy.put(i, copy.get(i) - 1);
                if(copy.values().stream().allMatch(j -> j == 0 || j == 1) ||  copy.values().stream().filter(kk -> kk == 1).count() > 1){
                    int ans = 1;
                    for (int k = 1; k < copy.values().stream().filter(kk -> kk == 1).count()+2; k++) {
                        ans *= k;
                    }
                    return ans;
                }else {
                    result += getCount(i, copy);
                }
            }
        }

        return result;
    }
}
