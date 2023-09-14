package programmers;

class _0_떼기_Java_230913 {
    /*
        정수로 이루어진 문자열 n_str이 주어질 때,
        n_str의 가장 왼쪽에 처음으로 등장하는 0들을 뗀 문자열을 return하도록 solution 함수를 완성해주세요.


     */
    public String solution(String n_str) {

        int i = 0;
        while(i < n_str.length() && n_str.charAt(i) == '0') {
            i++;
        }


        return n_str.substring(i);
    }


    public String solution_best(String n_str) {
        //똑똑박사
        return ""+Integer.parseInt(n_str);
    }
}