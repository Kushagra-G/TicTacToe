package assignment5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class tictest {
    // Static variables for the TicTacToe class, effectively configuration options
    // Use these instead of hard-coding ' ', 'X', and 'O' as symbols for the game
    // In other words, changing one of these variables should change the program
    // to use that new symbol instead without breaking anything
    // Do NOT add additional static variables to the class!
    static char emptySpaceSymbol = ' ';
    static char playerOneSymbol = 'X';
    static char playerTwoSymbol = 'O';

    public static void main(String[] args) {
        // TODO
        // This is where the main menu system of the program will be written.
        // Hint: Since many of the game runner methods take in an array of player names,
        // you'll probably need to collect names here.
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the game of Tic Tac Toe, choose one of the following options from below: ");
        System.out.printf("1: Single Player \n2: Two Player\nD: Display Last Match\nQ: Quit\n");

        String userInput = in.next();

        String[] playerName = {"", "Computer"};;

        ArrayList<char[][]> gameHistory = null;
        int userInput2 = Integer.parseInt(userInput);
        if (userInput2 == 1) {
            System.out.print("Enter Player 1 Name: ");
            String singlePlayerName = in.next();
            playerName[0] = singlePlayerName;
            gameHistory = runOnePlayerGame(playerName);
        }

        else if (userInput2 == 2) {
            System.out.print("Enter Player 1 Name: ");
            String name1 = in.next();
            playerName[0] = name1;
            System.out.print("Enter Player 2 Name: ");
            String name2 = in.next();
            playerName[1] = name2;
            gameHistory = runTwoPlayerGame(playerName);
        }

        else if (userInput == "D") {
            if (gameHistory == null) {
                System.out.println("no game played yet");
            } else {
                runGameHistory(playerName, gameHistory);
            }
        }

        else if (userInput == "Q") {
            System.out.println("Thanks for playing. Hope you had fun!");
        }
        else {
            System.out.println("Enter a valid input!");
        }
    }

    // Given a state, return a String which is the textual representation of the tic-tac-toe board at that state.
    private static String displayGameFromState(char[][] state) {
        // TODO
        // Hint: Make use of the newline character \n to get everything into one String
        // It would be best practice to do this with a loop, but since we hardcode the game to only use 3x3 boards
        // it's fine to do this without one.
        String output = (" " + state[0][0] + " | " + state[0][1] + " | " + state[0][2] + "\n-----------\n" +
                " " + state[1][0] + " | " + state[1][1] + " | " + state[1][2] + "\n-----------\n" +
                " " + state[2][0] + " | " + state[2][1] + " | " + state[2][2] + "\n");
        return output;
    }

    // Returns the state of a game that has just started.
    // This method is implemented for you. You can use it as an example of how to utilize the static class variables.
    // As you can see, you can use it just like any other variable, since it is instantiated and given a value already.
    private static char[][] getInitialGameState() {
        return new char[][]{{emptySpaceSymbol, emptySpaceSymbol, emptySpaceSymbol},
                {emptySpaceSymbol, emptySpaceSymbol, emptySpaceSymbol},
                {emptySpaceSymbol, emptySpaceSymbol, emptySpaceSymbol}};
    }

    // Given the player names, run the two-player game.
    // Return an ArrayList of game states of each turn -- in other words, the gameHistory
    private static ArrayList<char[][]> runTwoPlayerGame(String[] playerNames) {
        // TODO
        // Random Calculation
        System.out.println("Tossing a coin to decide who goes first!!!");
        int randValue = (int) (Math.random() * 10);
        ArrayList<char[][]> gameHistory = new ArrayList<char[][]>();
        String startPlayer;
        String secondPlayer;
        char startPlayerSymbol;
        char secondPlayerSymbol;
        if (randValue >= 5) {
            startPlayer = playerNames[0];
            startPlayerSymbol = playerOneSymbol;
            secondPlayer = playerNames[1];
            secondPlayerSymbol = playerTwoSymbol;
        } else {
            startPlayer = playerNames[1];
            startPlayerSymbol = playerTwoSymbol;
            secondPlayer = playerNames[0];
            secondPlayerSymbol = playerOneSymbol;
        }
        System.out.println(startPlayer + " gets to go first.");
        char[][] currentState = runPlayerMove(startPlayer, playerOneSymbol, getInitialGameState());
//        System.out.print(displayGameFromState(currentState));
        gameHistory.add(currentState);



        for (int i = 0; i < 10; i++) {


            if (i % 2 == 0) {
                gameHistory.add(runPlayerMove(secondPlayer, playerTwoSymbol, gameHistory.get(gameHistory.size() - 1)));
            } else {
                gameHistory.add(runPlayerMove(startPlayer, playerOneSymbol, gameHistory.get(gameHistory.size() - 1)));
            }
        }
        return gameHistory;
    }


    // Given the player names (where player two is "Computer"),
    // Run the one-player game.
    // Return an ArrayList of game states of each turn -- in other words, the gameHistory
    private static ArrayList<char[][]> runOnePlayerGame(String[] playerNames) {
        // TODO

        return null;
    }

    // Repeatedly prompts player for move in current state, returning new state after their valid move is made
    private static char[][] runPlayerMove(String playerName, char playerSymbol, char[][] currentState) {
        Scanner sc = new Scanner(System.in);
        // TODO
        char[][] newState = currentState;
        if(!checkWin(currentState) && !checkDraw(currentState)) {
            System.out.print(displayGameFromState(currentState));
            System.out.println(playerName + "'s turn");
            System.out.print(playerName + " enter row: ");
            int moveRow = sc.nextInt();
            System.out.print(playerName + " enter column: ");
            int moveColumn = sc.nextInt();
            int[] move = {moveRow, moveColumn};
            newState = currentState;

            while (!checkValidMove(move, currentState) || checkValidMove(move, currentState)) {
                if (checkValidMove(move, currentState)) {
                    newState = makeMove(move, playerSymbol, currentState);
                    currentState = newState;
                    return newState;
                } else {
                    System.out.println("Not a valid move, try again");
                    return runPlayerMove(playerName, playerSymbol, currentState);
                }
            }

        }

        else {
            if(checkWin(currentState)) {
                System.out.println("game won by");

            }
            else if(checkDraw(currentState)){
                System.out.println("Game draw");
            }
        }
        return newState;
    }

    // Repeatedly prompts player for move. Returns [row, column] of their desired move such that row & column are on
    // the 3x3 board, but does not check for availability of that space.
    private static int[] getInBoundsPlayerMove(String playerName) {
        Scanner sc = new Scanner(System.in);
        // TODO
        System.out.println(playerName + "'s turn");
        System.out.print(playerName + " enter row: ");
        int moveRow = sc.nextInt();
        System.out.print(playerName + " enter column: ");
        int moveColumn = sc.nextInt();
        int[] move = {moveRow, moveColumn};
        return move;
    }

    // Given a [row, col] move, return true if a space is unclaimed.
    // Doesn't need to check whether move is within bounds of the board.
    private static boolean checkValidMove(int[] move, char[][] state) {
        // TODO
        if (state[move[0]][move[1]] != emptySpaceSymbol) {
            return false;
        } else {
            return true;
        }
    }

    // Given a [row, col] move, the symbol to add, and a game state,
    // Return a NEW array (do NOT modify the argument currentState) with the new game state
    private static char[][] makeMove(int[] move, char symbol, char[][] currentState) {
        // TODO:
        // Hint: Make use of Arrays.copyOf() somehow to copy a 1D array easily
        // You may need to use it multiple times for a 1D array
        int[] newMove = Arrays.copyOf(move, symbol);
        char[][] newState = new char[currentState.length][currentState[0].length];
        for (int i = 0; i < currentState.length; i++) {
            for (int j = 0; j < currentState[i].length; j++) {
                newState[i][j] = currentState[i][j];
            }
        }
        newState[newMove[0]][newMove[1]] = symbol;
        return newState;
    }

    // Given a state, return true if some player has won in that state
    private static boolean checkWin(char[][] state) {
        // TODO
        // Hint: no need to check if player one has won and if player two has won in separate steps,
        // you can just check if the same symbol occurs three times in any row, col, or diagonal (except empty space symbol)
        // But either implementation is valid: do whatever makes most sense to you.

        boolean win = false;
        boolean empty = true;


        for(int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (state[i][j] != emptySpaceSymbol) {
                    empty = false;
                    break;
                }
            }
        }



        if (state[0][0] == playerOneSymbol && state[1][1] == playerOneSymbol && state[2][2] == playerOneSymbol
                || state[0][2] == playerOneSymbol && state[1][1] == playerOneSymbol && state[2][0] == playerOneSymbol) {
            win = true;
        }

        else if (state[0][0] == playerTwoSymbol && state[1][1] == playerTwoSymbol && state[2][2] == playerTwoSymbol
                || state[0][2] == playerTwoSymbol && state[1][1] == playerTwoSymbol && state[2][0] == playerTwoSymbol) {
            win = true;
        }
        //ver

        for (int i = 0; i < 2; i++) {
            if (state[0][i] == playerOneSymbol && state[1][i] == playerOneSymbol && state[2][i] == playerOneSymbol
                    || state[0][i] == playerTwoSymbol && state[1][i] == playerTwoSymbol && state[2][i] == playerTwoSymbol) {
                win = true;
                break;
            }
        }

        //hor
        for (int i = 0; i < 2; i++) {
            if ((state[i][0] == playerOneSymbol && state[i][1] == playerOneSymbol && state[i][2] == playerOneSymbol)
                    || (state[i][0] == playerTwoSymbol && state[i][1] == playerTwoSymbol && state[i][2] == playerTwoSymbol)) {
                win = true;
                break;

            }
        }

//        }

        return win;
    }

    // Given a state, simply checks whether all spaces are occupied. Does not care or check if a player has won.
    private static boolean checkDraw(char[][] state) {

        boolean tieconditon = false;
        boolean filled = false;


        for(int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (state[i][j] != emptySpaceSymbol) {
                    filled = false;
                }
            }
        }

        if (!checkWin(state) && filled){

            tieconditon  = true;

        }
        return tieconditon;
    }

