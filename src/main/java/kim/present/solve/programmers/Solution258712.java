package kim.present.solve.programmers;

import java.util.HashMap;
import java.util.Map;

import static kim.present.solve.Solver.assertion;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/258712?language=java">
 * 프러그래머스 258712 - 가장 많이 받은 선물
 * </a>
 */
public class Solution258712 {
    public int solution(String[] friends, String[] gifts) {
        // friends 로 관계 데이터 생성
        Map<String, Integer> baseRelations = new HashMap<>();
        for (String friend : friends) {
            baseRelations.put(friend, 0);
        }

        Map<String, Friend> relations = new HashMap<>();
        for (String friend : friends) {
            Friend friendData = new Friend();
            friendData.name = friend;
            friendData.point = 0;
            friendData.gift = 0;
            friendData.relations = new HashMap<>(baseRelations);
            relations.put(friend, friendData);
        }

        // 기존 선물 기록 처리
        for (String gift : gifts) {
            String[] split = gift.split(" ");
            String a = split[0];
            String b = split[1];

            //선물 지수 변화
            relations.get(a).point++;
            relations.get(b).point--;

            //선물을 준 횟수를 받은 친구의 관계 정보에 추가
            relations.get(a).relations.put(b, relations.get(a).relations.get(b) + 1);
        }

        // 다음달 선물 처리
        int max = 0;
        for (int i = 0; i < friends.length; ++i) {
            Friend a = relations.get(friends[i]);
            for (int j = i + 1; j < friends.length; ++j) {
                Friend b = relations.get(friends[j]);

                if (a.relations.get(b.name).equals(b.relations.get(a.name))) {
                    if (a.point == b.point) {
                        continue;
                    }

                    if (a.point > b.point) {
                        a.gift++;
                    } else {
                        b.gift++;
                    }
                } else if (a.relations.get(b.name) > b.relations.get(a.name)) {
                    a.gift++;
                } else {
                    b.gift++;
                }

                if (max < a.gift || max < b.gift) {
                    max = Math.max(a.gift, b.gift);
                }
            }
        }

        return max;
    }

    private static class Friend {
        public String name;
        public int point;
        public int gift;
        public Map<String, Integer> relations;
    }

    public static void main(String[] args) {
        Solution258712 solution = new Solution258712();

        assertion(solution.solution(
                new String[]{"muzi", "ryan", "frodo", "neo"},
                new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"}
        ), 2);
        assertion(solution.solution(
                new String[]{"joy", "brad", "alessandro", "conan", "david"},
                new String[]{"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"}
        ), 4);
        assertion(solution.solution(
                new String[]{"a", "b", "c"},
                new String[]{"a b", "b a", "c a", "a c", "a c", "c a"}
        ), 0);
    }
}
