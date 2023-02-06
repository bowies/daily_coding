package programmers;

import java.util.*;

public class 베스트앨범_230206 {
    public static void main(String[] args) {
        String [] 장르 = {"classic", "pop", "classic", "classic", "pop"};
        int [] 재생횟수 = {500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(solution(장르, 재생횟수)));
    }
    public static int[] solution(String[] genres, int[] plays) {

        int[] answer = {};
        int len = genres.length;
        HashMap<String, Integer> map = new HashMap();

        for (int i = 0; i < len; i++) {
            int 재생횟수 = map.getOrDefault(genres[i],0);
            map.put(genres[i], 재생횟수+plays[i]);

        }

        List<String> 내림차순정렬 = new ArrayList<>(map.keySet());
        Collections.sort(내림차순정렬, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));


        List<Integer> answerList = new ArrayList<>();

        내림차순정렬.forEach(values -> {
            //System.out.println(values);

            HashMap<Integer, Integer> answerMap = new HashMap<>();

            for (int i = 0; i < len; i++) {
                if (values.equals(genres[i])) {
                    answerMap.put(i, plays[i]);
                }
            }

            List<Integer> playsList = new ArrayList<>(answerMap.keySet());
            Collections.sort(playsList, (o1, o2) -> (answerMap.get(o2).compareTo(answerMap.get(o1))));

            answerList.add(playsList.get(0));
            if (playsList.size() != 1) {
                answerList.add(playsList.get(1));
            }
        });

        int length = answerList.size();
        answer = new int[length];

        for (int i = 0; i < length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
