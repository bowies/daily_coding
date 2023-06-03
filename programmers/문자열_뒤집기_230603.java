package programmers;

class 문자열_뒤집기_230603 {
    public String solution(String my_string) {
        
        String answer = new StringBuilder(my_string)
                .reverse()
                .toString();
        
        
        return answer;
    }

    public String solution2(String my_string) {
        char[] chars = my_string.toCharArray();
        int length = chars.length;

        for (int i = 0; i < length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[length - 1 - i];
            chars[length - 1 - i] = temp;
        }

        return new String(chars);
    }

}