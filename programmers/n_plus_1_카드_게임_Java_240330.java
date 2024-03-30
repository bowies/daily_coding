package programmers;

import java.util.*;

class n_plus_1_카드_게임_Java_240330 {
    public int solution(int coin, int[] cards) {
        List<Integer> 카드저장용 = new ArrayList<>();
        Deque<Integer> 카드뭉치저장용 = new LinkedList<>();
        List<Integer> 카드임시저장용 = new ArrayList<>();
        int 턴수 = 1;

        for (int i = 0; i < cards.length / 3; i++) {
            카드저장용.add(cards[i]);
        }
        for (int i = cards.length / 3; i < cards.length; i++) {
            카드뭉치저장용.add(cards[i]);
        }

        // 코인이 있고, 카드 뭉치 저장된 게 있는 동안
        while (coin >= 0 && !카드뭉치저장용.isEmpty()) {
            // 카드 뭉치에서 두 장을 뽑아 임시로 저장
            카드임시저장용.add(카드뭉치저장용.poll());
            카드임시저장용.add(카드뭉치저장용.poll());

            // 카드 두 장의 합이 목표값과 같으면 다음 라운드로 이동
            if (check(카드저장용, 카드저장용, cards.length + 1)) {
                // 아무 작업 하지 않음!
            } 
            // 코인이 1 이상이고, 두 장의 합이 목표값과 같으면 코인을 하나 소비
            else if (coin >= 1 && check(카드저장용, 카드임시저장용, cards.length + 1)) {
                coin--;
            } 
            // 코인이 2 이상이고, 두 장의 합이 목표값과 같으면 코인을 두 개 소비
            else if (coin >= 2 && check(카드임시저장용, 카드임시저장용, cards.length + 1)) {
                coin -= 2;
            } 
            // 두 장의 합이 목표값과 같지 않으면 게임 종료
            else {
                break;
            }
            // 다음 라운드로 진행
            턴수++;
        }

        return 턴수;
    }

    // 두 개의 덱에서 두 장의 카드를 뽑아 합이 목표값과 같은지 확인
    private boolean check(List<Integer> 덱1, List<Integer> 덱2, int target) {
        Set<Integer> 덱2값 = new HashSet<>(덱2);

        // 덱1의 카드를 반복하여 확인
        Iterator<Integer> iterator = 덱1.iterator();
        while (iterator.hasNext()) {
            int card = iterator.next();
            // 목표값에서 카드를 뺀 값이 덱2에 있는지 확인
            if (덱2값.contains(target - card)) {
                // 카드를 제거하고 true 반환
                iterator.remove();
                덱2.remove((Integer) (target - card));
                return true;
            }
        }
        // 모든 카드를 확인해도 합이 목표값과 같은 카드가 없으면 false 반환
        return false;
    }
}