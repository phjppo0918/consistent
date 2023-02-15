package org.example.binarySearch.bj16434;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static Room[] rooms;
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int roomCount = Integer.parseInt(st.nextToken());
        Long attack = Long.parseLong(st.nextToken());

        long leftPivot = 0;
        long rightPivot = Long.MAX_VALUE/3;
        long answer = 0;
        rooms = new Room[roomCount];
        for (int i = 0; i < roomCount; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int atk = Integer.parseInt(st.nextToken());
            int hp = Integer.parseInt(st.nextToken());
            rooms[i] = new Room(type, atk, hp);
        }

        while (leftPivot <= rightPivot) {
            long mid = (leftPivot + rightPivot) / 2;
            if(canClear(mid, attack)) {
                rightPivot = mid - 1;
                answer = mid;
            }else {
                leftPivot = mid + 1;
            }
        }
        sb.append(answer);

        
        bw.write(sb.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
    private static boolean canClear(long maxHp, long atk) {
        long hp = maxHp;
        for (int i = 0; i < rooms.length; i++) {
            Room now = rooms[i];
            if(now.type == 1) {
                long monsterHp = now.hpPoint;
                long monsterAtk = now.atkPoint;
                if(monsterHp%atk == 0) {
                    monsterHp--;
                }
                hp -= monsterAtk * (monsterHp/atk);
                if(hp <= 0) {
                    return false;
                }

            }else {
                hp += now.hpPoint;
                if(hp > maxHp) {
                    hp = maxHp;
                }

                atk += now.atkPoint;
            }
        }
        return true;
    }
}
class Room {
    int type;
    int atkPoint;
    int hpPoint;
    public Room(int type, int atkPoint, int hpPoint) {
        this.type = type;
        this.atkPoint = atkPoint;
        this.hpPoint = hpPoint;
    }
}
