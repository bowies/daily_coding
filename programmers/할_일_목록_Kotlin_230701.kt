package programmers

class 할_일_목록_Kotlin_230701 {
    /*
    오늘 해야 할 일이 담긴 문자열 배열 todo_list와
    각각의 일을 지금 마쳤는지를 나타내는 boolean 배열 finished가 매개변수로 주어질 때,
    todo_list에서 아직 마치지 못한 일들을 순서대로 담은 문자열 배열을 return 하는 solution 함수를 작성해 주세요.
     */
    fun solution(todo_list: Array<String>, finished: BooleanArray): Array<String> {
        //var answer: Array<String> = arrayOf<String>()
        //return answer

        val answer = mutableListOf<String>()

        for (i in todo_list.indices) {
            if (!finished[i]) {
                answer.add(todo_list[i])
            }
        }

        return answer.toTypedArray()
    }
    /*
    함수 내부에서는 answer라는 이름의 가변 리스트(mutableListOf)를 생성하고 초기화합니다.

    그 후, todo_list 배열을 인덱스 기반으로 반복하면서 (indices)
    해당 일이 아직 마무리되지 않았는지(!finished[i])를 확인합니다.
    만약 아직 마무리되지 않은 일이라면 answer 리스트에 추가합니다.

    마지막으로, answer 리스트를 toTypedArray() 함수를 사용하여 배열로 변환하고, 해당 배열을 반환합니다.
     */

    /*

    `mutableListOf`는 Kotlin의 표준 라이브러리 함수 중 하나로, 가변 크기의 리스트를 생성하는 함수입니다.
    `mutableListOf` 함수를 사용하면 리스트를 생성하고 원하는 요소를 추가하거나 삭제할 수 있는 가변 리스트를 생성할 수 있습니다.

    가변 리스트는 크기가 동적으로 변할 수 있으며, 리스트의 요소를 추가하거나 제거할 수 있는 유연성을 제공합니다.
    이는 Java에서의 ArrayList와 유사한 개념입니다.

    예를 들어, 다음과 같이 `mutableListOf`를 사용하여 가변 리스트를 생성할 수 있습니다:

    val list = mutableListOf<Int>() // 정수를 담는 가변 리스트 생성
    list.add(1) // 요소 추가
    list.add(2)
    list.add(3)
    list.removeAt(1) // 인덱스 1의 요소 제거

    println(list) // [1, 3]

    위 코드에서는 `mutableListOf`를 사용하여 `Int` 타입의 요소를 담는 가변 리스트를 생성했습니다.
    그 후 `add` 함수를 사용하여 요소를 추가하고, `removeAt` 함수를 사용하여 인덱스 1의 요소를 제거하였습니다.

    `mutableListOf`를 사용하면 리스트에 요소를 추가하고 제거하는 등의 작업을 수행할 수 있습니다.
     */

    /*
    `indices`는 Kotlin의 배열이나 리스트의 유효한 인덱스 범위를 나타내는 프로퍼티입니다.
    이 프로퍼티를 사용하면 배열이나 리스트의 인덱스를 순회하거나 접근할 수 있습니다.

    예를 들어, 다음과 같이 `indices`를 사용하여 배열의 인덱스를 순회할 수 있습니다:

    val array = arrayOf("apple", "banana", "orange")

    for (i in array.indices) {
        println("Index $i: ${array[i]}")
    }

    위 코드에서는 `array.indices`를 사용하여 `array` 배열의 유효한 인덱스 범위를 얻습니다.
    그 후 `for` 루프를 통해 인덱스를 순회하면서 해당 인덱스에 있는 요소를 출력합니다.

    출력 결과는 다음과 같습니다:

    Index 0: apple
    Index 1: banana
    Index 2: orange

    `indices`는 배열 뿐만 아니라 Kotlin의 `List` 인터페이스에서도 사용할 수 있습니다.
    이를 통해 배열이나 리스트의 인덱스를 순회하거나 인덱스를 활용한 작업을 수행할 수 있습니다.
     */

    fun solution_short(todo_list: Array<String>, finished: BooleanArray): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        return todo_list.filterIndexed {i, v -> finished[i].not()}.toTypedArray()
    }
    /*

    위 코드는 람다식과 Kotlin의 확장 함수인 filterIndexed를 사용하여 로직을 간단하게 작성한 예시입니다.

    filterIndexed 함수:
    todo_list 배열을 순회하면서 (인덱스, 값) 형태의 파라미터를 받는 람다식을 적용합니다.
    람다식에서는 finished[i].not()를 평가하여 false인 경우 해당 요소를 필터링합니다.

    toTypedArray 함수:
    filterIndexed로 필터링된 결과를 리스트로 반환하고, toTypedArray 함수를 사용하여 배열로 변환합니다.

     */
}