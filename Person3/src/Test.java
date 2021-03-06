///司令塔クラス(原本のインスタンス化)//
public class Test {

	public static void main(String[] args) {
		//メインメソッド=自動的に一番最初に実行されるメソッド//
		Person taro=new Person();
		//インスタンス可 new Personで新しいPersonクラスのインスタンスを生成.PersonはPersonクラスの型、taroは変数//
		taro.name="山田太郎";
		//taroインスタンスにあるnameフィールドに山田太郎という名前を代入、という表現//
		taro.age=20;
		System.out.println(taro.name);
		System.out.println(taro.age);//コンストラクタがなくてもjavaが自動的にコンストラクタを生成し、実行している//
		taro.talk();
		taro.walk();
		taro.run();

		Person jiro = new Person("jiro", 20);//代入を同時に行っている(引数を入れている)//
		System.out.println(jiro.name);
		System.out.println(jiro.age);

		Person saburo=new Person("saburo");//コンストラクタ③を適用//
		System.out.println(saburo.name);
		System.out.println(saburo.age);

		Person noname=new Person(25);//コンストラクタ④を適用//
		System.out.println(noname.name);
		System.out.println(noname.age);

		Person hanako=new Person(17,"hanako");//コンストラクタ⑤を適用//
		System.out.println(hanako.name);
		System.out.println(hanako.age);
	}//一つのクラスの中に同名のメソッドを定義(作成)すること(=オーバーロード)できる(引数のパターンが異なることが不可欠)//

}
