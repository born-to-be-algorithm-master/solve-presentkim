package kim.present.solve.programmers.level0;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/181832">
 * 프로그래머스 181832 - 정수를 나선형으로 배치하기
 * </a>
 */
public class Solution181832 {
    /**
     * @param n 양의 정수 1 ≤ n ≤ 30
     * @return n × n 배열에 1부터 n2 까지 정수를 인덱스 [0][0]부터 시계방향 나선형으로 배치한 이차원 배열
     */
    public int[][] solution(int n) {
        // 방향 별 이동 좌표 배열 정의
        final int[] dx = {1, 0, -1, 0};
        final int[] dy = {0, 1, 0, -1};

        // 정답 배열 초기화
        int[][] answer = new int[n][n];

        // 초기 위치 및 방향 설정
        int x = 0, y = 0, direction = 0;

        // 1부터 n^2 까지의 정수를 나선형으로 배치
        for (int i = 1; i <= n * n; i++) {
            answer[y][x] = i; // 현재 위치에 정수 배치

            // 다음 위치 계산
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            // 다음 위치가 배열 범위를 벗어나거나 이미 정수가 배치된 경우 방향 전환
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || answer[ny][nx] != 0) {
                direction = (direction + 1) % 4;
                nx = x + dx[direction];
                ny = y + dy[direction];
            }

            // 다음 위치로 이동
            x = nx;
            y = ny;
        }

        return answer;
    }
}
