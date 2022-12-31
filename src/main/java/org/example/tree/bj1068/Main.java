package tree.bj1068;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeSize = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        List<Integer> graph[] = new List[nodeSize];
        for (int i = 0; i < nodeSize; i++) {
            graph[i] = new ArrayList<>();
        }
        int topIndex = -1;

        for (int i = 0; i < nodeSize; i++) {
            int nodeParent = Integer.parseInt(st.nextToken());
            if(nodeParent == -1) {
                topIndex = i;
            }else {
                graph[nodeParent].add(i);
            }
        }

        int deleteNode = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        //stack.push(deleteNode);


        int leafCount = 0;
        stack.push(topIndex);
        while (!stack.isEmpty()) {
            Integer now = stack.pop();
            if(now == deleteNode) {
                continue;
            }
            int count = 0;
            for(Integer i : graph[now]) {
                if(i == deleteNode) {
                    continue;
                }
                count++;
                stack.push(i);
            }

            if(count == 0) {
                leafCount++;
            }
        }

        result.append(leafCount);
        result.append("\n");

        
        bw.write(result.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
}
