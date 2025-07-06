import entity.Book;
import entity.EBook;
import entity.PrintedBook;
import repository.ArrayBookRepository;
import repository.ArrayListBookRepository;
import repository.BookRepository;
import service.LibraryReportGenerator;
import service.LoanManager;
import service.filter.AuthorBookFilter;
import service.filter.AvailableBookFilter;
import service.filter.ColoredBookFilter;

import java.util.List;

public class Main {
    private List<String> getTitles(List<Book> books) {
        return books.stream()
                .map(Book::getTitle)
                .toList();
    }

    public static void main(String[] args) {
        // ----------------- Creando libros -----------------

        // Para ArrayListBookRepository
        Book book1 = new PrintedBook("LH46-02", "Aventura en el mar", "Juan Romero", 2025, "tapa dura", false);
        Book book2 = new EBook("CS24-12", "Patrones de diseño", "Carlos Ruiz", 2011, 5.64, "PDF");
        Book book3 = new PrintedBook("MF87-33", "Historias de la montaña", "Laura Méndez", 2018, "rústica", true);
        Book book4 = new EBook("TR09-58", "Introducción a la inteligencia artificial", "Carlos Ruiz", 2020, 3.21, "EPUB");
        Book book5 = new PrintedBook("BK10-75", "Cuentos del bosque encantado", "María Elena", 2005, "tapa blanda", false);
        Book book6 = new PrintedBook("XP55-19", "Viaje al centro de la Tierra", "Juan Romero", 2023, "tapa blanda", true);
        Book book7 = new EBook("DL33-77", "Aprendiendo Spring Boot", "Ana Torres", 2023, 2.48, "MOBI");
        Book book8 = new PrintedBook("QW88-42", "Relatos cortos", "Laura Méndez", 1998, "tapa dura", false);
        Book book9 = new EBook("ZT21-04", "Fundamentos de Python", "Elena García", 2019, 7.12, "PDF");
        Book book10 = new PrintedBook("MN67-53", "La selva misteriosa", "María Elena", 2015, "rústica", true);
        Book book11 = new PrintedBook("PL11-29", "Sombras en el bosque", "María Elena", 2008, "tapa dura", false);
        Book book12 = new EBook("TG22-60", "Spring Boot avanzado", "Ana Torres", 2024, 3.75, "PDF");
        Book book13 = new PrintedBook("CX39-81", "Expedición en la Antártida", "Juan Romero", 2021, "tapa blanda", true);
        Book book14 = new EBook("YU91-15", "Python para científicos", "Elena García", 2022, 6.30, "EPUB");
        Book book15 = new PrintedBook("RE55-90", "La ciudad sumergida", "Laura Méndez", 2017, "rústica", false);
        Book book16 = new EBook("VB70-36", "Diseño de patrones en Java", "Carlos Ruiz", 2015, 4.85, "MOBI");



        //Para ArrayBookRepository
        Book book17 = new EBook("GH21-90", "Dominios de la matemática", "Ricardo Salas", 2017, 4.56, "PDF");
        Book book18 = new PrintedBook("YU34-11", "El jardín secreto", "Frances Hodgson Burnett", 1911, "tapa dura", false);
        Book book19 = new EBook("OP78-66", "Desarrollo Ágil", "Sofía Martínez", 2022, 6.89, "EPUB");
        Book book20 = new PrintedBook("RT52-29", "Mitos y leyendas", "José Fernández", 2008, "rústica", true);
        Book book21 = new EBook("ZX49-03", "Redes neuronales profundas", "Marcos Vega", 2021, 8.34, "MOBI");


        // ----------------- Agregando libros al repositorio -----------------

        BookRepository listRepository = new ArrayListBookRepository();
        listRepository.addBook(book1);
        listRepository.addBook(book2);
        listRepository.addBook(book3);
        listRepository.addBook(book4);
        listRepository.addBook(book5);
        listRepository.addBook(book6);
        listRepository.addBook(book7);
        listRepository.addBook(book8);
        listRepository.addBook(book9);
        listRepository.addBook(book10);
        listRepository.addBook(book11);
        listRepository.addBook(book12);
        listRepository.addBook(book13);
        listRepository.addBook(book14);
        listRepository.addBook(book15);
        listRepository.addBook(book16);

        BookRepository arrRepository = new ArrayBookRepository();
        arrRepository.addBook(book17);
        arrRepository.addBook(book18);
        arrRepository.addBook(book19);
        arrRepository.addBook(book20);
        arrRepository.addBook(book21);

        // ----------------- Probando los demás métodos de repository -----------------

        System.out.println("----------------- Probando los demás métodos de repository -----------------");
        // Para ArrayListBookRepository

        System.out.println("\n -------- Para ArrayListBookRepository --------");
        List<Book> books = listRepository.getAllBooks();

        System.out.println("\nObteniendo todos los libros: \n" + books);
        System.out.println("Cantidad: " + books.size());

        System.out.println("\nBuscando el libro con el siguiente ISBN: LH46-02.\n" +
                listRepository.findBookByIsbn("LH46-02"));

        System.out.println("\nEliminando el libro ISBN: DL33-77. ");
        listRepository.removeBook("DL33-77");

        System.out.println("\nObteniendo todos los libros: " + books.size());

        // Para ArrayBookRepository
        System.out.println("\n -------- Para ArrayBookRepository --------");

        List<Book> arrbooks = arrRepository.getAllBooks();

        System.out.println("\nObteniendo todos los libros: \n" + arrbooks);
        System.out.println("Cantidad: " + arrbooks.size());

        System.out.println("\nBuscando el libro con el siguiente ISBN: OP78-66.\n" +
                arrRepository.findBookByIsbn("OP78-66"));

        System.out.println("\nEliminando el libro ISBN: OP78-66. ");
        arrRepository.removeBook("OP78-66");

        arrbooks = arrRepository.getAllBooks();

        System.out.println("\nObteniendo todos los libros: " + arrbooks.size() + "\n");

        // ----------------- Probando la capa service -----------------

        // LoanManager
        System.out.println("----------------- Probando LoanManager -----------------\n");

        LoanManager loanManager = new LoanManager(listRepository);

        System.out.println("Verificando disponibilidad del libro LH46-02: " + listRepository.findBookByIsbn("LH46-02").isAvailable());

        System.out.println("Prestando el libro con el ISBN: LH46-02");
        loanManager.loanBook("LH46-02");

        System.out.println("Verificando estado del libro LH46-02: " + listRepository.findBookByIsbn("LH46-02").isAvailable());

        System.out.println("\nRecibiendo el libro LH46-02");
        loanManager.returnBook("LH46-02");

        System.out.println("Estado: " +  listRepository.findBookByIsbn("LH46-02").isAvailable());

        // LibraryReportGenerator

        System.out.println("----------------- LibraryReportGenerator -----------------\n");

        LibraryReportGenerator reportGenerator = new LibraryReportGenerator(listRepository);

        System.out.println(reportGenerator.generateReport());

        System.out.println("---------");

        System.out.println(reportGenerator.generateFilteredReport(new AuthorBookFilter("Juan Romero")));

        System.out.println("---------");

        System.out.println(reportGenerator.generateFilteredReport(new AvailableBookFilter()));

        System.out.println("---------");

        System.out.println(reportGenerator.generateFilteredReport(new ColoredBookFilter()));
    }
}