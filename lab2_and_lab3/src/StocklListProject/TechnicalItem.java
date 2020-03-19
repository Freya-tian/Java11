package StocklListProject;

public class TechnicalItem extends GenericItem {
	short warrantyTime;// ±£ÐÞÊ±¼ä

	TechnicalItem(int ID1, String name1, float price1, short warr) {
		super(ID1, name1, price1);
		warrantyTime = warr;
	}

	public void printAll() {
		System.out.printf("category: %-20s, ID: %d , Name: %-20s , price:%5.2f, warrantyTime: %hd \n", a, ID, name,
				price, warrantyTime);
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
		if (o instanceof TechnicalItem) {

			TechnicalItem te = (TechnicalItem) o;

			if (this.ID == te.ID && this.name == te.name && this.price == te.price
					&& this.warrantyTime == te.warrantyTime) {
				return true;
			}
			return false;
		} else
			return false;

	}

	public TechnicalItem clone() throws CloneNotSupportedException {
		return (TechnicalItem) super.clone();
	}

	public String toString() {
		return super.toString();
	}
}
