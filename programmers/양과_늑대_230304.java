package programmers;


import java.util.Arrays;

public class 양과_늑대_230304 {
    public static void main(String[] args) {
        int [] info = {0,0,1,1,1,0,1,0,1,0,1,1}; //0이 양 | 1이 늑대
        int [][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};

    }



    int[] 왼쪽자식 = new int[20];
    int[] 오른쪽자식 = new int[20];
    int[] 양과늑대 = new int[20];
    int 양늑대길이;
    int[] 방문확인 = new int[1<<17];
    int answer = 1;


    public int solution(int[] info, int[][] edges) {
        양늑대길이 = info.length;

        Arrays.fill(왼쪽자식, -1); //boolean 으로 안 짰으면 -1로 채우기
        Arrays.fill(오른쪽자식, -1);

        for(int i = 0; i < 양늑대길이; i++){
            양과늑대[i] = info[i];
        }
        for(int i = 0; i < 양늑대길이 -1; i++){
            int 부모 = edges[i][0];
            int 자식 = edges[i][1];
            if(왼쪽자식[부모] == -1){
                왼쪽자식[부모] = 자식;
            }else{
                오른쪽자식[부모] = 자식;
            }
        }

        dfs(1);
        return answer;
    }

    void dfs(int 상태){
        if(방문확인[상태] == 1){
            return;
        }

        방문확인[상태] = 1;

        int 늑대마리수 = 0;
        int 정점수 = 0;
        for(int i = 0; i < 양늑대길이; i++){
            if((상태 & (1<<i)) != 0){
                정점수++;
                늑대마리수+= 양과늑대[i];
            }
        }
        if(2*늑대마리수 >= 정점수){
            //늑대가 1/2보다 크면 이미 다 잡아먹혀서 종료
            return;
        }

        answer = Math.max(answer,정점수-늑대마리수); //양 수가 정답보다 크면 answer를 갱신한다.


        for(int i = 0; i < 양늑대길이; i++){
            // i번째 비트가 꺼져있는 경우 해당 정점이 없으니 넘어감
            if((상태 & (1<<i)) == 0){
                continue;
            }
            // 현재 보고 있는 i번째 정점의 left가 있다면
            if(왼쪽자식[i] != -1) {
                dfs(상태 | (1 << 왼쪽자식[i]));
            }
            // 현재 보고 있는 i번째 정점의 right가 있다면
            if(오른쪽자식[i] != -1) {
                dfs(상태 | (1 << 오른쪽자식[i]));
            }
        }
    }


}
