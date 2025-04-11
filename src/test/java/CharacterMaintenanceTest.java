import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
//import org.testng.Assert;

import static org.junit.Assert.assertEquals;

public class CharacterMaintenanceTest {

    @Test
        @DisplayName("check for testSanity = 42")
        public void testSanity2(){
            assertEquals(42, 42);
        }

    @Test
        @DisplayName("check the CharacterMaintenance variable testSanity = 42")
        public void testSanity3(){
            assertEquals(3, CharacterMaintenance.add(1, 2) );
        }


}



