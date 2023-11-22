# Advanced-network-W2

1. Find a host name:
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
