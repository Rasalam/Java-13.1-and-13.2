package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductRepositoryTest {

    ProductRepository productRepository = new ProductRepository();

    public Book book1 = new Book(1, "Book", 530, "Chekhov");
    public Book book2 = new Book(2, "Book", 520, "Chekhov");
    public Book book3 = new Book(3, "Book", 500, "Gogol");
    public Book book4 = new Book(4, "Book", 550, "Pushkin");
    public Book book5 = new Book(5, "Book", 500, "Gogol");
    public Smartphone smartphone1 = new Smartphone(6, "Smartphone", 100000, "Apple");
    public Smartphone smartphone2 = new Smartphone(7, "Smartphone", 25000, "Xiaomi");
    public Smartphone smartphone3 = new Smartphone(8, "Smartphone", 10000, "Vivo");
    public Smartphone smartphone4 = new Smartphone(9, "Smartphone", 32000, "Samsung");
    public Smartphone smartphone5 = new Smartphone(10, "Smartphone", 40000, "Samsung");

    public void prepareProduct() {
        productRepository.saveProduct(book1);
        productRepository.saveProduct(book2);
        productRepository.saveProduct(book3);
        productRepository.saveProduct(book4);
        productRepository.saveProduct(book5);
        productRepository.saveProduct(smartphone1);
        productRepository.saveProduct(smartphone2);
        productRepository.saveProduct(smartphone3);
        productRepository.saveProduct(smartphone4);
        productRepository.saveProduct(smartphone5);
    }

    @Test
    // Должен добавить 1 смартфон
    public void shouldSaveOneSmartphoneTest() {
        prepareProduct();
        Smartphone smartphone6 = new Smartphone(6, "Smartphone", 41000, "Samsung");
        productRepository.saveProduct(smartphone6);
        Product[] expected = new Product[]{book1, book2, book3, book4, book5, smartphone1, smartphone2, smartphone3, smartphone4, smartphone5, smartphone6};
        Product[] actual = productRepository.getAllProduct();
        assertArrayEquals(expected, actual);
    }

    @Test
    // Должен добавить 1 книгу
    public void shouldSaveOneBookProductTest() {
        prepareProduct();
        Book book6 = new Book(6, "Book", 410, "Gogol");
        productRepository.saveProduct(book6);
        Product[] expected = new Product[]{book1, book2, book3, book4, book5, smartphone1, smartphone2, smartphone3, smartphone4, smartphone5, book6};
        Product[] actual = productRepository.getAllProduct();
        assertArrayEquals(expected, actual);
    }

    @Test
    // Должен добавить 1 книгу и 1 смартфон
    public void shouldSaveOneBookAndOneSmartphoneProductTest() {
        prepareProduct();
        Book book6 = new Book(6, "Book", 410, "Gogol");
        Smartphone smartphone6 = new Smartphone(6, "Smartphone", 41000, "Samsung");
        productRepository.saveProduct(book6);
        productRepository.saveProduct(smartphone6);
        Product[] expected = new Product[]{book1, book2, book3, book4, book5, smartphone1, smartphone2, smartphone3, smartphone4, smartphone5, book6, smartphone6};
        Product[] actual = productRepository.getAllProduct();
        assertArrayEquals(expected, actual);
    }

    @Test
    // Должен вернуть все элементы продкуты
    public void shouldReturnAllProductTest() {
        prepareProduct();
        Product[] expected = productRepository.getAllProduct();
        Product[] actual = new Product[]{book1, book2, book3, book4, book5, smartphone1, smartphone2, smartphone3, smartphone4, smartphone5};
        assertArrayEquals(expected, actual);
    }

    @Test
    // Должен удалить продукт из репозитория по его Id
    public void shouldRemoveItemByIdTest() {
        prepareProduct();
        int id = 5;
        productRepository.removeById(id);
        Product[] expected = productRepository.getAllProduct();
        Product[] actual = new Product[]{book1, book2, book3, book4, smartphone1, smartphone2, smartphone3, smartphone4, smartphone5};
        assertArrayEquals(expected, actual);
    }
}
