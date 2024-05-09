package kim.present.solve.backjoon;

import java.util.Scanner;

/**
 * <a href="https://www.acmicpc.net/problem/20529">
 * 백준 20529 - 가장 가까운 세 사람의 심리적 거리
 * </a>
 */
public class Main20529 {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // T : 테스트 케이스의 수
        while (t-- > 0) {
            int n = scanner.nextInt(); // N : 학생의 수 (MBTI 문자열의 수)
            final byte[] flags = scanMbtiFlags(scanner, n); // 변환된 MBTI 플래그 목록

            if (flags.length == 0) { // 플래그 목록의 길이가 0이면
                System.out.println(0); // 0을 출력하고 패스
                continue;
            }

            int min = calcMinDistance(n, flags);
            System.out.println(min);
        }
    }

    private static int calcMinDistance(int n, byte[] flags) {
        int min = 8; // 최대 값인 8로 초기화
        for (int i = 0; i < n - 2; ++i) {
            for (int j = i + 1; j < n - 1; ++j) {
                for (int k = j + 1; k < n; ++k) {
                    // MBTI 3개씩 묶어 가져와 비트 차이를 합산
                    int distance = bitDiff(flags[i], flags[j]) + bitDiff(flags[j], flags[k]) + bitDiff(flags[k], flags[i]);
                    if (min > distance) { // 비트 차이 합이 최소값보다 작으면 최소값 갱신
                        min = distance;
                    }
                }
            }
        }
        return min;
    }

    private static byte[] scanMbtiFlags(Scanner scanner, int mbtiCount) {
        byte[] flags = new byte[mbtiCount]; // MBTI 플래그 목록
        int[] counts = new int[16]; // MBTI 플래그의 개수 목록 (16가지)

        for (int i = 0; i < mbtiCount; ++i) {
            byte flag = mbtiToFlag(scanner.next()); // MBTI 문자열을 0~15의 4bit 정수 플래그로 변환

            if (++counts[flag] >= 3) { // 같은 MBTI 수가 3이 넘어가면
                if (scanner.hasNext()) { // 남은 MBTI 문자열을 버퍼에서 제거하고
                    scanner.nextLine();
                }
                return new byte[]{}; // 빈 배열을 반환 (무조건 거리가 최소 거리가 0)
            }

            flags[i] = flag; // MBTI 플래그 목록에 추가
        }

        return flags;
    }

    // MBTI 문자열을 4비트 플래그로 변환
    private static byte mbtiToFlag(String mbti) {
        byte flag = 0;
        for (int j = 0; j < 4; ++j) {
            flag |= (byte) (mbti.charAt(j) == "ISTP".charAt(j) ? 1 << j : 0);
        }
        return flag;
    }

    // 서로 다른 비트의 개수를 반환
    private static int bitDiff(byte a, byte b) {
        byte xor = (byte) (a ^ b);
        int diff = 0;
        for (int i = 0; i < 8; ++i) {
            diff += (xor >> i) & 1;
        }
        return diff;
    }
}