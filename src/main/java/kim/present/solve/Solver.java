package kim.present.solve;

public class Solver {

    private static int assertionNumber = 0;

    public static <T> void assertion(T expected, T actual) {
        System.out.print("[" + ++assertionNumber + "] ");
        if (expected.equals(actual)) {
            System.out.println("테스트를 통과하였습니다.");
        } else {
            System.out.println("실행한 결괏값 " + actual + "이 기댓값 " + expected + "과 다릅니다.");
        }
    }
}