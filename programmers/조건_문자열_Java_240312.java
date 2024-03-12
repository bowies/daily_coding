package programmers;

class 조건_문자열_Java_240312 {


    public int solution_ramda_Study(String ineq, String eq, int n, int m) {
        int answer = 0;

        //람다 연습용... -.-) 삼항연산자의 향연...
        answer = (eq.equals("=")) ?
                (ineq.equals("<") ? (n <= m ? 1 : 0) : (n >= m ? 1 : 0)) :
                (ineq.equals("<") ? (n < m ? 1 : 0) : (n > m ? 1 : 0));

        return answer;
    }
    public int solution(String ineq, String eq, int n, int m) {
        int answer = 0;
        
        if (eq.equals("=")) {
            if (ineq.equals("<")) {
                if (n <= m) {
                    answer = 1;
                }
            } else if (ineq.equals(">")) {
                if (n >= m) {
                    answer = 1;
                }
            }
        } else if (eq.equals("!")) {
            if (ineq.equals("<")) {
                if (n < m) {
                    answer = 1;
                }
            } else if (ineq.equals(">")) {
                if (n > m) {
                    answer = 1;
                }
            }
        }
        
        return answer;
    }
}
