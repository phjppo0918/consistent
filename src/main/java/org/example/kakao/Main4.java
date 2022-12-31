package kakao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main4 {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    

        
        bw.write(result.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }

    public int[] solution(long[] numbers) {
        Node root = new Node(numbers[0]);

        for (int i = 1; i < numbers.length; i++) {
            long nowValue = numbers[i];
            Node now = new Node(nowValue);
            setNode(root, now);
        }

        int[] answer = {};
        return answer;
    }
    public static void setNode(Node target, Node element) {
        if(target.value > element.value) {
            if(target.left == null) {
                target.left = element;
                return;
            }

            setNode(target.left, element);
        }else {
            if(target.right == null) {
                target.right = element;
                return;
            }

            setNode(target.right, element);
        }
    }
}

class Node {
    long value;
    Node left;
    Node right;

    public Node(long value) {
        this.value = value;
    }
}