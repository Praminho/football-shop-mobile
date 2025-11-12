import 'package:flutter/material.dart';
import 'package:football_shop/widgets/left_drawer.dart';

class ProductFormPage extends StatefulWidget {
    const ProductFormPage({super.key});

    @override
    State<ProductFormPage> createState() => _ProductFormPageState();
}

class _ProductFormPageState extends State<ProductFormPage> {
    final _formKey = GlobalKey<FormState>();
    String _title = "";
    int _price = 0;
    String _content = "";
    String _category = "atasan";
    String _thumbnail = "";
    bool _isFeatured = false;

    final List<String> _categories = [
      'atasan',
      'bawahan',
      'sepatu',
      'aksesoris',
    ];

    @override
    Widget build(BuildContext context) {
        return Scaffold(
          appBar: AppBar(
            title: const Center(
              child: Text(
                'Forum Menambah Produk',
              ),
            ),
            backgroundColor: Theme.of(context).colorScheme.primary,
            foregroundColor: Colors.white,
          ),
          drawer: const LeftDrawer(),
          body: Form(
            key: _formKey,
            child: SingleChildScrollView(
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: TextFormField(
                      decoration: InputDecoration(
                        hintText: "Nama Produk",
                        labelText: "Nama Produk",
                        border: OutlineInputBorder(
                          borderRadius: BorderRadius.circular(5.0),
                        ),
                      ),
                      onChanged: (String? value) {
                        setState(() {
                          _title = value!;
                        });
                      },
                      validator: (String? value) {
                        if (value == null || value.isEmpty) {
                          return "Nama Produk Tidak Boleh Kosong!";
                        }
                        if (value.length < 3) {
                          return "Nama Produk minimal 3 karakter!";
                        }
                        if (value.length > 100) {
                          return "Nama Produk maksimal 100 karakter!";
                        }
                        return null;
                      },
                    ),
                  ),

                  Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: TextFormField(
                      decoration: InputDecoration(
                        hintText: "Harga",
                        labelText: "Harga",
                        border: OutlineInputBorder(
                          borderRadius: BorderRadius.circular(5.0),
                        ),
                      ),
                      keyboardType: TextInputType.number,
                      onChanged: (String? value) {
                        setState(() {
                          _price = int.tryParse(value!) ?? 0;
                        });
                      },
                      validator: (String? value) {
                        if (value == null || value.isEmpty) {
                          return "Harga Produk Tidak Boleh Kosong!";
                        }
                        if (int.tryParse(value) == null) {
                          return "Harga Harus Dalam Angka Yang Valid!";
                        }
                        if (int.parse(value) < 0) {
                          return "Harga Tidak Boleh Negatif!";
                        }
                        if (int.parse(value) == 0) {
                          return "Harga Tidak Boleh 0!";
                        }
                        return null;
                      },
                    ),
                  ),

                  Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: TextFormField(
                      maxLines: 5,
                      decoration: InputDecoration(
                        hintText: "Isi Produk",
                        labelText: "Isi Produk",
                        border: OutlineInputBorder(
                          borderRadius: BorderRadius.circular(5.0),
                        ),
                      ),
                      onChanged: (String? value) {
                        setState(() {
                          _content = value!;
                        });
                      },
                      validator: (String? value) {
                        if (value == null || value.isEmpty) {
                          return "Isi Produk Tidak Boleh Kosong!";
                        }
                        if (value.length < 10) {
                          return "Deskripsi Produk minimal 10 karakter!";
                        }
                        if (value.length > 500) {
                          return "Deskripsi Produk maksimal 500 karakter!";
                        }
                        return null;
                      },
                    ),
                  ),

                  Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: DropdownButtonFormField<String>(
                      decoration: InputDecoration(
                        labelText: "Kategori",
                        border: OutlineInputBorder(
                          borderRadius: BorderRadius.circular(5.0),
                        ),
                      ),
                      value: _category,
                      items: _categories
                          .map((cat) => DropdownMenuItem(
                                value: cat,
                                child: Text(
                                    cat[0].toUpperCase() + cat.substring(1)),
                              ))
                          .toList(),
                      onChanged: (String? newValue) {
                        setState(() {
                          _category = newValue!;
                        });
                      },
                    ),
                  ),

                  Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: TextFormField(
                      decoration: InputDecoration(
                        hintText: "Thumbnail (opsional)",
                        labelText: "Thumbnail URL",
                        border: OutlineInputBorder(
                          borderRadius: BorderRadius.circular(5.0),
                        ),
                      ),
                      onChanged: (String? value) {
                        setState(() {
                          _thumbnail = value!;
                        });
                      },
                      validator: (String? value) {
                        if (value != null && value.isNotEmpty) {
                          // Validasi URL jika diisi
                          final urlPattern = RegExp(
                            r'^https?:\/\/.+\..+',
                            caseSensitive: false,
                          );
                          if (!urlPattern.hasMatch(value)) {
                            return "URL Thumbnail tidak valid! (harus dimulai dengan http:// atau https://)";
                          }
                        }
                        return null;
                      },
                    ),
                  ),

                  Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: SwitchListTile(
                      title: const Text("Tandai sebagai Produk Unggulan"),
                      value: _isFeatured,
                      onChanged: (bool value) {
                        setState(() {
                          _isFeatured = value;
                        });
                      },
                    ),
                  ),

                  Align(
                    alignment: Alignment.bottomCenter,
                    child: Padding(
                      padding: const EdgeInsets.all(8.0),
                      child: ElevatedButton(
                        style: ButtonStyle(
                          backgroundColor:
                              WidgetStateProperty.all(Theme.of(context).colorScheme.primary),
                        ),
                        onPressed: () {
                          if (_formKey.currentState!.validate()) {
                            showDialog(
                              context: context,
                              builder: (context) {
                                return AlertDialog(
                                  title: const Text('Produkmu Telah Disimpan!'),
                                  content: SingleChildScrollView(
                                    child: Column(
                                      crossAxisAlignment:
                                          CrossAxisAlignment.start,
                                      children: [
                                        Text('Judul: $_title'),
                                        Text('Harga: $_price'),
                                        Text('Isi: $_content'),
                                        Text('Kategori: $_category'),
                                        Text('Thumbnail: $_thumbnail'),
                                        Text(
                                            'Unggulan: ${_isFeatured ? "Ya" : "Tidak"}'),
                                      ],
                                    ),
                                  ),
                                  actions: [
                                    TextButton(
                                      child: const Text('OK'),
                                      onPressed: () {
                                        Navigator.pop(context);
                                        _formKey.currentState!.reset();
                                        setState(() {
                                          _title = "";
                                          _price = 0;
                                          _content = "";
                                          _category = "atasan";
                                          _thumbnail = "";
                                          _isFeatured = false;
                                        });
                                      },
                                    ),
                                  ],
                                );
                              },
                            );
                          }
                        },
                        child: const Text(
                          "Simpan",
                          style: TextStyle(color: Colors.white),
                        ),
                      ),
                    ),
                  ),
                ],
              ),
            ),
          ),
        );
    }
}