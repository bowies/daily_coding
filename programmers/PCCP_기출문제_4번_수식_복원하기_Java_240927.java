package programmers;

import java.util.*;

class PCCP_기출문제_4번_수식_복원하기_Java_240927 {
    public String[] solution(String[] expressions) {
        // 2~9진법 파악
        // 해당되는 진법이 여러개면 ?, 아니면 해당 진법으로 값 생성
        String[][] 수식들 = new String[expressions.length][5];
        for (int i = 0; i < expressions.length; i++) {
            수식들[i] = expressions[i].split(" ");
        }

        List<Integer> 가능한진법들 = new ArrayList<>();
        for (int 진법 = 2; 진법 <= 9; 진법++) {
            boolean 유효한진법 = true;
            for (int j = 0; j < 수식들.length; j++) {            
                int 숫자1 = 숫자변환(수식들[j][0], 진법);
                int 숫자2 = 숫자변환(수식들[j][2], 진법);
                if (숫자1 == -1 || 숫자2 == -1) {
                    유효한진법 = false;
                    break;    
                }

                if (수식들[j][4].equals("X"))
                    continue;

                int 결과값 = 숫자변환(수식들[j][4], 진법);
                if (결과값 == -1) {
                    유효한진법 = false;
                    break;
                }

                if ((수식들[j][1].equals("+") && 숫자1 + 숫자2 != 결과값) ||
                    (수식들[j][1].equals("-") && 숫자1 - 숫자2 != 결과값)) {
                    유효한진법 = false;
                    break;
                } 
            }

            if (유효한진법)
                가능한진법들.add(진법);
        }

        List<String> 답안목록 = new ArrayList<>();
        StringBuilder 임시저장소 = new StringBuilder();
        for (int i = 0; i < 수식들.length; i++) {
            if (!수식들[i][4].equals("X"))
                continue;

            for (int 진법 : 가능한진법들) {
                int 숫자1 = Integer.parseInt(수식들[i][0], 진법);
                int 숫자2 = Integer.parseInt(수식들[i][2], 진법);
                int 결과값 = 0;
                if (수식들[i][1].equals("+")) {
                    결과값 = 숫자1 + 숫자2;
                } else {
                    결과값 = 숫자1 - 숫자2;
                }

                if (!수식들[i][4].equals("X") && 
                    !수식들[i][4].equals(Integer.toString(결과값, 진법))) {
                    수식들[i][4] = "?";
                    break;
                }
                수식들[i][4] = Integer.toString(결과값, 진법);
            }

            for (int j = 0; j < 수식들[i].length - 1; j++) {
                임시저장소.append(수식들[i][j]).append(" ");
            }
            임시저장소.append(수식들[i][수식들[i].length - 1]);
            답안목록.add(임시저장소.toString());
            임시저장소.setLength(0);
        }

        String[] 답안 = 답안목록.toArray(new String[0]);
        return 답안;
    }

    static int 숫자변환(String 문자열, int 진법) {
        int 숫자 = 0;
        for (int i = 문자열.length() - 1; i >= 0; i--) {
            if (문자열.charAt(i) - '0' >= 진법)
                return -1;
            숫자 += (문자열.charAt(i) - '0') * Math.pow(진법, 문자열.length() - 1 - i);
        }
        return 숫자;
    }
}
