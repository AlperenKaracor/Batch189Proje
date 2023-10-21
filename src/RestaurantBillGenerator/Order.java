package RestaurantBillGenerator;

public class Order {

    private static int count = 999;

    private int orderCode;
    private Dish dish;//100 - Adana Kebabi-250
    private int numberOfDish;//3
    private double orderPrice;//3*250

    //8 -yemek ve adedini kullanarak order objemiz olussun


    public Order(Dish dish, int numberOfDish) {
        count++;//1000 , 1001
        this.orderCode=count;
        this.dish = dish;
        this.numberOfDish = numberOfDish;
    }

    //9 - orderPrice i hesaplayalim
    public void setOrderPrice(){

        this.orderPrice=this.dish.getPrice()*this.numberOfDish;

    }


    public void setNumberOfDish(int numberOfDish) {
        this.numberOfDish = numberOfDish;
    }


    //getter methodlari


    public int getOrderCode() {
        return orderCode;
    }

    public Dish getDish() {
        return dish;
    }

    public int getNumberOfDish() {
        return numberOfDish;
    }

    public double getOrderPrice() {
        return orderPrice;
    }
}
