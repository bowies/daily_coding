package programmers;

class 키패드_누르기_Java_241012 {
    private static final int[][] 키패드 = {
        {3, 1}, // 0의 좌표
        {0, 0}, // 1의 좌표
        {0, 1}, // 2의 좌표
        {0, 2}, // 3의 좌표
        {1, 0}, // 4의 좌표
        {1, 1}, // 5의 좌표
        {1, 2}, // 6의 좌표
        {2, 0}, // 7의 좌표
        {2, 1}, // 8의 좌표
        {2, 2}  // 9의 좌표
    };
    
    private int 거리계산(int[] 위치1, int[] 위치2) {
        return Math.abs(위치1[0] - 위치2[0]) + Math.abs(위치1[1] - 위치2[1]);
    }

    public String solution(int[] numbers, String hand) {
        StringBuilder 결과 = new StringBuilder();
        
        int[] 왼손위치 = {3, 0};  
        int[] 오른손위치 = {3, 2}; 
        
        boolean 오른손잡이 = hand.equals("right");
        
        for (int 번호 : numbers) {
            if (번호 == 1 || 번호 == 4 || 번호 == 7) {
                결과.append("L");
                왼손위치 = 키패드[번호];
            } else if (번호 == 3 || 번호 == 6 || 번호 == 9) {
                결과.append("R");
                오른손위치 = 키패드[번호];
            } else {
                int 왼손거리 = 거리계산(왼손위치, 키패드[번호]);
                int 오른손거리 = 거리계산(오른손위치, 키패드[번호]);
                
                if (왼손거리 < 오른손거리) {
                    결과.append("L");
                    왼손위치 = 키패드[번호];
                } else if (오른손거리 < 왼손거리) {
                    결과.append("R");
                    오른손위치 = 키패드[번호];
                } else {
                    if (오른손잡이) {
                        결과.append("R");
                        오른손위치 = 키패드[번호];
                    } else {
                        결과.append("L");
                        왼손위치 = 키패드[번호];
                    }
                }
            }
        }
        
        return 결과.toString();
    }
}
