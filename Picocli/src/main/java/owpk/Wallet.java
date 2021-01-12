package owpk;

import lombok.ToString;
import picocli.CommandLine;

import java.util.Arrays;
import java.util.List;

@ToString
public class Wallet {

   @CommandLine.Option(names = { "-f", "--filter"},
          paramLabel = "SPECIFICATIONS",
          description = "wallet specification")
   private String walletNames;

   @CommandLine.Option(names = {"-v", "--value"},
          paramLabel = "FILTER",
          description = "wallet specification")
   private String values;

}
