package mainApp;

import org.junit.Test;

public class randomTests {

    /*
    
    This was simply a test class for the level generator. We still keep it around in case we need to manually activate it.
    
    */

    @Test
    public void testLevelCreate(){
        LevelGenerator creator = new LevelGenerator();

        //this is NOT the same code used when the level generator is actually called, that is done through a loop
        //this is merely written like this for testing purposes
        
        creator.generateLevel(0, 2);
        creator.generateLevel(0, 3);
        creator.generateLevel(1, 4);
        creator.generateLevel(2, 5);
        creator.generateLevel(3, 6);
        creator.generateLevel(4, 7);
        creator.generateLevel(5, 8);
        creator.generateLevel(6, 9);
        creator.generateLevel(7, 10);
        creator.generateLevel(8, 11);
        creator.generateLevel(9, 12);
        creator.generateLevel(10, 13);
    }
}
