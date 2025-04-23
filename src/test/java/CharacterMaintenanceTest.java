//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import refactoredFiles.CharacterMaintenance;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterMaintenanceTest {

   @Test
        @DisplayName("check for testSanity = 42")
        public void testSanity2(){
            assertEquals(42, 42);
        }

    @Test
        @DisplayName("check the view.CharacterMaintenance variable testSanity = 42")
        public void testSanity3(){
            assertEquals(3, CharacterMaintenance.add(1, 2) );
        }


}



