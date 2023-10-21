package RestaurantBillGenerator;

//3-yiyecek objesi
public class Dish {//POJO (en temel en ilkel java classi demek)


    //yiyeceklerin ozellikleri okunsun fakar daha sonra degistirilemesin

    private int code;

    private String name;

    private double price;

    //yiyecekleri olustururken fieldlar set edilsin


    public Dish(int code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }


    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    //toString


    @Override
    public String toString() {
        return
                "code=" + code +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}




