package greedy.bj1931;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int roomSize = Integer.parseInt(st.nextToken());

        PriorityQueue<Room> pq = new PriorityQueue<>();

        for (int i = 0; i < roomSize; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int finish = Integer.parseInt(st.nextToken());
            pq.add(new Room(start, finish));
        }

        int roomCount = roomSize;

        long answer = 0;
        int finishTime = 0;
        while (!pq.isEmpty()) {
            Room room = pq.poll();
            if(room.start >= finishTime) {
                answer++;
                finishTime = room.finish;
            }
        }

        result.append(answer);
        result.append("\n");
        
        bw.write(result.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }

    static class Room implements Comparable<Room> {
        int start;
        int finish;


        public Room(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }

        @Override
        public int compareTo(Room o) {
            if(this.finish == o.finish) {
                return this.start - o.start;
            }
            return this.finish - o.finish;
        }
    }
}
