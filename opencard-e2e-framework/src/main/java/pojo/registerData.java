package pojo;

public class registerData {
    //same name as datasource json files
    private String firstName;
    private String lastName;
    private String telephone;
    private String password;
    private String confirmPass;

    //Constructor to initialice

    public registerData(String _firstName, String _lastName,String _telephone, String _password, String _confirmPass){
        this.firstName = _firstName;
        this.firstName = _lastName;
        this.telephone = _telephone;
        this.lastName = _password;
        this.password=_password;
        this.confirmPass = _confirmPass;
    }

    //Get methods

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }

    public String getTelephone(){
        return telephone;
    }


    public String getPassword(){
        return password;
    }

    public String getConfirmPass() {
        return confirmPass;
    }

}

