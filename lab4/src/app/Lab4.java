package app;

import java.security.SecureRandom;
import java.util.*;

public class Lab4 {
    public static void main(String[] args) throws Exception {

        // ypra 4-1
        String ALPHABET = "abcd";
        SecureRandom RANDOM = new SecureRandom();
        Random rand = new Random();

        ItemCatalog item = new ItemCatalog();
        for (int i = 0; i < 10; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 5; j++) {
                sb.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
            }
            float price = rand.nextFloat();
            String s = sb.toString();
            GenericItem genItem = new GenericItem(s, price, Category.GENERAL);
            item.addItem(genItem);
        }

        long begin = new Date().getTime();
        for (int i = 0; i < 100000; i++) {
            item.findItemByID(9);
        }
        long end = new Date().getTime();
        System.out.println("In Hash: " + (end - begin));
        begin = new Date().getTime();
        for (int i = 0; i < 100000; i++) {
            item.findItemByIDAL(9);
        }
        end = new Date().getTime();
        System.out.println("In ArrayList: " + (end - begin));
        System.out.println();

        // ypra4-2
        CatalogLoader loader = new CatalogStubLoader();
        loader.load(item);
        item.printItems();

        // ypra 4-3: work in lab2
    }
}

class ItemCatalog {

    private Map<Integer, GenericItem> catalog;
    private List<GenericItem> ALCatalog;

    public Map<Integer, GenericItem> getCatalog() {
        return catalog;
    }

    public void setCatalog(HashMap<Integer, GenericItem> _catalog) {
        catalog = _catalog;
    }

    public List<GenericItem> getALCatalog() {
        return ALCatalog;
    }

    public void setALCatalog(ArrayList<GenericItem> alcatalog) {
        ALCatalog = alcatalog;
    }

    public void addItem(GenericItem item) {
        int id = item.getID();
        catalog.put(id, item);
        ALCatalog.add(item);
    }

    public void printItems() {
        for (GenericItem i : ALCatalog) {
            System.out.println(i);
        }
    }

    public GenericItem findItemByID(int id) {
        if (!catalog.containsKey(id)) {
            return null;
        } else {
            return catalog.get(id);
        }
    }

    public GenericItem findItemByIDAL(int id) {
        for (GenericItem i : ALCatalog) {
            int _id = i.getID();
            if (_id == id)
                return i;
        }
        return null;
    }
}

interface CatalogLoader {
    public void load(ItemCatalog cat);
}

class CatalogStubLoader implements CatalogLoader {

    public void load(ItemCatalog cat) {
        GenericItem item1 = new GenericItem("Sony TV", 23000, Category.GENERAL);
        FoodItem item2 = new FoodItem("Bread", 12, null, new Date(), (short) 10);
        cat.addItem(item1);
        cat.addItem(item2);
    }
}
