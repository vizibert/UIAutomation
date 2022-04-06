public class TriangleSquare {

    public static double square(Integer a, Integer b, Integer c) throws Exception {
        if (a <= 0 || b <= 0 || b <= 0) {
        throw new Exception("Incorrect data");}

            int p = (a + b + c) / 2;
            double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));

            return s;
        }

    }