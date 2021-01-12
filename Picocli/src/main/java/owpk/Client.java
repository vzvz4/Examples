package owpk;

import picocli.CommandLine;

public class Client {
   public static void main(String[] args) {
      String[] arg = { "-c", "--file", "result.tar", "file1.txt", "file2.txt" };
      Tar tar = new Tar();
      System.out.println(tar);

      new CommandLine(tar).parseArgs(arg);
      System.out.println(tar);

      String[] arg1 = { "-w", "ethkraken, rvnbinance", "--filter", "--coin", "ETH, RVN"};
      Wallet wallet = new Wallet();
      new CommandLine(wallet).parseArgs(arg1);
      System.out.println(wallet);

   }
}
