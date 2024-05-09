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
        int answer = health;

        int time = 0;
        for (int[] attack : attacks) {
            int diff = attack[0] - time;
            answer = Math.min(answer + diff * x + diff / t * y, health) - attack[1];
            if (answer <= 0) {
                return -1;
            }

            time += diff + 1;
        }

        return answer;
    }
}
