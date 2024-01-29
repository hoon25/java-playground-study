public class UserInputGenerator {
    private String userInput;

    private UserInputGenerator(String userInput) {
        this.userInput = userInput;
    }

    public static UserInputGenerator from() {
        return new UserInputGenerator(InputView.getInput());
    }

    public String getUserInput() {
        return userInput;
    }
}
