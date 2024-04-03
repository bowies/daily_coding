package programmers;

class 문자_개수_세기_Java_240403 {
    public int[] solution(String my_string) {
        int[] answer = new int[52]; // 알파벳 대소문자 개수

        for (char chr : my_string.toCharArray()) {
            if (chr >= 'A' && chr <= 'Z')
                answer[chr - 'A']++;

            else if (chr >= 'a' && chr <= 'z')
                answer[chr - 'a' + 26]++;
        }

        return answer;
    }

}
