package graph.bj1717;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static int graph[];
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeSize = Integer.parseInt(st.nextToken());
        int activeSize = Integer.parseInt(st.nextToken());
        graph = new int[nodeSize + 1];
        for (int i = 0; i <= nodeSize; i++) {
            graph[i] = i;
        }
        for (int i = 0; i < activeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int active = Integer.parseInt(st.nextToken());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            if(active == 0) { // 합연산
                union(num1, num2);
            }else { // 매치
                if(confirm(num1, num2)) {
                    result.append("YES");
                }else {
                    result.append("NO");
                }

                result.append("\n");
            }
        }

        bw.write(result.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }

    public static void union(int num1, int num2) {

        if(num1 != num2) {
            graph[getParent(num2)] = getParent(num1);
        }


    }

    public static boolean confirm(int num1, int num2) {

        return getParent(num1) == getParent(num2);
    }

    public static int getParent(int num) {
        if(graph[num] == num) {
            return num;
        }
        return graph[num] = getParent(graph[num]);
    }
}
