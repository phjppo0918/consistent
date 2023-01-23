package org.example.greedy.bj1700;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int plugSize = Integer.parseInt(st.nextToken());
        int productCount = Integer.parseInt(st.nextToken());
        Product[] products = new Product[productCount + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= productCount; i++) {
            products[i] = new Product(i);
        }
        int[] order = new int[productCount + 1];
        for (int i = 1; i <= productCount; i++) {
            int label = Integer.parseInt(st.nextToken());
            order[i] = label;
            products[label].nextUse.add(i);
        }

        PriorityQueue<Product> plug = new PriorityQueue<>();
        boolean[] use = new boolean[productCount + 1];
        int answer = 0;
        for (int i = 1; i <= productCount; i++) {
            Product next = products[order[i]];
            if(use[next.label]) {
                plug.remove(next);
                next.nextUse.poll();
                plug.add(next);
                continue;
            }
            if(plug.size() == plugSize) {
                Product poll = plug.poll();
                use[poll.label] = false;
                answer++;
            }
            next.nextUse.poll();
            plug.add(next);
            use[next.label] = true;
        }
        sb.append(answer);
        
        bw.write(sb.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
}

class Product implements Comparable<Product> {
    int label;

    public Product(int label) {
        this.label = label;
    }

    Queue<Integer> nextUse = new PriorityQueue<>();

    @Override
    public int compareTo(Product o) {
        if(nextUse.isEmpty()) {
            return -1;
        }
        if(o.nextUse.isEmpty()) {
            return 1;
        }
        return o.nextUse.peek() - nextUse.peek();

    }
}
