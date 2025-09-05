JUnit digunakan sebagai test runner utama.
cucumber-java Inti dari Cucumber untuk Java. Sedangkan cucumber-junit digunakan Integrasi antara Cucumber dan JUnit, agar skenario Cucumber bisa dijalankan seperti tes JUnit biasa.
Selenium WebDriver adalah Library untuk otomatisasi browser.
Logging digunakan untuk mencatat log saat pengujian berjalan. Ini sangat membantu untuk debugging.
Hamcrest adalah Library untuk membuat assertions (pengecekan hasil) yang lebih mudah dibaca dan deskriptif.
Berikut adalah rincian dari setiap skenario:
1. Scenario Verify Home Page Loads Correctly: Tujuan untuk memastikan semua elemen kunci di halaman utama (link Login, link Sign up, dan carousel gambar) berhasil dimuat dan terlihat oleh user saat pertama kali membuka situs.
2. Scenario Navigate to Login page: Tujuan untuk memverifikasi fungsi navigasi dasar, yaitu memastikan user dapat pindah dari halaman utama ke halaman login dengan mengklik link Login yang tersedia.
3. Scenario Login with invalid credentials: Ini adalah skenario pengujian negatif untuk memeriksa bagaimana sistem menangani input yang salah. Skenario ini memastikan pesan error yang tepat (Wrong password.) muncul saat user mencoba login dengan credentials yang tidak valid.
4. Scenario Login with very long username (conceptual boundary test) Ini adalah contoh pengujian boundary. Tujuannya adalah untuk melihat bagaimana sistem merespons input yang ekstrem atau tidak biasa, seperti nama user yang sangat panjang. Ini membantu mengidentifikasi potensi error pada validasi input di sisi server atau client.
