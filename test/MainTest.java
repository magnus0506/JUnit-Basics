import org.junit.jupiter.api.*;
import org.junit.platform.engine.TestDescriptor;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Main main;
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter){
        main = new Main();
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        testReporter.publishEntry("Running " + testInfo.getDisplayName() + " With tags: " + testInfo.getTags());
    }

    @Tag("Math")
    @Nested
    class TestAdd{

        @DisplayName("positive add method")
        @Test
        void testAddPositive() {
            assertEquals(2,main.add(1,1));
        }
        @Test
        @DisplayName("negative add method")
        void testAddNegative(){
            assertEquals(-2,main.add(-1,-1));
        }
    }

    @Tag("Math")
    @DisplayName("compute circle area method")
    @Test
    void testComputeCircleArea() {
        assertEquals(314.1592653589793, main.computeCircleArea(10), "Should return right circle area");
    }


    @Tag("Math")
    @DisplayName("divide method")
    @Test
    void divide() {
        assertThrows(ArithmeticException.class, () -> main.divide(1,0), "Divide by zero should throw");
    }
}