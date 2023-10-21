package RestaurantBillGenerator;



//10 - orderla ilgili islemler


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderService {

    Scanner input = new Scanner(System.in);

    public List<Order> orderList = new ArrayList<>();



    //11- siparis olusturma
    public void createOrder(){


        int dishCode;

        do {

            System.out.println("Lutfen urun kodunu giriniz (CIKIS icin 0) : ");
            dishCode=input.nextInt();//100--> bu code ile dish objesini bulmamiz gerekir: 12
            //devam edecek



        }while(dishCode!=0);


    }






}
