package kim.present.solve.programmers

/**
 * [프로그래머스 258712 - 가장 많이 받은 선물](https://school.programmers.co.kr/learn/courses/30/lessons/258712) *
 */
class Solution258712kt {
    fun solution(friends: Array<String>, gifts: Array<String>): Int {
        val nameMap = friends.mapIndexed { i, name -> name to i }.toMap()
        val relations = friends.mapIndexed { i, _ -> i to Data(i, IntArray(friends.size) { 0 }) }.toMap()

        // 기존 선물 기록 처리
        gifts
            .map { it.split(" ") }
            .map { (a, b) -> relations[nameMap[a]]!! to relations[nameMap[b]]!! }
            .forEach { (a, b) ->
                //선물 지수 변화
                a.point++
                b.point--

                //선물을 준 횟수를 받은 친구의 관계 정보에 추가
                a.relations[b.id] = a.relations[b.id] + 1
            }

        // 다음달 선물 처리
        relations.forEach { (i, a) ->
            relations.forEach forEachJ@{ (j, b) ->
                if (j <= i) return@forEachJ

                when ((a.relations[j] compareTo b.relations[i]).takeIf { it != 0 } ?: (a.point compareTo b.point)) {
                    1 -> a.gift++
                    -1 -> b.gift++
                }
            }
        }

        return relations.maxOf { (_, data) -> data.gift }
    }

    private class Data(
        val id: Int,
        val relations: IntArray,
        var point: Int = 0,
        var gift: Int = 0
    )
}
