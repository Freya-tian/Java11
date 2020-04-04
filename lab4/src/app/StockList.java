package app;

import java.util.Date;

enum Category {
    FOOD, PRINT, DRESS, GENERAL
}

public class StockList {
    public static void main(String[] args) throws CloneNotSupportedException {

    }
}

class GenericItem implements Cloneable {
    private int ID;
    private String name;
    private float price;
    private Category type;
    private GenericItem analog;
    private static int currentID = 0;

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public Category getType() {
        return type;
    }

    public GenericItem(String name, float price, Category type) {
        this.ID = GenericItem.currentID++;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (o instanceof GenericItem) {
            GenericItem another = (GenericItem) o;
            if (this.ID == another.ID && this.name == another.name && this.price == another.price)
                return true;
            return false;
        } else
            return false;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = hash * 31 + this.name.hashCode();
        hash = hash * 31 + this.ID;
        return hash;
    }

    @Override
    public GenericItem clone() throws CloneNotSupportedException {
        GenericItem cloned = (GenericItem) super.clone();
        if (this.analog != null)
            cloned.analog = this.analog.clone();
        return cloned;
    }

    @Override
    public String toString() {
        return ID + " " + name + " " + price + " " + type;
    }

    void printAll() {
        System.out.printf("ID: %d \tname: %s \tprice: %5.2f \ttype: %s", ID, name, price, type);
    }

}

class FoodItem extends GenericItem {

    private Date dateOfIncome;
    private short expires;

    public Date getDate() {
        return dateOfIncome;
    }

    public void setDate(Date date) {
        dateOfIncome = date;
    }

    public short getExp() {
        return expires;
    }

    public FoodItem(String name, float price, Category type, Date date, short exp) {
        super(name, price, type);
        dateOfIncome = date;
        expires = exp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (o instanceof FoodItem) {
            FoodItem foo = (FoodItem) o;
            if (super.equals(foo) && this.dateOfIncome == foo.dateOfIncome && this.expires == foo.expires) {
                return true;
            }
            return false;
        } else
            return false;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = hash * 31 + this.getName().hashCode();
        hash = hash * 31 + this.expires;
        hash = hash * 31 + this.getID();
        return hash;
    }

    @Override
    public FoodItem clone() throws CloneNotSupportedException {
        return (FoodItem) super.clone();
    }

    @Override
    public String toString() {
        return this.getID() + " " + this.getName() + " " + this.getPrice() + " " + this.getType() + " " + dateOfIncome
                + " " + expires;
    }

    @Override
    public void printAll() {
        super.printAll();
    }
}

class TechnicalItem extends GenericItem {
    public TechnicalItem(String name, float price, Category type, short war) {
        super(name, price, type);
        warrantyTime = war;
    }

    private short warrantyTime;

    public short getWarranty() {
        return warrantyTime;
    }

    public void setWarranty(short warranty) {
        warrantyTime = warranty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (o instanceof TechnicalItem) {

            TechnicalItem te = (TechnicalItem) o;

            if (this.getID() == te.getID() & this.getName() == te.getName() && this.getPrice() == te.getPrice()
                    && this.warrantyTime == te.warrantyTime) {
                return true;
            }
            return false;
        } else
            return false;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = hash * 31 + this.getName().hashCode();
        hash = hash * 31 + this.getID();
        return hash;
    }

    @Override
    public TechnicalItem clone() throws CloneNotSupportedException {
        return (TechnicalItem) super.clone();
    }

    @Override
    public String toString() {
        return this.getID() + " " + this.getName() + " " + this.getPrice() + " " + this.getType() + " " + warrantyTime;
    }

    @Override
    void printAll() {
        super.printAll();
    }
}
