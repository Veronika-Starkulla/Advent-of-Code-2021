package Day04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day04 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("txtInputData/Day04/input.txt"));
        List<String> inputStringList = readInputTxt(bufferedReader);

//        Part 1

        String[] lotteryNum = inputStringList.get(0).split(",");
        List<Integer> lotteryNumList = convertToIntegerList(Arrays.asList(lotteryNum));
        List<int[][]> boards = detectAllBoard(inputStringList);

        for(Integer num : lotteryNumList) {
            markBoards(boards, num);

            boolean done = false;
            for (int[][] board : boards) {
                int sumOfUnmarkedNumbs = sumOfUnmarkedNumbs(board);
                if (isBoardWon(board)) {
                    System.out.println(sumOfUnmarkedNumbs*num);
                    done = true;
                    break;
                }
            }

            if (done) {
                break;
            }
        }

//        Part 2

        boards = detectAllBoard(inputStringList);

        for(Integer num : lotteryNumList) {
            markBoards(boards, num);

            for (int k = boards.size() - 1; k >= 0; k--) {
                if (isBoardWon(boards.get(k))) {
                    System.out.println("# boards: "+boards.size());

                    if (boards.size() == 1) {
                        int sumOfUnmarkedNumbs = sumOfUnmarkedNumbs(boards.get(0));
                        System.out.println(sumOfUnmarkedNumbs * num);
                    }
                    boards.remove(k);
                }
            }
        }
    }

    public static int sumOfUnmarkedNumbs(int [][] board) {
        int sum = 0;
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (board[row][col] != -1) {
                    sum += board[row][col];
                }
            }
        }
        
        return sum;
    }

    public static boolean isBoardWon(int[][] board) {
        boolean won;
//        horizontal
        for (int row = 0; row < 5; row++) {
            won = true;
            for (int col = 0; col < 5; col++) {
                if (board[row][col] != -1) {
                    won = false;
                    break;
                }
            }
            if (won) {
                return true;
            }
        }

//        vertikal
        for (int col = 0; col < 5; col++) {
            won = true;
            for (int row = 0; row < 5; row++) {
                if (board[row][col] != -1) {
                    won = false;
                    break;
                }
            }

            if (won) {
                return true;
            }
        }

        return false;
    }

    public static List<Integer> convertToIntegerList(List<String> stringList) {
        List<Integer> integerList = new ArrayList<>();
        for (String s : stringList) {
            integerList.add(Integer.parseInt(s));
        }

        return integerList;
    }

    public static void markBoards(List<int[][]> boards, int num) {
        for(int[][] board : boards) {
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    if (board[row][col] == num) {
                        board[row][col] = -1;
                    }
                    System.out.print(board[row][col] +" ");
                }
                System.out.println();
            }
        }
    }

    public static List<int[][]> detectAllBoard(List<String> input) {
        List<int[][]> boards = new ArrayList<>();
        int firstLine = 2;
        int currentLine;
        for(int i = 0; i < 5; i++) {
            currentLine = firstLine + i;
            while(currentLine < input.size()) {
                int[][] board;
                if (i == 0) {
                    board = new int[5][5];
                    boards.add(board);
                }else {
                    board = boards.get((currentLine - i - firstLine) / 6);
                }
                String line = input.get(currentLine);

                for (int j = 0; j < 5; j++) {
                    int num = Integer.parseInt(line.substring(j * 3, j * 3 + 2).strip());
                    board[i][j] = num;
                }
                currentLine += 6;
            }
        }

        return boards;
    }

    public static List<String> readInputTxt(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        String line;
        do {
            line = br.readLine();
            if (line != null) {
                lines.add(line);
            }
        } while (line != null);

        return lines;
    }
}
