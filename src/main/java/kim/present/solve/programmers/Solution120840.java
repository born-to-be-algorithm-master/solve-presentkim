package kim.present.solve.programmers;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/120840?language=java">
 * 프로그래머스 120840 - 구슬을 나누는 경우의 수
 * </a>
 */
class Solution120840 {
    /**
     * @param balls 1 ≤ balls ≤ 30
     * @param share 1 ≤ balls ≤ share ≤ 30
     * @return balls 개의 구슬 중 share 개의 구슬을 고르는 가능한 모든 경우의 수
     */
    public int solution(int balls, int share) {
        // nCr = nC(n - r) 이므로, share > balls - share 일 때, nCr = nC(balls - share) 로 계산하면 더 빠름
        return (int) nCr(balls, Math.min(share, balls - share));
    }

    /**
     * nCr (조합) : 서로 다른 n개 중 순서를 생각하지 않고 r개를 뽑는 경우의 수
     *
     * @param n 서로 다른 n개
     * @param r 순서를 생각하지 않고 r개를 뽑는 경우
     * @return 서로 다른 n개 중 순서를 생각하지 않고 r개를 뽑는 경우의 수
     */
    private long nCr(int n, int r) {
        /*
         * nPr (순열) : 서로 다른 n개 중 r개를 뽑는 경우의 수
         * nCr (조합) : 서로 다른 n개 중 순서를 생각하지 않고 r개를 뽑는 경우의 수
         * nCr  = nPr / r! (순열 / 뽑은 r개의 항목을 나열하는 방법의 수)
         *      = (n! / (n - r)!) / r!
         *      = n! / (r! * (n - r))!
         */
        long result = 1;
        for (int i = 0; i < r; ++i) {
            result *= n - i;
            result /= i + 1;
        }
        return result;
    }
}
