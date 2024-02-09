import java.util.ArrayList;
import java.util.List;

class ad_제거하기_Java_240209 {
    public String[] solution(String[] strArr) {
        List<String> list = new ArrayList<>();
        
        for (String str : strArr) {
            if (!str.contains("ad")) {
                list.add(str);
            }
        }
        
        return list.toArray(new String[0]);
    }
}
