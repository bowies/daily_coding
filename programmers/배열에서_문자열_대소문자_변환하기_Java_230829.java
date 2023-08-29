package programmers;

class 배열에서_문자열_대소문자_변환하기_Java_230829 {
    public String[] solution(String[] strArr) {
        for(int i = 0; i < strArr.length; i++) {
            if(i % 2 == 0) {
                strArr[i] = strArr[i].toLowerCase();
            }
            else {
                strArr[i] = strArr[i].toUpperCase();
            }
        }
        return strArr;
    }
}
