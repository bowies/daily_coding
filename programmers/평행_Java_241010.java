package programmers;

class 평행_Java_241010 {

    public int solution(int[][] dots) {
        if (gradient(dots[0], dots[1]) == gradient(dots[2], dots[3])) 
            return 1;
        else if (gradient(dots[0], dots[2]) == gradient(dots[1], dots[3])) 
            return 1;
        else if (gradient(dots[0], dots[3]) == gradient(dots[1], dots[2])) 
            return 1;
        
        return 0;
    }
    
    public double gradient(int[] arr1, int[] arr2) {
        return (arr2[1] - arr1[1]) * 1.0 / (arr2[0] - arr1[0]);
    }
}