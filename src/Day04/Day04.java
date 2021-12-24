package Day04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day04 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("txtInputData/Day04/test.txt"));
        List<String> inputStringList = readInputTxt(bufferedReader);

//        Part 1

        String[] lotteryNum = inputStringList.get(0).split(",");
        List<int[][]> boards = detectAllBoard(inputStringList);

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
                System.out.println(line);
                for (int j = 0; j < 5; j++) {
                    int num = Integer.parseInt(line.substring(j * 3, j * 3 + 2).strip());
                    board[i][j] = num;
                    System.out.println(num);

                }
                currentLine += 6;
            }
        }
        System.out.println(boards.size());

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
