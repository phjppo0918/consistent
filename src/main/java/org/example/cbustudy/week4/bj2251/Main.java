package org.example.cbustudy.week4.bj2251;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int bottleA = Integer.parseInt(st.nextToken());
        int bottleB = Integer.parseInt(st.nextToken());
        int bottleC = Integer.parseInt(st.nextToken());
        Queue<Bottles> queue = new LinkedList<>();
        Set<Bottles> visited = new HashSet<>();
        final Bottles start = new Bottles(0, 0, bottleC);
        queue.add(start);

        while (!queue.isEmpty()) {
            Bottles now = queue.poll();

            //A -> B
            int water = now.a;
            water = Math.min((bottleB - now.b), water);
            Bottles bottles = new Bottles(now.a - water, now.b + water, now.c);
            if (!visited.contains(bottles)) {
                queue.add(bottles);
                visited.add(bottles);
            }

            // A -> C
            water = now.a;
            water = Math.min((bottleC - now.c), water);
            bottles = new Bottles(now.a - water, now.b, now.c + water);
            if (!visited.contains(bottles)) {
                queue.add(bottles);
                visited.add(bottles);
            }

            // B -> A
            water = now.b;
            water = Math.min((bottleA - now.a), water);
            bottles = new Bottles(now.a + water, now.b - water, now.c);
            if (!visited.contains(bottles)) {
                queue.add(bottles);
                visited.add(bottles);
            }


            // B -> C
            water = now.b;
            water = Math.min((bottleC - now.c), water);
            bottles = new Bottles(now.a, now.b - water, now.c + water);
            if (!visited.contains(bottles)) {
                queue.add(bottles);
                visited.add(bottles);
            }
            // C -> A
            water = now.c;
            water = Math.min((bottleA - now.a), water);
            bottles = new Bottles(now.a + water, now.b, now.c - water);
            if (!visited.contains(bottles)) {
                queue.add(bottles);
                visited.add(bottles);
            }
            // C -> B
            water = now.c;
            water = Math.min((bottleB - now.b), water);
            bottles = new Bottles(now.a, now.b + water, now.c - water);
            if (!visited.contains(bottles)) {
                queue.add(bottles);
                visited.add(bottles);
            }
        }

        Queue<Integer> answer = new PriorityQueue<>();

        visited.forEach(v -> {
            if(v.a == 0) {
                answer.add(v.c);
            }
        });


        while (!answer.isEmpty()) {
            sb.append(answer.poll()).append(" ");
        }
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}

class Bottles {
    int a;
    int b;
    int c;

    public Bottles(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bottles bottles = (Bottles) o;

        if (a != bottles.a) return false;
        if (b != bottles.b) return false;
        return c == bottles.c;
    }

    @Override
    public int hashCode() {
        int result = a;
        result = 31 * result + b;
        result = 31 * result + c;
        return result;
    }
}
