//原本クラス//
public class Person {
	public String name=null;//フィールド(=データ),null=初期値//
	public int age=0;//フィールド//

	public Person(){}//コンストラクタ①//
//クラス名と同じメソッド名=コンストラクタ//
	public Person(String name, int age){
//コンストラクタ② コンストラクタは必ず一つ実行される。インスタンス化する際()内の情報によりどのコンストラクタが実行されるか決定される(最も適したコンストラクタ)//
		this.name = name;
		this.age =age;
	}
	//コンストラクタ③//
	public Person(String name){
		this.name=name;
		this.age=0;
	}
	//コンストラクタ④//
	public Person(int age){
		this.name="名前なし";
		this.age=age;
	}
	//コンストラクタ⑤//
	public Person(int age, String name){
		this.name=name;
		this.age=age;
	}

	public void talk(){
//メソッド(の定義)//
		System.out.println(this.name + "が話す");
		}
	public void walk(){
		System.out.println(this.name + "が歩く");
		}
	public void run(){
		System.out.println(this.name + "が走る");
		}

	//フィールドとメソッドがある。合わせてメンバーと呼ぶ//
}
