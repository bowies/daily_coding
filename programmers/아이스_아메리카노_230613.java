package programmers;

class 아이스_아메리카노_230613 {
    public int[] solution(int money) {
        int[] answer = new int[2];
        int coffee = 5500;
        answer[0] = money/coffee;
        answer[1] = money - answer[0] * coffee;
        
        
        return answer;
    }


    
    public int[] solution_oneline(int money) {
        return new int[] { money / 5500, money % 5500 };
    }
}