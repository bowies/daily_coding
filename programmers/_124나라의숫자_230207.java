package programmers;

public class _124나라의숫자_230207 {
    public static void main(String[] args) {
        //모든 수를 1, 2, 4 로만 표현함

        int n = 7;
        System.out.println(solution(n));
    }

    public static String solution(int n) {
        /*
        1 = 1
        2 = 2
        3 = 4

        4 = 11
        5 = 12
        6 = 14

        7 = 21
        8 = 22
        9 = 24

        10 = 41

        그러면 이런 식으로
        11 = 42
        12 = 44

        13 = 111
        14 = 112
        15 = 114

         */
        int temp = 0;
        StringBuilder sb = new StringBuilder();

        while(n > 0) {
            temp = n % 3; //숫자 개수로 나눔
            n = n / 3;
            
            if(temp==0) {
                //3을 4로 바꿔줘버림
                temp = 4;
                n -= 1; // 또 돌리기
            }

            sb.insert(0, temp);

        }

        return sb.toString();
    }
}
