package kim.present.solve.backjoon

/** [백준 1012 - 유기농 배추](https://www.acmicpc.net/problem/1012) */
object Main1012kt {
    @JvmStatic
    fun main(args: Array<String>) {
        val t = readln().toInt() // T : 테스트 케이스의 수
        repeat(t) {// 테스트 케이스만큼 반복
            // m : 배추밭의 가로길이
            // n : 배추밭의 세로길이
            // k : 배추가 심어져 있는 위치의 개수
            val (m, n, k) = readln().split(" ").map { it.toInt() }

            // 배추밭을 스캔하여 배추 위치를 저장
            val farm = scanFarm(m, n, k)

            // 모든 배추밭을 탐색하며 배추가 심어져 있는 경우, 해당 배추와 연결된 배추를 모두 제거하고 카운트 증가
            var answer = 0

            farm.forEachIndexed { x, line ->
                line.forEachIndexed { y, hasCabbage ->
                    if (hasCabbage) {
                        removeConnectedFarms(farm, x, y)
                        answer++
                    }
                }
            }
            println(answer)
        }
    }

    /**
     * 배추밭을 스캔하여 배추 위치를 저장
     *
     * @param m       배추밭의 가로길이
     * @param n       배추밭의 세로길이
     * @param k       배추가 심어져 있는 위치의 개수
     * @return 배추밭 정보, 배추가 심어져 있는 위치는 true, 아닌 경우 false
     */
    private fun scanFarm(m: Int, n: Int, k: Int): Array<BooleanArray> {
        // 배추밭 초기화
        val farm = Array(m) { BooleanArray(n) }

        // 배추가 심어져 있는 위치의 개수만큼 반복
        repeat(k) {
            // x : 배추의 x 좌표
            // y : 배추의 y 좌표
            val (x, y) = readln().split(" ").map { it.toInt() }
            farm[x][y] = true // 배추 위치 저장
        }
        return farm // 배추밭 반환
    }

    /**
     * 주어진 위치에서 연결된 배추를 모두 제거
     *
     * @param farms 배추밭
     * @param x     x 좌표
     * @param y     y 좌표
     */
    private fun removeConnectedFarms(farms: Array<BooleanArray>, x: Int, y: Int) {
        // 범위를 벗어나거나 배추가 없는 경우 패스
        if (x < 0 || x >= farms.size || y < 0 || y >= farms[0].size || !farms[x][y]) {
            return
        }

        // 배추를 제거
        farms[x][y] = false

        // 연결된 밭을 재귀 탐색
        for (dx in -1..1 step 2) {
            removeConnectedFarms(farms, x + dx, y)
            removeConnectedFarms(farms, x, y + dx)
        }
    }
}
