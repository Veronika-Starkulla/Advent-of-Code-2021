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

        int position = countPosition(inputStringList);
        System.out.println(position);
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
