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
