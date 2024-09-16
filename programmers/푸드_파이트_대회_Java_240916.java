package programmers;

class 푸드_파이트_대회_Java_240916 {
    public String solution(int[] food) {
        StringBuilder leftSide = new StringBuilder();  

        for (int i = 1; i < food.length; i++) {
            int count = food[i] / 2;  
            for (int j = 0; j < count; j++) {
                leftSide.append(i);  
            }
        }

        // 왼쪽 음식 + 물 + 오른쪽 음식 (왼쪽 배치를 뒤집어서 생성)
        String answer = leftSide.toString() + "0" + leftSide.reverse().toString();
        return answer;
    }
}
