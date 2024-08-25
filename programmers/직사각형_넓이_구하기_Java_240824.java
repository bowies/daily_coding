package programmers;

class 직사각형_넓이_구하기_Java_240824 {
    public int solution(int[][] dots) {
        int[] arr = {dots[0][0], dots[0][0], dots[0][1], dots[0][1]};
                    //x 최소, 최대, y 최소, 최대
        
        for (int i = 1; i < dots.length; i++) {
            arr[0] = Math.min(arr[0], dots[i][0]); // x 최소 갱신
            arr[1] = Math.max(arr[1], dots[i][0]); // x 최대 갱신
            arr[2] = Math.min(arr[2], dots[i][1]); // y 최소 갱신
            arr[3] = Math.max(arr[3], dots[i][1]); // y 최대 갱신
        }
        
        int width = arr[1] - arr[0];
        int height = arr[3] - arr[2];
        int area = width * height;
        
        return area;
    }
}
