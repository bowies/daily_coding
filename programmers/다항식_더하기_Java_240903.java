package programmers;

class 다항식_더하기_Java_240903 {

	public String solution_looks_good(String polynomial) {
		int x의계수 = 0;
		int 상수항 = 0;

		for (String str : polynomial.split(" ")) {
			if (str.contains("x")) {
				// 'x' 항의 경우 계수가 생략된 경우 1로 처리, 아닌 경우 해당 숫자로 처리
				x의계수 += str.equals("x") ? 1 : Integer.parseInt(str.replaceAll("x", ""));
			} 
			// '+' 기호가 아닌 숫자(상수항)를 처리
			else if (!str.equals("+")) {
				상수항 += Integer.parseInt(str);
			}
		}

		return 
			// x 항이 존재하는 경우
			(x의계수 != 0 
				? 
					// x 계수가 1보다 큰 경우와 1인 경우를 구분하여 처리
					(x의계수 > 1 ? x의계수 + "x" : "x") 
				: 
					""
			) 
			+ 
			// 상수항이 존재하는 경우
			(상수항 != 0 
				? 
					// x 항이 존재하는 경우에는 ' + '를 추가
					((x의계수 != 0 ? " + " : "") + 상수항) 
				: 
					// x 항도 상수항도 모두 없는 경우 "0" 반환
					(x의계수 == 0 ? "0" : "")
			);
	}

    public String solution(String polynomial) {
        int x의계수 = 0;
        int 상수항 = 0;
        
        String[] 다항식 = polynomial.split(" ");
        
        for (String str : 다항식) {
            if (str.equals("+")) {
				//+기호는 건너뛴다.
                continue;
            } else if (str.contains("x")) {
                if (str.equals("x")) {
					//x는 1x
                    x의계수 += 1;
                } else {
                    //1x가 아닌 형태를 뽑아준다.
                    x의계수 += Integer.parseInt(str.replace("x", ""));
                }
            } else {
                상수항 += Integer.parseInt(str);
            }
        }
        
        StringBuilder answer = new StringBuilder();
        
        if (x의계수 != 0) {
            answer.append(x의계수 == 1 ? "x" : x의계수 + "x");
        }
        
        if (상수항 != 0) {
            if (answer.length() > 0) {
                answer.append(" + ");
            }
            answer.append(상수항);
        }
        
        return answer.toString();
    }
}
