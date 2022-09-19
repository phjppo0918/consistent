package tree.bj5639;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Optional;

public class Main {
    public static StringBuilder result;
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int value = Integer.parseInt(br.readLine());
        Node startNode = new Node(value);
        while (br.ready()) {
            value = Integer.parseInt(br.readLine());
            Node now = new Node(value);
            setNode(startNode, now);
        }

        setResult(startNode);


        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    public static void setResult(Node node) {

        Optional.ofNullable(node.left).ifPresent(Main::setResult);
        Optional.ofNullable(node.right).ifPresent(Main::setResult);
        result.append(node.value);
        result.append("\n");
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
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}
