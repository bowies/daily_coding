package programmers;

public class 정수삼각형_221231 {
    public static void main(String[] args) {
        int [][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(solution(triangle));
    }
    
    public static int solution(int[][] triangle) {
        int answer = 0;
        int len = triangle.length;
        int[][] arr = new int[len][len];        
        
        for (int i = 0; i < len; i++) {
            if(i == 0){
                arr[0][0] = triangle[0][0];
            }else{
                // <>
                for (int j = 1; j <= i; j++) {
                    arr[i][j] = Math.max(arr[i-1][j], arr[i-1][j-1]) + triangle[i][j];
                }
                // <<<<
                arr[i][0] = arr[i-1][0] + triangle[i][0];
                // >>>>
                arr[i][i] = arr[i-1][i-1] + triangle[i][i];

            }            
        }
        
        for (int i = 0; i < len; i++) {
            answer = Math.max(answer, arr[len-1][i]);
        }
        
        return answer;
    }
}
