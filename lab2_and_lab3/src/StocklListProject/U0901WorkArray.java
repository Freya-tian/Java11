package StocklListProject;

public class U0901WorkArray<T extends Number> {
	public T[] arrNums;

	public U0901WorkArray(T[] numP) {
		arrNums = numP;
	}

	public double sum() {
		double doubleWork = 0;
		for (T i : arrNums) {

			doubleWork += i.doubleValue();
		}
		return doubleWork;
	}
}
