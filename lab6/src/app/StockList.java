package app;

import java.util.Date;

public class StockList {
    public enum Category {
        FOOD, PRINT, DRESS, GENERAL
    }

    public class GenericItem implements Cloneable {
        private int id;
        private String name;
        private float price;
        private Category type;
        private GenericItem analog;

        public GenericItem(int id, String name, float price, Category type) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.type = type;
        }

        public int getID() {
            return id;
        }

        public void setID(int id) {
            this.id = id;
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

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null) {
                return false;
            }
            if (o instanceof GenericItem) {
                GenericItem another = (GenericItem) o;
                if (this.id == another.id && this.name == another.name && this.price == another.price) {
                    return true;
                }
                return false;
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            int hash = 17;
            hash = hash * 31 + this.name.hashCode();
            hash = hash * 31 + this.id;
            return hash;
        }

        @Override
        public GenericItem clone() throws CloneNotSupportedException {
            GenericItem cloned = (GenericItem) super.clone();
            if (this.analog != null) {
                cloned.analog = this.analog.clone();
            }
            return cloned;
        }

        @Override
        public String toString() {
            return id + " " + name + " " + price + " " + type;
        }

        void printAll() {
            System.out.printf("id: %d \tname: %s \tprice: %5.2f \ttype: %s", id, name, price, type);
        }

    }

    public class FoodItem extends GenericItem {

        private Date dateOfIncome;
        private short expires;

        public FoodItem(int id, String name, float price, Category type, Date date, short exp) {
            super(id, name, price, type);
            dateOfIncome = date;
            expires = exp;
        }

        public Date getDate() {
            return dateOfIncome;
        }

        public void setDate(Date date) {
            dateOfIncome = date;
        }

        public short getExp() {
            return expires;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null) {
                return false;
            }
            if (o instanceof FoodItem) {
                FoodItem foo = (FoodItem) o;
                if (super.equals(foo) && this.dateOfIncome == foo.dateOfIncome && this.expires == foo.expires) {
                    return true;
                }
                return false;
            } else {
                return false;
            }
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
            return this.getID() + " " + this.getName() + " " + this.getPrice() + " " + this.getType() + " "
                    + dateOfIncome + " " + expires;
        }

        @Override
        public void printAll() {
            super.printAll();
        }
    }

    public class TechnicalItem extends GenericItem {

        private short warrantyTime;

        public TechnicalItem(int id, String name, float price, Category type, short war) {
            super(id, name, price, type);
            warrantyTime = war;
        }

        public short getWarranty() {
            return warrantyTime;
        }

        public void setWarranty(short warranty) {
            warrantyTime = warranty;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null) {
                return false;
            }
            if (o instanceof TechnicalItem) {

                TechnicalItem te = (TechnicalItem) o;

                if (this.getID() == te.getID() & this.getName() == te.getName() && this.getPrice() == te.getPrice()
                        && this.warrantyTime == te.warrantyTime) {
                    return true;
                }
                return false;
            } else {
                return false;
            }
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
            return this.getID() + " " + this.getName() + " " + this.getPrice() + " " + this.getType() + " "
                    + warrantyTime;
        }

        @Override
        void printAll() {
            super.printAll();
        }
    }
}
