package app;

import java.util.*;
import app.StockList.*;
import app.ru.itmo.CatalogLoadException;
import app.ru.itmo.ItemAlreadyExistsException;

public class Catalog {
    public class ItemCatalog {

        private Map<Integer, GenericItem> catalog = new HashMap<Integer, GenericItem>();
        private List<GenericItem> alCatalog = new ArrayList<GenericItem>();

        public Map<Integer, GenericItem> getCatalog() {
            return catalog;
        }

        public void setCatalog(final HashMap<Integer, GenericItem> catalog) {
            this.catalog = catalog;
        }

        public List<GenericItem> getalCatalog() {
            return alCatalog;
        }

        public void setalCatalog(final ArrayList<GenericItem> alCatalog) {
            this.alCatalog = alCatalog;
        }

        public void addItem(final GenericItem item) throws ItemAlreadyExistsException {

            final int id = item.getID();
            final boolean isExist = catalog.containsKey(id);
            if (!isExist) {
                catalog.put(id, item);
                alCatalog.add(item);
            } else {
                throw new ItemAlreadyExistsException("Key " + id + " is exist!");
            }

        }

        public void printItems() {
            for (final GenericItem i : alCatalog) {
                System.out.println(i);
            }
        }

        public GenericItem findItemByID(final int id) {
            if (!catalog.containsKey(id)) {
                return null;
            } else {
                return catalog.get(id);
            }
        }

        public GenericItem findItemByIDAL(final int id) {
            for (final GenericItem i : alCatalog) {
                final int id1 = i.getID();
                if (id1 == id) {
                    return i;
                }
            }
            return null;
        }
    }

    public interface CatalogLoader {
        public void load(ItemCatalog cat) throws CatalogLoadException;
    }

    class CatalogStubLoader implements CatalogLoader {

        public void load(final ItemCatalog cat) throws CatalogLoadException {
            try {
                final StockList list = new StockList();
                final GenericItem item1 = list.new GenericItem(1, "Sony TV", 23000, Category.GENERAL);
                final FoodItem item2 = list.new FoodItem(1, "Bread", 12, null, new Date(), (short) 10);
                cat.addItem(item1);
                cat.addItem(item2);
            } catch (final ItemAlreadyExistsException e) {
                System.out.println(e.getMessage());
                throw new CatalogLoadException("Cannot load catalog!");
            }
        }
    }
}
