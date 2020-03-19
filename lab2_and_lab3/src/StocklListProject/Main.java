package StocklListProject;

import java.util.Date;
import java.util.Vector;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// System.out.println("--------task1---------------\n");
		// GenericItem first = new GenericItem(134, "pencil", 50);
		// GenericItem gen = new GenericItem(123, "apple", 20);
		// first.printAll();
		// gen.printAll();

		// System.out.println("--------task2-1---------------\n");
		// Date date = new Date();
		// FoodItem food1 = new FoodItem(123, "apple", 20, date, (short) 1);
		// FoodItem food2 = new FoodItem(124, "egg", 100, date, (short) 1);
		// TechnicalItem tech1 = new TechnicalItem(012, "bicycle", 2000, (short) 365);
		// GenericItem[] alt = { food1, food2, tech1 };
		// for (GenericItem genericItem : alt) {
		// genericItem.printAll();
		// }
//
		// System.out.println("--------task2-2---------------\n");
		// System.out.println("food1==food2?\n" + food1.equals(food2));
		// System.out.println("food1==food1?\n" + food1.equals(food1));

		// FoodItem food1_clone = food1.clone();
		// System.out.println("food1_clone==food1?\n" + food1_clone.equals(food1));
		// System.out.println(food1_clone.hashCode());
		// System.out.println(food1.hashCode());

		// System.out.println("--------task2-3---------------\n");
		// GenericItem third = new GenericItem(134, "pencil", 50);
		// GenericItem second = new GenericItem(136, "pencil-1", 51);
		// third.analog = second;
		// System.out.println(third.analog);
		// GenericItem thirdClone = third.clone1();
		// System.out.println(thirdClone.analog);

		System.out.println("--------task3-1---------------\n");
		String line = "§¬§à§ß§æ§Ö§ä§í ¡¯§®§Ñ§ã§Ü§Ñ¡¯;45;120";
		String[] item_fld;
		item_fld = line.split(";");
		FoodItem ite = new FoodItem(item_fld[0], Float.parseFloat(item_fld[1]), Short.parseShort(item_fld[2]));
		ite.printAll();
	}

}
