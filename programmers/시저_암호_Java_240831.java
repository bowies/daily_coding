package programmers;

class 시저_암호_Java_240831 {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                char shifted = (char) ('a' + (c - 'a' + n) % 26);
                answer.append(shifted);
            } else if (Character.isUpperCase(c)) {
                char shifted = (char) ('A' + (c - 'A' + n) % 26);
                answer.append(shifted);
            } else { 
				//공백
                answer.append(c);
            }
        }
        
        return answer.toString();
 
    }
}