public class Capsule {
	public static void mani(String[]args){
		Person taro=new Person("山田太郎".20);
				System.out.println(taro.getName());//Person.nameは不可視//
	}
	public String getName(){
		return this.name();//読み取り用//
	}
	public void setName(String name){
		this.name=name;//書き込み用//
	}
}
