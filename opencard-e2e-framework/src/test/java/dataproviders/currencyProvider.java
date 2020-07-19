package dataproviders;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import pojo.currencyData;
import pojo.productData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class currencyProvider {

    @DataProvider(name="getProductCurrencyFromJson")

    private Object [][] getProductCurrencyFromJson() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/Resources/data/currency.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("dataset");

        //Creating a list of currency data to be returned by pojo

        List<currencyData> currencyData = new Gson().fromJson(dataSet, new TypeToken<List<currencyData>>(){}.getType());


        Object[][] returnValue = new Object[currencyData.size()][1];

        int index = 0;

        //Recorrer arreglo

        for(Object [] each: returnValue){
            each[0] = currencyData.get(index++);
        }
        return returnValue;
    }


}
