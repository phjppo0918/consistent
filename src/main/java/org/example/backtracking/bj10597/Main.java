package org.example.backtracking.bj10597;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static int[] graph;
    private static boolean[] doDoubleJump;
    private static boolean[] doSingleJump;
    private static int[] parentPivot;
    private static int[] record;

    private static int maxNum;
    private static boolean[] visited;
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int[] input = br.readLine().chars()
                .map(i -> i - '0')
                .toArray();
        if(input.length <= 9) {
            maxNum = input.length;
        }else {
            maxNum = (input.length + 9) / 2;
        }
        visited = new boolean[maxNum + 1];


        graph = new int[input.length];
        parentPivot = new int[input.length + 3];
        record = new int[input.length + 1];
        doDoubleJump = new boolean[input.length + 1];
        doSingleJump = new boolean[input.length + 1];
        doDoubleJump[input.length] = true;
        System.arraycopy(input, 0, graph, 0, input.length);


        int pivot = 0;
        while (pivot < input.length) {
            if(!doSingleJump[pivot]) {
                doSingleJump[pivot] = true;
                int singleTemp = graph[pivot];
                if(!visited[singleTemp] && singleTemp != 0) {
                    record[pivot] = singleTemp;
                    parentPivot[pivot + 1] = pivot;
                    pivot++;
                    visited[singleTemp] = true;
                    continue;
                }
            }

            if(!doDoubleJump[pivot]) {
                doDoubleJump[pivot] = true;
                int recordTemp = parseTwo(pivot);

                if(recordTemp <= maxNum && !visited[recordTemp]) {
                    visited[record[pivot]] = false;
                    record[pivot] = recordTemp;
                    visited[recordTemp] = true;
                    parentPivot[pivot + 2] = pivot;
                    pivot+=2;

                    continue;
                }
            }

            doSingleJump[pivot] = false;
            doDoubleJump[pivot] = false;
            visited[record[pivot]] = false;
            record[pivot] = 0;
            pivot = parentPivot[pivot];
        }
        pivot = input.length - 1;
        if(record[pivot] == 0) {
            pivot--;
        }
        List<Integer> answer = new ArrayList<>();
        while (pivot != 0) {
            answer.add(record[pivot]);
            pivot = parentPivot[pivot];
        }
        answer.add(record[0]);
        Collections.reverse(answer);
        for(Integer i : answer) {
            result.append(i).append(" ");
        }

        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }


    static int parseTwo(int index) {
        if(index + 1 >= graph.length ||  graph[index] == 0) {
            return 51;
        }
        return graph[index] * 10 + graph[index + 1];
    }
}
