package programmers;
import java.util.ArrayList;
import java.util.List;
class 공백으로_구분하기_2_Java_230903 {
    /*
        단어가 공백 한 개 이상으로 구분되어 있는 문자열 my_string이 매개변수로 주어질 때,
        my_string에 나온 단어를 앞에서부터 순서대로 담은 문자열 배열을 return 하는 solution 함수를 작성해 주세요.

        my_string은 영소문자와 공백으로만 이루어져 있습니다.
        1 ≤ my_string의 길이 ≤ 1,000
        my_string의 맨 앞과 맨 뒤에도 공백이 있을 수 있습니다.
        my_string에는 단어가 하나 이상 존재합니다.

     */
    public String[] solution(String my_string) {
        // 문자열을 공백을 기준으로 분리한 뒤, 리스트에 저장
        String[] words = my_string.split("\\s+");
        List<String> wordList = new ArrayList<>();

        // 공백으로 분리된 단어들을 리스트에 추가 (빈 문자열은 제외)
        for (String word : words) {
            if (!word.isEmpty()) {
                wordList.add(word);
            }
        }

        // 리스트를 문자열 배열로 변환
        String[] answer = new String[wordList.size()];
        answer = wordList.toArray(answer);

        return answer;
    }


    public String[] solution_best(String my_string) {
        // 1. 문자열의 앞뒤 공백을 제거한다.
        my_string = my_string.trim();

        // 2. 문자열을 공백 문자(스페이스)를 기준으로 분리하여 배열로 반환한다.
        //    정규 표현식 "[ ]+"을 사용하여 하나 이상의 공백 문자를 분리 기준으로 삼는다.
        //    예를 들어, "Hello  World" -> ["Hello", "World"]
        String[] words = my_string.split("[ ]+");

        // 3. 분리된 단어들을 문자열 배열로 반환한다.
        //    빈 문자열은 이전 단계에서 제거했기 때문에 ""값이 들어가지 않는다.
        return words;

        //동일한 코드 :  return my_string.trim().split("[ ]+");
    }


}