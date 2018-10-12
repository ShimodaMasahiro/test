
public class Person {
	private String name=null;//隠蔽
	private int age=0;//隠蔽


	public Person(String name,int age){
		this.name=name;
		this.age=age;
	}
	public String getName(){
		return this.name;
		}
		public void setName(){
		this.name = name;
		}

	public int getAge(){
		return this.age;
		}
		public void setAge(){
		this.age=age;
	}

}
