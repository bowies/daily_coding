package programmers;

class 둘만의_암호_Java_240621{
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        String 알파벳 = "abcdefghijklmnopqrstuvwxyz";
        boolean[] skiparr = new boolean[26];
        
        for (char chr : skip.toCharArray()) {
            skiparr[chr - 'a'] = true;
        }
        
        for (char chr : s.toCharArray()) {
            int 현재 = 알파벳.indexOf(chr);
            int cnt = 0;
            
            while (cnt < index) {
                현재 = (현재 + 1) % 26;
                if (!skiparr[알파벳.charAt(현재) - 'a']) {
                    cnt++;
                }
            }
            
            answer.append(알파벳.charAt(현재));
        }
        
        return answer.toString();
    }

    public String best_solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        for (char letter : s.toCharArray()) {
            char temp = letter;
            int idx = 0;
            while (idx < index) {
                temp = temp == 'z' ? 'a' : (char) (temp + 1);
                if (!skip.contains(String.valueOf(temp))) {
                    idx += 1;
                }
            }
            answer.append(temp);
        }

        return answer.toString();
    }
}
