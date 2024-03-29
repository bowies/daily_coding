package programmers;

class 코드_처리하기_Java_240329 {
    public String solution(String code) {

        if (code.isEmpty()) {
            return "EMPTY";
        }

        StringBuilder sb = new StringBuilder();
        int mode = 0; 

        for (int i = 0; i < code.length(); i++) {
            char chr = code.charAt(i);
            if (mode == 0) {
                if (chr != '1') {
                    if (i % 2 == 0)
                        sb.append(chr);
                } else {
                    mode = 1;
                }
            } else {
                if (chr != '1') {
                    if (i % 2 != 0)
                        sb.append(chr);
                } else {
                    mode = 0;
                }
            }
        }

        return sb.length() == 0 ? "EMPTY" : sb.toString();
    }
}
