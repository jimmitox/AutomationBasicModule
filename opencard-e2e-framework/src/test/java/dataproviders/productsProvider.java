package dataproviders;
import pojo.loginData;
import pojo.productData;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;


public class productsProvider {

    @DataProvider(name="getProductDataFromJson")

    private Object [][] getProductDataFromJson() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/Resources/data/products.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("dataset");

        //Creating a list of data to be return by pojo

        List<productData> productData = new Gson().fromJson(dataSet, new TypeToken<List<productData>>(){}.getType());


        Object[][] returnValue = new Object[productData.size()][1];


        int index = 0;

        //Recorrer arreglo

        for(Object [] each: returnValue){
            each[0] = productData.get(index++);
        }
        return returnValue;
    }

    @DataProvider(name="getProductDataEURFromJson")

    private Object [][] getProductDataEURFromJson() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/Resources/data/currency.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("dataset");

        //Creating a list of data to be return by pojo

        List<productData> productData = new Gson().fromJson(dataSet, new TypeToken<List<productData>>(){}.getType());


        Object[][] returnValue = new Object[productData.size()][1];


        int index = 0;

        //Recorrer arreglo

        for(Object [] each: returnValue){
            each[0] = productData.get(index++);
        }
        return returnValue;
    }

    @DataProvider(name="getProductDataGBPFromJson")

    private Object [][] getProductDataGBPFromJson() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/Resources/data/GBPCurrency.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("dataset");

        //Creating a list of data to be return by pojo

        List<productData> productData = new Gson().fromJson(dataSet, new TypeToken<List<productData>>(){}.getType());


        Object[][] returnValue = new Object[productData.size()][1];


        int index = 0;

        //Recorrer arreglo

        for(Object [] each: returnValue){
            each[0] = productData.get(index++);
        }
        return returnValue;
    }
}
