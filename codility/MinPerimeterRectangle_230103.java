package codility;

public class MinPerimeterRectangle_230103 {
    public static void main(String[] args) {
        int N = 30;
        System.out.println(solution(N));
    }

    
    public static int solution(int N) {
        int answer = 2147483647;
        int temp = 0;
        int len = (int)Math.sqrt(N);
        //System.out.println(len);

        for(int i = 1; i <= len; i++){
            temp = N%i;
            if (temp == 0){
                temp = ((N/i)+i)*2;
                answer = Math.min(answer, temp);
                //System.out.println(temp);
            }
        }

        return answer;
    }
}
