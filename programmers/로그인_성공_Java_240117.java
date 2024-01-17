package programmers;

class 로그인_성공_Java_240117 {
    public String solution(String[] id_pw, String[][] db) {
        String 로그인아이디 = id_pw[0];
        String 로그인비번 = id_pw[1];

        for (String[] user : db) {
            String db아이디 = user[0];
            String db비번 = user[1];

            if (로그인아이디.equals(db아이디)) {
                if (로그인비번.equals(db비번)) {
                    return "login"; // 아이디와 패스워드가 일치하는 회원이 존재
                } else {
                    return "wrong pw"; // 아이디는 일치하지만 패스워드가 일치하지 않는 회원이 존재
                }
            }
        }

        return "fail"; // 아이디가 일치하는 회원이 없음
    }
}