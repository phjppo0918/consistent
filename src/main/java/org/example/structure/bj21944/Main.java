package org.example.structure.bj21944;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        TreeSet<Quest> treeSet = new TreeSet<>();
        Map<Integer, Quest> map = new HashMap<>();
        Map<Integer, TreeSet<Quest>> subTreeMap = new HashMap<>();
        for (int i = 1; i <= 100; i++) {
            subTreeMap.put(i, new TreeSet<>());
        }

        int caseSize = Integer.parseInt(st.nextToken());
        for (int i = 0; i < caseSize; i++) {
            st = new StringTokenizer(br.readLine());
            int no = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            int type = Integer.parseInt(st.nextToken());
            Quest quest = new
                    Quest(no, level, type);
            treeSet.add(quest);
            map.put(no, quest);
            subTreeMap.get(type).add(quest);
        }
        int commandSize = Integer.parseInt(br.readLine());
        for (int i = 0; i < commandSize; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "add":
                    int no = Integer.parseInt(st.nextToken());
                    int level = Integer.parseInt(st.nextToken());
                    int type = Integer.parseInt(st.nextToken());
                    Quest quest = new
                            Quest(no, level, type);
                    treeSet.add(quest);
                    map.put(no, quest);
                    subTreeMap.get(type).add(quest);
                    break;
                case "recommend":
                    int reco1Type = Integer.parseInt(st.nextToken());
                    int num = Integer.parseInt(st.nextToken());
                    if (num == 1) {
                        sb.append(subTreeMap.get(reco1Type).last().num).append("\n");
                    } else {
                        sb.append(subTreeMap.get(reco1Type).first().num).append("\n");
                    }
                    break;
                case "recommend2":
                    int num2 = Integer.parseInt(st.nextToken());
                    if (num2 == 1) {
                        sb.append(treeSet.last().num).append("\n");
                    } else {
                        sb.append(treeSet.first().num).append("\n");
                    }
                    break;
                case "recommend3":
                    int num3 = Integer.parseInt(st.nextToken());
                    int targetLevel = Integer.parseInt(st.nextToken());
                    if (num3 == 1) {
                        Quest ceiling = treeSet.ceiling(new Quest(0, targetLevel, 0));
                        if(ceiling == null) {
                            sb.append(-1).append("\n");
                        }else {
                            sb.append(ceiling.num).append("\n");
                        }

                    } else {
                        Quest lower = treeSet.lower(new Quest(0, targetLevel, 0));
                        if(lower == null) {
                            sb.append(-1).append("\n");
                        }else {
                            sb.append(lower.num).append("\n");
                        }
                    }
                    break;
                case "solved":
                    int number = Integer.parseInt(st.nextToken());
                    Quest target = map.get(number);
                    treeSet.remove(target);
                    subTreeMap.get(target.type).remove(target);
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
    int type;

    public Quest(int num, int level, int type) {
        this.num = num;
        this.level = level;
        this.type = type;
    }

    @Override
    public int compareTo(
            Quest o) {
        if (o.level == this.level) {
            return this.num - o.num;
        }
        return this.level - o.level;
    }
}