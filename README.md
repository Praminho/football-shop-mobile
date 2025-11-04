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


## Getting Started

This project is a starting point for a Flutter application.

A few resources to get you started if this is your first Flutter project:

- [Lab: Write your first Flutter app](https://docs.flutter.dev/get-started/codelab)
- [Cookbook: Useful Flutter samples](https://docs.flutter.dev/cookbook)

For help getting started with Flutter development, view the
[online documentation](https://docs.flutter.dev/), which offers tutorials,
samples, guidance on mobile development, and a full API reference.
