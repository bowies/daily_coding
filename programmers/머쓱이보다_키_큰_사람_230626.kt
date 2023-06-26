package programmers

class 머쓱이보다_키_큰_사람_230626 {
    fun solution(array:IntArray, height:Int):Int{
        var answer: Int = 0

        for(i in array){
            if(i > height){
                answer++
            }
        }
        return answer
    }

    fun solution_stream(array: IntArray, height: Int) = array.filter { it > height }.size

    fun solution_stream2(array: IntArray, height: Int): Int {
        // it 대신에 다른 변수명을 사용해도 되긴 하는데, 그러면
        // return array.filter { it > height }.size 대신에
        // 아래와 같이 amugona(아무거나) 를 넣으면 된다.
        // it은 예약어 같이 람다에서 쓰면 되는 거라서 간단하게 it으로 쓴다고 한다.

        return array.filter { amugona -> amugona > height }.size
    }

}