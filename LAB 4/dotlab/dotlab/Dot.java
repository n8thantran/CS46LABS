public class Dot {

    private static String[] LEGAL_COLOR_NAMES = {
            "RED", "YELLOW", "BLUE", "CYAN", "GREEN", "MAGENTA", "ORANGE", "BLACK"
    };
    private String colorname;
    public int xVal, yVal, radius;

    public Dot(String col, int x, int y, int r) {
        boolean isLegalColor = false;
        try {        
            for (String legalColor : LEGAL_COLOR_NAMES) {
                if (legalColor.equals(col)) {
                    isLegalColor = true;
                    break;
                }
            }

            if (!isLegalColor) {
                throw new IllegalArgumentException("'" + col + "' is not a legal color name.");
            }
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        colorname = col;
        xVal = x;
        yVal = y;
        radius = r;
    }

    public String getColorName() {
        return colorname;
    }

    public int getX() {
        return xVal;
    }

    public int getY() {
        return yVal;
    }

    public int getRadius() {
        return radius;
    }

    public String toString() {
        return "Color: " + colorname + ", X: " + xVal + ", Y: " + yVal + ", Radius: " + radius;
    }

    public static void main(String[] args) {
        Dot dot1 = new Dot("RED", 3, 3, 4);
        System.out.println(dot1);
    }
}
