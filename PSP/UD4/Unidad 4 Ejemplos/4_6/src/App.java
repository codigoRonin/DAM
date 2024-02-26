import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class App {

  public static void main(String[] args) {
    BufferedReader bufInput = null;
    try {
      URL google = new URL("http://iestubalcain.net/");
      URLConnection conn = google.openConnection();

      String charset = getCharset(conn.getHeaderField("Content-Type"));

      bufInput =
        new BufferedReader(
          new InputStreamReader(conn.getInputStream(), charset)
        );

      String line;
      while ((line = bufInput.readLine()) != null) {
        System.out.println(line);
      }
    } catch (MalformedURLException e) {} catch (IOException e) {} finally {
      if (bufInput != null) {
        try {
          bufInput.close();
        } catch (IOException e) {}
      }
    }
  }

  // Get charset encoding (UTF-8, ISO,...)
  public static String getCharset(String contentType) {
    for (String param : contentType.replace(" ", "").split(";")) {
      if (param.startsWith("charset=")) {
        return param.split("=", 2)[1];
      }
    }
    return null; 
  }
}
