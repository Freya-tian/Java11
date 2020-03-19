package StocklListProject;

import java.util.Date;

public class FoodItem extends GenericItem {
	Date dateofIncome;// 生产日期
	short expires;// 保质期

	public FoodItem(String name, float price, short expirse) {
		this(name);
		this.price = price;
		this.expires = expirse;
	}

	public FoodItem(String name) {
		this.name = name;
	}

	public FoodItem(int ID1, String name, float price, Date date, short exp, FoodItem analog) {
		this(name, price, exp);// this()调用该类中的构造函数 ，super（）调用父类中的
		this.analog.ID = analog.ID;
		this.analog.name = analog.name;
		this.analog.price = analog.price;
		dateofIncome = date;
	}

	public void printAll() {
		System.out.printf("category: %-20s, ID: %d , Name: %-20s , price:%5.2f, expires: %hd, dateofIncome: %tF%n \n",
				a, ID, name, price, expires, dateofIncome);

	}
	
	public int hashCode() {
		int hash = 17;
		hash = hash * 31 + this.name.hashCode();
		hash = hash * 31 + this.expires;
		hash = hash * 31 + this.ID;
		return hash;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (o instanceof FoodItem) {

			FoodItem foo = (FoodItem) o;

			if (super.equals(foo) && this.dateofIncome == foo.dateofIncome && this.expires == foo.expires) {
				return true;
			}
			return false;
		} else
			return false;

	}

	public FoodItem clone() throws CloneNotSupportedException {
		return (FoodItem) super.clone();
	}

	public String toString() {
		return super.toString();
	}
}
