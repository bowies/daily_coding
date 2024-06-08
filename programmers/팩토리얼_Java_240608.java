package programmers;

class 팩토리얼_Java_240608 {
    public int solution(int n) {
        int i = 1;
        int factorial = 1;

        while (factorial <= n) {
            i++;
            factorial *= i;
        }

        return i - 1;
    }
}
