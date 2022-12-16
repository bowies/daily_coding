package programmers;

public class 도둑질_221216 {
    /*
    도둑이 어느 마을을 털 계획을 하고 있습니다. 이 마을의 모든 집들은 아래 그림과 같이 동그랗게 배치되어 있습니다.
    각 집들은 서로 인접한 집들과 방범장치가 연결되어 있기 때문에 인접한 두 집을 털면 경보가 울립니다.
    각 집에 있는 돈이 담긴 배열 money가 주어질 때, 도둑이 훔칠 수 있는 돈의 최댓값을 return 하도록 solution 함수를 작성하세요.
    
    제한사항
    이 마을에 있는 집은 3개 이상 1,000,000개 이하입니다.
    money 배열의 각 원소는 0 이상 1,000 이하인 정수입니다.
    */

    public static void main(String[] args) {
        int [] money = {1, 2, 3, 1};
        solution(money);
    }
    public static int solution(int[] money) {
        
        int[] first = new int[money.length]; //처음 집을 훔치고 마지막 집 훔치기 (원형 구조)
        int[] last = new int[money.length]; //두번째 집부터 훔치기

        first[0] = money[0]; //처음 집 값 
        first[1] = money[0]; //처음 집 값 

        last[0] = 0; //처음 집 빼놓고 두번째부터 시작하니까 0
        last[1] = money[1];

        for(int i = 2; i < money.length; i++){
            //두번째부터 시작
            //현재 위치 -2 + 현재 위치 + 현재 위치 -1 
            //max 값만 저장
            first[i] = Math.max(first[i-2] + money[i], first[i-1]);
            last[i] = Math.max(last[i-2] + money[i], last[i-1]);
        }
        
        //전체 길이 -2 인덱스랑 비교 해야 함 (첫 집 턴 것은 마지막 값 필요 없음)
        return Math.max(first[money.length-2], last[money.length-1]);

    }
}
