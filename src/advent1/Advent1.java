package advent1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Advent1 {
    private Path pathToFile = Paths.get("src/advent1/puzzleInput");
    private List<String> puzzleInputs = new ArrayList<>();
    private int sumOfDigits;

    public Advent1(){
        readFromFile();
        for (String textFromFile : puzzleInputs){
            sumOfDigits += getFirstAndLastDigitFromList(findDigitsInText(textFromFile));
        }
        System.out.println(sumOfDigits);
    }

    public List<Integer> findDigitsInText(String text){
        List<Integer> listToReturn = new ArrayList<>();
        for (char c : text.toCharArray()){
            if (Character.isDigit(c)){
                listToReturn.add(Character.getNumericValue(c));
            }
        }
        return listToReturn;
    }

    public int getFirstAndLastDigitFromList(List<Integer> listOfNumbers){
        String numberConcat = listOfNumbers.get(0) + "" + listOfNumbers.get(listOfNumbers.size() -1);
        return Integer.parseInt(numberConcat);
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
    public static void main(String[] args) {
        new Advent1();
    }
}