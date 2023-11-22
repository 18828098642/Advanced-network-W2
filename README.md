# Advanced-network-W2

**1. Find a host name:**
package Web;
import java.net.URL;
import java.util.Scanner;

public class HostnameFinding {
    public HostnameFinding(String address) {
    }

    public static String getHostname(String address) {
        try {
            URL url = new URL(address);
            return url.getHost();
        } catch (Exception e) {
            e.printStackTrace();
            String error="The URL is not valid.";
            return error;
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Input the URL:");
        String address = scanner.next();
        System.out.println("Hostname: " + getHostname(address));
    }
}
**result:**
Input the URL:
https://fearandhunger.fandom.com/wiki/Fear_%26_Hunger_2:_Termina
Hostname: fearandhunger.fandom.com

**2. Find IP address:**
package Web;
import java.net.InetAddress;

public class FindIPAddress {
    public FindIPAddress() {
    }

    public static void main(String[] args) {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            System.out.println("Local IP Address: " + ip.getHostAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
**result:**
Local IP Address: 192.168.1.103

**3. Get IP version**
package Web;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GetIPVersion {
    public static String getIPVersion(String ipAddress) {
        try {
            InetAddress address = InetAddress.getByName(ipAddress);
            byte[] ipBytes = address.getAddress();
            if (ipBytes.length == 4) {
                return "The version is IPv4";
            } else if (ipBytes.length == 16) {
                return "The version is IPv6";
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "Invalid IP";
    }

    public static void main(String[] args) {
        System.out.println("Please input the IP address:");
        Scanner scanner=new Scanner(System.in);
        String ipAddress = scanner.next();
        System.out.println(getIPVersion(ipAddress));
    }
}
**result:**
Please input the IP address:
192.168.1.103
The version is IPv4

**4. Download web page:**
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
        }[Uploading downloaded_page.html…]()

    }

    public static void main(String[] args) {
        String webpageUrl = "https://fearandhunger.fandom.com/wiki/Fear_%26_Hunger_2:_Termina";
        String filePath = "downloaded_page.html";
        downloadWebPage(webpageUrl, filePath);
    }
}
// the web page to download: https://fearandhunger.fandom.com/wiki/Fear_%26_Hunger_2:_Termina
// the file to save: downloaded_page.html
**result:**
file:///C:/Users/DELL/IdeaProjects/Project/downloaded_page.html



