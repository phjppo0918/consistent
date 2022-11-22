package tukorea2019.tree.nickname;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int size = Integer.parseInt(st.nextToken());
        List<String> nickname = new ArrayList<>();
        Trie trie = new Trie();
        for (int i = 0; i < size; i++) {
            nickname.add(trie.insert(br.readLine()));
        }
        nickname.forEach(n -> {
            result.append(n);
            result.append("\n");
        });

        
        bw.write(result.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
}

class Node {
    Map<Character, Node> child = new HashMap<>();
    public boolean isLastChar;
    int count = 1;

}

class Trie {
    Node root = new Node();

    String insert(String word) {
        Node now = root;
        StringBuilder sb = new StringBuilder();
        boolean inputStop = false;
        for(char c : word.toCharArray()) {
            if(!inputStop) {
                sb.append(c);
            }
            if(!now.child.containsKey(c)) {
                inputStop = true;
                now.child.put(c, new Node());
            }
            now = now.child.get(c);
        }
        if(now.isLastChar){
            now.count++;
            sb.append(now.count);
        }
        now.isLastChar = true;

        return sb.toString();
    }
}
