public class GenomicRangeQuery_221218 {
    public static void main(String[] args) {
        
        String s = "CAGCCCTA";
        int [] P = {2,5,0};
        int [] Q = {4,5,6};
        solution(s, P, Q);
    }   
    public static int[] solution(String S, int[] P, int[] Q) {
        
        //A C G T 
        //1 2 3 4 
        //2  5  0
        //4  5  6
        //아하 문자열의 2~4까지 중에 작은 ACGT를 찾으면 되는 거군

        int [][] arr = new int[S.length()][4];
        int [] answer = new int[P.length];
        char tempC = 'T';
        int temp = 0;

        for(int i = 0; i < S.length(); i++){    
            tempC = S.charAt(i);
            if(tempC == 'A'){
                arr[i][0] = 1;
            }else if(tempC == 'C'){
                arr[i][1] = 1;
            }else if(tempC == 'G'){
                arr[i][2] = 1;
            }else{
                //T
                arr[i][3] = 1;
            }
        }



        for(int i = 1; i < S.length(); i++){
            for(int j = 0; j < 4; j++){
                arr[i][j] += arr[i-1][j];
            }
        }


        for(int i = 0; i < P.length; i++){
            for(int j = 0; j < 4; j++){
                temp = 0;

                if(P[i] - 1 >= 0){
                    temp = arr[P[i]-1][j];
                    System.out.println(temp + "값");
                }

                if(arr[Q[i]][j] - temp > 0){
                    answer[i] = j+1;
                    break;
                }
            }

        }

        for(int i : answer){
            System.out.printf(i + " ");
        }
        System.out.println();
        return answer;
    }

}
