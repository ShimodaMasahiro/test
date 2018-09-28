/**
 *
 */

/**
 * @author internousdev
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Person taro=new Person();
		taro.name="山田太郎";
		taro.age=20;
		taro.phoneNumber="000-0000-0000";
		taro.adress="東京都";
		taro.job="会社員";

		System.out.println(taro.name);
		System.out.println(taro.age);
		System.out.println(taro.phoneNumber);
		System.out.println(taro.adress);
		System.out.println(taro.job);
		taro.talk();
		taro.walk();
		taro.run();

		Person jiro=new Person();
		jiro.name="木村次郎";
		jiro.age=18;
		jiro.phoneNumber="111-1111-1111";
		jiro.adress="大阪府";
		jiro.job="高校生";

		System.out.println(jiro.name);
		System.out.println(jiro.age);
		System.out.println(jiro.phoneNumber);
		System.out.println(jiro.adress);
		System.out.println(jiro.job);
		jiro.talk();
		jiro.walk();
		jiro.run();

		Person hanako=new Person();
		hanako.name="鈴木花子";
		hanako.age=16;
		hanako.phoneNumber="555-5555-5555";
		hanako.adress="広島県";
		hanako.job="高校生";

		System.out.println(hanako.name);
		System.out.println(hanako.age);
		System.out.println(hanako.phoneNumber);
		System.out.println(hanako.adress);
		System.out.println(hanako.job);
		hanako.talk();
		hanako.walk();
		hanako.run();

		Person masahiro=new Person();
		masahiro.name="下田真洋";
		masahiro.age=27;
		masahiro.phoneNumber="080-6555-6666";
		masahiro.adress="神奈川県";
		masahiro.job="自営業";

		System.out.println(masahiro.name);
		System.out.println(masahiro.age);
		System.out.println(masahiro.phoneNumber);
		System.out.println(masahiro.adress);
		System.out.println(masahiro.job);
		masahiro.talk();
		masahiro.walk();
		masahiro.run();

	}

}
