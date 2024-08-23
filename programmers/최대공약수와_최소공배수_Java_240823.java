package programmers;

class 최대공약수와_최소공배수_Java_240823 {

    public int[] solution(int n, int m) {
        int 최대공약수 = getGCD(n, m); 
        int 최소공배수 = (n * m) / 최대공약수; 

        return new int[] {gcd, 최소공배수}; 
    }

    // 유클리드 호제법을 이용한 최대공약수 구하기
    private int getGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
