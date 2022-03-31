package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repositories = new ProductRepository();

    public ProductManager() {
    }

    public void add(Product product) {
        repositories.saveProduct(product);
    }

    public Product[] searchBy(String search) {
        Product[] result = new Product[0];
        for (Product product : repositories.getAllProduct()) {
            if (matches(product, search)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (product.getName().contains(search)) {
                return true;
            }
            return book.getAuthor().contains(search);
        }
        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (product.getName().contains(search)) {
                return true;
            }
            return smartphone.getManufacturer().contains(search);
        }
        return false;
    }

    public Product[] getAllProduct() {
        return repositories.getAllProduct();
    }
}
