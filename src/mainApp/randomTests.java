package mainApp;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class randomTests {
    @Test
    public void testLevelCreate(){
        LevelGenerator creator = new LevelGenerator();
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
