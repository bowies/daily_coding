package programmers;

import java.util.LinkedList;
import java.util.List;

public class 수식_최대화_230227 {

    private String 표현식;
    private long 최대값 = 0;

    public long solution(String expression) {
        this.표현식 = expression;
        순열(0, 3, new String[]{"+", "-", "*"}, new boolean[3], "");
        return 최대값;
    }

    public void 순열(int start, int target, String[] arr, boolean[] checked, String result) {
        if (start == target) {
            calc(result);
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (!checked[i]) {
                    checked[i] = true;
                    순열(start + 1, target, arr, checked, result + arr[i]);
                    checked[i] = false;
                }
            }
        }
    }

    public void calc(String operator) {
        StringBuilder sb = new StringBuilder();
        List<Long> 피연산자Arr = new LinkedList<>();
        List<String> 연산자Arr = new LinkedList<>();

        for (int i = 0; i < 표현식.length(); i++) {
            if (표현식.charAt(i) == '+' || 표현식.charAt(i) == '-' || 표현식.charAt(i) == '*') {
                피연산자Arr.add(Long.parseLong(sb.toString()));
                sb = new StringBuilder();
                연산자Arr.add(String.valueOf(표현식.charAt(i)));
            } else
                sb.append(표현식.charAt(i));
        }

        피연산자Arr.add(Long.parseLong(sb.toString()));

        for (int i = 0; i < 3; i++) {
            String current = String.valueOf(operator.charAt(i));

            while(연산자Arr.size() != 0){
                int index = 연산자Arr.indexOf(current);

                if(index == -1)
                    break;
                else{
                    switch (current){
                        case "+":
                            피연산자Arr.add(index, 피연산자Arr.get(index) + 피연산자Arr.get(index + 1));
                            break;
                        case "-":
                            피연산자Arr.add(index, 피연산자Arr.get(index) - 피연산자Arr.get(index + 1));
                            break;
                        case "*":
                            피연산자Arr.add(index, 피연산자Arr.get(index) * 피연산자Arr.get(index + 1));
                            break;
                    }

                    피연산자Arr.remove(index + 1);
                    피연산자Arr.remove(index + 1);

                    연산자Arr.remove(index);
                }
            }
        }


        최대값 = Math.max(최대값, Math.abs(피연산자Arr.get(0)));
    }

}
