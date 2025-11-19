# football_shop

A new Flutter project.


## Tugas 7
1.  Jelaskan apa itu widget tree pada Flutter dan bagaimana hubungan parent-child (induk-anak) bekerja antar widget.

    Widget tree adalah bentuk representasi logikal yang berdasar dari widget UI. Widget ini dibuat dengan penggunaan layout dalam rendering hingga dapat dilakukan melalui event contohnya sentuhan jari (karena di mobile). Bentuk pohon pada widget dimaksudkan untuk hubungan masing-masing bagian antar satu dengan yang lain secara parent-child.

    Parent-child adalah konsep dimana parent menjadi dasar widget utama, sementara child yang berhubungan dengan widget parent memiliki widgetnya. Singkatnya parent menjadi "pembungkus" widget dari widget children. 

2.  Sebutkan semua widget yang kamu gunakan dalam proyek ini dan jelaskan fungsinya.

    Terdapat 3 widget utama pada proyek ini

    a. Scaffold
    Widget ini berfungsi sebagai dasar dari widget lainnya. Fungsi utamanya adalah memberikan judul aplikasi, membentuk latar belakang, membentuk banyaknya infocard, dan menyusun ukuran dari widget utama

    b. Card
    Membentuk card baru di bagian bawah sebagai tombol yang dapat ditekan oleh pengguna

    c. Material
    Widget ini berfokus pada interaksi dengan user contohnya seperti menunjukkan snackbar ketika ditekan dan di sisi lain membantu mengeset warna background.

3.  Apa fungsi dari widget MaterialApp? Jelaskan mengapa widget ini sering digunakan sebagai widget root.

    Selain widget root, widget ini dapat berfungsi sebagai pembuat warna utama dari background. Pada kasus ini saya menggunakan warna orange.

4.  Jelaskan perbedaan antara StatelessWidget dan StatefulWidget. Kapan kamu memilih salah satunya?

    Stateless widget 
    Seperti namanya memiliki bentuk yang tidak bisa berubah. Widget ini dapat digunakan ketika ingin membentuk widget yang tidak akan berubah contohnya pada tugas ini seperti widget nama, npm, dan kelas

    Stateful Widget
    Berbeda dengan stateless, stateful dapat berubah seiring adanya perubahan tampilan berdasarkan input user. Contoh penggunaannya adalah jika ingin melakukan perubahan data melalui interface user.

    Penggunaan stateless digunakan untuk data yang tidak akan dirubah sementara stateful akan digunakan ketika terdapat bagian yang bisa dirubah tanpa harus diedit kodenya

5.  Apa itu BuildContext dan mengapa penting di Flutter? Bagaimana penggunaannya di metode build?

    Buildcontext berfungsi sebagai objek yang merepresentasikan posisi sebuah widget dalam widget tree. Hal ini penting karena Buildcontext dapat menghubungkan widget dengan parentnya agar data dari parent dapat diakses.

    penggunaannya dengan metode build adalah menghubungkan tiap widget dengan parentnya, contohnya di menu.dart menghubungkan widget MyHomePage, Card, dan Material. Perannya seperti denah yang menunjuk arah ke tiap widget.

6.  Jelaskan konsep "hot reload" di Flutter dan bagaimana bedanya dengan "hot restart".

    Konsep hot reload di flutter adalah ketika kode di load, diganti melalui VM `dan di rebuild melalui widget tree tanpa melakukan run main() atau initState()`

    Konsep hot restart di flutter adalah ketika kode di load dan diganti melalui VM `dan melakukan restart aplikasi flutter dan menghilangkan state aplikasi.`

## Tugas 8
1.  Jelaskan perbedaan antara Navigator.push() dan Navigator.pushReplacement() pada Flutter. Dalam kasus apa sebaiknya masing-masing digunakan pada aplikasi Football Shop kamu?

    Navigator.push() adalah method yang menambahkan suatu route dalam stack yang dikelola oleh navigator. Route ini akan ditambahkan ke paling atas stack sehingga route yang baru ditambahkan langsung muncul ke pengguna. Contoh penggunaannya adalah pada product card yang akan terus menambah card baru tanpa mengganti yang sudah di simpan sebelumnya

    Navigator.pushReplacement() adalah method yang cara kerjanya mirip dengan push, bedanya jika push biasa hanya akan menambahkan yang baru, pushReplacement akan mengganti route sebelumnya dengan route terbaru. Contohnya adalah pada tombol home di drawer yang mengembalikan ke home tanpa memencet "back"

