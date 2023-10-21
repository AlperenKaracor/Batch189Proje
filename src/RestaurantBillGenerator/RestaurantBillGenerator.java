package RestaurantBillGenerator;



    /*
Proje: Restaurant Fiş Üretme Uygulaması(BillGenerator)
       1-Bir restaurantın online sipariş sisteminde hesabı
       yazdıran uygulama tasarlayınız.

       2-Restauranttaki yiyecekler bir listte tutulsun.
         Yiyeceklerin kodu, ismi ve ücreti olsun.

       3-Yiyecek menüsü gosterme, sipariş oluşturma/iptal ve hesap
         oluşturma için seçim menüsü gösterilsin.

       4-Yiyecek menü:Listedeki yiyecekler menü şeklinde listelensin
         Sipariş girme:Yiyeceğin kodu ve istenilen adet girilerek sipariş oluşturulsun
                       Her sipariş için kod üretilsin(başlangıç 1000 artarak devam eder)
                       Her bir yiyecek siparişi için tutar hesaplansın

         Sipariş iptal:Sipariş kodu girilerek sipariş silinsin
         Hesap oluşturma: Tutarları ile birlikte tüm siparişleri ve
                          toplam tutarı gösteren bir hesap fişi yazdırılsın.
*/

import java.sql.SQLOutput;
import java.util.Scanner;

public class RestaurantBillGenerator {


    public static void main(String[] args) {

        getSelectionMenu();


    }
//1- Islem secim menusu
    public static void getSelectionMenu(){

        Scanner input = new Scanner(System.in);
         //3- yiyecekler icin Class olusturalim : Dish

        //7-servis objesi olusturalim

        DishService dishService = new DishService();//listeye yemekler eklendi



        //2- tekrar tekrar menuyu gosterelim

        int select=-1;
        while (select!=0){

            System.out.println("------------------------------");
            System.out.println(" *** Kenan Abinin Yeri Siparis Uygulamasi *** ");
            System.out.println("1-menu");
            System.out.println("2-Siparis Gir");
            System.out.println("3-Siparis Olustur");
            System.out.println("4-Hesap Olustur");
            System.out.println("0-Cikis");
            select=input.nextInt();
            System.out.println("--------------------------------");

            switch (select){
                case 1 :
                    dishService.showMenu();
                    break;
                case 2 :
                    //siparis gir
                    break;
                case 3 :
                    //siparis iptal
                    break;
                case 4 :
                    //Hesap
                    break;
                case 0:
                    System.out.println("Iyi gunler Dileriz");
                    break;
                default:
                    System.out.println("Hatali giris");
                    break;
            }
        }


    }





























}
