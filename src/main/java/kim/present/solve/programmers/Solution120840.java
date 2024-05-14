package kim.present.solve.programmers;

import java.math.BigInteger;

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
     * HINT : 서로 다른 n개 중 m개를 뽑는 경우의 수 공식은 다음과 같습니다. n! / (m! * (n-m)!)
     */
    public int solution(int balls, int share) {
        if (balls == share) {
            return 1;
        }

        BigInteger n = BigInteger.valueOf(balls);
        BigInteger m = BigInteger.valueOf(share);
        return factorial(n).divide(factorial(m).multiply(factorial(n.subtract(m)))).intValue();
    }

    /**
     * n! 을 구하는 메소드
     *
     * @param bi 1 ≤ n ≤ 30
     * @return n!
     */
    private BigInteger factorial(BigInteger bi) {
        if (bi.equals(BigInteger.ONE)) {
            return bi;
        }

        return bi.multiply(factorial(bi.subtract(BigInteger.ONE)));
    }
}
