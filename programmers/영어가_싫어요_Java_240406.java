package programmers;

class 영어가_싫어요_Java_240406 {
    public long solution(String numbers) {
        long answer = 0;
        
        String[] engToNum = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for (int i = 0; i < engToNum.length; i++) {
            numbers = numbers.replaceAll(engToNum[i], String.valueOf(i));
        }
 
        answer = Long.parseLong(numbers);
        return answer;
    }


    public long solution_replaceAll(String numbers) {
        return Long.parseLong(
                numbers.replaceAll("zero", "0")
                        .replaceAll("one", "1")
                        .replaceAll("two", "2")
                        .replaceAll("three", "3")
                        .replaceAll("four", "4")
                        .replaceAll("five", "5")
                        .replaceAll("six", "6")
                        .replaceAll("seven", "7")
                        .replaceAll("eight", "8")
                        .replaceAll("nine", "9")
        );
    }
}