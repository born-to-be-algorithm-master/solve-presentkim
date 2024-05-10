package kim.present.solve.programmers;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/250137?language=java">
 * 프로그래머스 250137 - [PCCP 기출문제] 1번 / 붕대 감기
 * </a>
 */
class Solution250137 {
    /**
     * @param bandage 붕대 감기 기술 정보 (bandage.length = 3)
     *                bandage[0] : 시전 시간 t (1 ≤ t ≤ 50)
     *                bandage[1] : 초당 회복량 x (1 ≤ x ≤ 100)
     *                bandage[2] : 추가 회복량 y (1 ≤ y ≤ 100)
     * @param health  최대 체력 (1 ≤ health ≤ 1000)
     * @param attacks 공격 정보 배열 (1 ≤ attacks.length ≤ 100)
     *                attacks[i][0] : 공격 시간 (1 ≤ attacks[i][0] ≤ 1000)
     *                attacks[i][1] : 피해량 (1 ≤ attacks[i][1] ≤ 100)
     */
    public int solution(int[] bandage, int health, int[][] attacks) {
        // bandage(붕대 감기 기술 정보)를 각 변수(t, x, y)에 저장
        int t = bandage[0], x = bandage[1], y = bandage[2];

        // answer(현재 체력)을 health(최대 체력)으로 초기화
        int answer = health;

        // time(시간)을 0으로 초기화
        int time = 0;
        for (int[] attack : attacks) { // 공격 정보 배열을 순회하며
            int diff = attack[0] - time; // diff(공격까지 남은 시간)을 계산

            // answer(현재 체력)을 다음 공격까지의 시간 동안 회복한 체력으로 갱신
            answer = Math.min(answer + diff * x + diff / t * y, health);

            // answer(현재 체력)에서 attack[1](피해량)을 뺌
            answer -= attack[1];

            // answer(현재 체력)이 0 이하라면 -1을 반환
            if (answer <= 0) {
                return -1;
            }

            // time(시간)을 diff(공격까지 남은 시간) + 1로 갱신
            time += diff + 1;
        }

        // answer(현재 체력)을 반환
        return answer;
    }
}
