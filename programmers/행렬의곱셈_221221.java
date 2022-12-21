package programmers;

import java.util.Arrays;

public class 행렬의곱셈_221221 {
    public static void main(String[] args) {
        
        int [][] arr1 = {{1,4}, {3,2}, {4,1}};
        int [][] arr2 = {{3,3}, {3,3}};
        solution(arr1, arr2);
    }
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        //https://mathbang.net/562 이걸 보고 구현하면 된다... ★
        //3중 for문~~
        int[][] answer = new int[arr1.length][arr2[0].length];


        for(int i = 0; i < answer.length; i++){
            for(int j = 0; j < answer[i].length; j++){
                for(int k = 0; k < arr1[0].length; k++){
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        for(int [] i : answer){
            System.out.println(Arrays.toString(i));
        }

        return answer;
    }
}