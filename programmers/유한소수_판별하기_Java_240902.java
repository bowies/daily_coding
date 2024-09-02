package programmers;

class 유한소수_판별하기_Java_240902 {
    public int solution(int a, int b) {
        int gcd = gcd(a, b); //최대 공약수
        
        b /= gcd; //분모 / 최대공약수 = 기약분수
        
        while (b % 2 == 0) { //분모 / 2 
            b /= 2;
        }
        while (b % 5 == 0) { //분모 / 5
            b /= 5;
        }
        
        if (b == 1) {
            //2랑 5로 나누고 난 분모가 1이면 유한소수
            return 1;
        } else {
            return 2;
        }
    }
    
    private int gcd(int a, int b) {
        //최대공약수 구하기 - 유클리드 호제법
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
