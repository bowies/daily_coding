package programmers;

class OX_퀴즈_Java_240922 {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for (int i = 0; i < quiz.length; i++) {
            String[] parts = quiz[i].split(" ");
            
            int 첫번째숫자 = Integer.parseInt(parts[0]);
            String operator = parts[1];           
            int 두번째숫자 = Integer.parseInt(parts[2]);
            int 결과 = Integer.parseInt(parts[4]);   
            
            int result = 0;
            if (operator.equals("+")) {
                result = 첫번째숫자 + 두번째숫자;
            } else if (operator.equals("-")) {
                result = 첫번째숫자 - 두번째숫자;
            }
            
            if (result == 결과) {
                answer[i] = "O";
            } else {
                answer[i] = "첫번째숫자";
            }
        }
        
        return answer;
    }
}
