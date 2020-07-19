package pojo;

public class productData {

    //same name as datasource json files
    private String product;
    private String dollar;
    private String amountDollar;
    private String euro;
    private String amountEuro;
    private String pound;
    private String amountPound;


    //Constructor to initialice

    public productData(String _product, String _dollar, String _amountDollar, String _euro, String _amountEuro, String _pound, String _amountPound){
        this.product = _product;
        this.dollar = _dollar;
        this.amountDollar = _amountDollar;
        this.euro = _euro;
        this.amountEuro = _amountEuro;
        this.pound = _pound;
        this.amountPound = _amountPound;

    }

    //Get methods

    public String getProduct(){
        return product;
    }
    public String getUSDCurrency(){
        return dollar;
    }
    public String getAmountDollar(){
        return amountDollar;
    }
    public String getAmountEuro(){
        return amountEuro;
    }
    public String getAmountPound(){
        return amountPound;
    }
    public String getEURCurrency(){
        return euro;
    }
    public String getGBPCurrency(){
        return pound;
    }

}
