package owpk;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.Callable;

@Command(name = "myapp", mixinStandardHelpOptions = true, version = "1.0")
public class Execute implements Callable<Integer> {

    @Option(names = "-x") int x;

    @Override
    public Integer call() { // business logic
        System.out.printf("x=%s%n", x);
        return 123; // exit code
    }



    public static void main(String... args_) { // bootstrap the application
        String[] args = new String[]{"-x", "15", "-v", "some file"};
        new CommandLine(new Execute()).execute(args);

    }
}