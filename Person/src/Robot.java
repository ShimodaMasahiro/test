/**
 *
 */

/**
 * @author internousdev
 *
 */
public class Robot {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Person aibo =new Person();
		aibo.name="AIBO";
		System.out.println(aibo.name);
		aibo.talk();
		aibo.walk();
		aibo.run();

		Person asimo=new Person();
		asimo.name="ASIMO";
		System.out.println(asimo.name);
		asimo.talk();
		asimo.walk();
		asimo.run();

		Person pepper=new Person();
		pepper.name="PEPPER";
		pepper.talk();
		pepper.walk();
		pepper.run();

		Person doraemon=new Person();
		doraemon.name="ドラえもん";
		doraemon.talk();
		doraemon.walk();
		doraemon.run();

	}

}
