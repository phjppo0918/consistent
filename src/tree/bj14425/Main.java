package tree.bj14425;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int strSize = Integer.parseInt(st.nextToken());
        int testSize = Integer.parseInt(st.nextToken());

        Node root = new Node();

        for (int i = 0; i < strSize; i++) {
            char[] arr = br.readLine().toCharArray();


        }




        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}

class Node {
    Node arr[] = new Node[26];
    boolean isEnd;
}
