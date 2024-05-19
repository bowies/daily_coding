package programmers;

class 커피_심부름_Java_240519 {
    public int solution(String[] order) {
        int answer = 0;
        
        for (String item : order) {
            if (item.equals("americano") || item.equals("anything") || 
                item.equals("iceamericano") || item.equals("americanoice") || 
                item.equals("hotamericano") || item.equals("americanohot")) {
                answer += 4500;
            } else if (item.equals("cafelatte") || 
                       item.equals("icecafelatte") || item.equals("cafelatteice") || 
                       item.equals("hotcafelatte") || item.equals("cafelattehot")) {
                answer += 5000;
            }
        }
        
        return answer;
    }



    public int best_solution(String[] order) {
        int answer = 0;
        for(String o : order) {
            if(o.contains("cafelatte")) {
                answer += 5000;
            } else {
                answer += 4500;
            }
        }
        return answer;
    }
}
