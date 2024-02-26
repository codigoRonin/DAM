
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class LinkSearch {

    // Get charset encoding (UTF-8, ISO,...)
    public static String getCharset(String contentType) {
        for (String param : contentType.replace(" ", "").split(";")) {
            if (param.startsWith("charset=")) {
                return param.split("=", 2)[1];
            }
        }
        
        return null; // Probably binary content
    }  

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkReader bufInput = null;
        
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter address: ");
            String address = in.readLine();

            URL google = new URL(address);
            URLConnection conn = google.openConnection();
            String charset = getCharset(conn.getHeaderField("Content-Type"));
            bufInput = new LinkReader(
                    new InputStreamReader(conn.getInputStream(), charset));
            String line;
            while ((line = bufInput.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException ex) {

        }
    }

}
