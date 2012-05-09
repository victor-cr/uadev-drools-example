package ua.devclub.drools.order;

/**
 * JavaDoc here
 *
 * @author Victor Polischuk
 * @since 15.04.12 23:10
 */
public class Product {
    private final long id;

    public Product(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
