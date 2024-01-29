import java.util.HashSet;
import java.util.Random;

public class AnswerGenerator {
    private final String answer;
    private final HashSet<Integer> answerSet;

    private AnswerGenerator(String answer, HashSet<Integer> answerSet) {
        this.answer = answer;
        this.answerSet = answerSet;
    }

    public static AnswerGenerator from() {
        HashSet<Integer> answerSet = AnswerGenerator.generateRandomSet();
        String randomNumber = AnswerGenerator.getRandomNumber(answerSet);
        return new AnswerGenerator(randomNumber, answerSet);
    }

    private static String getRandomNumber(HashSet<Integer> set) {
        String randomNumber = "";

        for (int num : set) {
            randomNumber += String.valueOf(num);
        }
        return randomNumber;
    }

    private static HashSet<Integer> generateRandomSet() {
        Random random = new Random();
        HashSet<Integer> set = new HashSet<>();

        while (set.size() < 3) {
            set.add(random.nextInt(9) + 1);
        }
        return set;
    }

    public String getAnswer() {
        return answer;
    }

    public HashSet<Integer> getAnswerSet() {
        return answerSet;
    }
}
