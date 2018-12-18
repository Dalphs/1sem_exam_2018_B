import org.junit.Test;

import static org.junit.Assert.*;

public class MediaIDTest {

    @Test
    public void generate() {
        for (int i = 0; i < 1000; i++) {
            assertNotEquals(MediaID.generate(), MediaID.generate());
        }

    }
}