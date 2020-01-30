package irsat;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

public class main {
    public static void main(String[] args) throws IOException {

        //düzenlenecek path
        String path = args[0]+"\\Jenkinsfile";
        String appName = args[1];
        String proName = args[2];
        //son argüman yeni jenkins file için path
        String jenkPath = args[3]+"\\Jenkinsfile";

        //ilk iki satıra girilmeis gereken değerleri yazar
        String firstLine = "final def appName = \""+appName+"\"";
        String secondLine = "final def ProjectName = \""+proName+"\"";

        //yeni jenkins dosyasının ilk iki satırına oluşacak değerleri basar ve devam eder.
        BufferedReader reader = new BufferedReader(new FileReader(jenkPath));
        StringBuffer sb=new StringBuffer();
        String line;
        sb.append(firstLine);
        sb.append("\n");
        sb.append(secondLine);
        sb.append("\n");
        while ((line = reader.readLine()) != null) {
            sb.append(line);
            sb.append('\n');
        }
        reader.close();
        String inputStr = sb.toString();
        //varolan dosyanın üzerine yazar
        FileOutputStream fileOut = new FileOutputStream(path);
        fileOut.write(inputStr.getBytes());
        fileOut.close();







    }
}
