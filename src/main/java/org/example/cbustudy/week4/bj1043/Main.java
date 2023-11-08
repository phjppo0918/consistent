package org.example.cbustudy.week4.bj1043;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] union;
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeSize = Integer.parseInt(st.nextToken());
        union = new int[nodeSize + 1];
        for (int i = 0; i <= nodeSize; i++) {
            union[i] = i;
        }
        int partyCount = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int trueCount = Integer.parseInt(st.nextToken());
        List<Integer> trueMans = new ArrayList<>();

        for (int i = 0; i < trueCount; i++) {
            int num = Integer.parseInt(st.nextToken());
            trueMans.add(num);
        }
        Collections.sort(trueMans);
        for (int i = 0; i < trueCount; i++) {
            union[trueMans.get(i)] = trueMans.get(0);
        }
        List<Integer>[] parties = new List[partyCount + 1];
        for (int i = 0; i <= partyCount; i++) {
            parties[i] = new ArrayList<>();
        }


        for (int i = 1; i <= partyCount; i++) {
            st = new StringTokenizer(br.readLine());
            int memSize = Integer.parseInt(st.nextToken());
            List<Integer> mens = new ArrayList<>();
            for (int j = 0; j < memSize; j++) {
                final int member = Integer.parseInt(st.nextToken());
                mens.add(member);
                parties[i].add(member);
            }
            Collections.sort(mens);
            for (int j = 1; j < memSize; j++) {
                union[getUnion(mens.get(j))] = getUnion(mens.get(0));
            }
        }

        if(trueCount == 0) {
            sb.append(partyCount);
        }else {
            int trueMember = getUnion(trueMans.get(0));

            int answer = 0;
            for (int i = 1; i <=partyCount ; i++) {
                boolean can = true;
                for (int j = 0; j < parties[i].size(); j++) {
                    if(getUnion(parties[i].get(j)) == trueMember) {
                        can = false;
                        break;
                    }
                }
                if(can) {
                    answer++;
                }
            }

            sb.append(answer);
        }

        
        bw.write(sb.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }

    static int getUnion(int num) {
        if(num == union[num]) {
            return num;
        }
        union[num] = getUnion(union[num]);
        return union[num];
    }
}
