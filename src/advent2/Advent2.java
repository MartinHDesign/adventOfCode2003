package advent2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Advent2 {
    private Path pathToFile = Paths.get("src/advent2/puzzleInput.txt");
    List<String> puzzleInput = readFromFile();
    int totalSum = 0;

    public Advent2(){
        int gameNumber = 1;

        for (String text : puzzleInput){
            int amountOfId = countAmountOfIds(text);
            if (checkToManyCubes(text)){
                totalSum += gameNumber;
            }
            gameNumber++;

        }
        System.out.println("total: "+totalSum);
    }
    public int countSumOfId(String text, int maxAmount, String colour){
        String temp = text;
        int valueToReturn = 0;
        for (int i = maxAmount; i > 0; i--) {
            if (temp.contains(maxAmount+" "+colour)){
                temp.replace(maxAmount+" "+colour,"0");
                valueToReturn += i;
            }
        }
        return valueToReturn;
    }
    public boolean checkToManyCubes(String text){

        for (int i = 13; i < 99; i++) {
            if (text.contains(i+" red")){
                return false;
            }
            if (text.contains(i+1+" green")){
                return false;
            }
            if (text.contains(i+2+" blue")){
                return false;
            }
        }
        return true;
    }

    public int countAmountOfIds(String text){
        int ids = 0;
        for (char c : text.toCharArray()){
            if (c == ';'){
                ids++;
            }
        }
        return ids+1;
    }
    public List<String> readFromFile(){
        List<String> tempList = new ArrayList<>();
        try (BufferedReader readFromFile = Files.newBufferedReader(pathToFile)){
            String temp;
            while ((temp = readFromFile.readLine()) != null){
                tempList.add(temp);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return tempList;
    }

    public static void main(String[] args) {
        new Advent2();
    }
}
