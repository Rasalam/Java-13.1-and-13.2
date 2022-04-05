package ru.netology.repository;

import ru.netology.domain.AlreadyExistsException;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;

public class ProductRepository {
    private Product[] items = new Product[0];

    public ProductRepository() {
    }

    public void saveProduct(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;

    }

    public Product[] getAllProduct() {
        return items;
    }

    public Product[] removeById(int id) {

        if (findById(id) == null) {
            throw new NotFoundException(id);
        }
        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
        return items;
    }

    public Product[] findById(int id) {
        Product[] products = new Product[1];
        int index = 0;
        for (Product item : items) {
            if (item.getId() == id) {
                products[index] = item;
                return products;
            }
        }
        return null;
    }

    public void saveProductIdCheck(Product item) {
        int currentId = item.getId();
        if (findById(currentId) != null) {
            throw new AlreadyExistsException(currentId);
        }
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

}