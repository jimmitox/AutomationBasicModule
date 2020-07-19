package dataproviders;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import pojo.loginData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import pojo.registerData;


public class usersProvider {
    @DataProvider(name="getUserDataFromJson")

    private Object [][] getUserDataFromJson() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/Resources/data/users.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("dataset");

        //Creating a list of data to be return by pojo

        List<loginData> loginData = new Gson().fromJson(dataSet, new TypeToken<List<loginData>>(){}.getType());


        Object[][] returnValue = new Object[loginData.size()][1];

        int index = 0;

        //Recorrer arreglo

        for(Object [] each: returnValue){
                each[0] = loginData.get(index++);
        }
        return returnValue;
    }

    @DataProvider(name="getWrongUsersDataFromJson")

    private Object [][] getWrongUsersDataFromJson() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/Resources/data/unexistingUsers.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("dataset");

        //Creating a list of data to be retorned by pojo

        List<loginData> loginData = new Gson().fromJson(dataSet, new TypeToken<List<loginData>>(){}.getType());


        Object[][] returnValue = new Object[loginData.size()][1];

        int index = 0;

        //Recorrer arreglo

        for(Object [] each: returnValue){
            each[0] = loginData.get(index++);
        }
        return returnValue;
    }

    @DataProvider(name="getRegistrationUserDataFromJson")

    private Object [][] getRegistrationUserDataFromJson() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/Resources/data/registerUser.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("dataset");

        //Creating a list of data to be returned by pojo

        List<registerData> registerData = new Gson().fromJson(dataSet, new TypeToken<List<registerData>>(){}.getType());


        Object[][] returnValue = new Object[registerData.size()][1];

        int index = 0;

        //Recorrer arreglo

        for(Object [] each: returnValue){
            each[0] = registerData.get(index++);
        }
        return returnValue;
    }



}
