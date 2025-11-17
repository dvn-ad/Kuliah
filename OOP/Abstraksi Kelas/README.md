# Soal 1: Hierarki Makhluk Hidup (LivingBeing)

Proyek ini adalah sebuah contoh implementasi konsep **Pewarisan (Inheritance)** dan **Polimorfisme** dalam Pemrograman Berorientasi Objek (OOP). Tujuannya adalah untuk membangun sebuah hierarki kelas yang merepresentasikan berbagai jenis makhluk hidup, mulai dari yang paling umum (`LivingBeing`) hingga yang paling spesifik (seperti `Doctor`, `Programmer`, `Dog`, dll).

## Struktur dan Hierarki Kelas

Hierarki kelas dalam proyek ini dirancang sebagai berikut:

```
LivingBeing (abstract)
├── Animal (abstract)
│   ├── Human (abstract)
│   │   ├── Doctor (concrete)
│   │   └── Programmer (concrete)
│   ├── Dog (concrete)
│   └── Bird (concrete)
└── Plant (abstract)
    ├── FloweringPlant (concrete)
    └── NonFloweringPlant (concrete)

```

### 1. `LivingBeing.java`

- **Peran:** Kelas dasar (akar) yang paling abstrak.
- **Tujuan:** Mendefinisikan karakteristik paling fundamental dari semua makhluk hidup, seperti `breath()` (bernafas) dan `eat()` (makan).

### 2. `Animal.java` dan `Plant.java`

- **Peran:** Turunan langsung dari `LivingBeing`, membagi makhluk hidup menjadi dua kerajaan.
- **Tujuan:**
    - `Animal`: Mendefinisikan sifat umum hewan, seperti kemampuan untuk bergerak (`move`).
    - `Plant`: Mendefinisikan sifat umum tumbuhan.

### 3. Turunan dari `Animal`

- **`Human.java`**:
    - **Peran:** Kelas abstrak turunan dari `Animal`.
    - **Tujuan:** Menambahkan atribut dan perilaku spesifik manusia, seperti `name` (nama) dan metode `work()`.
- **`Doctor.java` dan `Programmer.java`**:
    - **Peran:** Kelas konkret turunan dari `Human`.
    - **Tujuan:** Merepresentasikan spesialisasi (profesi) dan memberikan implementasi unik untuk metode `work()`. `Doctor` "menyembuhkan orang", sedangkan `Programmer` "menulis kode".
- **`Dog.java` dan `Bird.java`**:
    - **Peran:** Kelas konkret turunan dari `Animal`.
    - **Tujuan:** Memberikan implementasi spesifik untuk perilaku hewan. `Dog` bergerak dengan "berlari", `Bird` bergerak dengan "terbang".

### 4. Turunan dari `Plant`

- **`FloweringPlant.java` dan `NonFloweringPlant.java`**:
    - **Peran:** Kelas konkret turunan dari `Plant`.
    - **Tujuan:** Merepresentasikan jenis tumbuhan yang lebih spesifik dengan perilaku yang berbeda.

### 5. `Main.java`

- **Peran:** Titik masuk program (entry point).
- **Tujuan:** Mendemonstrasikan konsep polimorfisme. Kelas ini membuat objek dari berbagai kelas konkret (`Doctor`, `Dog`, `Bird`, dll.) dan memanggil metode yang sama pada objek-objek tersebut untuk menunjukkan bahwa setiap objek memberikan respons yang berbeda sesuai dengan kelasnya masing-masing.

## Konsep OOP yang Ditunjukkan

- **Inheritance (Pewarisan):** Terlihat jelas dari struktur kelas yang bertingkat, di mana kelas anak mewarisi sifat dan metode dari kelas induknya (misalnya, `Doctor` adalah `Human`, yang juga adalah `Animal`, dan akhirnya `LivingBeing`).
- **Polymorphism:** Ditunjukkan di kelas `Main`, di mana pemanggilan metode yang sama (misalnya `work()` atau `move()`) pada objek dari kelas yang berbeda menghasilkan perilaku yang berbeda.
- **Abstraction:** Penggunaan kelas `abstract` (`LivingBeing`, `Animal`, `Plant`, `Human`) untuk mendefinisikan konsep umum tanpa harus membuat objek dari konsep tersebut.

## Screenshot

