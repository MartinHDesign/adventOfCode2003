package advent1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Advent1PartTwo {
    private Path pathToFile = Paths.get("src/advent1/puzzleinput2");
    private List<String> puzzleInputs = new ArrayList<>();
    int sum = 0;
    public Advent1PartTwo(){
        readFromFile();
        for (String text : puzzleInputs){
            sum += compareTextDigitsAndDigits(text);
        }
        System.out.println(sum);
    }
    public int compareTextDigitsAndDigits(String text){
        int finalFirstDigit;
        int finalLastDigit;
        List<Integer> digits = findDigitsInText(text);
        List<Integer> textDigits = findTextDigits(text);

        if (digits.get(2)< textDigits.get(2)){
            finalFirstDigit = digits.get(0);
        } else {
            finalFirstDigit = textDigits.get(0);
        }
        if (digits.get(3) > textDigits.get(3)){
            finalLastDigit = digits.get(1);
        } else {
            finalLastDigit = textDigits.get(1);
        }

        return Integer.parseInt(finalFirstDigit+""+finalLastDigit);
    }
    public List<Integer> findTextDigits(String text){
        String[] digitsInText = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int firstIndexOfDigitInText = Integer.MAX_VALUE;
        int lastIndexOfDigitInText = -1;
        int firstDigit = -1;
        int lastDigit = -1;
        List<Integer> listToReturn = new ArrayList<>();
        for (int index = 0; index < digitsInText.length; index++) {
            if (text.contains(digitsInText[index])){

                int tempFirstIndex = text.indexOf(digitsInText[index]);
                int tempLastIndex = text.lastIndexOf(digitsInText[index]);
                if (tempFirstIndex < firstIndexOfDigitInText && tempFirstIndex != -1){
                    firstIndexOfDigitInText = tempFirstIndex;
                    firstDigit = convertTextToDigit(digitsInText[index]);
                }
                if (tempLastIndex > lastIndexOfDigitInText){
                    lastIndexOfDigitInText = tempLastIndex;
                    lastDigit = convertTextToDigit(digitsInText[index]);
                }
            }
        }
        listToReturn.add(firstDigit);
        listToReturn.add(lastDigit);
        listToReturn.add(firstIndexOfDigitInText);
        listToReturn.add(lastIndexOfDigitInText);
        return listToReturn;
    }

    public List<Integer> findDigitsInText(String text){
        int firstIndexOfDigit = Integer.MAX_VALUE;
        int lastIndexOfDigit = -2;
        int firstDigit = -1000;
        int lastDigit = -1000;
        List<Integer> listToReturn = new ArrayList<>();
        int index = 0;
        for (char c : text.toCharArray()){
            if (Character.isDigit(c)){
                if (index < firstIndexOfDigit) {
                    firstDigit = Character.getNumericValue(c);
                    firstIndexOfDigit = index;
                }
                if (index > lastIndexOfDigit){
                    lastDigit = Character.getNumericValue(c);
                    lastIndexOfDigit = index;
                }
            }
            index++;
        }
        listToReturn.add(firstDigit);
        listToReturn.add(lastDigit);
        listToReturn.add(firstIndexOfDigit);
        listToReturn.add(lastIndexOfDigit);
        return listToReturn;
    }
    public void readFromFile(){
        try (BufferedReader readFromFile = Files.newBufferedReader(pathToFile)){
            String temp;
            while ((temp = readFromFile.readLine()) != null){
                puzzleInputs.add(temp);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public int convertTextToDigit(String text){
        switch (text){
            case "one" -> {return 1;}
            case "two" -> {return 2;}
            case "three" -> {return 3;}
            case "four" -> {return 4;}
            case "five" -> {return 5;}
            case "six" -> {return 6;}
            case "seven" -> {return 7;}
            case "eight" -> {return 8;}
            case "nine" -> {return  9;}
        }
        return -1;
    }

    public static void main(String[] args) {
        new Advent1PartTwo();
    }

}
