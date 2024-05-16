package kim.present.solve.backjoon;

import java.util.Scanner;

/**
 * <a href="https://www.acmicpc.net/problem/1107">
 * 백준 1107 - 리모컨
 * </a>
 */
public class Main1107 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 이동하려는 채널 (0 ≤ N ≤ 500,000)
        int m = scanner.nextInt(); // 고장난 버튼의 개수 (0 ≤ M ≤ 10)
        boolean[] buttons = new boolean[10]; // 0 ~ 9 버튼의 고장 여부
        for (int i = 0; i < m; i++) {
            buttons[scanner.nextInt()] = true; // 고장난 버튼을 true 로 설정
        }

        int answer = Math.abs(n - 100); // 초기값: 초기 채널(100)과 이동하려는 채널(n)의 차이 (0 ~ 499,900)
        int channelLimit = n + answer; // 대상 채널 + 초기값 (100 ~ 999,900)

        for (int i = 0; i < channelLimit; i++) {
            int moveCount = Math.abs(n - i); // 채널 이동 수 : 현재 채널(i)에서 이동하려는 채널(n)의 차이
            if (answer <= moveCount) continue; // 채널 이동 수가 최소값보다 크거나 같다면 넘어감
            if (buttons[i % 10]) continue; // 현재 채널(i)의 일의 자리 버튼이 고장났다면 넘어감

            if (i < 10) { // 현재 채널(i)이 0 ~ 9 버튼만으로 이동이 가능하고
                if (!buttons[i]) answer = moveCount + 1; // 고장난 버튼이 포함되어 있지 않다면 최소값 갱신
                continue; // 다음 채널 순회로 넘어감
            }

            int pushCount = calcPushCount(i, buttons); // 번호 입력 수
            if (pushCount == 0) continue; // 고장난 버튼이 포함되어 있으면 넘어감

            int totalCount = pushCount + moveCount; // 총 입력 수 : 번호 입력 수 + 채널 이동 수
            if (answer > totalCount) { // 최소값 갱신
                answer = totalCount;
            }
        }
        System.out.println(answer);
    }

    /**
     * 채널을 이동하기 위해 눌러야 하는 버튼 수를 계산
     *
     * @param channel 이동하려는 채널
     * @param buttons 고장난 버튼
     * @return 눌러야 하는 버튼 수, 고장난 버튼이 포함되어 있으면 0을 반환
     */
    private static int calcPushCount(int channel, boolean[] buttons) {
        if (channel < 10 && !buttons[channel]) {
            return 1;
        }

        int length;
        for (length = 0; channel > 0; length++) {
            if (buttons[channel % 10]) {
                return 0;
            }
            channel /= 10;
        }
        return length;
    }
}
