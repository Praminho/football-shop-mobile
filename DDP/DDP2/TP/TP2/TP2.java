import java.util.Scanner;

public class TP2 {
    static int totalPindah = 0;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("    ,---,.                         ,---,                                \r\n" + //
                            "  ,'  .'  \\                      ,--.' |                                \r\n" + //
                            ",---.' .' |         ,--,  __  ,-.|  |  :                      ,---,     \r\n" + //
                            "|   |  |: |       ,'_ /|,' ,'/ /|:  :  :                  ,-+-. /  |    \r\n" + //
                            ":   :  :  /  .--. |  | :'  | |' |:  |  |,--.  ,--.--.    ,--.'|'   |    \r\n" + //
                            ":   |    ; ,'_ /| :  . ||  |   ,'|  :  '   | /       \\  |   |  ,\"' |    \r\n" + //
                            "|   :     \\|  ' | |  . .'  :  /  |  |   /' :.--.  .-. | |   | /  | |    \r\n" + //
                            "|   |   . ||  | ' |  | ||  | '   '  :  | | | \\__\\/: . . |   | |  | |    \r\n" + //
                            "'   :  '; |:  | : ;  ; |;  : |   |  |  ' | : ,\" .--.; | |   | |  |/     \r\n" + //
                            "|   |  | ; '  :  `--'   \\  , ;   |  :  :_:,'/  /  ,.  | |   | |--'      \r\n" + //
                            "|   :   /  :  ,      .-./---'    |  | ,'   ;  :   .'   \\|   |/          \r\n" + //
                            "|   | ,'    `--`----'            `--''     |  ,     .-./'---'           \r\n" + //
                            "`----'                                      `--`---'                    \r\n" + //
                            "    ,---,.                                                              \r\n" + //
                            "  ,'  .' |            ,-.----.                                          \r\n" + //
                            ",---.'   |            \\    /  \\   __  ,-.                               \r\n" + //
                            "|   |   .' ,--,  ,--, |   :    |,' ,'/ /|          .--.--.    .--.--.   \r\n" + //
                            ":   :  |-, |'. \\/ .`| |   | .\\ :'  | |' | ,---.   /  /    '  /  /    '  \r\n" + //
                            ":   |  ;/| '  \\/  / ; .   : |: ||  |   ,'/     \\ |  :  /`./ |  :  /`./  \r\n" + //
                            "|   :   .'  \\  \\.' /  |   |  \\ :'  :  / /    /  ||  :  ;_   |  :  ;_    \r\n" + //
                            "|   |  |-,   \\  ;  ;  |   : .  ||  | ' .    ' / | \\  \\    `. \\  \\    `. \r\n" + //
                            "'   :  ;/|  / \\  \\  \\ :     |`-';  : | '   ;   /|  `----.   \\ `----.   \\\r\n" + //
                            "|   |    \\./__;   ;  \\:   : :   |  , ; '   |  / | /  /`--'  //  /`--'  /\r\n" + //
                            "|   :   .'|   :/\\  \\ ;|   | :    ---'  |   :    |'--'.     /'--'.     / \r\n" + //
                            "|   | ,'  `---'  `--` `---'.|           \\   \\  /   `--'---'   `--'---'  \r\n" + //
                            "`----'                  `---`            `----'                         ");


        // input nama user
        System.out.print("Masukkan nama kamu: ");
        String name = scanner.nextLine();
        System.out.println("Halo, " + name + " selamat datang di Burhan Express");

        // class globalVar
        globalVar globalVar = new globalVar();
        
        // cekStatusPaket(scanner, globalVar);
        // hitungJumlahPaket(globalVar);
        // urutanStatusPaket(globalVar);
        // mencariNomorTrackingPaket(scanner, globalVar);


