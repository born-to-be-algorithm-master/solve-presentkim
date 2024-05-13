package kim.present.solve.backjoon

/**
 * [백준 20529 - 가장 가까운 세 사람의 심리적 거리](https://www.acmicpc.net/problem/20529)
 */
object Main20529kt {
    @JvmStatic
    fun main(args: Array<String>) {
        val t = readln().toInt() // T : 테스트 케이스의 수
        repeat(t) {// 테스트 케이스만큼 반복
            val flags = scanMbtiFlags() // 변환된 MBTI 플래그 배열

            if (flags.isEmpty()) { // 플래그 배열의 길이가 0이면
                println(0) // 0을 출력
            } else {
                println(calcMinDistance(flags)) // 가장 가까운 세 사람의 심리적 거리를 계산하여 출력
            }
        }
    }

    /**
     * MBTI 문자열을 스캔하여 4비트 플래그로 변환한 배열을 반환
     *
     * @return MBTI 플래그 배열, 3개 이상인 플래그가 있으면 빈 배열
     */
    private fun scanMbtiFlags(): IntArray {
        readln() // N : 학생의 수 (MBTI 문자열의 수), 사용하지 않음

        val counts = IntArray(16) // MBTI 플래그의 개수 배열 (16가지)
        val flags = readln().split(" ").map { mbtiToFlag(it) } //  MBTI 문자열을 4bit 정수 플래그로 변환
        flags.forEach { flag ->
            if (++counts[flag] >= 3) { // 같은 MBTI 수가 3이 넘어가면
                return intArrayOf() // 빈 배열을 반환 (무조건 거리가 최소 거리가 0)
            }
        }

        return flags.toIntArray() // MBTI 플래그 배열 반환
    }

    /**
     * MBTI 문자열을 4비트 플래그로 변환
     *
     * @param mbti MBTI 문자열
     * @return 4비트 플래그
     */
    private fun mbtiToFlag(mbti: String): Int =
        (0..3).sumOf { if (mbti[it] == "ISTP"[it]) 1 shl it else 0 }


    /**
     * 세 개의 정수 간의 비트 차이의 합을 계산
     *
     * @param a 정수 a
     * @param b 정수 b
     * @param c 정수 c
     * @return 세 개의 정수 간의 비트 차이의 합
     */
    private fun sumOfBitDiff(a: Int, b: Int, c: Int) =
        (a xor b).countOneBits() + (b xor c).countOneBits() + (c xor a).countOneBits()

    // private fun sumOfBitDiff(vararg nums: Int) = nums.zip(nums).sumOf { (a, b) -> (a xor b).countOneBits() }

    /**
     * MBTI 플래그 배열에서 가장 가까운 세 사람의 심리적 거리를 계산
     *
     * @param flags MBTI 플래그 배열
     */
    private fun calcMinDistance(flags: IntArray): Int {
        val length = flags.size // MBTI 플래그 배열의 길이
        var min = 8 // 최대 값인 8로 초기화
        for (i in 0 until length) {
            for (j in i + 1 until length) {
                for (k in j + 1 until length) {
                    // MBTI 3개씩 묶어 가져와 비트 차이를 합산
                    val distance = sumOfBitDiff(flags[i], flags[j], flags[k])
                    if (min > distance) { // 최소값 갱신
                        min = distance
                    }

                    if (min == 0) { // 최소값이 0이면 더 이상 계산할 필요 없음
                        return 0
                    }
                }
            }
        }
        return min
    }
}