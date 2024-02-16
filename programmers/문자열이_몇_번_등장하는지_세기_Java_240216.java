package programmers;
import java.util.stream.IntStream;

class 문자열이_몇_번_등장하는지_세기_Java_240216 {
    public int solution(String myString, String pat) {
        int count = 0;
        int length = pat.length();
        int myLength = myString.length();

        for (int i = 0; i <= myLength - length; i++) {
            if (myString.substring(i, i + length).equals(pat)) {
                count++;
            }
        }

        return count;
    }
    public int solution_stream(String myString, String pat) {
        // 1. 문자열 길이만큼의 인덱스 범위를 생성한다. (문자열의 모든 위치를 포함한다.)
        return (int) IntStream.range(0, myString.length())
                // 2. 각 인덱스에서 시작하는 부분 문자열을 필터링한다.
                .filter(i -> myString.substring(i).startsWith(pat))
                // 3. 필터링된 부분 문자열의 개수를 세어서 반환한다.
                .count();
    }
}