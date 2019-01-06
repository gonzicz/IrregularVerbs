import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Dictionary {
    // ta funkcja czyta dane z pliku i zwraca liste
    public static List<String[]> readFile(String file)
    {
        List<String[]> data = new LinkedList<String[]>();
        String dataRow;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((dataRow = br.readLine()) !=null)
            {
                String[] dataRecords = dataRow.split(";");
                data.add(dataRecords);
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("PLIK NIE ISTNIEJE!!!");
            e.printStackTrace();
        } catch (IOException e)
        {
            System.out.println("NIE MOŻNA ODCZYTA PLIKU");
            e.printStackTrace();
        }
        return data;
    }
}
