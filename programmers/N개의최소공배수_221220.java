package programmers;

public class N개의최소공배수_221220 {

    public static void main(String[] args) {
        int [] arr = {2,6,8,14};
        System.out.println(solution(arr));
    }
    
    public static int solution(int[] arr) {
        int answer = arr[0]; //1개짜리 배열이면 그냥 answer 에서 끝남!

        for(int i = 1; i<arr.length; i++){
            int gcd = gcd(answer,arr[i]); //최대공약수
            answer = answer * arr[i] / gcd; //최소공배수
        }
        


        return answer;
    }

    public static int gcd(int num1, int num2){
        int max = Math.max(num1, num2);
        int min = Math.min(num1, num2);
        int temp = 0;

        while(max % min != 0){
            temp = max % min;
            max = min;
            min = temp;

        }

        return min;
    }
}
