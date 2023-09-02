package aracSigortaApp;
/*
Proje: Araç Sigorta Prim Hesaplama
       Araç tipleri:otomobil, kamyon, otobüs, motosiklet
                    -otobüs: 18-30 koltuk veya 31 ve üstü koltuk
       Tarife dönemi:Aralık 2023,Haziran 2023
          1.dönem :Haziran 2023               2.dönem:Aralık 2023
          otomobil: 2000                       otomobil: 2500
          kamyon:   3000                       kamyon:   3500
          otobüs: tip1: 4000 tip2: 5000        otobüs: tip1: 4500 tip2: 5500
          motosiklet: 1500                     motosiklet: 1750

        1-Tekrar tekrar kullanılan bir seçim menüsü(form) gösterelim.
        2-Tarife dönemi bilgisi,araç tipi bilgilerini kullanıcıdan alalım.
        3-Hatalı girişte hesaplama başarısız uyarısı verip tekrar menü(form) gösterilsin.
        4-Menüde yeni işlem veya çıkış için seçenek sunulsun .
        5-tarife dönemi ve araç tipine göre sigorta primi hesaplansın.
 */

import java.util.Scanner;

public class AracSigortaApplication {

    public static void main(String[] args) {

        //1. Uygulamayi baslatan bir method

        start();


    }

    public static void start() {

        //2. Kullanicidan bilgi alma

        Scanner inp = new Scanner(System.in);
        boolean isAgain;


        //3.Tekrar tekrar menu gosterilsin

        do {
            System.out.println("--- Zorunlu Arac Sigorta Primi Hesaplama ---");
            System.out.println("Tarife donemi seciniz : ");
            System.out.println("1. Haziran 2023");
            System.out.println("2. Aralik 2023");
            int term = inp.nextInt();
            String termName = term == 1 ? "Haziran 2023" : "Aralik 2023";
            int select;
            //tarife donemi dogru girilirse isleme devam edicez fakat hatali ise uyari mesaji ver ve yeniden form goster

            if (term == 1 || term == 2) {
                //4.arac objesi olusturalim

                Arac arac = new Arac();//default
                System.out.println("Arac tipini giriniz :");
                System.out.println("otomobil , kamyon , otobus , motosiklet");
                arac.type = inp.next();//kamyon
                arac.countPrim(term);//prim set edildi
                //prim = 0 ise hatali giris yeni islem secenegi
                //prim > 0 ise hesaplama basarili , sonucu goruntule

                if (arac.prim > 0) {
                    System.out.println("---------------------------");
                    System.out.println("Arac tipi : " + arac.type);
                    System.out.println("Tarife donemi : " + termName);
                    System.out.println("Aracinizin ilgili donem sigorta primi : " + arac.prim);
                    System.out.println("---------------------------");

                    System.out.println("Yeni islem icin 1 , CIKIS icin 0 seciniz : ");
                    select = inp.nextInt();

                    isAgain = select == 1 ? true : false;


                } else {
                    System.out.println("Hesaplama basarisiz, tekrar deneyiniz.");
                    System.out.println("Yeni islem icin 1 , CIKIS icin 0 seciniz : ");
                    select = inp.nextInt();

                    isAgain = select == 1 ? true : false;
                }


            } else {//Hatali girisde mesaj vericez
                System.out.println("Hatali giris!");
                isAgain = true;//Deger dogru olsun ki calismaya devam etsin

            }


        } while (isAgain);

        System.out.println("Iyi gunler dileriz...");


    }


}