![image.png](https://www.notion.so/image/attachment%3A1df9ff48-5b21-4ba0-ba49-4eb238efc4cd%3Aimage.png?table=block&id=2aeb08d2-28e2-806b-89e4-d95ef38f25ed&spaceId=df288384-cefa-4600-bf26-62945660eae2&width=1420&userId=&cache=v2)

# Soal 2: Foxes and Rabbit

Proyek ini adalah sebuah simulasi ekosistem sederhana yang melibatkan dua jenis hewan: Rubah (predator) dan Kelinci (mangsa) dalam sebuah area/lapangan (field). Simulasi ini menunjukkan bagaimana populasi kedua hewan tersebut berubah seiring waktu karena proses seperti berkembang biak, makan, dan kematian.

### Struktur Project

Proyek ini terdiri dari beberapa kelas Java, masing-masing dengan tanggung jawab spesifik:

### 1. `Simulator.java`

- **Tujuan:** Kelas utama yang menginisialisasi simulasi, menjalankan langkah-langkah simulasi secara berulang, dan mengontrol jalannya program.
- **Cara Kerja (Sekilas Kode):**
    - Membuat objek `Field` sebagai area simulasi.
    - Membuat dan menempatkan populasi awal dari `Fox` dan `Rabbit` di lokasi acak di dalam `Field`.
    - Memiliki sebuah *loop* utama yang menjalankan simulasi langkah demi langkah.
    - Dalam setiap langkah, memanggil metode `act()` dari setiap hewan untuk menentukan perilaku mereka (bergerak, berkembang biak, makan).
    - Menampilkan status lapangan atau populasi ke konsol setelah setiap langkah.

### 2. `Field.java`

- **Tujuan:** Merepresentasikan lapangan atau grid 2D tempat para hewan hidup dan mengelola data tentang posisi setiap hewan.
- **Cara Kerja (Sekilas Kode):**
    - Menggunakan array 2D (misalnya `Object[][] field`) untuk menyimpan referensi ke objek `Animal` di setiap sel grid.
    - Menyediakan metode untuk menempatkan hewan (`place`), mendapatkan hewan di lokasi tertentu (`getObjectAt`), mengosongkan lokasi (`clear`), dan menemukan lokasi kosong di sekitar (`getFreeAdjacentLocations`).

### 3. `Location.java`

- **Tujuan:** Kelas sederhana yang merepresentasikan koordinat (baris dan kolom) di dalam `Field`.
- **Cara Kerja (Sekilas Kode):**
    - Memiliki dua atribut integer: `row` (baris) dan `col` (kolom).
    - Konstruktor untuk menginisialisasi nilai `row` dan `col`.
    - Metode *getter* untuk mendapatkan nilai `row` dan `col`.

### 4. `Animal.java`

- **Tujuan:** Kelas abstrak yang menjadi dasar (induk) bagi kelas `Fox` dan `Rabbit`, mendefinisikan properti dan perilaku umum yang dimiliki oleh semua hewan.
- **Cara Kerja (Sekilas Kode):**
    - Merupakan kelas `abstract` karena tidak ada objek "Animal" generik yang dibuat.
    - Memiliki atribut umum seperti `age` (usia), `alive` (status hidup/mati), dan `location` (posisi).
    - Mendefinisikan sebuah metode abstrak `act(newAnimals)`, yang akan diimplementasikan secara spesifik oleh `Fox` dan `Rabbit`.

### 5. `Fox.java`

- **Tujuan:** Merepresentasikan hewan Rubah dan mendefinisikan perilaku spesifiknya sebagai predator.
- **Cara Kerja (Sekilas Kode):**
    - Merupakan *subclass* dari `Animal`.
    - Memiliki atribut tambahan seperti `foodLevel` (tingkat kelaparan).
    - Implementasi metode `act()` mencakup: bertambah tua, berkurangnya tingkat makanan (jika terlalu lapar akan mati), mencari dan memakan `Rabbit` di sekitar, bergerak ke lokasi kosong, dan berkembang biak.

### 6. `Rabbit.java`

- **Tujuan:** Merepresentasikan hewan Kelinci dan mendefinisikan perilaku spesifiknya sebagai mangsa.
- **Cara Kerja (Sekilas Kode):**
    - Merupakan *subclass* dari `Animal`.
    - Implementasi metode `act()` mencakup: bertambah tua (jika mencapai usia maksimal akan mati), berkembang biak jika sudah mencapai usia yang tepat, dan bergerak ke lokasi kosong di sekitarnya.

## Konsep OOP yang Digunakan

Proyek ini adalah contoh bagus dari konsep Object-Oriented Programming (OOP) seperti:

- **Inheritance (Pewarisan):** Kelas `Fox` dan `Rabbit` mewarisi properti dan perilaku umum dari kelas `Animal`.
- **Polymorphism:** Metode `act()` memiliki implementasi yang berbeda di kelas `Fox` dan `Rabbit`, sesuai dengan perilaku spesifik masing-masing hewan.
- **Abstraction:** Kelas `Animal` adalah kelas abstrak yang menyediakan kerangka umum tanpa detail implementasi spesifik.

## Screenshot

![image.png](https://www.notion.so/image/attachment%3A357080e4-c080-4bb2-b933-cf3e58e0770e%3Aimage.png?table=block&id=2aeb08d2-28e2-808a-8d18-c8d9bc011868&spaceId=df288384-cefa-4600-bf26-62945660eae2&width=1420&userId=&cache=v2)
