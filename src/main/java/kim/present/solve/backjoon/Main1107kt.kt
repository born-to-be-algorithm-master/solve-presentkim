package kim.present.solve.backjoon

import kotlin.math.abs
import kotlin.math.log10

/**
 * [백준 1107 - 리모컨](https://www.acmicpc.net/problem/1107) *
 */
object Main1107kt {
    @JvmStatic
    fun main(args: Array<String>) {
        val n = readln().toInt() // 이동하려는 채널 (0 ≤ N ≤ 500,000)
        readln() // 고장난 버튼의 개수 (0 ≤ M ≤ 10) - 사용하지 않음

        // 0 ~ 9 버튼의 고장 여부를 배열에 저장
        val buttons = BooleanArray(10)
        readlnOrNull()?.split(" ")?.forEach { buttons[it.toInt()] = true }

        var answer = abs(100 - n) // 초기값 : 초기 채널(100)에서 +, - 버튼만으로 이동하는 횟수 (0 ~ 499,900)
        var current = nextButton(0, buttons) // 현재 채널 초기값 : 고장나지 않은 첫번째 버튼
        val limit = n + answer // 최대 채널 : 이동하려는 채널(n) + 초기 채널과 이동하려는 채널(n)의 차이 (100 ~ 999,900)
        while (current < limit) {
            val digitCount = if (current == 0) 1 else (log10(current.toDouble()) + 1).toInt() // 번호 입력 수
            val absoluteDiff = abs(current - n) // 채널 이동 수

            answer = minOf(answer, digitCount + absoluteDiff) // 최소값 갱신

            current = nextChannel(current, buttons) // 다음 채널로 이동
        }

        // 최소 입력 횟수 출력
        println(answer)
    }

    /**
     * 고장난 버튼이 포함되지 않은 다음 채널로 가기 위한 증가 값을 반환
     *
     * @param channel 현재 채널
     * @param buttons 고장난 버튼
     * @return 고장난 버튼이 포함되지 않은 다음 채널과 현재 채널의 차이
     */
    private fun nextChannel(channel: Int, buttons: BooleanArray): Int {
        var nextChannel = channel

        var digit = 1
        while (digit < 10000000) { // 6자리까지만 검사
            val curr = (nextChannel / digit) % 10
            val next = nextButton(curr + 1, buttons)

            // 고장난 버튼만 있거나, 0번 버튼만 고장나지 않은 경우 Int.MAX_VALUE 반환
            if (next == Int.MAX_VALUE || curr == next && next == 0) return Int.MAX_VALUE

            // 현재 자리수 업데이트
            nextChannel += (-curr + next) * digit

            // 다음 자리수에 영향을 주지 않는 경우 결과 반환
            if (curr < next) return nextChannel

            // 자리수 증가
            digit *= 10
        }

        // 6자리까지 검사했는데도 결과가 없으면 +1 반환
        return nextChannel + 1
    }

    /**
     * 고장나지 않은 버튼을 찾아 반환, 없으면 Int.MAX_VALUE 반환
     *
     * @param num     현재 버튼
     * @param buttons 고장난 버튼
     * @return 고장나지 않은 다음 버튼, 없으면 Int.MAX_VALUE
     */
    private fun nextButton(num: Int, buttons: BooleanArray) =
        (0..9).map { (it + num) % 10 }.firstOrNull { !buttons[it] } ?: Int.MAX_VALUE
}