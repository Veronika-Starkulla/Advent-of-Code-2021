package Day02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day02 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("txtInputData/Day02/input.txt"));
        List<String> inputStringList = readInputTxt(bufferedReader);

//        Part 1
        int position = countPosition(inputStringList);
        
//        Part 2
        int position2 = countPosition2(inputStringList);

        System.out.println(position);
        System.out.println(position2);
    }

    public static int countPosition2(List<String> input) {
        int horizontal = 0;
        int depth = 0;
        int aim = 0;

        for (String entry : input) {

            String[] entryArr = entry.split(" ");
            if (entryArr[0].equals("forward")) {
                horizontal += Integer.parseInt(entryArr[1]);
                depth += aim * Integer.parseInt(entryArr[1]);
            }else if (entryArr[0].equals("down")) {
                aim += Integer.parseInt(entryArr[1]);
            }else if (entryArr[0].equals("up")) {
                aim -= Integer.parseInt(entryArr[1]);
            }
        }

        return horizontal * depth;
    }

    public static int countPosition(List<String> input) {
        int horizontal = 0;
        int depth = 0;

        for (String entry : input) {

            String[] entryArr = entry.split(" ");
            if (entryArr[0].equals("forward")) {
                horizontal += Integer.parseInt(entryArr[1]);
            }else if (entryArr[0].equals("down")) {
                depth += Integer.parseInt(entryArr[1]);
            }else if (entryArr[0].equals("up")) {
                depth -= Integer.parseInt(entryArr[1]);
            }
        }
        return horizontal * depth;
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
