# ☕ Tunas Coffee

Tunas Coffee adalah aplikasi Android untuk pemesanan dan manajemen produk kopi. Aplikasi ini menyediakan antarmuka yang user-friendly untuk browsing produk kopi, manajemen akun pengguna, dan pemrosesan transaksi pemesanan.

## 📋 Daftar Isi
- [Fitur Utama](#fitur-utama)
- [Teknologi yang Digunakan](#teknologi-yang-digunakan)
- [Persyaratan Sistem](#persyaratan-sistem)
- [Instalasi](#instalasi)
- [Struktur Proyek](#struktur-proyek)
- [Konfigurasi](#konfigurasi)
- [Panduan Penggunaan](#panduan-penggunaan)
- [API Integration](#api-integration)
- [Kontribusi](#kontribusi)

## ✨ Fitur Utama

- **Autentikasi Pengguna**: Login, Sign Up, dan Forgot Password
- **Daftar Produk**: Menampilkan katalog produk kopi dengan kategori
- **Manajemen Transaksi**: Pemesanan dan riwayat transaksi
- **Manajemen Akun**: Update profil pengguna
- **Token Management**: Sistem JWT untuk autentikasi yang aman
- **Kategori Produk**: Organisasi produk berdasarkan kategori

## 🛠 Teknologi yang Digunakan

### Platform & Framework
- **Android SDK**: Target SDK 34, Min SDK 24
- **Java**: Version 21
- **Android Version**: Android 7.0+ (API level 24+)

### Dependencies Utama
- **AndroidX AppCompat**: `1.6.1` - Kompatibilitas ke versi Android lama
- **RecyclerView**: `1.3.2` - Untuk menampilkan list produk
- **ConstraintLayout**: `2.1.4` - UI layout yang fleksibel
- **Retrofit**: `2.9.0` - HTTP client untuk API calls
- **OkHttp**: `4.10.0` - Interceptor dan logging HTTP
- **JWT**: `4.4.0` - Authentication token management
- **Lifecycle**: `2.6.1` - Lifecycle awareness dan coroutines

## 📱 Persyaratan Sistem

- **Android SDK**: API Level 24 atau lebih tinggi (Android 7.0+)
- **Java**: JDK 21 atau lebih tinggi
- **Gradle**: Gradle 8.13.2 atau kompatibel
- **RAM Minimum**: 2GB

## 🚀 Instalasi

### 1. Clone Repository
```bash
git clone https://github.com/ramdanariadi/tunas-coffee
cd tunas-coffee
```

### 2. Setup Gradle
```bash
# Di Windows
./gradlew.bat clean build

# Di Linux/Mac
./gradlew clean build
```

### 3. Konfigurasi Android Studio
1. Buka project di Android Studio
2. Tunggu Gradle sync selesai
3. Koneksikan device Android atau buka emulator
4. Klik **Run** atau tekan `Shift + F10`

### 4. Build APK
```bash
# Debug APK
./gradlew assembleDebug

# Release APK (memerlukan signing key)
./gradlew assembleRelease
```

## 📁 Struktur Proyek

```
tunas-coffee/
├── src/main/
│   ├── java/id/tunas/coffee/
│   │   ├── MainActivity.java                    # Layar utama
│   │   ├── LoginActivity.java                   # Layar login
│   │   ├── SignUpActivity.java                  # Layar daftar
│   │   ├── ForgotPasswordActivity.java          # Reset password
│   │   ├── ListProductActivity.java             # Daftar produk
│   │   ├── SplashActivity.java                  # Splash screen
│   │   ├── adapter/                             # Adapters untuk RecyclerView
│   │   ├── service/                             # API Services
│   │   │   ├── RetrofitClient.java             # Konfigurasi Retrofit
│   │   │   ├── LoginApiService.java            # API Login
│   │   │   ├── UserApiService.java             # API User
│   │   │   ├── ProductApiService.java          # API Produk
│   │   │   ├── CategoryApiService.java         # API Kategori
│   │   │   ├── TransactionApiService.java      # API Transaksi
│   │   │   └── TokenManagement.java            # Manajemen JWT Token
│   │   └── dto/                                 # Data Transfer Objects
│   │       ├── Product.java
│   │       ├── User.java
│   │       └── api/                             # API Response Models
│   ├── res/
│   │   ├── layout/                              # XML Files untuk UI
│   │   ├── drawable/                            # Resources gambar
│   │   ├── values/                              # Strings, colors, styles
│   │   ├── mipmap/                              # App icons
│   │   └── xml/                                 # Config files (network security)
│   └── AndroidManifest.xml                      # Manifest aplikasi
├── build.gradle                                 # Gradle configuration
├── gradle.properties
├── local.properties                             # Local SDK path
└── README.md

```

## ⚙️ Konfigurasi

### 1. Network Security Configuration
File: `src/main/res/xml/network_security_config.xml`

Konfigurasi ini mengatur keamanan koneksi network HTTPS dan HTTP.

### 2. Retrofit Client Configuration
File: `src/main/java/id/tunas/coffee/service/RetrofitClient.java`

Ganti `BASE_URL` dengan endpoint API server Anda:
```java
private static final String BASE_URL = "http://localhost/api/";
```

### 3. Local Properties
File: `local.properties`

Pastikan path Android SDK sudah benar:
```properties
sdk.dir=C:\\Users\\YourUsername\\AppData\\Local\\Android\\Sdk
```

## 📖 Panduan Penggunaan

### 1. Splash Screen
Aplikasi dimulai dengan layar splash yang menampilkan logo aplikasi.

### 2. Login
- Masukkan email dan password
- Sistem akan mengvalidasi kredensial melalui API
- Token JWT disimpan untuk sesi autentikasi

### 3. Sign Up
- Isi form pendaftaran dengan data yang valid
- Konfirmasi password harus cocok
- Akun akan dibuat di server

### 4. Daftar Produk
- Tampilan semua produk kopi tersedia
- Filter berdasarkan kategori
- Klik produk untuk detail lebih lanjut

### 5. Transaksi
- Pilih produk dan jumlah
- Lakukan check-out
- Transaksi akan tercatat di riwayat

## 🔌 API Integration

Aplikasi ini menggunakan Retrofit untuk berkomunikasi dengan backend API.

### Available API Services

#### 1. LoginApiService
```java
POST /login              // Login user
POST /register           // Daftar user baru
POST /forgot-password    // Request reset password
```

#### 2. ProductApiService
```java
GET /products            // Semua produk
GET /products/{id}       // Detail produk
GET /products/category/{categoryId}  // Produk per kategori
```

#### 3. CategoryApiService
```java
GET /categories          // Semua kategori
GET /categories/{id}     // Detail kategori
```

#### 4. TransactionApiService
```java
POST /transactions       // Buat transaksi
GET /transactions        // Daftar transaksi user
GET /transactions/{id}   // Detail transaksi
```

#### 5. UserApiService
```java
GET /users/profile       // Data profil user (Auth required)
PUT /users/profile       // Update profil user
```

### Authentication
Semua endpoint kecuali login dan register memerlukan JWT Token:
```
Authorization: Bearer <your-jwt-token>
```

## 🤝 Kontribusi

Kami menerima kontribusi dari komunitas. Silakan:

1. Fork repository ini
2. Buat branch feature Anda (`git checkout -b feature/fitur-baru`)
3. Commit perubahan Anda (`git commit -m 'Add fitur baru'`)
4. Push ke branch (`git push origin feature/fitur-baru`)
5. Buka Pull Request

## 📝 Lisensi

Project ini belum memiliki lisensi resmi. Silakan hubungi pemilik project untuk informasi lebih lanjut.

## 📧 Kontak

Untuk pertanyaan atau saran, silakan hubungi tim development Tunas Coffee.

---

**Dibuat dengan ☕ oleh Tim Tunas Coffee**
