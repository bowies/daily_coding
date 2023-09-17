package programmers;

class 가장_긴_팰린드롬_Java_230917{
    /*
        앞뒤를 뒤집어도 똑같은 문자열을 팰린드롬(palindrome)이라고 합니다.
        문자열 s가 주어질 때, s의 부분문자열(Substring)중 가장 긴 팰린드롬의 길이를 return 하는 solution 함수를 완성해 주세요.

        예를들면, 문자열 s가 "abcdcba"이면 7을 return하고 "abacde"이면 3을 return합니다.

        제한사항
        문자열 s의 길이 : 2,500 이하의 자연수
        문자열 s는 알파벳 소문자로만 구성
     */


    public int solution(String s) {
        int length = s.length();

        // 문자열의 길이가 1 이하인 경우, 그대로 길이를 반환한다.
        if (length <= 1) return length;

        // dp[i][j] 배열을 사용하여 팰린드롬 부분 문자열 여부를 저장한다.
        boolean[][] dp = new boolean[length][length];
        int maxPalidrome = 1; //1인 부분 문자열이 팰린드롬일 경우는 기본값으로 둔다.

        // 초기값: 모든 길이가 1인 부분 문자열은 팰린드롬이다.
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        // 길이가 2인 부분 문자열을 검사한다.
        for (int i = 0; i < length - 1; i++) { // +1을 체크할 것이므로 length - 1까지만 검사한다.
            if (s.charAt(i) == s.charAt(i + 1)) { //길이가 2일 경우에는 앞 뒤가 같으면 팰린드롬이다.
                dp[i][i + 1] = true;
                // 만약 길이가 2인 팰린드롬을 찾으면 최대 길이를 2로 갱신해 놓는다.
                maxPalidrome = 2;
            }
        }

        // 길이가 3 이상인 부분 문자열을 검사한다.
        for (int len = 3; len <= length; len++) { //길이가 3인 부분 문자열부터 검사한다.
            for (int i = 0; i + len - 1 < length; i++) {
                int j = i + len - 1; // j는 i에서 길이를 더한 값이다.
                // 문자열의 양 끝이 같고, 내부 부분이 팰린드롬인 경우 팰린드롬으로 표시한다.
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    // 현재 팰린드롬의 길이를 갱신해 놓는다.
                    maxPalidrome = len;
                }
            }
        }

        return maxPalidrome;

    }

}