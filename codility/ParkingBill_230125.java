class ParkingBill_230125 {
    public static void main(String[] args) {
        String E = "10:00";
        String L = "13:21";
        System.out.println(solution(E, L));
    }
    public static int solution(String E, String L) {
        int answer = 2;

        //주차장 입장료 : 2
        //처음 한시간 : 3
        //그 다음부터는 : 4

        /*
         * 10:00~13:21
         * 2 
         * ~ 11:00 - 3 = 5
         * ~ 12:00 - 4 = 9
         * ~ 13:00 - 4 = 13
         * ~ 13:~  - 4 = 17
         */

        String [] ESplit = E.split(":");
        String [] LSplit = L.split(":");
        int 출발시 = Integer.parseInt(ESplit[0]);
        int 출발분 = Integer.parseInt(ESplit[1]);
        int 이별시 = Integer.parseInt(LSplit[0]);
        int 이별분 = Integer.parseInt(LSplit[1]);

        if((출발분 - 이별분) < 0){
           이별시++;
        }

        int 시간 = 이별시 - 출발시;
        if(시간 == 1 ||시간 == 0){
            answer = answer + 3;
        }else if(시간 > 0){
            answer = answer + 3 + 4 * (시간-1);
        }

        return answer;
    }
}
