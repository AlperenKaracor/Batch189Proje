package biletRezervasyon;

public class Ticket {

    //4 mesafe(km) , koltuk no, fiyat , yolculuk tipi

    public double distance;

    public int typeNo;

    public String seatNo;

    public double price;  //verilen bilgilere gore hesaplayacagiz

    //5-bilet fiyatini hesaplama
    public void getTotalPrice(int age) {

        double total = 0;
        int seat = Integer.parseInt(this.seatNo);
        switch (this.typeNo) {

            case 1://tek yon
                if (seat % 3 == 0) {

                    total = this.distance * 1.2;

                } else {

                    total = this.distance * 1;
                }
                System.out.println("Toplam tutar : " + total);


                break;
            case 2://cift yon:gidis-donus
                if (seat % 3 == 0) {
                    total = this.distance * 2.4;
                } else {
                    total = this.distance * 2;
                }
                System.out.println("Toplam tutar : " + total);//100
                //cift yon indirimi
                total = total * 0.8;
                System.out.println("Cift yon indirimli toplam tutar : " + total);//80
                break;

        }


        if (age < 12) {
            total = total * 0.5;
            System.out.println("12 yas alti indirimli toplam tutar : " + total);

        } else if (age > 65) {
            total = total * 0.7;
            System.out.println("65 yas ustu indirimli toplam tutar : " + total);
        }
        this.price = total;

    }


    //6- bileti yazdiralim

    public void printTicket(Bus bus){


        System.out.println("*".repeat(42));
        System.out.println("--- Bilet Detayi ---");
        System.out.println("Otobus Plakasi  :"+bus.numberPlate);
        System.out.println("Mesafe          :" + this.distance);
        System.out.println("Yolculuk Tipi   :"+(this.typeNo ==1 ? "Tek yon" : "Gidis Donus"));
        System.out.println("Koltuk No       :");
        System.out.println("Toplam Tutar    :");
        System.out.println("Keyifli yolculuklar dileriz...");
    }

}
