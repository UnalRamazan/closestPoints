import java.io.FileReader;
import java.io.BufferedReader;

public class ReadFile {

    public ReadFile() {

    }

    public String readerFromMainFile(String fileName) {
        String str = "";

        try {
            String line = "";

            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((line = bufferedReader.readLine()) != null) {

                str += line + "\n";
            }

        } catch (Exception e) {
            System.out.println(fileName + " dosyası okunurken hata çıktı...");
        }

        return str;
    }
}