//     Given a game state, return a new game state with move from the AI
//     It follows the algorithm in the PDF to ensure a tie (or win if possible)
    private static char[][] getCPUMove(char[][] gameState) {
        // TODO


        // Hint: you can call makeMove() and not end up returning the result, in order to "test" a move
        // and see what would happen. This is one reason why makeMove() does not modify the state argument

        // Determine all available spaces
        ArrayList<int[]> emptyPositions = new ArrayList<>();


        for (int i = 0; i < gameState.length; i++) {
            for (int j = 0; j < gameState[0].length; j++) {
                if (gameState[i][j] == emptySpaceSymbol) {
                    int[] position = {i, j};
                    emptyPositions.add(position);
                }
            }
        }
        // If there is a winning move available, make that move
        for (int[] position : emptyPositions) {
            char[][] testState = makeMove(position,playerTwoSymbol, gameState);
            if (checkWin(gameState)) {
                return testState;
            }
        }

        // If not, check if opponent has a winning move, and if so, make a move there
        for (int[] position : emptyPositions) {
            char[][] testState = makeMove(position, playerOneSymbol,gameState );
            if (checkWin(gameState)) {
                return makeMove( position, playerTwoSymbol,gameState);
            }
        }

        // If not, move on center space if possible
        int[] center = {1, 1};
        if (emptyPositions.contains(center)) {
            return makeMove(center, playerTwoSymbol, gameState );
        }

        // If not, move on corner spaces if possible
        int[][] corners = {{0, 0}, {0, 2}, {2, 0}, {2, 2}};
        for (int[] corner : corners) {
            if (emptyPositions.contains(corner)) {
                return makeMove( corner, playerTwoSymbol, gameState);
            }
        }

        // Otherwise, move in any available spot
        return makeMove( emptyPositions.get(0), playerTwoSymbol, gameState);
    }

    // Given a game state, return an ArrayList of [row, column] positions that are unclaimed on the board
    private static ArrayList<int[]> getValidMoves(char[][] gameState) {

        ArrayList<int[]> emptyPositions = new ArrayList<>();


        for (int i = 0; i < gameState.length; i++) {
            for (int j = 0; j < gameState[0].length; j++) {
                if (gameState[i][j] == emptySpaceSymbol) { // check if the current position is empty
                    int[] position = {i, j}; // create a new array with the current row and column
                    emptyPositions.add(position); // add the position to the list of empty positions
                }
            }
        }

        return emptyPositions;
    }

    // Given player names and the game history, display the past game as in the PDF sample code output
    private static void runGameHistory(String[] playerNames, ArrayList<char[][]> gameHistory) {
        // TODO
        // We have the names of the players in the format [playerOneName, playerTwoName]
        // Player one always gets 'X' while player two always gets 'O'
        // However, we do not know yet which player went first, but we'll need to know...
        // Hint for the above: which symbol appears after one turn is taken?

        // Hint: iterate over gameHistory using a loop

//
      for (int i = 0; i < gameHistory.size(); i++) {
            System.out.print(displayGameFromState(gameHistory.get(i)));
            int playerIndex = (i % 2);
            System.out.printf("Player %s (%s) made this move.\n\n", (playerIndex+1), playerNames[playerIndex]);
        }
    }


    }