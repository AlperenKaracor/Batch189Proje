package AppointmentApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//10-randevu objesi ile ilgili islemler
public class AppoitmentService {

    public Scanner inp = new Scanner(System.in);

    //11-olusan rendevulari listede tutalim, cunku daha sonra goruntuleyecegiz
    public List<Appointment> appointments=new ArrayList<>();

    //12-randevu oluşturma
    public void createAppointment(DoctorService doctorService){
        //13-dr listesini gösterelim
        doctorService.printDoctors();
        System.out.println("Randevu almak istediğiniz doktoru seçiniz (no): ");
        int selectDr=inp.nextInt();//1
        inp.nextLine();

        Doctor doctor=doctorService.findDoctorById(selectDr);
        if (doctor!=null){
            //14-tarih seçme : takvimde randevu için müsait tarih var mı
            if (doctor.getDates().isEmpty()){
                System.out.println(doctor.getName()+" un bu hafta tüm randevuları dolmuştur, daha sonra tekrar deneyiniz.");
            }else {
                //randevu oluşturmaya devam
                System.out.println("Lütfen ismini giriniz: ");
                String name=inp.nextLine();
                System.out.println("Sayın "+name+" randevu alabileceğiniz tarihler : ");
                for (int i=1;i<doctor.getDates().size();i++){
                    System.out.println(i+" - "+doctor.getDates().get(i-1));//1-2023-09-26--index:0
                    //2-2023-09-27--index:1
                }
                System.out.println("Randevu almak istediğiniz tarihin numarasını giriniz : ");
                int dateNo=inp.nextInt();
                inp.nextLine();
                //15-geçerli bir tarih no girildi mi
                if (dateNo>0 && dateNo<=doctor.getDates().size()){
                    //randevu oluşturabilir
                    Appointment appointment=new Appointment(name,doctor,doctor.getDates().get(dateNo-1));
                    //randevu tarihinin doktorun takviminden silinmesi gerekir
                    doctor.getDates().remove(dateNo-1);
                    //randevuyu kaydedelim
                    this.appointments.add(appointment);
                    System.out.println("Sayın "+name+" randevunuz başarılı bir şekilde oluşturuldu.");
                    System.out.println("Randevu no : "+appointment.getAppointmentNo()+" ile randevu bilgilerinizi görüntüleyebilirsiniz. ");
                }else {
                    System.out.println("Hatalı giriş, tekrar deneyiniz!");
                }
            }
        }else {
            System.out.println("Doktor bulunamadı, tekrar deneyiniz.");
        }
    }


}
