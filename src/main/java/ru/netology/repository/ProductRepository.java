package ru.netology.repository;

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
}