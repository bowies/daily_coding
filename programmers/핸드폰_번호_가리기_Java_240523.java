package programmers;

class 핸드폰_번호_가리기_Java_240523 {
    public String solution(String phone_number) {
        int len = phone_number.length();
        String asta = "*".repeat(len - 4);
        String lastdigit = phone_number.substring(len - 4);
        return asta + lastdigit;
    }
}
