import java.io.*;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Action {
    private final boolean unpack;
    private final boolean pack;
    private final boolean output;
    private final List<String> fileName;
    private String inputFile;
    private String outputFile;


    public Action(boolean unpack, boolean pack, boolean output, List<String> fileName) {
        this.unpack = unpack;
        this.pack = pack;
        this.output = output;
        this.fileName = fileName;
    }

    public void result() throws FileNotFoundException {
        String res = "";
        if (output) {
            outputFile = fileName.get(0);
            inputFile = fileName.get(1);
        } else inputFile = fileName.get(0);

        String reader = new BufferedReader(new FileReader(inputFile)).lines().collect(Collectors.joining()).toLowerCase(Locale.ROOT);

        if (pack) res = code(reader);
        else if (unpack) res = encode(reader);

        if (output) writerInFile(outputFile, res);
        else writerInFile(inputFile, res);
    }

    public static String code(String str) {
        StringBuilder sb = new StringBuilder();
        char bufer = str.charAt(0);
        int count = 0;
        for (char x: str.toCharArray()) {
            if (x != bufer) {
                if (count == 1) sb.append(bufer);
                else sb.append(count).append(bufer);
                bufer = x;
                count = 1;
            } else count++;
        }
        if (count == 1) sb.append(bufer);
        else sb.append(count).append(bufer);
        return sb.toString();
    }

    public static String encode(String str) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (char x: str.toCharArray()){
            if (Character.isDigit(x)) {
                if (count != 0) count = count * 10 + Character.getNumericValue(x);
                else count = Character.getNumericValue(x);
            }
            if (Character.isAlphabetic(x) && count == 0) sb.append(x);
            if (Character.isAlphabetic(x)) {
                while (count != 0){
                    sb.append(x);
                    count--;
                }
            }
        }
        return sb.toString();
    }

    private void writerInFile(String path, String res) {
        try(FileWriter writer = new FileWriter(path)) {
            writer.write(res);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}