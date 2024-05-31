package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

class 전국_대회_선발_고사_Java_240531 {
    public int solution(int[] rank, boolean[] attendance) {
        List<int[]> 참석가능학생리스트 = new ArrayList<>(); //등수 & 번호
        
        for (int i = 0; i < rank.length; i++) {
            if (attendance[i]) {
                참석가능학생리스트.add(new int[]{rank[i], i});
            }
        }
        
        Collections.sort(참석가능학생리스트, (i, j) -> Integer.compare(i[0], j[0]));
        
        int _1등 = 참석가능학생리스트.get(0)[1];
        int _2등 = 참석가능학생리스트.get(1)[1];
        int _3등 = 참석가능학생리스트.get(2)[1];
        
        return 10000 * _1등 + 100 * _2등 + _3등;
    }


    public int solution_stream(int[] rank, boolean[] attendance) {
        return IntStream.range(0, rank.length)
                .filter(i -> attendance[i])
                .boxed()
                .sorted(Comparator.comparing(i -> rank[i]))
                .limit(3L)
                .reduce((current, next) -> current * 100 + next)
                .get();
    }
}
