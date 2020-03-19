package StocklListProject;

public class U0901Main {

	@SuppressWarnings({ "null", "unused" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] intArr = { 10, 20, 15 };
		Float[] floatArr = new Float[5];
		float a = 1.1f;
		for (int i = 0; i < 5; i++) {

			floatArr[i] = a;
			a++;
			System.out.println(floatArr[i]);
		}
		U0901WorkArray<Float> insWorkArrayFloat = new U0901WorkArray<Float>(floatArr);
		U0901WorkArray<Integer> insWorkArrayINt = new U0901WorkArray<Integer>(intArr);
		System.out.println(insWorkArrayFloat.sum());
		System.out.println(insWorkArrayINt.sum());
	}

}
