import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class App4 {

  private static String getSumFromService(int n1, int n2) {
    BufferedReader bufInput = null;
    String result;
    try {
      URL url = new URL("http://localhost/services/sum/" + n1 + "/" + n2);
      URLConnection conn = url.openConnection();

      bufInput =
        new BufferedReader(new InputStreamReader(conn.getInputStream()));
      result = bufInput.readLine();
    } catch (IOException e) {
      return "Error";
    } finally {
      if (bufInput != null) {
        try {
          bufInput.close();
        } catch (IOException e) {
          return "Error";
        }
      }
    }

    return result == null ? "Error" : result;
  }

  public static void main(String[] args) {
    System.out.println(getSumFromService(3, 5));
  }
}
