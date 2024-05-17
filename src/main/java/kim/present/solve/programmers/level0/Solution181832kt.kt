package kim.present.solve.programmers.level0

/**
 * [프로그래머스 181832 - 정수를 나선형으로 배치하기](https://school.programmers.co.kr/learn/courses/30/lessons/181832)
 */
class Solution181832kt {
    /**
     * @param n 양의 정수 1 ≤ n ≤ 30
     * @return n × n 배열에 1부터 n2 까지 정수를 인덱스 [0][0]부터 시계방향 나선형으로 배치한 이차원 배열
     */
    fun solution(n: Int): Array<IntArray> {
        // 방향 별 이동 좌표 배열 정의
        val dx = intArrayOf(1, 0, -1, 0)
        val dy = intArrayOf(0, 1, 0, -1)

        // 정답 배열 초기화
        val answer = Array(n) { IntArray(n) }

        // 초기 위치 및 방향 설정
        var (x, y, d) = arrayOf(0, 0, 0)

        // 1부터 n^2 까지의 정수를 나선형으로 배치
        (1..n * n).forEach { i ->
            answer[y][x] = i // 현재 위치에 정수 배치

            // 다음 위치 계산
            var nx = x + dx[d]
            var ny = y + dy[d]

            // 다음 위치가 배열 범위를 벗어나거나 이미 정수가 배치된 경우 방향 전환
            if (nx !in 0 until n || ny !in 0 until n || answer[ny][nx] != 0) {
                d = (d + 1) % 4
                nx = x + dx[d]
                ny = y + dy[d]
            }

            // 다음 위치로 이동
            x = nx
            y = ny
        }

        return answer
    }
}
