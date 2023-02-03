public class TennisTournament_230203 {
    public static void main(String[] args) {
        int P = 5;
        int C = 3;

        System.out.println(solution(P,C));

        int P2 = 10;
        int C2 = 3;

        System.out.println(solution(P2, C2));
    }


    public static int solution(int P, int C) {
        //2명의 플레이어 플레이
        //코트수 : C
        //플레이어수 : P

        if (C*2 < P && P > C) {
            return C;
        }else{
            return P/2;
        }

    }
}
