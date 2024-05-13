package pl.StyczenMarta.ecommerce.catalog;

public class ProductCatalogControllerBuilder {
    private ProductCatalog catalog;

    public ProductCatalogControllerBuilder setCatalog(ProductCatalog catalog) {
        this.catalog = catalog;
        return this;
    }

    public ProductCatalogController createProductCatalogController() {
        return new ProductCatalogController(catalog);
    }
}
