package programmers

class 치킨_쿠폰_Kotlin_230726 {
    fun solution(chicken: Int): Int {
        var answer = 0 // 치킨을 얻기 위해 필요한 최소 쿠폰 개수를 저장하는 변수
        var 쿠폰 = chicken // 치킨 교환이 이루어지고 남은 쿠폰의 개수를 저장하는 변수

        // 보유한 쿠폰의 개수가 10개 이상일 때까지 반복한다.
        while (쿠폰 >= 10) {
            val 남은쿠폰 = 쿠폰 % 10 // 10으로 나눈 나머지를 계산하여 남은 쿠폰을 구한다.
            answer += 쿠폰 / 10 // 10으로 나눈 몫을 answer에 누적하여 쿠폰을 교환할 횟수를 계산한다.
            쿠폰 = 남은쿠폰 + 쿠폰 / 10 // 남은 쿠폰과 쿠폰 교환으로 얻은 새로운 쿠폰을 합하여 다시 쿠폰의 개수를 업데이트한다.
        }

        return answer // 치킨을 얻기 위해 필요한 최소 쿠폰 개수를 반환한다.
    }

    fun solution2(chicken: Int): Int {
        var answer = 0

        var 쿠폰 = chicken
        while (쿠폰 >= 10) {
            val 서비스치킨 = 쿠폰 / 10
            val 나머지 = 쿠폰 % 10

            쿠폰 = 서비스치킨 + 나머지

            answer += 서비스치킨
        }

        return answer
    }

    fun solution_재귀(chicken: Int): Int {
        //재귀 종료 조건까지 도달할 때까지 과정을 반복하며 최소 쿠폰 개수를 구합니다.
        // = if(chicken < 10) 0 else chicken/10 + solution(chicken/10 + chicken%10) 와 같습니다.
        return if (chicken < 10) {
            // 기저 조건 (chicken < 10): chicken이 10 미만이면 쿠폰이 부족하여 더 이상 교환할 수 없으므로 0을 반환합니다.
            0
        } else {
            // 재귀 부분: chicken이 10 이상이면, 한 마리의 치킨을 얻기 위해 10개의 쿠폰이 필요합니다.
            // chicken / 10을 통해 현재 가지고 있는 쿠폰 중 10으로 교환 가능한 개수를 계산하고,
            // chicken % 10을 통해 남은 쿠폰의 개수를 구합니다.
            // 그리고 chicken / 10 + chicken % 10을 통해 다음 호출에서 사용할 chicken의 새로운 값으로 대체합니다.
            // 이후 재귀적으로 solution 함수를 호출하여 쿠폰을 누적하여 교환하는 과정을 반복합니다.
            chicken / 10 + solution_재귀(chicken / 10 + chicken % 10)
        }
    }


}