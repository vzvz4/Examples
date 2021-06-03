package owpk;

import picocli.CommandLine;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Command(name = "cat", footer = "Copyright(c) 2017",
        description = "Concatenate FILE(s), or standard input, to standard output.")
public class CommandExample implements Runnable {


        @Parameters(paramLabel = "FILE", description = "Files whose contents to display")
        List<File> files;

        @CommandLine.Option(names = "--help", usageHelp = true, description = "display this help and exit")
        boolean help;

        @Option(names = "-t",                 description = "equivalent to -vT")  List<String> t;
        @Option(names = "-e",                 description = "equivalent to -vE")  boolean e;
        @Option(names = {"-A", "--show-all"}, description = "equivalent to -vET") boolean all;

        // ...
        public static void main(String[] args) {
                String[] args_ = new String[]{"-t", "file1", "file2"};
                new CommandLine(new CommandExample()).execute(args_);
        }

        @Override
        public void run() {
             if (t != null) System.out.println(t);
        }
}
