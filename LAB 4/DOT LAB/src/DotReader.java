package dotlab;

import java.io.*;

public class DotReader {

    private BufferedReader br;

    public DotReader(BufferedReader br) {
        this.br = br;
    }

    public Dot readDot() throws IOException{
            String line = br.readLine();
            if(line == null) {
                return null;
            }

            String[] parts = line.split(",");

            try {
                if(parts.length != 4) {
                    throw new IOException("This line has an invalid amount of arguments! (Only takes four)");
                    break;
                }
                else {
                    String clr = parts[0].trim();
                    int xx = Integer.parseInt(parts[1].trim());
                    int yy = Integer.parseInt(parts[2].trim());
                    int rad = Integer.parseInt(parts[3].trim());
                    return new Dot(clr, xx, yy, rad);
                }
            } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}