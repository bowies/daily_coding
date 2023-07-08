package programmers;

import java.util.Arrays;

public class 분수의_덧셈_230605 {
	
	public static int[] solution(int denum1, int num1, int denum2, int num2) {
        int[] answer = new int [2];
        
        answer[0] = (denum1 * num2) + (denum2 * num1);
        answer[1] = num1 * num2;
        
        // 두 개의 인자 중 작은 값을 리턴하여 min에 저장
        int min = Math.min(answer[0], answer[1]);
        int max = 1;
        
        for(int i = 1; i <= min; i++) {
        	if(answer[0] % i == 0 && answer[1] % i == 0) {
        		max = i; // i로 분자 분모 모두 나누어 떨어지는 수가 '최대 공약수'
        				// 즉 max 는 최대공약수
        	}
        }
        
        // 최대 공약수로 모두 약분
        answer[0] /= max;
        answer[1] /= max;
        
        return answer;
    }


//---------------------------------------------------------------------------------


    public static int[] solution2(int denum1, int num1, int denum2, int num2) {
        int[] answer = new int[2];

        answer[0] = (denum1 * num2) + (denum2 * num1);
        answer[1] = num1 * num2;

        // 최대 공약수 계산
        int gcd = gcd(answer[0], answer[1]);

        // 최대 공약수로 약분
        answer[0] /= gcd;
        answer[1] /= gcd;

        return answer;
    }

    // 최대 공약수를 구하는 유클리드 호제법
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    /*
        1. 
            max 변수를 gcd로 변경하였습니다. 
            gcd는 최대 공약수를 나타내는 변수명으로 더 의미적으로 적합합니다.
        
        2. 
            최대 공약수를 계산하는 부분을 gcd 메서드로 분리하였습니다. 
            이는 유클리드 호제법을 사용하여 최대 공약수를 효율적으로 계산하는 일반적인 방법입니다.
        
        3. 
            for 루프를 사용하지 않고 while 루프를 사용하여 최대 공약수를 계산하였습니다. 
            이렇게 함으로써 성능을 향상시킬 수 있습니다.

            
        /=는 복합 할당 연산자로, 
        변수의 값을 나눈 뒤 그 결과를 변수에 다시 할당하는 역할을 합니다. 
        다시 말해, x /= y는 x = x / y와 동일한 역할을 수행합니다.
        
    */
}

