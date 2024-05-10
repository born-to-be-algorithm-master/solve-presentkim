package kim.present.solve.backjoon;

import java.util.Scanner;

/**
 * <a href="https://www.acmicpc.net/problem/1012">
 * 백준 1012 - 유기농 배추
 * </a>
 */
public class Main1012 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt(); // T : 테스트 케이스의 수
        while (t-- > 0) { // 테스트 케이스의 수만큼 반복
            int m = scanner.nextInt(); // 배추밭의 가로길이 M(1 ≤ M ≤ 50)
            int n = scanner.nextInt(); // 배추밭의 세로길이 N(1 ≤ N ≤ 50)
            int k = scanner.nextInt(); // 배추가 심어져 있는 위치의 개수 K(1 ≤ K ≤ 2500)

            // 배추밭을 스캔하여 배추 위치를 저장
            boolean[][] farm = scanFarm(scanner, m, n, k);

            // 모든 배추밭을 탐색하며 배추가 심어져 있는 경우, 해당 배추와 연결된 배추를 모두 제거하고 카운트 증가
            int answer = 0;
            for (int x = 0; x < m; ++x) {
                for (int y = 0; y < n; ++y) {
                    if (farm[x][y]) {
                        removeConnectedFarms(farm, x, y);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }

    /**
     * 배추밭을 스캔하여 배추 위치를 저장
     *
     * @param scanner 입력 스캐너
     * @param m       배추밭의 가로길이
     * @param n       배추밭의 세로길이
     * @param k       배추가 심어져 있는 위치의 개수
     * @return 배추밭 정보, 배추가 심어져 있는 위치는 true, 아닌 경우 false
     */
    private static boolean[][] scanFarm(Scanner scanner, int m, int n, int k) {
        // 배추밭 초기화
        boolean[][] farm = new boolean[m][n];

        // 배추가 심어져 있는 위치의 개수만큼 반복
        while (k-- > 0) {
            int x = scanner.nextInt(); // 배추의 가로 위치
            int y = scanner.nextInt(); // 배추의 세로 위치
            farm[x][y] = true; // 배추 위치 저장
        }
        return farm; // 배추밭 반환
    }

    /**
     * 주어진 위치에서 연결된 배추를 모두 제거
     *
     * @param farms 배추밭
     * @param x     x 좌표
     * @param y     y 좌표
     */
    private static void removeConnectedFarms(boolean[][] farms, int x, int y) {
        // 범위를 벗어나거나 배추가 없는 경우 패스
        if (x < 0 || x >= farms.length || y < 0 || y >= farms[0].length || !farms[x][y]) {
            return;
        }

        // 배추를 제거
        farms[x][y] = false;

        // 연결된 밭을 재귀 탐색
        removeConnectedFarms(farms, x - 1, y);
        removeConnectedFarms(farms, x + 1, y);
        removeConnectedFarms(farms, x, y - 1);
        removeConnectedFarms(farms, x, y + 1);
    }
}
