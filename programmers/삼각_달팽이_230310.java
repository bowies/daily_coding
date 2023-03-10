package programmers;

public class 삼각_달팽이_230310 {
    public static int[] solution(int n) {
        // % 3 이 포인트임!

        /*
        달팽이 : 데굴데굴 모양 만들기
        00
        11 12
        21 22 23
        31 32 33 34

         */
        int len = (n *(n+1))/2 ;
        int[] answer = new int[len];
        int[][] 삼각형 = new int[n][n];

        int x = -1; // 앞 
        int y = 0; // 뒤
        int cnt = 1; // 0부터가 아니라서 1부터 시작

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(i % 3 == 0) { // 대각선 아래
                    x++;
                }
                else if(i % 3 == 1) { // 가로
                    y++;
                }
                else if(i % 3 == 2) { // 대각선 위
                    x--;
                    y--;
                }
                
                삼각형[x][y] = cnt++; //값 추가해서 저장
            }
        }

        int counter = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(삼각형[i][j] == 0) break;
                answer[counter++] = 삼각형[i][j];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        /*
            정수 n이 매개변수로 주어집니다.
            다음 그림과 같이 밑변의 길이와 높이가 n인 삼각형에서
            맨 위 꼭짓점부터 반시계 방향으로 달팽이 채우기를 진행한 후,
            첫 행부터 마지막 행까지 모두 순서대로 합친
            새로운 배열을 return 하도록 solution 함수를 완성해주세요.
         */
        int n = 4;
        System.out.println(solution(n));
    }
}
