import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int chosen;
        char firstPlayer = 'X';
        char secondPlayer = 'O';
        char[] boardGame = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for (int i = 0; i <= boardGame.length; i++) {
            if (i % 2 != 0) {
                System.out.println("Player 1 choose place");
                printBoard(boardGame);
                chosen = scanner.nextInt();
                chosen = getPositionFromUser(boardGame, chosen);

                if (placeSymbolOnBoard(boardGame, chosen, firstPlayer)) {
                    printBoard(boardGame);
                    System.out.println("Game Over");
                    break;
                }

                if (i == boardGame.length) {
                    System.out.println("No Winner");
                    break;
                }

                System.out.println("Player 2 choose place");
                printBoard(boardGame);
                chosen = scanner.nextInt();
                chosen = getPositionFromUser(boardGame, chosen);
                if (placeSymbolOnBoard(boardGame, chosen, secondPlayer)) {
                    printBoard(boardGame);
                    System.out.println("Game Over");
                    break;
                }
            }
        }
    }

    public static void printBoard(char[] boardGame) { //אחרון
        System.out.print(boardGame[0] + "\t");
        System.out.print(boardGame[1] + "\t");
        System.out.println(boardGame[2] + "\t");
        System.out.print(boardGame[3] + "\t");
        System.out.print(boardGame[4] + "\t");
        System.out.println(boardGame[5] + "\t");
        System.out.print(boardGame[6] + "\t");
        System.out.print(boardGame[7] + "\t");
        System.out.println(boardGame[8] + "\t");
    }

    public static boolean isAvailable(char[] boardGame, int place) {//2 בתוך 1 כבר
        return !(boardGame[place - 1] == 'X' | boardGame[place - 1] == 'O');
    }

    public static int getPositionFromUser(char[] boardGame, int userChoice) {//1
        Scanner scanner = new Scanner(System.in);
        while (userChoice < 1 || userChoice > 9) {
            System.out.println("Wrong user choice please try again");
            userChoice = scanner.nextInt();
        }

        while (!isAvailable(boardGame, userChoice)) {
            System.out.println("Busy place please try other place");
            userChoice = scanner.nextInt();
        }
        return userChoice;
    }


    public static char checkWinner(char[] boardGame) {//4 בתוך 3
        char winnerIcon = '-';
        if ((boardGame[0] == boardGame[1] && boardGame[1] == boardGame[2]) ||
                (boardGame[0] == boardGame[3] && boardGame[3] == boardGame[6]) ||
                (boardGame[0] == boardGame[4] && boardGame[4] == boardGame[8])) {
            winnerIcon = boardGame[0];
            return winnerIcon;
        } else if (boardGame[1] == boardGame[4] && boardGame[4] == boardGame[7]) {
            winnerIcon = boardGame[1];
            return winnerIcon;
        } else if ((boardGame[2] == boardGame[5] && boardGame[5] == boardGame[8] ||
                (boardGame[2] == boardGame[4] && boardGame[4] == boardGame[6]))) {
            winnerIcon = boardGame[2];
            return winnerIcon;
        } else if (boardGame[3] == boardGame[4] && boardGame[4] == boardGame[5]) {
            winnerIcon = boardGame[3];
            return winnerIcon;

        } else if (boardGame[6] == boardGame[7] && boardGame[7] == boardGame[8]) {
            winnerIcon = boardGame[6];
            return winnerIcon;
        } else return winnerIcon;
    }

    public static boolean placeSymbolOnBoard(char[] boardGame, int userChoice, char iconPlayer) { //3
        boardGame[userChoice - 1] = iconPlayer;
        System.out.println(boardGame);
        iconPlayer = checkWinner(boardGame);
        if (iconPlayer == 'X') {
            System.out.println("The Winner is Player 1");
            return true;
        }

        if (iconPlayer == 'O') {
            System.out.println("The Winner is Player 2");
            return true;
        } else return false;
    }
}