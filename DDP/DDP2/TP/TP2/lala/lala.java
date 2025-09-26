import java.util.Scanner;

public class lala {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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


        System.out.print("Masukkan nama kamu: ");
        String name = scanner.nextLine();
        System.out.println("Halo, " + name + " selamat datang di Burhan Express");
        globalVar globalVar = new globalVar();
        cekStatusPaket(scanner, globalVar);
        hitungJumlahPaket(globalVar);
        urutanStatusPaket(globalVar);
        mencariNomorTrackingPaket(scanner, globalVar);
        review(scanner);
        scanner.close();
    }

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

    // sub task 2
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
    // sub task 3
    public static void hitungJumlahPaket(globalVar globalVar){
        System.out.println("===== RINGKASAN STATUS PAKET =====");
        System.out.println("- \u2192 Jumlah paket dengan status Shipped: " + globalVar.shippedTotal);
        System.out.println("- \u23F3 Jumlah paket dengan status In Transit: " + globalVar.inTransitTotal);
        System.out.println("- \u2714 Jumlah paket dengan status Delivered: " + globalVar.deliveredTotal);
        System.out.println("Total paket yang dicek: " + globalVar.paketTotal());
        
    }

   public static void urutanStatusPaket(globalVar globalvar){
        String text = globalvar.semuaStatus.toString();

    // Pass 1: Delivered
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

    // Pass 2: In Transit
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

    // Pass 3: Shipped
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

    // sub task 4
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

     // task 6
    public static void review(Scanner scanner){
        System.out.println("Apa review anda tentang Burhan Express? ");
        String review = scanner.nextLine();
        System.out.println("Terimakasih atas review anda: \"" + review + "\"");
    }
}       