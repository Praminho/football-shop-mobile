import 'package:flutter/material.dart';
import 'package:football_shop/screens/login.dart';
import 'package:football_shop/widgets/left_drawer.dart';
import 'package:football_shop/screens/product_entry_list.dart';
import 'package:football_shop/screens/productlist_form.dart';
import 'package:pbp_django_auth/pbp_django_auth.dart';
import 'package:provider/provider.dart';

class ItemHomepage {
  final String name;
  final IconData icon;
  final Color color;

  ItemHomepage(this.name, this.icon, this.color);
}

class MyHomePage extends StatelessWidget {
  MyHomePage({super.key});

  final String nama = "Prama Ardend Narendradhipa";
  final String npm = "2406439066";
  final String kelas = "F";

  final List<ItemHomepage> items = [
    ItemHomepage("All Products", Icons.menu_rounded, Colors.blue),
    ItemHomepage("My Products", Icons.person, Colors.green),
    ItemHomepage("Create Products", Icons.my_library_add, Colors.red),
    ItemHomepage("Logout", Icons.my_library_add, Colors.purple),
    
  ];

  @override
  Widget build(BuildContext context) {
    final request = context.watch<CookieRequest>();
    return Scaffold(
      appBar: AppBar(
        title: const Text(
          'Fisik Football',
          style: TextStyle(
            color: Colors.white,
            fontWeight: FontWeight.bold,
          ),
        ),
        backgroundColor: Colors.orange,
        iconTheme: const IconThemeData(color: Colors.white),
      ),
      drawer: const LeftDrawer(),
      body: Column(
        crossAxisAlignment: CrossAxisAlignment.center,
        children: [
          // Info cards dan welcome text dapat ditambahkan di sini sesuai kebutuhan
          Padding(
            padding: const EdgeInsets.symmetric(vertical: 24, horizontal: 16),
            child: Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: items.map((item) {
                return Expanded(
                  child: Padding(
                    padding: const EdgeInsets.symmetric(horizontal: 8),
                    child: Material(
                      color: item.color,
                      borderRadius: BorderRadius.circular(12),
                      child: InkWell(
                        onTap:() async {
                          if (item.name == "All Products") {
                            Navigator.push(
                              context,
                              MaterialPageRoute(
                                builder: (context) =>
                                  const ProductEntryListPage(onlyMine: false),
                              ),
                            );
                          } else if (item.name == "My Products") {
                            Navigator.push(
                              context,
                              MaterialPageRoute(
                                builder: (context) =>
                                  const ProductEntryListPage(onlyMine: true),
                              ),
                            );
                          } else if (item.name == "Logout") {
                            final response = await request.logout(
                                  "http://localhost:8000/auth/logout/");
                              String message = response["message"];
                              if (context.mounted) {
                                  if (response['status']) {
                                      String uname = response["username"];
                                      ScaffoldMessenger.of(context).showSnackBar(SnackBar(
                                          content: Text("$message See you again, $uname."),
                                      ));
                                      Navigator.pushReplacement(
                                          context,
                                          MaterialPageRoute(builder: (context) => const LoginPage()),
                                      );
                                  } else {
                                      ScaffoldMessenger.of(context).showSnackBar(
                                          SnackBar(
                                              content: Text(message),
                                          ),
                                      );
                                  }
                              }
                            }else {
                            Navigator.push(
                              context,
                              MaterialPageRoute(
                                builder: (context) =>
                                  const ProductFormPage(),
                              ),
                            );

                          }
                        },
                        child: SizedBox(
                          height: 220,
                          child: Column(
                            mainAxisAlignment: MainAxisAlignment.center,
                            children: [
                              Icon(item.icon, color: Colors.white, size: 48),
                              const SizedBox(height: 18),
                              Text(
                                item.name,
                                style: const TextStyle(
                                  color: Colors.white,
                                  fontSize: 18,
                                  fontWeight: FontWeight.bold,
                                ),
                              ),
                            ],
                          ),
                        ),
                      ),
                    ),
                  ),
                );
              }).toList(),
            ),
          ),
        ],
      ),
    );
  }
}
