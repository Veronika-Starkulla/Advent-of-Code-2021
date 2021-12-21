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

//        Part 1
        int numberOfIncreases = countIncreases(inputIntegerList);

//        Part 2
        int numberOfIncreases2 = countIncreases2(inputIntegerList);

        System.out.println(numberOfIncreases);
        System.out.println(numberOfIncreases2);

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

    public static int countIncreases2(List<Integer> input) {

        List<Integer> windowList = new ArrayList<>();
        for (int i = 0; i<input.size()-2; i++) {
            windowList.add(input.get(i)+input.get(i+1)+input.get(i+2));
        }

        int numberofIncreases = countIncreases(windowList);
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
