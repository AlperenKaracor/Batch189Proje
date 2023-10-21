package MiniBookStore;
//1-c defter ozellikleri + marka , yaprak sayisi , urun kodu
public class NoteBook extends Product{

    private String brand;

    private String sheet;

    private String code;//unique

    public NoteBook(String name, String price, int stock, String brand, String sheet, String code) {
        super(name, price, stock);
        this.brand = brand;
        this.sheet = sheet;
        this.code = code;
    }


    //getter-setter


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSheet() {
        return sheet;
    }

    public void setSheet(String sheet) {
        this.sheet = sheet;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
