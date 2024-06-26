package kim.present.solve.backjoon;

import java.util.Scanner;

/**
 * <a href="https://www.acmicpc.net/problem/20529">
 * 백준 20529 - 가장 가까운 세 사람의 심리적 거리
 * </a>
 */
public class Main20529 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt(); // T : 테스트 케이스의 수
        while (t-- > 0) { // 테스트 케이스의 수만큼 반복
            int n = scanner.nextInt(); // N : 학생의 수 (MBTI 문자열의 수)
            byte[] flags = scanMbtiFlags(scanner, n); // 변환된 MBTI 플래그 배열

            if (flags.length == 0) { // 플래그 배열의 길이가 0이면
                System.out.println(0); // 0을 출력하고 패스
                continue;
            }

            // 가장 가까운 세 사람의 심리적 거리를 계산하여 출력
            System.out.println(calcMinDistance(flags));
        }
    }

    /**
     * MBTI 문자열을 스캔하여 4비트 플래그로 변환한 배열을 반환
     *
     * @param scanner   입력 스캐너
     * @param mbtiCount MBTI 문자열의 개수
     * @return MBTI 플래그 배열, 3개 이상인 플래그가 있으면 빈 배열
     */
    private static byte[] scanMbtiFlags(Scanner scanner, int mbtiCount) {
        byte[] flags = new byte[mbtiCount]; // MBTI 플래그 배열
        int[] counts = new int[16]; // MBTI 플래그의 개수 배열 (16가지)

        for (int i = 0; i < mbtiCount; ++i) {
            byte flag = mbtiToFlag(scanner.next()); // MBTI 문자열을 4bit 정수 플래그로 변환

            if (++counts[flag] >= 3) { // 같은 MBTI 수가 3이 넘어가면
                if (scanner.hasNext()) { // 남은 MBTI 문자열을 버퍼에서 제거하고
                    scanner.nextLine();
                }
                return new byte[]{}; // 빈 배열을 반환 (무조건 거리가 최소 거리가 0)
            }

            flags[i] = flag; // MBTI 플래그 배열에 추가
        }

        return flags;
    }

    /**
     * MBTI 문자열을 4비트 플래그로 변환
     *
     * @param mbti MBTI 문자열
     * @return 4비트 플래그
     */
    private static byte mbtiToFlag(String mbti) {
        byte flag = 0;
        for (int i = 0; i < 4; ++i) {
            flag += (byte) (mbti.charAt(i) == "ISTP".charAt(i) ? 1 << i : 0);
        }
        return flag;
    }

    /**
     * 세 개의 정수 간의 비트 차이의 합을 계산
     *
     * @param a 정수 a
     * @param b 정수 b
     * @param c 정수 c
     * @return 세 개의 정수 간의 비트 차이의 합
     */
    private static int sumOfBitDiff(int a, int b, int c) {
        return Integer.bitCount(a ^ b) + Integer.bitCount(a ^ c) + Integer.bitCount(b ^ c);
    }

    /**
     * MBTI 플래그 배열에서 가장 가까운 세 사람의 심리적 거리를 계산
     *
     * @param flags MBTI 플래그 배열
     */
    private static int calcMinDistance(byte[] flags) {
        int length = flags.length; // MBTI 플래그 배열의 길이
        int min = 8; // 최대 값인 8로 초기화
        for (int i = 0; i < length; ++i) {
            for (int j = i + 1; j < length; ++j) {
                for (int k = j + 1; k < length; ++k) {
                    // MBTI 3개씩 묶어 가져와 비트 차이를 합산
                    int distance = sumOfBitDiff(flags[i], flags[j], flags[k]);
                    if (min > distance) { // 최소값 갱신
                        min = distance;
                    }

                    if (min == 0) { // 최소값이 0이면 더 이상 계산할 필요 없음
                        return 0;
                    }
                }
            }
        }
        return min;
    }
}