        // System.out.print("Berapa banyak paket yang ingin dipindahkan: ");
        // int n = scanner.nextInt();
        // scanner.nextLine();
        // pemindahanPaket(n,  'A', 'B', 'C');
        // System.out.println("Total langkah: " + totalPindah);
        mengantarPaket();
        review(scanner);
        scanner.close();

    }
    // variabel yang akan digunakan di berbagai method
    public static class globalVar{
        StringBuilder semuaStatus = new StringBuilder();
        int shippedTotal = 0;
        int inTransitTotal = 0;
        int deliveredTotal = 0;
        int paket = 1;
        int paketTotal(){
            return shippedTotal + inTransitTotal + deliveredTotal;
        }
    }

    // pengecekan status paket dan id paket menggunakan stringbuilder
    public static void cekStatusPaket(Scanner inputStatusPaket, globalVar globalVar) {
        System.out.print("Berapa jumlah paket yang ingin dicek statusnya? ");
        int paketTotal = inputStatusPaket.nextInt();
        inputStatusPaket.nextLine(); // buang newline
        int paket = 1;
        while (paket <= paketTotal) {
            System.out.print("Masukkan status paket " + paket + " (Shipped, In Transit, Delivered): ");
            String status = inputStatusPaket.nextLine();

            if (status.equalsIgnoreCase("Shipped")) {
                globalVar.shippedTotal++;  
                globalVar.semuaStatus.append("BRN")
                    .append(String.format("%06d", 100000 + paket))
                    .append(status).append(","); 
                paket++;
            } else if (status.equalsIgnoreCase("In Transit")) {
                    globalVar.inTransitTotal++;
                    globalVar.semuaStatus.append("BRN")
                        .append(String.format("%06d", 100000 + paket))
                        .append(status).append(","); 
                    paket++;
            } else if (status.equalsIgnoreCase("Delivered")) {
                    globalVar.deliveredTotal++;
                    globalVar.semuaStatus.append("BRN")
                        .append(String.format("%06d", 100000 + paket))
                        .append(status).append(",");
                    paket++;
            } else {
                    System.out.println("Status tidak valid, silakan ulangi.");
                    
            }
        }
    }
    // menghitung jumlah paket
    public static void hitungJumlahPaket(globalVar globalVar){
        System.out.println("===== RINGKASAN STATUS PAKET =====");
        System.out.println("- \u2192 Jumlah paket dengan status Shipped: " + globalVar.shippedTotal);
        System.out.println("- \u23F3 Jumlah paket dengan status In Transit: " + globalVar.inTransitTotal);
        System.out.println("- \u2714 Jumlah paket dengan status Delivered: " + globalVar.deliveredTotal);
        System.out.println("Total paket yang dicek: " + globalVar.paketTotal());
        
    }


    // urutan status paket   
   public static void urutanStatusPaket(globalVar globalvar){
        String text = globalvar.semuaStatus.toString();

    // delivered
    int i = 0;
    while (i < text.length()) {
        int start = text.indexOf("BRN", i);
        if (start == -1) break;
        int end = text.indexOf(",", start);
        if (end == -1) end = text.length();

        String idStr = text.substring(start, start + 9); // BRNxxxxxx
        String status = text.substring(start + 9, end).trim();

        if (status.equalsIgnoreCase("Delivered")) {
            System.out.println("- ✔ " + idStr + " (" + status + ")");
        }

        i = end + 1;
    }

    // in transit
    i = 0;
    while (i < text.length()) {
        int start = text.indexOf("BRN", i);
        if (start == -1) break;
        int end = text.indexOf(",", start);
        if (end == -1) end = text.length();

        String idStr = text.substring(start, start + 9);
        String status = text.substring(start + 9, end).trim();

        if (status.equalsIgnoreCase("In Transit")) {
            System.out.println("- ⏳ " + idStr + " (" + status + ")");
        }

        i = end + 1;
    }

    // shipped
    i = 0;
    while (i < text.length()) {
        int start = text.indexOf("BRN", i);
        if (start == -1) break;
        int end = text.indexOf(",", start);
        if (end == -1) end = text.length();

        String idStr = text.substring(start, start + 9);
        String status = text.substring(start + 9, end).trim();

        if (status.equalsIgnoreCase("Shipped")) {
            System.out.println("- → " + idStr + " (" + status + ")");
        }

        i = end + 1;
    }
   }

    // mencari nomor tracking paket
    public static void mencariNomorTrackingPaket(Scanner scanner, globalVar globalVar){
        boolean loopFindPaket = true;
        while (loopFindPaket) {
            System.out.print("Masukkan nomor tracking: ");
            String inputNumTrack = scanner.nextLine();

            boolean foundNumTrack = false;
            for (int trackingNumber = 0; trackingNumber < globalVar.paketTotal(); trackingNumber++) {
                String numberOfTracking = "BRN" + String.format("%06d", 100001 + trackingNumber);

                if (inputNumTrack.equalsIgnoreCase(numberOfTracking)) {
                    int awal = 0;
                    int hitung = 0;
                    int akhir = globalVar.semuaStatus.length();
                    for (int status = 0; status < globalVar.semuaStatus.length(); status++) {
                        if (globalVar.semuaStatus.charAt(status) == ',') {
                            if (hitung == trackingNumber) {
                                akhir = status;
                                break;
                            }
                            hitung++;
                            awal = status + 1;
                        }
                    }
                    String status = globalVar.semuaStatus.substring(awal, akhir);

                    System.out.println("Paket ditemukan! Status paket: " + status);
                    foundNumTrack = true;
                    break;
                }
            }

            if (!foundNumTrack) {
                System.out.println("Paket dengan nomor tracking tersebut tidak ditemukan.");
            }

            System.out.print("Cari paket lain? (yes/no): ");
            String findAnotherPaket = scanner.nextLine();
            if (findAnotherPaket.equalsIgnoreCase("no")) {
                System.out.println("Terimakasih telah menggunakan layanan Burhan Express!");
                loopFindPaket = false;
            } else if (!findAnotherPaket.equalsIgnoreCase("yes")) {
                System.out.println("Input tidak valid! Keluar dari pencarian.");
                loopFindPaket = false;
            }

        }
    }

    // subtask 3
    public static int printBox(int n){ // menentukan paket ke berapa yang ingin dipindahkan
        if (n % 2 == 1) {return 1;}
        else if (n % 4 != 0) {return 2;}
        else if (n % 8 != 0) {return 3;}
        else {return 4;}
    }
    public static void pemindahanPaket(int n, char lemariAsal, char lemariAux, char lemariAkhir){
    if (n == 1) { // base case: jika paket di paket dalam 1 lemari, hanya ada 1
        totalPindah += 1;
        System.out.println("Pindahkan paket "+ printBox(totalPindah) +" dari " + lemariAsal + " ke " + lemariAkhir);
        
    } 
    else { // 
        pemindahanPaket(n - 1,lemariAsal, lemariAkhir, lemariAux);
        totalPindah ++;
        System.out.println("Pindahkan paket " + printBox(totalPindah) + " dari " + lemariAsal + " ke " + lemariAkhir);
        pemindahanPaket(n - 1 , lemariAux, lemariAsal, lemariAkhir);
        
    }

}

    // melakukan print mengantar paket tiap lantai menggunakan rekursif
    public static void mengantarPaket(){
        System.out.println("Masukkan jumlah lantai dalam gedung: ");
        int jumlahLantai = scanner.nextInt();
        int i = 1;
        int total = 0;
         System.out.println("Total paket sampai ke lantai ke-0: 0");
        while (i <= jumlahLantai) {
            total = total*2+1;
            System.out.println("Total paket sampai ke lantai ke-" + i + ": " + total);
            i++;
        }
    }

     // review
    public static void review(Scanner scanner){
        System.out.println("Apa review anda tentang Burhan Express? ");
        String review = scanner.nextLine();
        System.out.println("Terimakasih atas review anda: \"" + review + "\"");
    }
}        


