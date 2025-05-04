
import java.util.Scanner;
 
 public class MahasiswaDemo24 {
 
     public static void main(String[] args) {
         StackTugasMahasiswa24 stack = new StackTugasMahasiswa24(5);
         Scanner scan = new Scanner(System.in);
         int pilih;
 
         do {
             System.out.println("\n=========================");
             System.out.println("Menu : ");
             System.out.println("1. Mengumpulkan Tugas");
             System.out.println("2. Menilai Tugas");
             System.out.println("3. Melihat Tugas Teratas");
             System.out.println("4. Melihat Daftar Tugas");
             System.out.println("5. Melihat Tugas Pertama yang Dikirim");
             System.out.println("6. Jumlah Tugas yang Terkumpul");
             System.out.println("0. Keluar");
             System.out.print("Pilih: ");
             pilih = scan.nextInt();
             scan.nextLine();
             switch (pilih) {
                 case 1:
                     System.out.print("Nama: ");
                     String nama = scan.nextLine();
                     System.out.print("NIM: ");
                     String nim = scan.nextLine();
                     System.out.print("Kelas: ");
                     String kelas = scan.nextLine();
                     Mahasiswa24 mhs = new Mahasiswa24(nim, nama, kelas);
                     stack.push(mhs);
                     System.out.printf("Tugas %s berhasil dikumpulkan\n", mhs.nama);
                     break;
                 case 2:
                     Mahasiswa24 dinilai = stack.pop();
                     if (dinilai != null) {
                         System.out.println("Menilai tugas dari " + dinilai.nama);
                         System.out.print("Masukkan nilai (0 - 100) : ");
                         int nilai = scan.nextInt();
                         dinilai.tugasDinilai(nilai);
                         System.out.printf("Nilai tugas %s adalah %d\n", dinilai.nama, nilai);
                         String biner = stack.konversiDesimalkeBiner(nilai);
                         System.out.println("Nilai tugas dalam biner: " + biner);
                     } else {
                         System.out.println("Tidak ada tugas untuk dinilai.");
                     }
                     break;
                 case 3:
                     Mahasiswa24 lihat = stack.peek();
                     if (lihat != null) {
                         System.out.println("Tugas terakhir dikumpulkan oleh: " + lihat.nama);
                     } else {
                         System.out.println("Tidak ada tugas untuk dilihat.");
                     }
                     break;
                 case 4:
                     System.out.println("Daftar semua tugas");
                     System.out.println("Nama\tNIM\tKelas");
                     stack.print();
                     break;
                 case 5:
                     Mahasiswa24 pertama = stack.bottom();
                     if (pertama != null) {
                         System.out.println("Tugas pertama dikumpulkan oleh " + pertama.nama);
                     } else {
                         System.out.println("Belum ada tugas yang dikumpulkan.");
                     }
                     break;
                 case 6:
                     System.out.printf("Total tugas yang sudah dikumpulkan: %d\n", stack.countTugas());
                     break;
                 case 0:
                     System.out.println("Terima kasih!");
                     break;
                 default:
                     System.out.println("Pilihan tidak valid.");
             }
         } while (pilih != 0);
     }
 }