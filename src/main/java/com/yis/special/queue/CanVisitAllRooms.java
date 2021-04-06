package com.yis.special.queue;

import java.util.*;

/**
 * 输入：[[1,3],[3,0,1],[2],[0]]
 * 输出：false
 *
 * 输入: [[1],[2],[3],[]]
 * 输出: true
 * @author YeShuai
 * @date 2021/3/12
 */
public class CanVisitAllRooms {

    boolean[] openRoom;
    int num;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int size = rooms.size();
        openRoom = new boolean[size];
        num = 0;
        dfs(rooms, 0);
        return num == size;
    }

    public void dfs(List<List<Integer>> rooms, int x) {
        openRoom[x] = true;
        num++;
        for (int i : rooms.get(x)) {
            if (!openRoom[i]) {
                dfs(rooms, i);
            }
        }
    }



    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> room0 = new ArrayList<>();
        room0.add(1);
        room0.add(3);
        List<Integer> room1 = new ArrayList<>();
        room1.add(2);
        room1.add(0);
        room1.add(1);
        List<Integer> room2 = new ArrayList<>();
        room2.add(2);
        List<Integer> room3 = new ArrayList<>();
        room3.add(0);
        rooms.add(room0);
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        CanVisitAllRooms can = new CanVisitAllRooms();
        boolean b = can.canVisitAllRooms(rooms);
        System.out.println(b);
    }

}
