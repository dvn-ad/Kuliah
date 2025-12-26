import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LibraryManager {
    private List<Book> books;

    public LibraryManager() {
        this.books = new ArrayList<>();
    }

    // Create
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Buku berhasil ditambahkan.");
    }

    // Read
    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("Tidak ada buku di perpustakaan.");
        } else {
            System.out.println("Daftar Buku:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public Book findBookById(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    // Update
    public void updateBook(String id, String newTitle, String newAuthor, int newYear) {
        Book book = findBookById(id);
        if (book != null) {
            book.setTitle(newTitle);
            book.setAuthor(newAuthor);
            book.setYear(newYear);
            System.out.println("Buku berhasil diperbarui.");
        } else {
            System.out.println("Buku dengan ID " + id + " tidak ditemukan.");
        }
    }

    // Delete
    public void deleteBook(String id) {
        Book book = findBookById(id);
        if (book != null) {
            books.remove(book);
            System.out.println("Buku berhasil dihapus.");
        } else {
            System.out.println("Buku dengan ID " + id + " tidak ditemukan.");
        }
    }
}
