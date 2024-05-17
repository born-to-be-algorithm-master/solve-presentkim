package kim.present.solve.programmers.level0

/**
 * [프로그래머스 120875 - 평행](https://school.programmers.co.kr/learn/courses/30/lessons/120875) *
 */
class Solution120875kt {
    /**
     * 주어진 네 개의 점을 두 개씩 이었을 때, 두 직선이 평행이 되는 경우가 있으면 1을 없으면 0을 반환
     *
     * @param dots 점 네 개의 좌표를 담은 이차원 배열 [[x1, y1], [x2, y2], [x3, y3], [x4, y4]]
     * @return 두 직선이 평행이 되는 경우가 있으면 1, 없으면 0
     */
    fun solution(dots: Array<IntArray>) = if (arrayOf(
            arrayOf(0, 1, 2, 3), arrayOf(0, 2, 1, 3), arrayOf(0, 3, 1, 2)
        ).any { (a, b, c, d) -> angle(dots[a], dots[b]) == angle(dots[c], dots[d]) }
    ) 1 else 0

    private fun angle(a: IntArray, b: IntArray) = (a[0] - b[0]) / (a[1] - b[1]).toDouble()
}
