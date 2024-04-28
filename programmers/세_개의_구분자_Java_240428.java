package programmers;
import java.util.Arrays;
class 세_개의_구분자_Java_240428 {
    public String[] solution(String myStr) {
        
        myStr = myStr.replaceAll("[a|b|c]+", ",");
        myStr = myStr.charAt(0) == ',' ? myStr.substring(1) : myStr;
        myStr = myStr.equals("") ? "EMPTY" : myStr;

        return myStr.split("[,]");
    }
}