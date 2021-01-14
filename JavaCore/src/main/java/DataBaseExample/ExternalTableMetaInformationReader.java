package DataBaseExample;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Map;

public interface ExternalTableMetaInformationReader {
    int getSize();
    Pair<String, Column>[] getTableData() throws FileNotFoundException;
}
