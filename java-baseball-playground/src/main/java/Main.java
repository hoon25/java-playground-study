public class Main {
    public static void main(String[] args) {
        while(true) {
            BaseBallGame baseBallGame = BaseBallGame.from();
            baseBallGame.play();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int checker = InputView.getChecker();
            if (checker == 2) break;
        }

    }
}
