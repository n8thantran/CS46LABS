import java.io.*;

public class DotReader {
    private BufferedReader br;

    public DotReader(BufferedReader br) {
        this.br = br;
    }

    public Dot readDot() throws IOException, DotException {
        String line = br.readLine();

        if (line == null) {
            return null;
        }

        String[] parts = line.split(",");

        if (parts.length != 4) {
            throw new DotException("Invalid number of properties: " + line);
        }

        try {
            String colorName = parts[0].trim();
            int x = Integer.parseInt(parts[1].trim());
            int y = Integer.parseInt(parts[2].trim());
            int radius = Integer.parseInt(parts[3].trim());
            return new Dot(colorName, x, y, radius);
        } catch (NumberFormatException e) {
            throw new DotException("Invalid number format in line: " + line);
        } catch (IllegalArgumentException e) {
            throw new DotException("Invalid color name in line: " + line);
        }
    }
}