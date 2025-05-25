public class Product {
    private String id;
    private String name;
    private double price;

    public Product(String var1,String var2,double var3){
        this.id=var1;
        this.name=var2;
        this.price=var3;

    }
     public String getId(){
        return this.id;
     }

     public String getname(){
        return this.name;
     }
    public double getprice(){
        return this.price;
    }
}
