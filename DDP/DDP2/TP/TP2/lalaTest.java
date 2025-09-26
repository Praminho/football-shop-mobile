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
        // Test: Memverifikasi method paketTotal() dalam class globalVar
        // Penjelasan: Test ini memastikan bahwa method paketTotal() mengembalikan
        // jumlah yang benar dari shippedTotal + inTransitTotal + deliveredTotal
        
        TP2.globalVar globalVar = new TP2.globalVar();
        globalVar.shippedTotal = 3;
        globalVar.inTransitTotal = 2;
        globalVar.deliveredTotal = 4;
        
        int result = globalVar.paketTotal();
        
        assertEquals("Total paket harus 9 (3+2+4)", 9, result);
    }
    
    // ========== TEST UNTUK cekStatusPaket METHOD ==========
    
    @Test
    public void testCekStatusPaket() {
        // Test: Memverifikasi method cekStatusPaket dengan berbagai input status
        // Penjelasan: Test ini memastikan bahwa method dapat menerima input jumlah paket
        // dan status paket, kemudian menghitung dengan benar dan menyimpan data
        // dalam StringBuilder dengan format yang tepat
        
        TP2.globalVar globalVar = new TP2.globalVar();
        String input = "3\nShipped\nIn Transit\nDelivered\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        
        TP2.cekStatusPaket(scanner, globalVar);
        
        // Verifikasi counter untuk setiap jenis status
        assertEquals("shippedTotal harus 1", 1, globalVar.shippedTotal);
        assertEquals("inTransitTotal harus 1", 1, globalVar.inTransitTotal);
        assertEquals("deliveredTotal harus 1", 1, globalVar.deliveredTotal);
        
        // Verifikasi data tersimpan dalam StringBuilder dengan format yang benar
        String allStatus = globalVar.semuaStatus.toString();
        assertTrue("Data harus mengandung BRN100001Shipped", allStatus.contains("BRN100001Shipped"));
        assertTrue("Data harus mengandung BRN100002In Transit", allStatus.contains("BRN100002In Transit"));
        assertTrue("Data harus mengandung BRN100003Delivered", allStatus.contains("BRN100003Delivered"));
    }
    
    // ========== TEST UNTUK hitungJumlahPaket METHOD ==========
    
    @Test
    public void testHitungJumlahPaket() {
        // Test: Memverifikasi method hitungJumlahPaket menampilkan ringkasan yang benar
        // Penjelasan: Test ini memastikan method dapat menampilkan ringkasan status paket
        // dengan format yang benar, termasuk jumlah masing-masing status dan total paket
        
        TP2.globalVar globalVar = new TP2.globalVar();
        globalVar.shippedTotal = 2;
        globalVar.inTransitTotal = 3;
        globalVar.deliveredTotal = 1;
        
        // Redirect output untuk capturing
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        
        TP2.hitungJumlahPaket(globalVar);
        
        // Restore original output
        System.setOut(originalOut);
        
        String output = outContent.toString();
        
        // Verifikasi output mengandung informasi yang benar
        assertTrue("Harus ada header ringkasan", output.contains("===== RINGKASAN STATUS PAKET ====="));
        assertTrue("Harus menampilkan jumlah Shipped: 2", output.contains("Shipped: 2"));
        assertTrue("Harus menampilkan jumlah In Transit: 3", output.contains("In Transit: 3"));
        assertTrue("Harus menampilkan jumlah Delivered: 1", output.contains("Delivered: 1"));
        assertTrue("Harus menampilkan total paket: 6", output.contains("Total paket yang dicek: 6"));
    }
    
    // ========== TEST UNTUK urutanStatusPaket METHOD ==========
    
    @Test
    public void testUrutanStatusPaket() {
        // Test: Memverifikasi method urutanStatusPaket menampilkan urutan yang benar
        // Penjelasan: Test ini memastikan method dapat memparse data dari StringBuilder
        // dan menampilkan paket dalam urutan: Delivered → In Transit → Shipped
        // dengan format output yang sesuai
        
        TP2.globalVar globalVar = new TP2.globalVar();
        // Setup data dengan berbagai status dalam urutan acak
        globalVar.semuaStatus.append("BRN100001Shipped,BRN100002In Transit,BRN100003Delivered,");
        
        // Redirect output untuk capturing
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        
        TP2.urutanStatusPaket(globalVar);
        
        // Restore original output
        System.setOut(originalOut);
        
        String output = outContent.toString();
        
        // Verifikasi bahwa setiap status ditampilkan dengan format yang benar
        assertTrue("Harus menampilkan paket Delivered", output.contains("BRN100003 (Delivered)"));
        assertTrue("Harus menampilkan paket In Transit", output.contains("BRN100002 (In Transit)"));
        assertTrue("Harus menampilkan paket Shipped", output.contains("BRN100001 (Shipped)"));
    }
    
    // ========== TEST UNTUK mencariNomorTrackingPaket METHOD ==========
    
    @Test
    public void testReview() {
        // Test: Memverifikasi method review dapat menerima input dan menampilkan output yang benar
        // Penjelasan: Test ini memastikan method review dapat:
        // 1. Menampilkan pertanyaan review kepada user
        // 2. Membaca input review dari Scanner
        // 3. Menampilkan ucapan terima kasih dengan review yang diinput dalam tanda kutip
        // 4. Coverage 100% untuk semua baris dalam method review
        
        String input = "Pelayanan Burhan Express sangat memuaskan!\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        
        // Redirect output untuk capturing
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        
        TP2.review(scanner);
        
        // Restore original output
        System.setOut(originalOut);
        
        String output = outContent.toString();
        
        // Verifikasi semua output yang diharapkan untuk coverage 100%
        assertTrue("Harus menampilkan pertanyaan review", 
                  output.contains("Apa review anda tentang Burhan Express?"));
        assertTrue("Harus menampilkan ucapan terima kasih", 
                  output.contains("Terimakasih atas review anda:"));
        assertTrue("Harus menampilkan review dalam tanda kutip yang benar", 
                  output.contains("\"Pelayanan Burhan Express sangat memuaskan!\""));
    }
}