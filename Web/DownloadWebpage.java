package Web;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class DownloadWebpage {
    public DownloadWebpage() {
    }
    public static void downloadWebPage(String webpageUrl, String filePath) {
        try {
            URL url = new URL(webpageUrl);
            URLConnection connection = url.openConnection();
            InputStream input = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
            FileOutputStream fos = new FileOutputStream(filePath);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                fos.write((line + "\n").getBytes());
            }
            fos.close();
            bufferedReader.close();
            System.out.println("Web page downloaded successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String webpageUrl = "https://fearandhunger.fandom.com/wiki/Fear_%26_Hunger_2:_Termina";
        String filePath = "downloaded_page.html";
        downloadWebPage(webpageUrl, filePath);
    }
}
