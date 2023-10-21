package MiniBookStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//2-a: Kitaplarlar yapilabilecek islemler
public class BookService implements ProductService {


    public Scanner inp = new Scanner(System.in);

    //3-kitaplari saklamak icin list olusturalim

    public List<Book> bookList = new ArrayList<>();

    //4- sistemde baslangicta mevcut olan kitaplar olsun:test icin
    public BookService() {//bu bir cons

        Book book1 = new Book("Fareler ve Insanlar", "150", 15, "J.steinbeck", "Penguin", "A111");
        Book book2 = new Book("Suç ve Ceza", "250", 25, "Dostoyevski", "Penguin", "A222");
        Book book3 = new Book("sefiller", "170", 15, "V.Hugo", "Dream", "A333");
        this.bookList.add(book1);
        this.bookList.add(book2);
        this.bookList.add(book3);


    }


    @Override
    public void processMenu() {
        int choice;
        do {
            System.out.println("-------------------------------");
            System.out.println("1-Kitaplari listele");
            System.out.println("2-Kitap ekle");
            System.out.println("3-Kitabi Sil");
            System.out.println("4-Yayinevine gore filtrele");
            System.out.println("0-Geri Don");
            System.out.println("Seciminiz :");
            choice = inp.nextInt();
            inp.nextLine();//dummy
            switch (choice) {
                case 1:
                    listProducts();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    System.out.println("Yayinevini : ");
                    String publisher = inp.nextLine();
                    filterProducts(publisher);
                    break;
                case 0:
                    System.out.println("Ana menuye yonlerdiriliyorsunuz");
                    break;
                default:
                    System.out.println("Hatali giris");
                    break;
            }

        } while (choice != 0);


    }

    //6-kitaplari formata listele
    @Override
    public void listProducts() {
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.printf("%-3s | %-20s | %-15s | %-10s | %-4s | %-10s | %-3s | \n", "ID", "Kitap Adı", "Yazar Adı", "Yayınevi", "ISBN", "Birim Fiyat", "Stok");
        System.out.println("--------------------------------------------------------------------------------------");
        this.bookList.forEach(book -> System.out.printf("%-3s | %-20s | %-15s | %-10s | %-4s | %-10s | %-3s | \n",
                book.getId(), book.getName(), book.getAuthorName(), book.getPublisher(), book.getIsbn(),
                book.getPrice() + " Lira", book.getStock()));
        System.out.println("-----------------------------------------------------------------------------------");

    }
    //7-yeni kitap girisi

    @Override
    public void addProduct() {

        System.out.println("ISBN : ");
        String isbn = inp.nextLine();
        //bu kitap dah once siteme girilmis mi
        boolean isExists = false;
        for (Book book : this.bookList) {
            if (book.getIsbn().equals(isbn)) {
                System.out.println("Bu kitap sistemde kayitli, lutfen urun guncelleme yapiniz.");//stok guncelleme : ODEV
                isExists = true;
                break;
            }

        }
        if (!isExists) {
            System.out.println("Kitap Adi : ");
            String name = inp.nextLine();
            System.out.println("Yazar Adi : ");
            String author = inp.nextLine();
            System.out.println("Yayinevi");
            String publisher = inp.nextLine();
            System.out.println("Birim Fiyat : ");
            String price = inp.nextLine();
            System.out.println("Stok : ");
            int stock = inp.nextInt();
            inp.nextLine();

            Book newBook = new Book(name, price, stock, author, publisher, isbn);
            this.bookList.add(newBook);

        }
        listProducts();


    }

    //8 - Kullanicidan alinan id ile silme islemini gerceklestir
    @Override
    public void deleteProduct() {
        boolean isFound = true;
        System.out.println("Kitap id : ");
        int id = inp.nextInt();
        for (Book book : this.bookList) {
            if (book.getId() == id) {
                this.bookList.remove(book);
                System.out.println("Urun silindi.");
                isFound = true;
                break;
            } else {
                isFound = false;
            }
        }
        if (!isFound) {
            System.out.println("Urun bulunamadi");
        }
    }
//9-yayinevi gore filtreleme
    @Override
    public void filterProducts(String filter) {
        int counter=0;
        for(Book book:this.bookList){

            if(book.getPublisher().equalsIgnoreCase(filter)){
                System.out.printf("%-3s | %-20s | %-15s | %-10s | %-4s | %-10s | %-3s | \n",
                        book.getId(), book.getName(), book.getAuthorName(), book.getPublisher(), book.getIsbn(),
                        book.getPrice() + " Lira", book.getStock());
                counter++;

            }

        }
        if(counter==0){
            System.out.println("Eslenen urun bulunamadi!");
        }

    }
}
