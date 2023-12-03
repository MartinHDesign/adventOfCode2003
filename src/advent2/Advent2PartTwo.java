package advent2;

import advent1.Advent1PartTwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Advent2PartTwo {
    private Path pathToFile = Paths.get("src/advent2/puzzleInput.txt");
    List<String> puzzleInput = readFromFile();
    int totalSum = 0;

    public Advent2PartTwo(){
        for (String game : puzzleInput){
            totalSum += findHighestValue(game);
        }
        System.out.println(totalSum);
    }
    public int findHighestValue(String test){
        String[] colors = {" red"," green"," blue"};
        int[] numberOfColor = {0,0,0};

        for (int i = 0; i < 99; i++) {
            int count = 0;
            for (String color: colors){
                if (test.contains(i+ color)){
                    numberOfColor[count] = i;
                }
                count++;
            }

        }
        return numberOfColor[0]*numberOfColor[1]*numberOfColor[2];
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
        new Advent2PartTwo();
    }
}
