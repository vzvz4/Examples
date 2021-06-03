package owpk;

import lombok.ToString;
import picocli.CommandLine;
import picocli.CommandLine.ParseResult;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.Arrays;
import java.util.List;

@Command(name = "main", subcommands = {
        Wallet.ChildOpt.class })
public class Wallet {

   @Option(names = {"--wal-farm-list"})
   protected boolean getFarmWalletsList;

   @Option(names = {"--wal-farm-info"})
   protected boolean getFarmWalletInfo;

   @Option(names = {"--wal-info"})
   protected boolean getWalletInfo;

   @Option(names = {"--wal-list"})
   protected boolean getWalletsList;

   @Command(name = "", hidden = true)
   static class ChildOpt {
      @Option(names = {"-f"})
      protected String farmId;

      @Option(names = {"-w"})
      protected String walletId;
   }

   @Option(names = {"-r", "--raw"})
   protected boolean configJson;


   @Command(name = "baz", description = "I'm a subcommand of `bar`")
   int baz(@Option(names = "-z") int z) {
      System.out.printf("hi from baz, z=%d%n", z);
      return 45;
   }
   public static void main(String[] args) {
      Wallet w = new Wallet();
      Wallet.ChildOpt childOpt = new ChildOpt();

      String[] args_ = new String[]{"--wal-farm-list", "-z", "15"};
      new CommandLine(w).execute(args_);
      System.out.println();
   }

   @Option(names = "-v", scope = CommandLine.ScopeType.INHERIT) // option is shared with subcommands
   public void setVerbose(boolean[] verbose) {
   }

   public void execute() {
      if (getFarmWalletsList) {
         System.out.println();
      }
      if (getFarmWalletInfo) {
      }
      if (getWalletInfo) {
      }
      if (getWalletsList) {
      }
   }
}