package programmers;

import java.util.ArrayList;
import java.util.List;

class 리스트_자르기_Java_240327 {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];
        
        List<Integer> result = new ArrayList<>();
        
        switch(n) {
            case 1:
                for (int i = 0; i <= b; i++) {
                    result.add(num_list[i]);
                }
                break;
            case 2:
                for (int i = a; i < num_list.length; i++) {
                    result.add(num_list[i]);
                }
                break;
            case 3:
                for (int i = a; i <= b; i++) {
                    result.add(num_list[i]);
                }
                break;
            case 4:
                for (int i = a; i <= b; i += c) {
                    result.add(num_list[i]);
                }
                break;
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
