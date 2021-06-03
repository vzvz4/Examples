package owpk;

import picocli.CommandLine;

import java.io.File;
import java.util.Arrays;

public class Method {

    @CommandLine.Command(description = "Concatenate FILE(s) to standard output.",
            mixinStandardHelpOptions = true, version = "4.1.3")
    void cat(@CommandLine.Option(names = {"-E", "--show-ends"}) boolean showEnds,
             @CommandLine.Option(names = {"-n", "--number"}) boolean number,
             @CommandLine.Option(names = {"-T", "--show-tabs"}) boolean showTabs,
             @CommandLine.Option(names = {"-v", "--show-nonprinting"}) boolean showNonPrinting,
             @CommandLine.Parameters(paramLabel = "FILE") File[] files) {
        System.out.println(showEnds);
        System.out.println(number);
        System.out.println(showTabs);
        System.out.println(showNonPrinting);
        System.out.println(Arrays.toString(files));
    }

    public static void main(String[] args_) {
        String[] args = new String[]{"-v", "15", "-T", "some file"};
        java.lang.reflect.Method doit = CommandLine.getCommandMethods(Method.class, "cat").get(0);
        CommandLine cmd = new CommandLine(doit);
        int exitCode = cmd.execute(args);
    }
}
