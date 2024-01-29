import java.util.HashSet;

public class BaseBallGame {
    private String userInput;
    private AnswerGenerator answerGenerator;


    private BaseBallGame(String userInput, AnswerGenerator answerGenerator) {
        System.out.println(answerGenerator.getAnswer());
        this.userInput = userInput;
        this.answerGenerator = answerGenerator;
    }

    public static BaseBallGame from() {
        UserInputGenerator userInputGenerator = UserInputGenerator.from();
        AnswerGenerator answerGenerator = AnswerGenerator.from();
        return new BaseBallGame(userInputGenerator.getUserInput(), answerGenerator);
    }

    public void play() {
        while(true) {
            int strikes = this.checkStrikes();
            int ball = this.countBalls(strikes);
            if (strikes == 0 && ball == 0) {
                System.out.println("낫싱");
            }

            if (ball == 0) {
                System.out.println(String.format("%s스트라이크", strikes));
            }

            if (strikes == 0) {
                System.out.println(String.format("%s볼", ball));
            }

            if (strikes != 0 && ball != 0) {
                System.out.println(String.format("%s스트라이크 %s볼", strikes, ball));
            }

            if (strikes == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
            userInput = InputView.getInput();
        }
    }

    private int checkStrikes() {
        int strikes = 0;
        String answer = answerGenerator.getAnswer();
        for (int i = 0; i < answer.length(); i++) {
            strikes = this.countStrikes(strikes, userInput.charAt(i), answer.charAt(i));
        }
        return strikes;
    }

    private int countStrikes(int strikes, char userAnswer, char answer) {
        if (userAnswer == answer) strikes++;
        return strikes;
    }

    private int countBalls(int strikes) {
        HashSet<Integer> set = answerGenerator.getAnswerSet();
        int ball = 0;
        for (int answerChar: set) {
            if(userInput.contains(String.valueOf(answerChar))){
                ball++;
            }
        }
        ball -= strikes;
        return ball;
    }
}
