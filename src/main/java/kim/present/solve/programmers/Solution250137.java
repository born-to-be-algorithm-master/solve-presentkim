package kim.present.solve.programmers;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/250137?language=java">
 * 프로그래머스 250137 - [PCCP 기출문제] 1번 / 붕대 감기
 * </a>
 */
class Solution250137 {

    /*
     * bandage : 붕대 감기 기술 정보 (bandage.length = 3)
     *     bandage[0] : 시전 시간 t (1 ≤ t ≤ 50)
     *     bandage[1] : 초당 회복량 x (1 ≤ x ≤ 100)
     *     bandage[2] : 추가 회복량 y (1 ≤ y ≤ 100)
     * health : 최대 체력 (1 ≤ health ≤ 1000)
     * attacks : 공격 정보 배열 (1 ≤ attacks.length ≤ 100)
     *     attacks[i][0] : 공격 시간 (1 ≤ attacks[i][0] ≤ 1000)
     *     attacks[i][1] : 피해량 (1 ≤ attacks[i][1] ≤ 100)
     */
    public int solution(int[] bandage, int health, int[][] attacks) {
        final int t = bandage[0], x = bandage[1], y = bandage[2];
        final int maxTime = attacks[attacks.length - 1][0];

        int attackIndex = 0;
        int answer = health;
        int success = 0;
        for (int time = 1; time <= maxTime; ++time) {
            if (attacks[attackIndex][0] == time) { // 현재 시간에 공격을 당할 경우
                answer -= attacks[attackIndex][1];
                success = 0;
                if (answer < 1) return -1;

                if (++attackIndex == attacks.length) return answer;
            } else {
                answer += x;
                success++;
                if (success == t) {
                    success = 0;
                    answer += y;
                }

                if (answer > health) answer = health;
            }
        }
        return answer;
    }
}
