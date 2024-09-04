package programmers;

import java.util.HashMap;
import java.util.Map;

class 숫자_문자열과_영단어_Java_240904 {

    public int solution(String s) {
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i = 0; i < numbers.length; i++) {
            s = s.replaceAll(numbers[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
	
    public int solution(String s) {
        Map<String, String> numbers = new HashMap<>();
        numbers.put("zero", "0");
        numbers.put("one", "1");
        numbers.put("two", "2");
        numbers.put("three", "3");
        numbers.put("four", "4");
        numbers.put("five", "5");
        numbers.put("six", "6");
        numbers.put("seven", "7");
        numbers.put("eight", "8");
        numbers.put("nine", "9");
        
        for (Map.Entry<String, String> map : numbers.entrySet()) {
            s = s.replace(map.getKey(), map.getValue());
        }
        
        return Integer.parseInt(s);
    }
}
