import java.util.HashMap;
import java.util.Map;

class 중복된_숫자_개수_230602 {
    public int 중복된_숫자_개수_230602(int[] array, int n) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : array) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        return countMap.getOrDefault(n, 0);
    }
}
