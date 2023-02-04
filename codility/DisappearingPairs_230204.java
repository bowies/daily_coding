public class DisappearingPairs_230204 {
    public static void main(String[] args) {
        String S = "ACCAABBC";
        System.out.println(solution(S));
    }
    public static String solution(String S) {

        StringBuffer answer = new StringBuffer();
        int len;
        for (char chr : S.toCharArray()) {
            len = answer.length();

            if (len > 0 && answer.charAt(len - 1) == chr) {
                answer.deleteCharAt(len - 1);
            } else {
                answer.append(chr);
            }
        }

        return answer.toString();
    }

}
