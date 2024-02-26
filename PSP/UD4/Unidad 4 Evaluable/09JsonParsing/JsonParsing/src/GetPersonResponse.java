import com.google.gson.annotations.SerializedName;

public class GetPersonResponse {
	@SerializedName("error")
	boolean haserror; // In JSON it will be named "error"
	Person person;
	
	public boolean getError() {
		return haserror;
	}
	
	public Person getPerson() {
		return person;
	}
}
