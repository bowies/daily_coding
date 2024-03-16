package programmers;

class 주사위_게임_2_Java_240317 {
    public int solution(int a, int b, int c) {
        int answer = 0;
        int sum = a + b + c;
        int squareSum = a * a + b * b + c * c;
        
        if (a != b && b != c && a != c) {
            answer = sum;
        }
        else if (a == b && b != c || a != b && b == c || a == c && b != c) {
            answer = sum * squareSum;
        }
        else {
            answer = sum * squareSum * (a * a * a + b * b * b + c * c * c);
        }
        
        return answer;
    }
}
