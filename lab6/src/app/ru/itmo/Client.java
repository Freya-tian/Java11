package app.ru.itmo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import app.StockList.*;
import app.StockList;
import app.Catalog.*;

public class Client {

    class CatalogFileLoader implements CatalogLoader {

        private String fileName;

        public CatalogFileLoader(String fileName) {
            this.fileName = fileName;
        }

        public void load(ItemCatalog cat) throws CatalogLoadException {
            File f = new File(fileName);
            FileInputStream fis;
            String line;
            Scanner scanner = null;
            try {
                fis = new FileInputStream(f);
                scanner = new Scanner(fis);

                while (scanner.hasNextLine()) {
                    line = scanner.nextLine();
                    if (line.length() == 0) {
                        break;
                    }
                    String[] itemFld = line.split(";");
                    String name = itemFld[0];
                    float price = Float.parseFloat(itemFld[1]);
                    short expires = Short.parseShort(itemFld[2]);
                    StockList stock = new StockList();
                    FoodItem item = stock.new FoodItem(1, name, price, null, new Date(), expires);
                    cat.addItem(item);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                throw new CatalogLoadException(e.getMessage());
            } catch (ItemAlreadyExistsException e) {
                e.printStackTrace();
                throw new CatalogLoadException(e.getMessage());
            } finally {
                if (scanner != null) {
                    scanner.close();
                }
            }
        }
    }
}
