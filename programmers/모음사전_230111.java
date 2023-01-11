package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class 모음사전_230111 {
    
    public static void main(String[] args) {
        모음사전_230111 m = new 모음사전_230111();
        String word = "AAAAE";
        System.out.println(m.solution(word));
    }
    public int solution(String word) {
        
        int answer=word.length();
		String wordDictionary = "AEIOU";

		Integer [] wordCounter = new Integer [wordDictionary.length()];
        
        for(int i = 0; i < wordDictionary.length(); i++){
            if(i == 0){
                wordCounter[i] = 1;    
            }else{
                wordCounter[i] = wordCounter[i-1] + (int)Math.pow(5,i);
            }
        }

        Arrays.sort(wordCounter, Comparator.reverseOrder());
        //이거 맨날 () 생략해서 오류 뜬 거 의아해했었음... (-.-) 자동완성을 써야지...

        
        for (int i = 0; i < word.length(); i++) {
            answer += (wordCounter[i] * wordDictionary.indexOf(word.charAt(i)));
        }

		return answer;
    }
}
