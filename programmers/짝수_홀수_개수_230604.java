package programmers;

class 짝수_홀수_개수_230604 {
    public int[] solution(int[] num_list) {
        int evenCount = 0;
        int oddCount = 0;

        for (int num : num_list) {
            if (num % 2 == 0) {
                evenCount++;
            } else if(num != 0){
                oddCount++;
            }
        }

        return new int[]{evenCount, oddCount};
    }


    public int[] solution2(int[] num_list) {
        int[] answer = new int[2];

        for(int i = 0; i < num_list.length; i++){
            answer[num_list[i] % 2]++; //오...
        }

        return answer;
    }
}
