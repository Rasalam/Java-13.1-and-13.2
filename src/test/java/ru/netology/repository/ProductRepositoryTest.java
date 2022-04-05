package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.*;


import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    ProductRepository repository = new ProductRepository();

    public Book book1 = new Book(1, "Book", 530, "Chekhov");
    public Book book2 = new Book(2, "Book", 520, "Chekhov");
    public Book book3 = new Book(3, "Book", 500, "Gogol");
    public Book book4 = new Book(4, "Book", 550, "Pushkin");
    public Smartphone smartphone1 = new Smartphone(6, "Smartphone", 100000, "Apple");
    public Smartphone smartphone2 = new Smartphone(7, "Smartphone", 25000, "Xiaomi");
    public Smartphone smartphone3 = new Smartphone(8, "Smartphone", 10000, "Vivo");

    public void prepareProduct() {
        repository.saveProduct(book1);
        repository.saveProduct(book2);
        repository.saveProduct(book3);
        repository.saveProduct(smartphone1);
        repository.saveProduct(smartphone2);
        repository.saveProduct(smartphone3);

    }

    @Test
    // RemoveById
    public void shouldDeleteSuccessfullyTest() {
        int removeId = 2;
        prepareProduct();
        Product[] expected = repository.removeById(removeId);
        Product[] actual = new Product[]{book1, book3, smartphone1, smartphone2, smartphone3};
        assertArrayEquals(actual, expected);
    }

    @Test
    //RemoveById
    public void shouldThrowExceptionTest() {
        int removeId = 0;
        prepareProduct();
        assertThrows(NotFoundException.class, () -> repository.removeById(removeId));
    }

    @Test
    // saveProductIdCheck
    public void shouldAddItemTest() {
        prepareProduct();
        repository.saveProductIdCheck(book4);
        Product[] expected = repository.getAllProduct();
        Product[] actual = new Product[]{book1, book2, book3, smartphone1, smartphone2, smartphone3, book4};
        assertArrayEquals(actual, expected);
    }

    @Test
    // saveProductIdCheck
    public void shouldTrowExceptionTest() {
        prepareProduct();
        assertThrows(AlreadyExistsException.class, () -> repository.saveProductIdCheck(book3));

    }
}



