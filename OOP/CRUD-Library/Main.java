import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryManager libraryManager = new LibraryManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Sistem Manajemen Perpustakaan ===");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Lihat Semua Buku");
            System.out.println("3. Update Buku");
            System.out.println("4. Hapus Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Masukkan ID Buku: ");
                    String id = scanner.nextLine();
                    System.out.print("Masukkan Judul Buku: ");
                    String title = scanner.nextLine();
                    System.out.print("Masukkan Penulis: ");
                    String author = scanner.nextLine();
                    System.out.print("Masukkan Tahun Terbit: ");
                    int year = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    
                    Book newBook = new Book(id, title, author, year);
                    libraryManager.addBook(newBook);
                    break;
                case 2:
                    libraryManager.listBooks();
                    break;
                case 3:
                    System.out.print("Masukkan ID Buku yang akan diupdate: ");
                    String updateId = scanner.nextLine();
                    if (libraryManager.findBookById(updateId) != null) {
                        System.out.print("Masukkan Judul Baru: ");
                        String newTitle = scanner.nextLine();
                        System.out.print("Masukkan Penulis Baru: ");
                        String newAuthor = scanner.nextLine();
                        System.out.print("Masukkan Tahun Terbit Baru: ");
                        int newYear = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        
                        libraryManager.updateBook(updateId, newTitle, newAuthor, newYear);
                    } else {
                        System.out.println("Buku tidak ditemukan.");
                    }
                    break;
                case 4:
                    System.out.print("Masukkan ID Buku yang akan dihapus: ");
                    String deleteId = scanner.nextLine();
                    libraryManager.deleteBook(deleteId);
                    break;
                case 5:
                    running = false;
                    System.out.println("Terima kasih telah menggunakan aplikasi ini.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
        scanner.close();
    }
}
