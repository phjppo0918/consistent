package org.example.structure.bj21939;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        TreeSet<Quest> treeSet = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        int caseSize = Integer.parseInt(st.nextToken());
        for (int i = 0; i < caseSize; i++) {
            st = new StringTokenizer(br.readLine());
            int no = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            Quest quest = new Quest(no, level);
            treeSet.add(quest);
            map.put(no, level);
        }
        int commandSize = Integer.parseInt(br.readLine());
        for (int i = 0; i < commandSize ; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "add":
                    int no = Integer.parseInt(st.nextToken());
                    int level = Integer.parseInt(st.nextToken());
                    Quest quest = new Quest(no, level);
                    treeSet.add(quest);
                    map.put(no, level);
                    break;
                case "recommend":
                    int num = Integer.parseInt(st.nextToken());
                    if(num == 1) {
                        sb.append(treeSet.last().num).append("\n");
                    }else {
                        sb.append(treeSet.first().num).append("\n");
                    }
                    break;
                case "solved":
                    int number = Integer.parseInt(st.nextToken());
                    treeSet.remove(new Quest(number, map.get(number)));
                    map.remove(number);
                    break;
            }
        }

        bw.write(sb.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
}

class Quest implements Comparable<Quest> {
    int num;
    int level;

    public Quest(int num, int level) {
        this.num = num;
        this.level = level;
    }

    @Override
    public int compareTo(Quest o) {
        if( o.level == this.level) {
            return this.num - o.num;
        }
        return this.level - o.level;
    }
}