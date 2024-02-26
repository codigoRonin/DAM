
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.StringJoiner;


public class LinkReader extends BufferedReader {
    public LinkReader(Reader reader) {
        super(reader);
    }
    
    private String searchLinks(String line) {
        if(line == null) return line;
        
        boolean finished = false;
        int begin, end = -1;
        StringJoiner strJoin = new StringJoiner("\n");
        
        while(!finished) {
            begin = line.indexOf("<a", end + 1);
            if(begin == -1)
                finished = true;
            else {
                end = line.indexOf("</a>", begin + 1);
                if(end == -1) finished = true;
                else strJoin.add(line.substring(begin, end + 4));
            }
        }
        
        return strJoin.length() == 0?null:strJoin.toString();
    }
    
    @Override
    public String readLine() throws IOException {
        String line;
        String result = null;
        while(result == null && (line = super.readLine()) != null) {
            result = searchLinks(line);
        }
        
        return result;
    }
    
}
