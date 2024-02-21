package userdata.model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * User data that will be shared by both server and client
 */
public class User implements Serializable
{
    String login;
    String password;
    LocalDate regDate;

    public User() 
    {
        login = "";
        password = "";
        regDate = LocalDate.now();
    }

    public String getLogin() 
    {
        return login;
    }

    public void setLogin(String login) 
    {
        this.login = login;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }

    public LocalDate getRegDate() 
    {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) 
    {
        this.regDate = regDate;
    }

    @Override
    public String toString() 
    {
        return "login=" + login + ", password=" + password + ", regDate=" + regDate;
    }
    
}
