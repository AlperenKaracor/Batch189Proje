package MiniBookStore;

//1-a urunlerin ortak ozellikleri: id,isim,birim fiyat,stok miktari
public class Product {//POJO class

    private static int counter=1;

    private int id;

    private String name;

    private String price;

    private int stock;



      //parametreli const
    public Product(String name, String price, int stock) {
        this.id=counter++;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }



    public int getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
