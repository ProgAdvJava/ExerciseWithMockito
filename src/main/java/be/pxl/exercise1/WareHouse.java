package be.pxl.exercise1;

import external.db.ProductRepository;
import external.email.EmailService;

import java.util.List;

public class WareHouse {
    private GSTCalculator gstCalculator;
    private EmailService emailService;
    private ProductRepository productRepository;

    public WareHouse(GSTCalculator gstCalculator, EmailService emailService, ProductRepository productRepository) {
        this.gstCalculator = gstCalculator;
        this.emailService = emailService;
        this.productRepository = productRepository;
    }

    public void processProducts(String user, List<Product> products) {
        for (Product product : products) {
            // calculate gst price gstCalculator
            // save to db using productRepository
        }
        //send email to user
    }
}
