package kim.present.solve.programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/250136?language=java">
 * 프로그래머스 250136 - [PCCP 기출문제] 2번 / 석유 시추
 * </a>
 */
class Solution250136 {
    /**
     * @param land 석유가 묻힌 땅과 석유 덩어리를 나타내는 2차원 정수 배열
     *             1 ≤ land 의 길이 = 땅의 세로길이 = n ≤ 500
     *             1 ≤ land[i]의 길이 = 땅의 가로길이 = m ≤ 500
     *             land[i][j]는 i+1행 j+1열 땅의 정보를 나타냅니다.
     *             land[i][j]는 0 또는 1입니다.
     *             land[i][j]가 0이면 빈 땅을, 1이면 석유가 있는 땅을 의미합니다.
     * @return 시추관 하나를 설치해 뽑을 수 있는 가장 많은 석유량
     */
    public int solution(int[][] land) {
        int n = land.length; // n : 땅의 세로길이
        int m = land[0].length; // m : 땅의 가로길이

        List<Integer> oils = new ArrayList<>(); // 석유 덩어리의 크기를 저장하는 리스트
        for (int x = 0; x < m; ++x) {
            for (int y = 0; y < n; ++y) {
                if (land[y][x] != 1) continue; // 빈 땅이거나 이미 석유 덩어리로 변경된 경우 패스

                int value = -oils.size() - 1; // 새로운 석유 덩어리의 인덱스를 음수로 저장
                // 연결된 석유 덩어리를 모두 찾아 변경하고, 변경된 땅의 수(석유 덩어리의 크기)를 저장
                oils.add(replaceConnectedOil(land, x, y, value));
            }
        }

        int max = 0;
        for (int x = 0; x < m; ++x) {
            int amount = 0;
            for (int y = 0; y < n; ++y) {
                int value = land[y][x];
                if (value == 0) continue; // 빈 땅인 경우 패스

                int oilIndex = -value - 1; // 음수로 저장된 석유 덩어리의 인덱스를 양수로 변환
                if (oilIndex < oils.size()) { // 석유 덩어리의 인덱스가 유효한 경우
                    amount += oils.get(oilIndex); // 석유 덩어리의 크기를 더하고
                    for (int y2 = y + 1; y2 < n; ++y2) {
                        if (land[y2][x] == value) land[y2][x] = 0; // 같은 X의 연결된 석유 덩어리를 모두 빈 땅으로 변경
                    }
                }
            }
            if (amount > max) max = amount; // 최대값 갱신
        }

        return max; // 최대값 반환
    }

    /**
     * 연결된 석유가 있는 땅을 모두 주어진 value 값으로 변경
     *
     * @param land   땅
     * @param startX 시작 x 좌표
     * @param startY 시작 y 좌표
     * @param value  변경할 값
     * @return 변경된 개수
     */
    private int replaceConnectedOil(int[][] land, int startX, int startY, int value) {
        int count = 0;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{startX, startY});

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int x = current[0];
            int y = current[1];

            // 범위를 벗어나거나 빈 땅 또는 이미 변경된 땅인 경우 건너뜀
            if (x < 0 || x >= land[0].length || y < 0 || y >= land.length || land[y][x] != 1) {
                continue;
            }

            // 현재 땅을 변경하고 개수 증가
            land[y][x] = value;
            count++;

            // 인접한 땅을 스택에 추가
            for (int i = -1; i < 2; i += 2) {
                stack.push(new int[]{x + i, y});
                stack.push(new int[]{x, y + i});
            }
        }

        return count;
    }
}
