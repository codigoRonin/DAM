import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class ReadGSON {
	
    public static void main(String[] args) {
        String json = ServiceUtils.getResponse("http://localhost/services/example", null, "GET");

        if(json != null) {
            Gson gson = new Gson();
            GetPersonResponse personResp = gson.fromJson(json, GetPersonResponse.class);
            if(!personResp.getError()) {
                System.out.println(personResp.getPerson().toString());
                System.out.println(personResp.getPerson().getClass());
            } else {
                System.out.println("There was an error in the request");
            }
        }
    }
}
