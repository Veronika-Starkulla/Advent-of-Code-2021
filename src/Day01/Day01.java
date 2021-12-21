package Day01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day01 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("txtInputData/day01input.txt"));
        List<String> inputStringList = readInputTxt(bufferedReader);
        List<Integer> inputIntegerList = convertToIntegerList(inputStringList);

        int numberOfIncreases = countIncreases(inputIntegerList);

        System.out.println(numberOfIncreases);

    }

    public static List<Integer> convertToIntegerList(List<String> stringList) {
        List<Integer> integerList = new ArrayList<>();
        for (String s : stringList) {
            integerList.add(Integer.parseInt(s));
        }
        return integerList;
    }
    public static int countIncreases(List<Integer> input) {
        int numberofIncreases = 0;

//        Starts at index 1, because: there is no measurement before the first measurement.
        for (int i = 1; i < input.size(); i++) {
            if (input.get(i) > input.get(i-1)) {
                numberofIncreases += 1;
            }
        }
        return numberofIncreases;
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
