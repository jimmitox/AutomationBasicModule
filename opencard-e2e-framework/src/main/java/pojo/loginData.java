package pojo;

public class loginData {
    //same name as datasource json files
    private String email;
    private String password;


    //Constructor to initialice

    public loginData(String _email, String _password){
        this.email = _email;
        this.password=_password;
    }

    //Get methods

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

}
