package kim.present.solve.programmers.level0;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/181846">
 * 프로그래머스 181846 - 두 수의 합
 * </a>
 */
public class Solution181846 {
    public String solution(String a, String b) {
        int len = Math.max(a.length(), b.length()) + 1;
        int[] arr = new int[len];
        for (int i = 0; i < len - 1; i++) {
            int aDigit = i < a.length() ? a.charAt(a.length() - 1 - i) - '0' : 0;
            int bDigit = i < b.length() ? b.charAt(b.length() - 1 - i) - '0' : 0;
            arr[len - 1 - i] = aDigit + bDigit;
        }

        for (int i = len - 1; i > 0; i--) {
            arr[i - 1] += arr[i] / 10;
            arr[i] %= 10;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (i == 0 && arr[i] == 0) {
                continue;
            }
            sb.append(arr[i]);
        }

        return sb.toString();
    }
}