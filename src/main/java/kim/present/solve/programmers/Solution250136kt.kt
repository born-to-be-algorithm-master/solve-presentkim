package kim.present.solve.programmers

/**
 * [프로그래머스 250136 - [PCCP 기출문제] 2번 / 석유 시추](https://school.programmers.co.kr/learn/courses/30/lessons/250136?language=java) *
 */
class Solution250136kt {

    // 땅의 가로 길이만큼 순회하며 시추 가능한 석유량 계산 후 최대값 반환
    fun solution(land: Array<IntArray>) = land[0].indices.maxOf { x -> land.indices.sumOf { y -> bfs(land, x, y) } }

    private fun bfs(land: Array<IntArray>, startX: Int, startY: Int): Int {
        var count = 0 // 석유 덩어리의 매장량
        val queue = ArrayDeque(listOf(startX to startY)) // BFS 처리를 위한 큐
        val yMap = IntArray(land[0].size) { -1 } // 석유 덩어리의 Y 좌표를 저장하는 배열

        while (!queue.isEmpty()) { // 큐가 비어있을 때까지 반복
            val (x, y) = queue.removeLast()

            // 땅의 범위를 벗어나거나 빈 땅인 경우 패스
            if (x < 0 || x >= land[0].size || y < 0 || y >= land.size || land[y][x] == 0) {
                continue
            }

            // 이미 연결된 석유 덩어리 값이 지정된 경우 반환
            if (land[y][x] != 1) {
                return land[y][x]
            }

            if (yMap[x] == -1) { // 처음 방문한 y 좌표인 경우
                yMap[x] = y // 해당 Y 좌표를 저장
            }
            land[y][x] = 0 // 방문한 땅은 0으로 변경
            count++ // 석유 덩어리의 매장량 증가

            // 상하좌우 4개의 좌표를 큐에 추가
            queue.addAll((-1..1 step 2).flatMap { listOf(x + it to y, x to y + it) })
        }

        // 석유 덩어리의 Y 좌표를 저장한 배열을 순회하며 방문한 땅의 값을 변경
        yMap.forEachIndexed { x, y ->
            if (y != -1) { // y 값이 -1이 아닌 경우 (방문한 땅인 경우)
                land[y][x] = count // 땅의 값을 석유 덩어리의 매장량으로 변경
            }
        }

        return count // 석유 덩어리의 매장량 반환
    }
}
