package programmers;

import java.util.HashMap;
import java.util.Map;

public class 할인행사_230110 {
    public static void main(String[] args) {
        할인행사_230110 h = new 할인행사_230110();
        String [] want = {"banana", "apple", "rice", "pork", "pot"};
        int [] number = {3, 2, 2, 2, 1};
        String [] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        
        System.out.println(h.solution(want, number, discount));
    }
    //마트에서 10일간 회원 자격을 줌
    //할인하는 제품은 하루에 하나씩 구매함
    //원하는 제품과 수량이 할인하는 날짜와 일치할 경우에 가입


    public int solution(String[] 필요물건, int[] 필요개수, String[] 할인물건) {
        

        int answer = 0;

        //map에 want랑 number를 매칭해서 넣어줌
        Map<String, Integer> 살것 = new HashMap<String, Integer>();
        for (int i = 0; i < 필요물건.length; i++) {
            살것.put(필요물건[i], 필요개수[i]);
        }

        //할인된거를 10일치 상품을 추가함
        Map<String, Integer> 할인된것 = new HashMap<String, Integer>();
        for (int i = 0; i < 10; i++) {
            할인된것.put(할인물건[i], 할인된것.getOrDefault(할인물건[i], 0) + 1);
        }

        if (isEqual(살것, 할인된것)) {
            answer++;
        }
        
        //두번째 날부터 삭제할 상품 | 추가할 상품 지정해서 할인된것을 업데이트하고,
        //업데이트된 것을 바탕으로 answer 값을 변경함
        for (int i = 1; i <= 할인물건.length - 10; i++) {
            String 삭제할상품 = 할인물건[i - 1];
            할인된것.put(삭제할상품, 할인된것.get(삭제할상품) - 1);

            String 추가할상품 = 할인물건[i - 1 + 10];
            할인된것.put(추가할상품, 할인된것.getOrDefault(추가할상품, 0) + 1);

            if (isEqual(살것, 할인된것)) {
                answer++;
            }
        }

        return answer;
    }

    public boolean isEqual(Map<String, Integer> 살것, Map<String, Integer> 할인된것) {
        for (String key : 살것.keySet()) {
            if (!할인된것.containsKey(key) || 살것.get(key) != 할인된것.get(key)) {
                return false;
            }
        }

        return true;
    }
}
