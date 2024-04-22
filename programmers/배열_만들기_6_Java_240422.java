package programmers;

import java.util.ArrayList;
import java.util.List;

class 배열_만들기_6_Java_240422 {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (list.isEmpty()) {
                list.add(arr[i]);
            } else if (list.get(list.size() - 1) == arr[i]) {
                list.remove(list.size() - 1);
            } else {
                list.add(arr[i]);
            }
        }
        
        if (list.isEmpty()) {
            return new int[] {-1};
        } else {
            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
