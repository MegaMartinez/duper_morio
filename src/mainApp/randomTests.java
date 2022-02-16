package mainApp;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class randomTests {
    @Test
    public void testLevelCreate(){
        LevelGenerator creator = new LevelGenerator();
        creator.generateLevel(0, 45);
    }
}
