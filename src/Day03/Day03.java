package Day03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day03 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("txtInputData/Day03/test.txt"));
        List<String> inputStringList = readInputTxt(bufferedReader);

        //        Part 1

        List<int[]> zerosAndOnes = countZerosAndOnes(inputStringList);
        int[] sumZero = zerosAndOnes.get(0);
        int[] sumOne = zerosAndOnes.get(1);

//        save most common bit in gammaRate and least common bit in epsilonRate
        List<int[]> gammaAndEpsilon = detectGammaAndEpsilon(sumZero, sumOne);
        int[] gammaRate = gammaAndEpsilon.get(0);
        int[] epsilonRate = gammaAndEpsilon.get(1);

//        convert from binary to decimal
        int gamma = convertToDecimal(gammaRate);
        int epsilon = convertToDecimal(epsilonRate);

        System.out.println(gamma*epsilon);

//        Part 2

        List<String> oxygenList = new ArrayList<>(inputStringList);
        String oxygen = detectOxygen(oxygenList);
        System.out.println(oxygen);

        List<String> co2List = new ArrayList<>(inputStringList);
        String c02 = detectCO2(co2List);
        System.out.println(c02);

        int[] oxygenArr = convertToIntArray(oxygen);
        int[] co2Arr = convertToIntArray(c02);

        int oxygenDec = convertToDecimal(oxygenArr);
        int co2Dec = convertToDecimal(co2Arr);

        System.out.println(oxygenDec);
        System.out.println(co2Dec);
        System.out.println(co2Dec * oxygenDec);
    }

    public static int[] convertToIntArray(String input) {
        String[] oxygenArr = input.split("");
        int[] intArr = new int[oxygenArr.length];
        for (int i= 0; i < oxygenArr.length; i++) {
            intArr[i] = Integer.parseInt(oxygenArr[i]);
        }
        return intArr;
    }

    public static String detectCO2(List<String> input) {
        int[] sumZero = new int[input.get(0).length()];
        int index = 0;
        while (input.size() > 1 && index < sumZero.length) {
            List<int[]> newCalc = countZerosAndOnes(input);
            int[] sumOne = newCalc.get(1);
            sumZero = newCalc.get(0);
            for (int i = input.size()-1; i >= 0; i--) {
                if (sumZero[index] <= sumOne[index] && input.get(i).charAt(index) == '1') {
                    input.remove(i);
                }else if (sumOne[index] < sumZero[index] && input.get(i).charAt(index) == '0') {
                    input.remove(i);
                }
            }
            index++;
        }
        return input.get(0);
    }

    public static String detectOxygen(List<String> input) {
        int[] sumZero = new int[input.get(0).length()];

        int index = 0;
        while (input.size() > 1 && index < sumZero.length) {
            List<int[]> newCalc = countZerosAndOnes(input);
            int[] sumOne = newCalc.get(1);
            sumZero = newCalc.get(0);
            for (int i = input.size()-1; i >= 0; i--) {
                if (sumZero[index] > sumOne[index] && input.get(i).charAt(index) == '1') {
                    input.remove(i);
                }else if (sumOne[index] >= sumZero[index] && input.get(i).charAt(index) == '0') {
                    input.remove(i);
                }
            }
            index++;
        }
        return input.get(0);
    }

    public static List<int[]> countZerosAndOnes(List<String> input) {
        List<int[]> zerosAndOnes = new ArrayList<>();
        int[] sumZero = new int[input.get(0).length()];
        int[] sumOne = new int[input.get(0).length()];
        for (String entry : input) {
            for (int i = 0; i < entry.length(); i++) {
                if (entry.charAt(i) == '0') {
                    sumZero[i] += 1;
                }else {
                    sumOne[i] += 1;
                }
            }
        }
        zerosAndOnes.add(sumZero);
        zerosAndOnes.add(sumOne);
        return zerosAndOnes;
    }

    public static int convertToDecimal(int[] binary) {
        int decimal = 0;
        for(int i = 0; i < binary.length; i++) {
            if (binary[i] == 1) {
                decimal += Math.pow(2,binary.length-1-i);
            }
        }
        return decimal;
    }

    public static List<int[]> detectGammaAndEpsilon(int[] zero, int[] one) {
        int[] gammaRate = new int[zero.length];
        int[] epsilonRate = new int[zero.length];

        for (int i = 0; i < zero.length; i++) {
            if (zero[i] > one[i]) {
                gammaRate[i] = 0;
                epsilonRate[i] = 1;
            } else {
                gammaRate[i] = 1;
                epsilonRate[i] = 0;
            }
        }
        return Arrays.asList(gammaRate, epsilonRate);
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


