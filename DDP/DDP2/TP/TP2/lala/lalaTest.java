import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class lalaTest {
    
    // ========== TEST UNTUK globalVar CLASS ==========
    
    @Test
    public void testGlobalVarPaketTotal() {
        // verifikasi method paketTotal() dalam class globalVar untuk mengambil data dari variabel global
        
        lala.globalVar globalVar = new lala.globalVar();
        globalVar.shippedTotal = 3;
        globalVar.inTransitTotal = 2;
        globalVar.deliveredTotal = 4;
        
        int result = globalVar.paketTotal();
        
        assertEquals("Total paket harus 9 (3+2+4)", 9, result);
        // mengecek dengan total paket berjumlah 9 dari 3+2+4 dari masing masing status
    }
    
    // ========== TEST UNTUK cekStatusPaket METHOD ==========
    
    @Test
    public void testCekStatusPaket() {
        // verikasi method cekStatusPaket dengan input status
        // method dapat input jumlah dan status paket dan disimpan dalam StringBuilder

        lala.globalVar globalVar = new lala.globalVar();
        String input = "3\nShipped\nIn Transit\nDelivered\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        
        lala.cekStatusPaket(scanner, globalVar);
        
        // verifikasi counter untuk jenis status
        assertEquals("shippedTotal harus 1", 1, globalVar.shippedTotal);
        assertEquals("inTransitTotal harus 1", 1, globalVar.inTransitTotal);
        assertEquals("deliveredTotal harus 1", 1, globalVar.deliveredTotal);
        
        // verifikasi data tersimpan dalam StringBuilder 
        String allStatus = globalVar.semuaStatus.toString();
        assertTrue("Data harus mengandung BRN100001Shipped", allStatus.contains("BRN100001Shipped"));
        assertTrue("Data harus mengandung BRN100002In Transit", allStatus.contains("BRN100002In Transit"));
        assertTrue("Data harus mengandung BRN100003Delivered", allStatus.contains("BRN100003Delivered"));
    }
    
    // ========== TEST UNTUK hitungJumlahPaket METHOD ==========
    
    @Test
    public void testHitungJumlahPaket() {
        // memberi print ringkasan status paket
        
        lala.globalVar globalVar = new lala.globalVar();
        globalVar.shippedTotal = 2;
        globalVar.inTransitTotal = 3;
        globalVar.deliveredTotal = 1;
        
        // redirect output untuk capturing
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        
        lala.hitungJumlahPaket(globalVar);
        
        // restore original output
        System.setOut(originalOut);
        
        String output = outContent.toString();
        
        // verifikasi output
        assertTrue("Harus ada header ringkasan", output.contains("===== RINGKASAN STATUS PAKET ====="));
        assertTrue("Harus menampilkan jumlah Shipped: 2", output.contains("Shipped: 2"));
        assertTrue("Harus menampilkan jumlah In Transit: 3", output.contains("In Transit: 3"));
        assertTrue("Harus menampilkan jumlah Delivered: 1", output.contains("Delivered: 1"));
        assertTrue("Harus menampilkan total paket: 6", output.contains("Total paket yang dicek: 6"));
    }
    
    // ========== TEST UNTUK urutanStatusPaket METHOD ==========
    
    @Test
    public void testUrutanStatusPaket() {
        // mengurutan status paket yang benar: Delivered, In Transit, Shipped
        
        lala.globalVar globalVar = new lala.globalVar();
        // setup data dan status 
        globalVar.semuaStatus.append("BRN100001Shipped,BRN100002In Transit,BRN100003Delivered,");
        
        // redirect output untuk capturing
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        
        lala.urutanStatusPaket(globalVar);
        
        // restore original output
        System.setOut(originalOut);
        
        String output = outContent.toString();
        
        // verifikasi output
        assertTrue("Harus menampilkan paket Delivered", output.contains("BRN100003 (Delivered)"));
        assertTrue("Harus menampilkan paket In Transit", output.contains("BRN100002 (In Transit)"));
        assertTrue("Harus menampilkan paket Shipped", output.contains("BRN100001 (Shipped)"));
    }
    
    // ========== TEST UNTUK mencariNomorTrackingPaket METHOD ==========
    
 @Test
    public void testMencariNomorTrackingPaketFound() {
        // verifikasi nomor tracking paket yang ditemukan
        lala.globalVar globalVar = new lala.globalVar();
        // setup data paket
        globalVar.semuaStatus.append("BRN100001Shipped,BRN100002Delivered,");
        globalVar.shippedTotal = 1;
        globalVar.deliveredTotal = 1;
        
        // cari BRN100001, pilih "no" untuk tidak lanjut
        String input = "BRN100001\nno\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        
        // redirect output untuk capturing
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        
        lala.mencariNomorTrackingPaket(scanner, globalVar);
        
        // restore original output
        System.setOut(originalOut);
        
        String output = outContent.toString();
        
        // Verifikasi hasil pencarian
        assertTrue("Harus menampilkan prompt untuk input tracking", output.contains("Masukkan nomor tracking:"));
        assertTrue("Harus menampilkan paket ditemukan", output.contains("Paket ditemukan!"));
        assertTrue("Harus menampilkan status yang benar", output.contains("BRN100001Shipped"));
        assertTrue("Harus menampilkan ucapan terima kasih", output.contains("Terimakasih telah menggunakan layanan Burhan Express!"));
    }
    
    @Test
    public void testMencariNomorTrackingPaketNotFound() {
        // verifikasi nomor tracking paket yang tidak ditemukan
        
        lala.globalVar globalVar = new lala.globalVar();
        // setup data paket
        globalVar.semuaStatus.append("BRN100001Shipped,");
        globalVar.shippedTotal = 1;
        
        // cari BRN999999 (tidak ada), pilih "no" 
        String input = "BRN999999\nno\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        
        // redirect output untuk capturing
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        
        lala.mencariNomorTrackingPaket(scanner, globalVar);
        
        // restore original output
        System.setOut(originalOut);
        
        String output = outContent.toString();
        
        // verifikasi hasil pencarian tidak ditemukan
        assertTrue("Harus menampilkan prompt untuk input tracking", output.contains("Masukkan nomor tracking:"));
        assertTrue("Harus menampilkan pesan paket tidak ditemukan", 
                  output.contains("Paket dengan nomor tracking tersebut tidak ditemukan."));
        assertTrue("Harus menampilkan ucapan terima kasih", 
                  output.contains("Terimakasih telah menggunakan layanan Burhan Express!"));
    }
    

    @Test
    public void testReview() {
        // menerima input dari user dan diprint

        
        String input = "Pelayanan Burhan Express sangat memuaskan!\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        
        // redirect output untuk capturing
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        
        lala.review(scanner);
        
        // restore original output
        System.setOut(originalOut);
        
        String output = outContent.toString();
        
        // verifikasi input dan output
        assertTrue("Harus menampilkan pertanyaan review", 
                  output.contains("Apa review anda tentang Burhan Express?"));
        assertTrue("Harus menampilkan ucapan terima kasih", 
                  output.contains("Terimakasih atas review anda:"));
        assertTrue("Harus menampilkan review dalam tanda kutip yang benar", 
                  output.contains("\"Pelayanan Burhan Express sangat memuaskan!\""));
    }
}