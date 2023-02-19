package programmers;

import java.util.Arrays;
import java.util.HashMap;

public class 호텔_방_배정_230219 {
    public static void main(String[] args) {

        long k = 10;
        long [] rn = {1,3,4,1,3,1};

        System.out.println(Arrays.toString(solution(k, rn)));
    }

    /*
        1. 한 번에 한 명씩 신청한 순서대로 방을 배정합니다.
        2. 고객은 투숙하기 원하는 방 번호를 제출합니다.
        3. 고객이 원하는 방이 비어 있다면 즉시 배정합니다.
        4. 고객이 원하는 방이 이미 배정되어 있으면 원하는 방보다 번호가 크면서 비어있는 방 중 가장 번호가 작은 방을 배정합니다.
     */


    static long[] solution(long k, long[] room_number) {
        HashMap <Long, Long> map = new HashMap<>();

        long[] answer = new long[room_number.length];

        for (int i = 0; i < room_number.length; i++){
            answer[i] = 방찾기(map, room_number[i]);
        }

        return answer;
    }

    static Long 방찾기(HashMap <Long, Long> map, long 방번호) {

        if (map.containsKey(방번호) == false) {
            //방이 비어 있으면 다음 방 번호 추가
            map.put(방번호, 방번호 + 1);
            System.out.println(방번호);
            return 방번호;
        }

        long 빈방 = 방찾기(map, map.get(방번호));
        map.put(방번호, 빈방);
        return 빈방;
    }






    //이것과 동일한 로직
    /*
        static HashSet<Long> room = new HashSet<>();
        static TreeSet<Long> empty_room = new TreeSet<>();
        public long[] solution(long k, long[] room_number) {
            long[] answer = new long[room_number.length];
            int idx = 0;
            for(long i : room_number) {
                answer[idx++] = findRoom(i);
            }
            return answer;
        }
        static long findRoom(long num) {
            // 이미 해당 방이 배정되어 있는 경우
            if(room.contains(num)) return findRoom(empty_room.higher(num));

            room.add(num);
            empty_room.remove(num);
            // 배정된 방 보다 +1 한 방이 배정되지 않았다면 빈방으로 지정
            if(!room.contains(num+1)) empty_room.add(num+1);
            return num;
        }

     */

}
