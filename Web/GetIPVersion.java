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

