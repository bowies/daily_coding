package programmers;

class 문자열_바꿔서_찾기_Java_230824 {
    /*
        문자 "A"와 "B"로 이루어진 문자열 myString과 pat가 주어집니다.
        myString의 "A"를 "B"로, "B"를 "A"로 바꾼 문자열의
        연속하는 부분 문자열 중 pat이 있으면 1을 아니면 0을 return 하는 solution 함수를 완성하세요.
     */

    public int solution(String myString, String pat) {
        return myString.replace("A","1").replace("B","A").replace("1", "B").contains(pat) ? 0 : 1;

        //char 로 변환하고 String.valueOf 하면 오류나는거는 오류인가
    }
}

