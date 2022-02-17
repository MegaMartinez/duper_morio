package mainApp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

/**
 * Class: LevelGenerator
 * @author Team 405
 * Purpose: Creates new files and writes game levels to them.
 */

public class LevelGenerator {

    private String levelString = "";
    private String templateString = "";
    
    private void createFile(File newLevel) throws IOException{
        newLevel.delete();
        newLevel.createNewFile();
        return;
    }

    private boolean percentTest(int percent){
        Random rand = new Random();
        int number = rand.nextInt(100);
        return number <= percent;
    }

    private void writeLevel(int[] stats) {
        int index = 0;
        for(int row = 0; row < 10; row++){
            for(int column = 0; column < 20; column++){
                switch(this.templateString.charAt(index)){
                    case '!':
                        if(percentTest(stats[0])){
                            this.levelString += "1";
                        } else {
                            this.levelString += "0";
                        }
                        break;
                    case '@':
                        if(percentTest(50)){
                            this.levelString += "2";
                        } else {
                            this.levelString += "0";
                        }
                        break;
                    case '#':
                        if(stats[2] > 0){
                            if(percentTest(stats[1])){
                                this.levelString += "4";
                            } else {
                                this.levelString += "3";
                            }
                        } else {
                            this.levelString += "0";
                        }
                        stats[2]--;
                        break;
                    default:
                        this.levelString += String.valueOf(this.templateString.charAt(index));
                } index++;

                if(column != 19){
                    this.levelString += ",";
                }
            }
            if(row != 9){
                this.levelString += "\n";
            }
        }
        return;
    }

    private void writeIntoFile(File newLevel) throws IOException{
        FileWriter writer = new FileWriter(newLevel);
        writer.write(this.levelString);
        writer.close();
        return;
    }

    private void readIntoString(FileReader template) throws IOException{
        Scanner scanner = new Scanner(template);
        while(scanner.hasNext()){
            String[] lineOfIDs = scanner.nextLine().trim().split(",");
            for(int i = 0; i < lineOfIDs.length; i++){
                this.templateString += lineOfIDs[i];
            }
        }
        scanner.close();
        return;
    }

    private FileReader pickTemplate() throws FileNotFoundException {
        File dir = new File("LevelTemplates");
        File tempFile = new File(dir.getAbsolutePath() + "/basic1");
        FileReader template = new FileReader(tempFile);
        return template;
    }

    private int[] adjustDifficulty(int difficulty){
        /*
        stats[0] is percent chance for block spawn
        stats[1] is percent of spawned enemies that are officers or grunts
                 lower number means more grunts, higher number means more officers
        stats[2] is the minimum amount of enemy spawns
        */
        int[] stats = {0, 0, 2};
        
        stats[0] += difficulty * 10;
        stats[1] += difficulty * 10;
        if(difficulty > 8){
            stats[2] += 8;
        } else {
            stats[2] += difficulty;
        }

        return stats;
    }

    public void generateLevel(int difficulty, int levelNum) {
        File dir = new File("Levels");
        String singleDigitZero = "";
        if(levelNum < 10){
            singleDigitZero = "0";
        }
        String levelName = "Level" + singleDigitZero + levelNum;

        File newLevel = new File(dir.getAbsolutePath() + "/" + levelName);
        try {
            createFile(newLevel);
            readIntoString(pickTemplate());
            writeLevel(adjustDifficulty(difficulty));
            writeIntoFile(newLevel);
        } catch (IOException e) {
            System.out.println("\nFAILED TO GENERATE FILE\n");
            e.printStackTrace();
        }
        this.levelString = "";
        this.templateString = "";
        return;
    }

}
