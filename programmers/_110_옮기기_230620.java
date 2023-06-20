package programmers;

import java.util.*;

public class _110_옮기기_230620 {
/*
    주어진 코드는 주어진 문자열 배열에서 각 문자열에 대해 "110"을 옮기는 작업을 수행하는 함수입니다.
    코드를 단계별로 설명하겠습니다.

    1. 주어진 문자열 배열의 길이에 맞게 결과를 담을 문자열 배열 `answer`를 생성합니다.
    2. 주어진 문자열 배열을 순회하면서 각 문자열에 대해 작업을 수행합니다.
    3. 현재 처리 중인 문자열 `str`에 대해 스택 `stack`과 카운트 변수 `cnt`를 초기화합니다.
    4. 문자열 `str`을 순회하면서 각 문자를 처리합니다.
    5. 스택 `stack`의 크기가 2 이상이라면 가장 최근에 넣은 2개의 문자와 현재 문자를 비교합니다.
       - 만약 "110"인 경우 `cnt`를 증가시킵니다.
       - 그렇지 않은 경우에는 스택에 다시 문자를 넣습니다.
    6. 스택의 크기가 2보다 작은 경우에는 현재 문자를 스택에 넣습니다.
    7. 스택의 크기 `idx`와 "110"을 삽입할 위치를 표시할 인덱스 `flag`를 초기화하고, 결과를 담을 `StringBuilder`인 `sb`를 생성합니다.
    8. 스택이 비어있지 않을 때까지 스택에서 문자를 꺼내면서 결과를 `sb`에 역순으로 삽입합니다.
       - 만약 `flag`가 false이고 꺼낸 문자가 '1'인 경우에는 `idx`를 1 감소시킵니다.
       - `flag`가 false이고 꺼낸 문자가 '0'인 경우에는 `flag`를 true로 변경합니다.
    9. `cnt`가 0보다 큰 경우, 즉 "110"을 삽입해야 할 경우에는 `cnt`만큼 반복하면서 "110"을 `sb`의 `idx` 위치에 삽입하고 `idx`와 `cnt`를 갱신합니다.
    10. 모든 작업이 완료된 `sb`를 문자열로 변환하여 `answer` 배열의 해당 인덱스에 저장합니다.
    11. 처리가 필요 없는 경우에는 원래의 문자열을 그대로 `answer` 배열에 저장합니다.
    12. 모든 작업이 완료되었으면 `answer` 배열을 반환합니다.

    이렇게 주어진 문자열 배열에 대해 "110"을 옮기는 작업을 수행하고 결과를 반환하는 함수입니다.
 */
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        StringBuilder sb;

        for(int i=0; i<s.length; i++) {
            String str = s[i];
            Stack<Character> stack = new Stack<>();
            int cnt = 0;

            for(int j=0; j<str.length(); j++) {
                char z = str.charAt(j);

                if(stack.size()>=2) {
                    char y = stack.pop();
                    char x = stack.pop();

                    if(x=='1' && y=='1' && z=='0') {
                        cnt++;
                    } else {
                        stack.push(x);
                        stack.push(y);
                        stack.push(z);
                    }
                } else {
                    stack.push(z);
                }
            }

            int idx = stack.size();
            boolean flag = false;
            sb = new StringBuilder();
            while(!stack.isEmpty()) {
                if(!flag && stack.peek()=='1') {
                    idx--;
                }

                if(!flag && stack.peek()=='0') {
                    flag = true;
                }

                sb.insert(0, stack.pop());
            }

            if(cnt>0) {
                while(cnt>0) {
                    sb.insert(idx, "110");
                    idx += 3;
                    cnt--;
                }
                answer[i] = sb.toString();
            } else {
                answer[i] = s[i];
            }
        }
        return answer;
    }

}
