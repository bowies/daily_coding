package programmers;


class 최소직사각형_Java_240830 {

    
    public int solution_best(int[][] sizes) {
        int width = 0;
        int height = 0;

        for (int[] card : sizes) {
            width = Math.max(width, Math.max(card[0], card[1]));
            height = Math.max(height, Math.min(card[0], card[1]));
        }

        int answer = width * height;
        return answer;
    }

    
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;

        for (int[] card : sizes) {
            int width = Math.max(card[0], card[1]);
            int height = Math.min(card[0], card[1]);
            
            if (width > maxWidth) {
                maxWidth = width;
            }
            
            if (height > maxHeight) {
                maxHeight = height;
            }
        }

        return maxWidth * maxHeight;
    }



}