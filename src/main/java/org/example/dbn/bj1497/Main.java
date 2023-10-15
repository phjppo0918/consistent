package org.example.dbn.bj1497;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int gSize = Integer.parseInt(st.nextToken());
        int mSize = Integer.parseInt(st.nextToken());

        List<String> keys = new ArrayList<>();
        Map<String, List<Boolean>> maps = new HashMap<>();

        for (int i = 0; i < gSize; i++) {
            st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            String musics = st.nextToken();
            List<Boolean> booleans = new ArrayList<>();
            for (int j = 0; j < mSize; j++) {
                if (musics.charAt(j) == 'Y') {
                    booleans.add(Boolean.TRUE);
                } else {
                    booleans.add(Boolean.FALSE);
                }
            }

            keys.add(key);
            maps.put(key, booleans);
        }

        for (int i = 0; i < gSize; i++) {
            String nowKey = keys.get(i);
            if (!maps.containsKey(nowKey)) {
                continue;
            }
            List<Boolean> nowMusics = maps.get(nowKey);

            for (int j = 0; j < gSize; j++) {
                String vsKey = keys.get(j);
                if (!maps.containsKey(vsKey)) {
                    continue;
                }

                List<Boolean> vsMusics = maps.get(vsKey);
                boolean isNowBig = true;
                boolean isVsBig = true;
                for (int k = 0; k < mSize; k++) {
                    if (nowMusics.get(k) == true) {
                        if (vsMusics.get(k) == false) {
                            isVsBig = false;
                        }
                    } else {
                        if (vsMusics.get(k) == true) {
                            isNowBig = false;
                        }
                    }

                    if (vsMusics.get(k) == true) {
                        if (nowMusics.get(k) == false) {
                            isNowBig = false;
                        }
                    } else {
                        if (nowMusics.get(k) == true) {
                            isVsBig = false;
                        }
                    }

                    if (!isNowBig && !isVsBig) {
                        continue;
                    } else if (isNowBig) {
                        maps.remove(vsKey);
                    } else {
                        maps.remove(nowKey);
                        break;
                    }
                }
            }
            Set<String> strings = maps.keySet();


        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

}