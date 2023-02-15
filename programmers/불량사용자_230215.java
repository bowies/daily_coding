package programmers;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
public class 불량사용자_230215 {
    public static void main(String[] args) {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "abc1**"};


        System.out.println(solution(user_id,banned_id));
    }



    //남이 짠 게 좋아 보이는 코드


    Set<Integer> set2;

    public int solution2(String[] user_id, String[] banned_id) {
        set2 = new HashSet<>();

        go(0, user_id, banned_id, 0);

        return set2.size();
    }

    public void go(int index, String[] user_id, String[] banned_id, int bit) {

        if(index == banned_id.length) {
            set2.add(bit);
            return;
        }

        String reg = banned_id[index].replace("*", "[\\w\\d]");
        for(int i=0; i<user_id.length; ++i) {
            if((((bit>>i) & 1) == 1) || !user_id[i].matches(reg)) continue;
            go(index + 1, user_id, banned_id, (bit | 1<<i));
        }

    }

    // 남이 짠 게 좋아 보이는 코드

    public static int solution(String[] user_id, String[] banned_id) {

        HashSet <HashSet<String>> answer = new HashSet<>();
        dfs(new LinkedHashSet<>(), user_id, banned_id, answer);

        return answer.size();
    }


    private static void dfs(HashSet<String> set, String[] user_id, String[] banned_id, HashSet answer) {
        if (set.size() == banned_id.length) {
            if (불량체크(set, banned_id)) {
                answer.add(new HashSet<>(set));
            }
            return;
        }

        for (String str : user_id) {
            if (set.add(str)) {
                dfs(set, user_id, banned_id, answer);
                set.remove(str);
            }
        }
    }


    private static boolean 불량체크(HashSet<String> set, String[] banned_id) {
        int index = 0;
        for (String str : set) {
            //user_id s
            String banID = banned_id[index++];

            if (str.length() != banID.length()) {
                return false;
            }
            for (int i = 0; i < banID.length(); i++) {
                if (banID.charAt(i) == '*') {
                    continue;
                }
                if (str.charAt(i) != banID.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

}
