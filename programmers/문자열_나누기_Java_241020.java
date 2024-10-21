package programmers;

class 문자열_나누기_Java_241020 {
    public int solution(String s) {
        int answer = 0;
        int i = 0;
        
        while (i < s.length()) {
            char x = s.charAt(i);
            int countX = 0;
            int countOther = 0;
            
            while (i < s.length()) {
                if (s.charAt(i) == x) {
                    countX++;
                } else {
                    countOther++;
                }
                i++;
                
                if (countX == countOther) {
                    break;
                }
            }
            
            answer++;
        }
        
        return answer;
    }
}
