package external.db;

import be.pxl.exercise1.Product;

public class ProductRepository {
    public void save(Product product, int price) {
        System.out.print("saved a gst price " + price + "to db for product " + product.getName());
    }
}
