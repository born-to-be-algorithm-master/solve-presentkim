package kim.present.solve.programmers

/**
 * [프로그래머스 250136 - [PCCP 기출문제] 2번 / 석유 시추](https://school.programmers.co.kr/learn/courses/30/lessons/250136?language=java) *
 */
class Solution250136kt {
    fun solution(land: Array<IntArray>): Int {
        var oilCount = 0 // 석유 덩어리 인덱스
        // 석유 덩어리별 매장량을 계산하고 배열에 저장
        val oils = land.flatMapIndexed { y, line -> line.mapIndexed { x, value -> Triple(x, y, value) } }
            .mapNotNull { (x, y, value) -> if (value == 1) groupingOil(land, x, y, oilCount++) else null }

        // 땅의 가로 길이만큼 순회하며 시추 가능한 석유량 계산 후 최대값 반환
        return (0 until land[0].size).maxOf { x ->
            land.map { -it[x] - 1 }.sumOf { oilIndex -> // 석유 덩어리 인덱스로 변환 후 순회 결과 합산
                // 방문하지 않은 석유 덩어리인 경우 석유 덩어리의 매장량 반환
                // 방문한 석유 덩어리인 경우 0 반환
                if (oilIndex != -1) oils[oilIndex] else 0
            }
        }
    }

    private fun groupingOil(land: Array<IntArray>, startX: Int, startY: Int, oilIndex: Int): Int {
        var count = 0 // 석유 덩어리의 매장량
        val queue = ArrayDeque(listOf(startX to startY)) // BFS 처리를 위한 큐
        val visited = BooleanArray(land[0].size) // X 별 방문 여부를 저장할 배열

        while (!queue.isEmpty()) { // 큐가 비어있을 때까지 반복
            val (x, y) = queue.removeLast()

            // 땅의 범위를 벗어나거나 이미 방문한 땅인 경우 무시
            if (x < 0 || x >= land[0].size || y < 0 || y >= land.size || land[y][x] != 1) {
                continue
            }

            if (visited[x]) { // 이미 방문한 땅인 경우
                // 땅의 값을 0으로 변경 (방문 처리, 같은 x 좌표에 대해 중복 체크를 방지하기 위해)
                land[y][x] = 0
            } else {
                // 방문 처리
                visited[x] = true
                // 땅의 값을 석유 덩어리 인덱스를 음수로 변환한 값으로 변경 (방문 처리, 기본값인 0과 1과 다른 값을 넣기 위해)
                land[y][x] = -oilIndex - 1
            }
            count++ // 석유 덩어리의 매장량 증가

            // 상하좌우 4개의 좌표를 큐에 추가
            queue.addAll((-1..1 step 2).flatMap { listOf(x + it to y, x to y + it) })
        }

        return count // 석유 덩어리의 매장량 반환
    }
}
