package codility;

public class Ladder_230111 {
    public static void main(String[] args) {
        Ladder_230111 l = new Ladder_230111();
        int [] A = {4,4,5,5,1};
        int [] B = {3,2,4,3,1};
        System.out.println(l.solution2(A, B));
    }   
    
    public int [] solution2(int [] A, int [] B){
        int len = A.length;
        
        int[] answer = new int[len];
        int[] fibo = new int[len+2];
        
        fibo[0] = 0;
        fibo[1] = 1;
        fibo[2] = 2;
        
        for (int i = 3; i <= len; i++) {
            fibo[i] = (fibo[i-1] + fibo[i-2]) % (1 << 30);
        }
        
        for (int i = 0; i < len; i++) {
            answer[i] = fibo[A[i]] % (1 << B[i]);
        }

        return answer;

    }


    public int[] solution(int[] A, int[] B) {
        int len = A.length;
        int[] answer = new int[len];
        int max = (int)Math.pow(2,30); 
        //오... >> 를 안 쓰다니 천재 
        // max값은 B[i]가 될 수 있는 가장 큰 값이 30이기 때문에, 2^30인 값이다. 
        // ↑ https://sustainable-dev.tistory.com/40
        //나머지 연산 할 때 땡큐!
        //어...이 문제는 사실 그냥 계단 올라가는 법 같은 것이라서 효율성 머리를 짜봅니다.


        int[] fibo = new int[len *2]; //그냥 크게 잡았음

        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i <= len; i++) {
            fibo[i] = (fibo[i - 2] + fibo[i - 1]) % max;
            //System.out.println(fibo[i]);
        }
        



        for (int i = 0; i < len; i++) {
            answer[i] = fibo[A[i]] % (int) Math.pow(2, B[i]);  //재활용!
        }

        return answer;
    }

}
