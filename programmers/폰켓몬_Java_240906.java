package programmers;

import java.util.HashSet;
import java.util.Set;

class 폰켓몬_Java_240906 {
    public int solution(int[] nums) {
        
        int pokemon = nums.length / 2;
        
        Set<Integer> set = new HashSet<>(); //distinct
        
        for (int n : nums) {
            set.add(n);
        }
        
        return Math.min(set.size(), pokemon);
    }
}