2. Bagaimana kamu memanfaatkan hierarchy widget seperti Scaffold, AppBar, dan Drawer untuk membangun struktur halaman yang konsisten di seluruh aplikasi?

    Scaffold digunakan sebagai rangka dari halaman yang ada di `menu.dart`. `productlist_form.dart` digunakan untuk struktur design standar `appBar`, `body`, dan `endDrawer`. Appbar dan drawer menjadi menu navigasi yang diatur scaffold.

3. Dalam konteks desain antarmuka, apa kelebihan menggunakan layout widget seperti Padding, SingleChildScrollView, dan ListView saat menampilkan elemen-elemen form? Berikan contoh penggunaannya dari aplikasi kamu.

    Padding membantu user untuk lebih dapat membaca berbagai fitur dengan menggunakan "jarak". Hal ini dilakukan agar fitur fitur tersebut tidak berdempetan atau menempel satu sama lain

    SingleChildScrollView berfungsi sebagai form yang perlu melakukan scroll yang banyak. Konsepnya konten yang panjang ketika di scroll saat melebihi ukuran layar dapat dicegah overvlow error pada layar kecil. Fitur ini diimplementasikan pada semua input fields yang mencakup nama, harga, deskripsi, kategori, thumbnail, dan sebagainya. Hal ini memastikan user dapat mengakses semua field meskipun tinggi konten melebihi tinggi layar.

    ListView berguna untuk menampilkan list item yang panjang hingga perlu discroll. ListView digunakan di drawer agar header dan tiap ListTiledapat discroll dengan ukuran layar yang terbatas.

4. Bagaimana kamu menyesuaikan warna tema agar aplikasi Football Shop memiliki identitas visual yang konsisten dengan brand toko?
   
    Saya menggunakan warna orange untuk toko yang saya ubah di main.dart 
   
    ```             colorScheme: ColorScheme.fromSwatch(primarySwatch: Colors.orange)
          .copyWith(
            primary: Colors.orange[700],
            secondary: Colors.orangeAccent[400],
          )
    ```

   Hal ini membuat widget widget lain mengikuti warna orange ini 

## Tugas 9
1. Jelaskan mengapa kita perlu membuat model Dart saat mengambil/mengirim data JSON? Apa konsekuensinya jika langsung memetakan Map<String, dynamic> tanpa model (terkait validasi tipe, null-safety, maintainability)?

    Membuat model Dart saat mengambil/mengirim data JSON sangat penting karena memberikan type safety dan null safety yang ketat. Tanpa model, kita hanya bekerja dengan Map<String, dynamic> yang bersifat dynamic dan kehilangan semua manfaat sistem tipe Dart yang menyebabkan runtime errors yang sulit di-debug karena tidak ada validasi tipe saat compile-time. Model juga memungkinkan autocompletion, compile-time exceptions, dan validasi data di awal sehingga widget tidak perlu menangani data invalid. Dari sisi maintainability, model membuat kode lebih mudah dipahami dan dimodifikasi karena merepresentasikan objek dunia nyata dengan struktur yang jelas, dibanding map yang strukturnya tidak terdefinisi dan rawan typo.

2. Apa fungsi package http dan CookieRequest dalam tugas ini? Jelaskan perbedaan peran http vs CookieRequest.
    Package http adalah library standar untuk melakukan HTTP request (GET, POST, dll) di Flutter, namun tidak menangani cookies dan session management secara otomatis. Sebaliknya, CookieRequest (biasanya dari package pbp_django_auth) dirancang khusus untuk integrasi Flutter-Django dengan kemampuan menyimpan dan mengirim cookies/session secara otomatis di setiap request. Package http hanya mengirim request dan menerima response tanpa menyimpan state, sementara CookieRequest memelihara session sehingga Django bisa mengenali user yang sudah login tanpa perlu mengirim credentials berulang kali.

