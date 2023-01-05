package programmers;


public class test_230105 {

    public static void main(String[] args) {
        //문제1
        //문제 1은 풀만했음

        //문제2
        //효율성 테스트 WTH...

        //문제3
        //이거 SimpleDateFormat 쓰면 계속 오류나서 생으로 짜던 중에 temp[1] 이랑 temp[0] 바꿔 쓴 것을 5분 전에 깨달음
        //다 풀고 나서 컴파일 안 되어서 틀림 ㅠ...
    }

/*    public static void main(String[] args) {
        String [] birth = {"1899-13-31", "19001231", "2001-09-04", "1900-02-29", "2021-5-31", "1950-11-30", "1996-02-29", "1999-11-31", "2000-02-29"};
        System.out.println(solution(birth));
    }

    public static boolean checkDate(String date){
		try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            df.setLenient(false);
            df.parse(date);
            

        } catch (ParseException e) {
            return false;
        }
        return true;
		
    }
    public static int solution(String[] birth) {
        int answer = 0;
        
        for(int i = 0; i < birth.length; i++){
            if(birth[i].length() == 10){
                    String[] temp = birth[i].split("-");
                    if(Integer.parseInt(temp[0]) >= 1900 && Integer.parseInt(temp[0]) <= 2021 ) {
                        
                        //연
                        if(temp[1].length()==2){
                            //월
                            int tempMonth = Integer.parseInt(temp[1]);
                            if(tempMonth == 1 || tempMonth == 3 || tempMonth == 5 || tempMonth == 7 || tempMonth == 8 || tempMonth == 10 || tempMonth == 12){
                                if(Integer.parseInt(temp[2]) >= 1 && Integer.parseInt(temp[2])<=31){    
                                    
                                    answer++;
                                }
                            } else if(tempMonth == 2){
                                boolean flag = Integer.parseInt(temp[0])%4 == 0 && Integer.parseInt(temp[0])%100 !=0;
                                boolean flag2 = Integer.parseInt(temp[0]) % 400 == 0 ;
                                
                                if(flag || flag2){
                                    //윤년
                                    if(Integer.parseInt(temp[2]) >= 1 && Integer.parseInt(temp[2])<=29){
                                        
                                        answer++;
                                    }
                                }else{
                                    //윤년아님
                                    if(Integer.parseInt(temp[2]) >= 1 && Integer.parseInt(temp[2])<=28){    
                                        
                                        answer++;
                                    }

                                }
                            } else if (tempMonth == 4 || tempMonth == 6 || tempMonth == 9 || tempMonth == 11 ){
                                //4 6 9 11
                                if(Integer.parseInt(temp[2]) >= 1 && Integer.parseInt(temp[2])<=30){  
                                    
                                    
                                    answer++;
                                }
                            }


                        }
                    }
            }

        }
        return answer;
    }

     */
    /*
    public static void main(String[] args) {
        //등수 구하기

        int [] grade = {3, 2, 1, 2};
        System.out.println(Arrays.toString(solution(grade)));
    }

    

    public static int[] solution(int[] grade) {
      
        int [] answer = new int[grade.length];
        int[] arr = new int[1000001];
        int rank = 1;

        for (int i = 0; i <= grade.length; i++) {
            for (int j=0; j< grade.length; j++) {
                if (grade[j] > i) {
                    rank++;
                }
            }
            arr[i] = rank;
            rank = 1;
        }

        int count = 0;

        for (int i : grade) {
            answer[count] = arr[i];
            count++;
        }


        return answer;
    }
    */
    /*
     * 
     * 

        int[] answer = new int[grade.length];

        for(int i = 0; i < grade.length; i++){
            int count = 1;

            for(int j = 0; j < grade.length; j++){
                if(grade[i] < grade[j]){
                    count++;
                }
            }

            answer[i] = count;
        }

        
        return answer;
     * 
     */
    /*
    public static void main(String[] args) {
        //자동차 과속 단속
        //설치 시각 기록
        //int speed_limit = 30;
        //int[][] cameras = {{60,3},{152,6},{240,9}};

        
        int speed_limit = 60;
        int[][] cameras = {{60,1},{130,2},{240,4},{432,7}};
        System.err.println(solution(speed_limit, cameras));

    }
    public static int solution(int speed_limit, int[][] cameras) {
        int answer = 0;

        int start = 0;
        int end = 0;
        int hour = 0;

        for(int i = 0; i < cameras.length; i++){
            if(i == 0){
                start = 0;
                end = cameras[i][0];
                hour = cameras[i][1];

                
                if((double)(end - start)/hour > speed_limit){
                    answer++;
                }
                
                //계산 후
                start = cameras[i][0];
            }else{
                end = cameras[i][0]; 
                hour = cameras[i][1] - hour;

                if((double)(end - start)/hour > speed_limit){
                    answer++;                   
                }
                start = cameras[i][0];
                hour = cameras[i][1];
            }
            
        }


        return answer;
    }
     */
}
