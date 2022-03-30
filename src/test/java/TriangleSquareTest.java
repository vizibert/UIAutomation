import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleSquareTest {

    @Test
    void successCalculationTest() throws Exception {
        Assertions.assertEquals(TriangleSquare.square(3, 4, 5), 6);
    }

    @Test
    void ExceptionTest() {
        Assertions.assertThrows(Exception.class, () -> TriangleSquare.square(0, 3, 2));
    }
}