3. Jelaskan mengapa instance CookieRequest perlu untuk dibagikan ke semua komponen di aplikasi Flutter.
    Instance CookieRequest perlu dibagikan ke semua komponen Flutter menggunakan state management seperti Provider agar session dan cookies konsisten di seluruh aplikasi. Jika setiap komponen membuat instance sendiri, maka cookies tidak akan tershare—artinya komponen A bisa logout tapi komponen B masih menganggap user login, atau setiap komponen harus login ulang. Dengan ChangeNotifierProvider atau MultiProvider, kita bisa membungkus CookieRequest di root app dan semua widget di bawahnya bisa mengakses instance yang sama, memastikan state authentication sinkron dan efisien tanpa rebuild tidak perlu.
    
4. Jelaskan konfigurasi konektivitas yang diperlukan agar Flutter dapat berkomunikasi dengan Django. Mengapa kita perlu menambahkan 10.0.2.2 pada ALLOWED_HOSTS, mengaktifkan CORS dan pengaturan SameSite/cookie, dan menambahkan izin akses internet di Android? Apa yang akan terjadi jika konfigurasi tersebut tidak dilakukan dengan benar?
    Untuk komunikasi Flutter-Django, kita perlu menambahkan 10.0.2.2 ke ALLOWED_HOSTS karena itu adalah IP khusus Android emulator untuk mengakses localhost komputer host (127.0.0.1 tidak berfungsi di emulator). CORS (django-cors-headers) harus diaktifkan agar Django menerima request dari origin berbeda (Flutter app domain berbeda dengan Django backend). Pengaturan SameSite=None dan Secure pada cookies diperlukan jika menggunakan HTTPS atau cross-origin request, plus izin internet di AndroidManifest.xml harus ditambahkan agar aplikasi bisa akses jaringan. Jika konfigurasi tidak benar: ALLOWED_HOSTS salah akan return HTTP 400 Bad Request, CORS tidak aktif akan block request dengan CORS error, dan izin internet tidak ada akan gagal koneksi sama sekali.

5. Jelaskan mekanisme pengiriman data mulai dari input hingga dapat ditampilkan pada Flutter.
    - Mekanisme dimulai dari input user di Flutter (form, TextField, dll) yang datanya dikumpulkan sebagai Map atau object model, 
    
    - Selanjutnya dikirim via CookieRequest.post() atau http.post() dengan encoding JSON ke endpoint Django. 
    
    - Django menerima request di views.py, memproses data (validasi, simpan ke database via models), dan return response JSON. 
    
    - Flutter menerima response JSON, parse dari yang telah diedit oleh quicktype, lalu data ditampilkan di widget menggunakan widgetBuilder, setState(), atau Provider untuk update UI. 
    
    - Jika ada error (validasi gagal, server error), Django return status code error dan Flutter menangani dengan try-catch atau checking response status untuk menampilkan pesan error yang sesuai.​

6. Jelaskan mekanisme autentikasi dari login, register, hingga logout. Mulai dari input data akun pada Flutter ke Django hingga selesainya proses autentikasi oleh Django dan tampilnya menu pada Flutter.
    Login dan register
    - dimulai dari input pengguna yang memasukkan username dan password
    - untuk login data dikirim sebagai form data dan untuk register sebagai Json
    - django menerima request dan melakukan verifikasi. Login menggunakan fungsi authenticate() memverifikasi credential dan membuat session baru sementara register akan menyimpan obyek baru untuk disimpan di database
    - django akan mengirim respon sukses dan menghasilkan cookie dan disimpan agar status login menjadi true
    - flutter mengarahkan ke homepage

    Logout
    - fungsi ontap yang mengarah ke POST request ke endpoint /auth/logout/
    - sesi akan dihapus di database
    - cookie terhapus dan satus login menjadi false yang membuat navigasi diarahkan ke login page

7.  Jelaskan bagaimana cara kamu mengimplementasikan checklist di atas secara step-by-step! (bukan hanya sekadar mengikuti tutorial).
    - hal pertama melakukan install authentication di django yang berfungsi untuk memvalidasi register dan login di flutter dengan melakukan routing antar aplikasi
    - mengganti url menjadi localhost8000 agar berjalan di web
    - menambah field baru untuk masing-masing produk seperti name, price, content, dsbg
    - membuat beberapa direktori baru untuk display card, card detail, register, dan beberapa lainnya pada dart
    - melakukan setting pada direktori AndroidManifest.xml dengan menambah permission untuk akses ke internet


