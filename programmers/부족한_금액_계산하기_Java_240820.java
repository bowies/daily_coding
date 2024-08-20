package programmers;

class 부족한_금액_계산하기_Java_240820 {
    public long solution(int price, int money, int count) {
        // 총 필요 금액: 등차수열의 합: price * (1 + 2 + ... + count)
        long total = (long) price * count * (count + 1) / 2;
        
        // 부족한 금액
        long answer = total - money; 
        
        return answer > 0 ? answer : 0;
    }

    
    public long solution_best(long price, long money, long count) {
        return Math.max(price * (count * (count + 1) / 2) - money, 0);
    }
}

