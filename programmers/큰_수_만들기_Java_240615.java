package programmers;

class 큰_수_만들기_Java_240615 {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int length = number.length();
        int index = 0;
        
        for (int i = 0; i < length - k; i++) {
            char temp = '0';
            for (int j = index; j <= k + i; j++) {
                if (number.charAt(j) > temp) {
                    temp = number.charAt(j);
                    index = j + 1;
                }
            }
            answer.append(temp);
        }
        
        return answer.toString();
    }
}
