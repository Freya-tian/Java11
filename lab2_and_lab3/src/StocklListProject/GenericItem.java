package StocklListProject;

public class GenericItem implements Cloneable {

	public int ID;
	public String name;
	public float price;
	Category a;
	GenericItem analog;
	static int currentID = 123456;

	public GenericItem(String name1, float price1, Category categoryy) {
		ID = GenericItem.currentID++;
		name = name1;
		price = price1;
		a = categoryy;
	}

	public GenericItem(String name1, float price1, GenericItem analog) {
		ID = GenericItem.currentID++;
		name = name1;
		price = price1;
		analog.ID = analog.ID;
		analog.name = analog.name;
		analog.price = analog.price;
	}

	public GenericItem() {
		ID = GenericItem.currentID;
		name = null;
		price = 0;
		a = null;
		analog = null;
	}

	public void printAll() {
		System.out.printf("category: %-20s, ID: %d , Name: %-20s , price:%5.2f \n", a, ID, name, price);
	}

	
	public int hashCode() {
		int hash = 17;
		hash = hash * 31 + this.name.hashCode();
		hash = hash * 31 + this.ID;
		return hash;
	}
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (o instanceof GenericItem) {

			GenericItem te = (GenericItem) o;

			if (this.ID == te.ID && this.name == te.name && this.price == te.price) {
				return true;
			}
			return false;
		} else
			return false;

	}

	public GenericItem clone() throws CloneNotSupportedException {
		return (GenericItem) super.clone();
	}

	public String toString() {
		return super.toString();
	}

	public GenericItem clone1() throws CloneNotSupportedException {
		GenericItem gene = (GenericItem) super.clone();
		if (this.analog != null) {
			gene.analog = this.analog.clone1();
		}
		return gene;
	}

}
