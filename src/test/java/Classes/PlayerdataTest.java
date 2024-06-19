package Classes;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.*;

class PlayerdataTest {

    @Test
    public void testDeserialize() {
        Playerdata object = new Playerdata();
        File invalidFile = new File("invalidPlayerFile.txt");
        try (PrintWriter writer = new PrintWriter(invalidFile)) {
            writer.write("afafa");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertDoesNotThrow(() -> object.deserialize());
    }
}