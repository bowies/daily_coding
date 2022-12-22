package programmers;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class 행렬이동하기_221222 {
    static int row;
    static int col;
    //배열로 짜면 시간초과!
    static ArrayDeque<Integer> que1;
    static ArrayDeque<Integer> que2;
    static LinkedList<ArrayDeque<Integer>> rows;

    private static void rotate() {
        if (col == 2) {
            que2.addFirst(que1.pollFirst());
            que1.addLast(que2.pollLast());
            return;
        }
        rows.peekFirst().addFirst(que1.pollFirst());
        que2.addFirst(rows.peekFirst().pollLast());
        rows.peekLast().addLast(que2.pollLast());
        que1.addLast(rows.peekLast().pollFirst());
    }

    private static void shiftRow() {
        rows.addFirst(rows.pollLast());
        que1.addFirst(que1.pollLast());
        que2.addFirst(que2.pollLast());
    }

    public static int[][] solution(int[][] rc, String[] operations) {
        row = rc.length;
        col = rc[0].length;

        que1 = new ArrayDeque<>();
        que2 = new ArrayDeque<>();
        
        for (int i = 0; i < row; i++) {
            que1.add(rc[i][0]);
            que2.add(rc[i][col-1]);
        }

        rows = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            ArrayDeque<Integer> tmp = new ArrayDeque<>();
            for (int j = 1; j < col-1; j++) {
                tmp.add(rc[i][j]);
            }
            rows.add(tmp);
        }
        
        

        for (String s : operations) {
            switch(s){
                case "Rotate" :
                    rotate();
                    break;
                case "ShiftRow" :
                    shiftRow();
                    break;
            }
        }

        
        int[][] ans = new int[row][col];
        for (int i = 0; i < row; i++) {
            ans[i][0] = que1.pollFirst();
            ans[i][col-1] = que2.pollFirst();
        }
        int i = 0;
        for (ArrayDeque<Integer> row : rows) {
            for (int j = 1; j < col-1; j++) {
                ans[i][j] = row.pollFirst();
            }
            i++;
        }
        return ans;

        
    }

    
    public static void main(String[] args) {
        int [][] rc = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}; //초기 상태를 담고 있음
        String [] operations = {"ShiftRow", "Rotate", "ShiftRow", "Rotate"}; //실행할 것
        //String [] operations = { "Rotate",  "Rotate"}; //실행할 것

        solution(rc, operations);
    }
}
