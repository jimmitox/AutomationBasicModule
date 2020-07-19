package pojo;

public class currencyData {

    //same name as datasource json files
    private String dolar;
    private String amountDolar;
    private String euro;
    private String amountEuro;
    private String pound;
    private String amountPound;

    //Constructor to initialice

    public currencyData(String _dolar, String _amountDolar, String _euro, String _amountEuro, String _pound, String _amountPound){

        this.dolar = _dolar;
        this.amountDolar=_amountDolar;
        this.euro= _euro;
        this.amountEuro = _amountEuro;
        this.pound = _pound;
        this.amountPound = _amountPound;

    }

    //Get methods

    public String getDolar(){
        return dolar;
    }
    public String getAmountDolar(){
        return amountDolar;
    }
    public String getEuro(){
        return euro;
    }
    public String getAmountEuro(){
        return amountEuro;
    }
    public String getPound(){
        return pound;
    }
    public String getAmountPound(){
        return amountPound;
    }

}
