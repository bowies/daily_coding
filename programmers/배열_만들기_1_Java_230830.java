package programmers;


class Solution {
    public int[] 배열_만들기_1_Java_230830(int n, int k) {
        int[] answer = new int[n/k];

        for(int i = 0; i < n/k; i++){
            answer[i] = (i+1)*k;
        }

        return answer;
    }

    public int[] solution2(int n, int k) {
        int length = n / k;
        
        List<Integer> answer = new ArrayList<>();

        for (int i = 1; i <= length; i++) {
            answer.add(i * k);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }


}