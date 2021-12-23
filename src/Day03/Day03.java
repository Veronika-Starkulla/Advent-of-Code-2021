package Day03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day03 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("txtInputData/Day03/input.txt"));
        List<String> inputStringList = readInputTxt(bufferedReader);

//        Part 1

//        Count all zeros and ones
        int[] sumZero = new int[inputStringList.get(0).length()];
        int[] sumOne = new int[inputStringList.get(0).length()];
        for (String entry : inputStringList) {
            for (int i = 0; i < entry.length(); i++) {
                if (entry.charAt(i) == '0') {
                    sumZero[i] += 1;
                }else {
                    sumOne[i] += 1;
                }
            }
        }

//        save most common bit in gammaRate and least common bit in epsilonRate
        int[] gammaRate = new int[inputStringList.get(0).length()];
        int[] epsilonRate = new int[inputStringList.get(0).length()];

        for (int i = 0; i < sumZero.length; i++) {
            if (sumZero[i] > sumOne[i]) {
                gammaRate[i] = 0;
                epsilonRate[i] = 1;
            } else {
                gammaRate[i] = 1;
                epsilonRate[i] = 0;
            }
        }

//        convert from binary to decimal
        int gamma = 0;
        for(int i = 0; i < gammaRate.length; i++) {
            if (gammaRate[i] == 1) {
                gamma += Math.pow(2,gammaRate.length-1-i);
            }
        }

        int epsilon = 0;
        for(int i = 0; i < epsilonRate.length; i++) {
            if (epsilonRate[i] == 1) {
                epsilon += Math.pow(2,epsilonRate.length-1-i);
            }
        }

        System.out.println(gamma * epsilon);
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


