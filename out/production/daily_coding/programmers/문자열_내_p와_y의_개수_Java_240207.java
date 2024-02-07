class 문자열_내_p와_y의_개수_Java_240207 {
    boolean solution(String s) {
        boolean answer = true;
        
        int pCount = 0;
        int yCount = 0;
        
        for (char ch : s.toLowerCase().toCharArray()) {
            if (ch == 'p') {
                pCount++;
            } else if (ch == 'y') {
                yCount++;
            }
        }
        
        if (pCount != yCount) {
            answer = false;
        }
        
        return answer;
    }
}
