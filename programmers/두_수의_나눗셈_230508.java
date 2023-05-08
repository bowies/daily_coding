package programmers;

public class 두_수의_나눗셈_230508 {

    public int solution(int num1, int num2) {

        float answer;
        answer = ((float)num1 / (float)num2) * 1000;
        return (int)answer;
    }
}
