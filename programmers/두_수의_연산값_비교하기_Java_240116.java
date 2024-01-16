package programmers;

class 두_수의_연산값_비교하기_Java_240116 {
    public int solution(int a, int b) {
        int 연산값 = Integer.parseInt(String.valueOf(a) + String.valueOf(b));
        int 두배 = 2 * a * b;

        return Math.max(연산값, 두배);
    }
}