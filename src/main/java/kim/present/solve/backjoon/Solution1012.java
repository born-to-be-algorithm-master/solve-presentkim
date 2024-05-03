package kim.present.solve.backjoon;

import java.util.Scanner;

/**
 * <a href="https://www.acmicpc.net/problem/1012">
 * 백준 1012 - 유기농 배추
 * </a>
 */
class Solution1012 implements ISolution {
    public void solve() {
        Scanner scanner = new Scanner(System.in);

        /* 테스트 케이스의 개수 */
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            /* 배추밭의 가로길이 M(1 ≤ M ≤ 50) */
            int m = scanner.nextInt();
            /* 배추밭의 세로길이 N(1 ≤ N ≤ 50) */
            int n = scanner.nextInt();
            /* 배추가 심어져 있는 위치의 개수 K(1 ≤ K ≤ 2500) */
            int k = scanner.nextInt();

            int[][] farm = new int[m][n];
            for (int j = 0; j < k; j++) {
                /* 배추의 위치 X(0 ≤ X < M) */
                int x = scanner.nextInt();
                /* 배추의 위치 Y(0 ≤ Y < N) */
                int y = scanner.nextInt();
                farm[x][y] = 1;
            }

            // 모든 배추밭을 탐색하며 배추가 심어져 있는 경우, 해당 배추와 연결된 배추를 모두 제거하고 카운트 증가
            int answer = 0;
            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    if (farm[x][y] == 1) {
                        removeConnectedFarms(farm, x, y);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }

    private void removeConnectedFarms(int[][] field, int x, int y) {
        // 범위를 벗어나거나 배추가 없는 경우 패스
        if (x < 0 || x >= field.length || y < 0 || y >= field[0].length || field[x][y] == 0) {
            return;
        }

        // 배추를 제거
        field[x][y] = 0;

        // 연결된 밭을 재귀 탐색
        removeConnectedFarms(field, x - 1, y);
        removeConnectedFarms(field, x + 1, y);
        removeConnectedFarms(field, x, y - 1);
        removeConnectedFarms(field, x, y + 1);
    }
}
