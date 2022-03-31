package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    ProductManager repository = new ProductManager();

    public Book book1 = new Book(1, "Book", 530, "Chekhov");
    public Book book2 = new Book(2, "Book", 520, "Chekhov");
    public Book book3 = new Book(3, "Book", 500, "Gogol");
    public Book book4 = new Book(4, "Book", 550, "Pushkin");
    public Book book5 = new Book(5, "Book", 500, "Gogol");
    public Smartphone smartphone1 = new Smartphone(1, "Smartphone", 100000, "Apple");
    public Smartphone smartphone2 = new Smartphone(2, "Smartphone", 25000, "Xiaomi");
    public Smartphone smartphone3 = new Smartphone(3, "Smartphone", 10000, "Vivo");
    public Smartphone smartphone4 = new Smartphone(4, "Smartphone", 32000, "Samsung");
    public Smartphone smartphone5 = new Smartphone(5, "Smartphone", 40000, "Samsung");

    public void prepareProduct() {
        repository.add(book1);
        repository.add(book2);
        repository.add(book3);
        repository.add(book4);
        repository.add(book5);
        repository.add(smartphone1);
        repository.add(smartphone2);
        repository.add(smartphone3);
        repository.add(smartphone4);
        repository.add(smartphone5);

    }

    @Test
        // book, должен вернуть пустой массив
    void shouldReturnZeroBookTest() {
        prepareProduct();
        String search = "Pasternak";
        Product[] expected = repository.searchBy(search);
        Product[] actual = new Product[0];
        assertArrayEquals(expected, actual);

    }

    @Test
        // smartphone, должен вернуть пустой массив
    void shouldReturnZeroSmartphoneTest() {
        prepareProduct();
        String search = "Motorola";
        Product[] expected = repository.searchBy(search);
        Product[] actual = new Product[0];
        assertArrayEquals(expected, actual);

    }

    @Test
        // book, должен вернуть массив из 1 элементов
    void shouldReturnOneBookTest() {
        prepareProduct();
        String search = "Pushkin";
        Product[] expected = repository.searchBy(search);
        Product[] actual = new Product[]{book4};
        assertArrayEquals(expected, actual);

    }

    @Test
        // smartphone, должен вернуть массив из 1 элементов
    void shouldReturnOneSmartphoneTest() {
        prepareProduct();
        String search = "Apple";
        Product[] expected = repository.searchBy(search);
        Product[] actual = new Product[]{smartphone1};
        assertArrayEquals(expected, actual);

    }

    @Test
        // book, должен вернуть массив из 2 элементов
    void shouldReturnTwoBookTest() {
        prepareProduct();
        String search = "Chekhov";
        Product[] expected = repository.searchBy(search);
        Product[] actual = new Product[]{book1, book2};
        assertArrayEquals(expected, actual);

    }

    @Test
        // smartphone, должен вернуть массив из 2 элементов
    void shouldReturnTwoSmartphoneTest() {
        prepareProduct();
        String search = "Samsung";
        Product[] expected = repository.searchBy(search);
        Product[] actual = new Product[]{smartphone4, smartphone5};
        assertArrayEquals(expected, actual);

    }

    @Test
        // book, должен вернуть массив содержащий все книги
    void shouldReturnAllBookTest() {
        prepareProduct();
        String search = "Book";
        Product[] expected = repository.searchBy(search);
        Product[] actual = new Product[]{book1, book2, book3, book4, book5};
        assertArrayEquals(expected, actual);
    }

    @Test
        // smartphone, должен вернуть массив содержащий все смартфоны
    void shouldReturnAllSmartphoneTest() {
        prepareProduct();
        String search = "Smartphone";
        Product[] expected = repository.searchBy(search);
        Product[] actual = new Product[]{smartphone1, smartphone2, smartphone3, smartphone4, smartphone5};
        assertArrayEquals(expected, actual);
    }
}