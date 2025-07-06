import entity.Book;
import entity.EBook;
import entity.PrintedBook;
import repository.ArrayBookRepository;
import repository.BookRepository;

public class Main {
    public static void main(String[] args) {
        Book book1 = new PrintedBook("LH46-02", "Aventura en el mar", "Juan Romero", 2011, "tapa dura", false);
        Book book2 = new EBook("CS24-12", "Patrones de diseño", "Anónimo", 2011, 5.64, "PDF");
        Book book3 = new PrintedBook("MF87-33", "Historias de la montaña", "Laura Méndez", 2018, "rústica", true);
        Book book4 = new EBook("TR09-58", "Introducción a la inteligencia artificial", "Carlos Ruiz", 2020, 3.21, "EPUB");
        Book book5 = new PrintedBook("BK10-75", "Cuentos del bosque encantado", "María Elena", 2005, "tapa blanda", false);

//        System.out.println("\n" + book1.toString());
//        System.out.println("\n" + book2.toString());

//        BookRepository repository = new ArrayListBookRepository();
//
//        repository.addBook(book1);
//        repository.addBook(book2);
//        repository.addBook(book3);
//        repository.addBook(book4);
//        repository.addBook(book5);

//        System.out.println("antes");
//
//        repository.getAllBooks().stream().forEach(System.out::println);
//        repository.removeBook("sss");
//
//
//        System.out.println("despues");
//        repository.getAllBooks().stream().forEach(System.out::println);

//        System.out.println(repository.findBookByIsbn("TR09-58").toString());

        // Probando ArrayRepository

        BookRepository repositoryArr = new ArrayBookRepository();

        repositoryArr.addBook(book1);
        repositoryArr.addBook(book2);
        repositoryArr.addBook(book3);

        repositoryArr.getAllBooks().stream().forEach(System.out::println);


        repositoryArr.removeBook(book2.getIsbn());

        System.out.println("borrado el 2do");
        repositoryArr.getAllBooks().stream().forEach(System.out::println);
    }
}