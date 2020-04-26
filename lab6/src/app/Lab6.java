package app;

import app.ru.itmo.CatalogLoadException;
import app.Catalog.*;

public class Lab6 {
    public static void main(final String[] args) throws Exception {

        // Ypra 6-1
        Catalog cata = new Catalog();
        ItemCatalog catalog = cata.new ItemCatalog();
        final CatalogLoader loader = cata.new CatalogStubLoader();
        try {
            loader.load(catalog);
        } catch (final CatalogLoadException e) {
            System.out.println(e.getMessage());
        }
        catalog.printItems();

        // Ypra 6-2 work on directory "sync"

        // Ypra 6-3 work on "Client.java"
    }
}
