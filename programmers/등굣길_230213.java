package programmers;

public class 등굣길_230213 {
    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int [][] puddles = {{2,2}};
        System.out.println(solution(4,3,puddles));
    }

    public static int solution(int m, int n, int[][] puddles) {
        //m x n 크기의 길
        //집 : 0/0 위치인데 1x1이라고 부름
        //학교 : mxn위치임

        int 최단경로의수를나누라고함 = 1000000007;

        int[][] array = new int[n + 1][m + 1];
        //한 칸 씩 +1하고 0 -1 -1 0 이런 식으로 보이게 함

        for(int i = 0; i < puddles.length; i++) {
            array[puddles[i][1]][puddles[i][0]] = -1; //check
        }

        array[1][1] = 1; //이것은 집의 위치
        
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < m + 1; j++) {
                if(array[i][j] == -1){
                    continue;
                }
                if(array[i - 1][j] > 0){
                    array[i][j] += array[i - 1][j] % 최단경로의수를나누라고함;
                }
                if(array[i][j - 1] > 0){
                    array[i][j] += array[i][j - 1] % 최단경로의수를나누라고함;
                }
            }
        }
        return array[n][m] % 최단경로의수를나누라고함;
    }
}
