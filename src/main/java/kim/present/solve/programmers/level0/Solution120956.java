package kim.present.solve.programmers.level0;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/120956">
 * 프로그래머스 120956 - 옹알이 (1)
 * </a>
 */
public class Solution120956 {
    /**
     * @param babbling 옹알이 문자열 배열
     *                 1 ≤ babbling.length≤ 100
     *                 1 ≤ babbling[i].length() ≤ 100
     *                 각 문자열에서 "aya", "ye", "woo", "ma"는 각각 최대 한 번씩만 등장합니다
     *                 모든 문자열은 소문자입니다
     * @return 발음할 수 있는 단어의 개수
     */
    public int solution(String[] babbling) {
        final String[] patterns = new String[]{"aya", "ye", "woo", "ma"};

        int count = 0;
        for (String word : babbling) {
            int length = word.length();
            for (String pattern : patterns) {
                length -= (word.contains(pattern) ? pattern.length() : 0);
            }
            if (length == 0) {
                count++;
            }
        }
        return count;
    }
}
