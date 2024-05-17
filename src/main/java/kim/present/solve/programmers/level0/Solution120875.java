package kim.present.solve.programmers.level0;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/120875">
 * 프로그래머스 120875 - 평행
 * </a>
 */
public class Solution120875 {
    /**
     * 주어진 네 개의 점을 두 개씩 이었을 때, 두 직선이 평행이 되는 경우가 있으면 1을 없으면 0을 반환
     *
     * @param dots 점 네 개의 좌표를 담은 이차원 배열 [[x1, y1], [x2, y2], [x3, y3], [x4, y4]]
     * @return 두 직선이 평행이 되는 경우가 있으면 1, 없으면 0
     */
    public int solution(int[][] dots) {
        // 직선을 만들 수 있는 모든 방법을 확인
        for (int[] a1 : dots) {
            for (int[] b1 : dots) {
                if (a1 == b1) {
                    continue;
                }

                for (int[] a2 : dots) {
                    for (int[] b2 : dots) {
                        if (a2 == b2 || a1 == a2 || a1 == b2 || b1 == a2 || b1 == b2) {
                            continue;
                        }

                        // 만약 두 직선의 각도가 같다면 1을 반환
                        if (angle(a1, b1) == angle(a2, b2)) {
                            return 1;
                        }
                    }
                }
            }
        }


        return 0;
    }

    private double angle(int[] a, int[] b) {
        return ((double) a[0] - b[0]) / (a[1] - b[1]);
    }
}
