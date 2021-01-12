package owpk;

import picocli.CommandLine;

import java.io.File;
import java.util.Arrays;

class Tar {
   @CommandLine.Option(names = "-c", description = "create a new archive")
   boolean create;

   @CommandLine.Option(names = { "-f", "--file" }, paramLabel = "ARCHIVE", description = "the archive file")
   File archive;

   @CommandLine.Parameters(paramLabel = "FILE", description = "one ore more files to archive")
   File[] files;

   @CommandLine.Option(names = { "-h", "--help" }, usageHelp = true, description = "display a help message")
   private boolean helpRequested = false;

   @Override
   public String toString() {
      return "Tar{" +
             "create=" + create +
             ", archive=" + archive +
             ", files=" + Arrays.toString(files) +
             ", helpRequested=" + helpRequested +
             '}';
   }
}
