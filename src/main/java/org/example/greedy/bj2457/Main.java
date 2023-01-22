package org.example.greedy.bj2457;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] monthMax = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        List<Flower>flowers = new ArrayList<>();

        int flowerCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < flowerCount; i++) {
            st = new StringTokenizer(br.readLine());
            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());
            if(startMonth < 3) {
                startMonth = 3;
                startDay = 1;
            }
            if(endMonth == 12 && endDay > 1) {
                endDay = 1;
            }
            Flower flower = new Flower(
                    new DateData(startMonth, startDay),
                    new DateData(endMonth, endDay)
            );

            if(validDateRange(flower)) {
                continue;
            }

            flowers.add(flower);
        }
        DateData datePivot = new DateData(12, 1);
        int pivot = 0;
        Collections.sort(flowers, Comparator.reverseOrder());

        boolean isAnswer = false;
        int count = 0;
        while (true) {
            Flower next = null;
            //find next;
            while (pivot != flowers.size()) {
                if(datePivot.compareTo(flowers.get(pivot).close) <= 0) {
                    if(next == null || next.open.compareTo(flowers.get(pivot).open) > 0) {
                        next = flowers.get(pivot);
                    }
                    pivot++;
                }else {
                    break;
                }
            }
            if(next == null) {
                break;
            }

            datePivot = next.open;
            count++;
            if(datePivot.month == 3 && datePivot.day == 1) {
                isAnswer =true;
                break;
            }
        }

        if(!isAnswer) {
            sb.append(0);
        }else {
            sb.append(count);
        }




        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean validDateRange(Flower flower) {
        return flower.close.compareTo(new DateData(3, 1)) <= 0 &&
                flower.open.compareTo(new DateData(11, 30)) > 0;
    }
}

class Flower implements Comparable<Flower> {
    DateData open;
    DateData close;

    public Flower(DateData open, DateData close) {
        this.open = open;
        this.close = close;
    }

    @Override
    public int compareTo(Flower o) {
        int compareValue = close.compareTo(o.close);
        if(compareValue == 0) {
            compareValue = o.open.compareTo(open);
        }
        return compareValue;
    }
}

class DateData implements Comparable<DateData> {
    Integer month;
    Integer day;

    public DateData(int month, int day) {
        this.month = month;
        this.day = day;
    }

    @Override
    public int compareTo(DateData o) {
        int compareValue = this.month - o.month;
        if(compareValue == 0) {
            compareValue = this.day - o.day;
        }
        return compareValue;
    }
}
