import java.util.ArrayList;
import java.util.List;

public class Person {
    
    String name;
    int age;
    List<Address> address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }
    
    @Override
    public String toString() {
        String str = "Name -> " + name + "\nage -> " + age + "\nAddress ->";
        for(Address a: address)
            str += "\n\t" + a.toString();
        return str;
    }
}
