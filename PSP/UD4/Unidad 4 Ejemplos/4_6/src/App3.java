import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class App3 {

  public static void main(String[] args) {
    BufferedReader bufInput = null;
    try {
      // URL tubalcain = new URL("http://www.iestubalcain.net");
      // HttpURLConnection conn = (HttpURLConnection)tubalcain.openConnection();
      // conn.setInstanceFollowRedirects(true);
      URL url = new URL("http://www.iestubalcain.net");
      HttpURLConnection conn;
      do {
        conn = (HttpURLConnection) url.openConnection();
        if (conn.getResponseCode() == 301) {
          url = new URL(conn.getHeaderField("Location"));
        }
      } while (conn.getResponseCode() == 301);
      //String charset = getCharset(conn.getHeaderField("Content-Type"));

      bufInput =
        new BufferedReader(new InputStreamReader(conn.getInputStream()));

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
