package mainApp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;

/**
 * Class: LevelGenerator
 * @author Team 405
 * Purpose: Creates new files and writes game levels to them.
 */

public class LevelGenerator {

    private String levelString = "";
    private String levelTemplate = "";
    
    private void createFile(File dir, File newLevel) throws IOException{
        newLevel.delete();
        newLevel.createNewFile();
    }

    private void writeLevel(int difficulty) {
        Random rand = new Random();
        for(int row = 0; row < 13; row++){
            switch(row){
                case 0:
                    break;
            }
            for(int column = 0; column < 13; column++){
                switch(column){
                    default:
                        this.levelString += "0";
                        break;
                }

                if(column != 12){
                    this.levelString += ",";
                }
            }
            if(row != 12){
                this.levelString += "\n";
            }
        }
    }

    private void writeIntoFile(File dir, File newLevel) throws IOException{
        FileWriter writer = new FileWriter(newLevel);
        writer.write(this.levelString);
        writer.close();
    }

    public void generateLevel(int difficulty, int levelNum) {
        writeLevel(difficulty);
        File dir = new File("Levels");
        String levelName = "Level" + levelNum;
        File newLevel = new File(dir.getAbsolutePath() + "/" + levelName);
        try {
            createFile(dir, newLevel);
            writeIntoFile(dir, newLevel);
        } catch (IOException e) {
            System.out.println("\nFAILED TO GENERATE FILE\n");
            e.printStackTrace();
        }
        this.levelString = "";
        this.levelTemplate = "";
        return;
    }

}
