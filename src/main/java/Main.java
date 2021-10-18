import org.kohsuke.args4j.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    @Option(name = "-u", usage = "if you need unpack file")
    private boolean unpack;

    @Option(name = "-z", usage = "if you need pack file")
    private boolean pack;

    @Option(name = "-out", usage = "output file name.txt")
    private boolean output;

    @Argument(required = true, metaVar = "fileName", usage = "File name")
    private List<String> fileName = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        new Main().parsing(args);
    }

    private void parsing(String[] args) throws IOException {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("java -jar RLE.jar [-u or -z] [-out(optional) outFileName.txt] fileName.txt");
            parser.printUsage(System.err);
            System.exit(1);
        }
        Action res = new Action(unpack, pack, output, fileName);
        res.result();
    }
}
