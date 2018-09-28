import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestUserDAO {

	String name="";
	String password="";
public void select(String name,String password)//引数を二つ入れる//
{
	DBConnector db=new DBConnector();//インスタンス化(DB型)//
	Connection con=db.getConnection();

	String sql ="select * from test_table where user_name=? and password=?";//nameとpasswordのあるテーブルのデータを抽出（をsqlに代入）//
	try{
		PreparedStatement ps=con.prepareStatement(sql);//PreparedStatement（あらかじめ準備されたSQL文）型のpsという変数にConnectionクラスの持つpreapreStatementのメソッドを実行する//
		ps.setString(1, name);//setStringメソッドは２つの引数を使って１個目の？に最初にselectで代入されたnameを代入//
		ps.setString(2, password);//↑と同様//
		ResultSet rs=ps.executeQuery();//executteQueryメソッドを実行(preparedStatement型の)Resultset型はselect文の結果をだすクラス//
		if(rs.next()){//nextメソッドはResultSetの一つ、trueであれば{}内の処理を実行。nextはレコード全体を示す矢印を行下にずらす。その後実際にデータが存在していたらtrue、存在していなかったらfalseを戻り値として返す//
			System.out.println(rs.getString("user_name"));
			System.out.println(rs.getString("password"));
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
try{
	con.close();//conはDBConnorのツール。ここで作ったコネクションを閉じる//
}catch(SQLException e){
	e.printStackTrace();
		}
	}
public void selectAll(){
	DBConnector db=new DBConnector();
	Connection con=db.getConnection();

	String sql="select * from test_table";
	try{
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while (rs.next()){//繰り返しで全部出すまで行う//
			System.out.print(rs.getString("user_name"));
			System.out.println(rs.getString("password"));
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	try{
		con.close();
	}catch(SQLException e){
		e.printStackTrace();
	}
}
public void selectByName(String name){
	DBConnector db=new DBConnector();
	Connection con=db.getConnection();

	String sql="select * from test_table where user_name=?";
	try{
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,name);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			System.out.println(rs.getString("user_name"));
			System.out.println(rs.getString("password"));
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	try{
		con.close();
	}catch(SQLException e){
		e.printStackTrace();
	}
}
public void selectByPassword(String password){
	DBConnector db=new DBConnector();
	Connection con=db.getConnection();

	String sql="select * from test_table where password=?";
	try{
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, password);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			System.out.println(rs.getString("user_name"));
			System.out.println(rs.getString("password"));
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	try{
		con.close();
	}catch(SQLException e){
		e.printStackTrace();
	}
}
public void updateUserNameByUserName(String oldName,String newName){
	DBConnector db=new DBConnector();
	Connection con=db.getConnection();

	String sql="update test_table set user_name=? where user_name=?";
	try{
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, newName);
		ps.setString(2, oldName);
		int i=ps.executeUpdate();
		if(i>0){
			System.out.println(i+"件変更されました");
		}else{
			System.out.println("該当するデータはありませんでした");
		}
	}catch(SQLException e){
		e.printStackTrace();
	}try{
		con.close();
	}catch(SQLException e){
		e.printStackTrace();
	}
}
public void insert(int user_id,String name,String password){//新規にデータを挿入//
	DBConnector db=new DBConnector();
	Connection con=db.getConnection();

	String sql="insert into test_table values(?,?,?)";//?はあとから値を入れる（パラメータという）//
	try{
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, user_id);
		ps.setString(2, name);
		ps.setString(3, password);
		int i=ps.executeUpdate();//SQL文実行。戻り値として追加があったデータの件数が戻り値//
		if(i>0){
			System.out.println(i+"件登録されました");
		}
	}catch(SQLException e){
		e.printStackTrace();
	}try{con.close();
}catch(SQLException e){
	e.printStackTrace();
	}
}
public void delete(String name){
	DBConnector db=new DBConnector();
	Connection con=db.getConnection();

	String sql="delete from test_table where user_name=?";
	try{
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, name);
		int i=ps.executeUpdate();
		if(i>0){
			System.out.println(i+"件削除されました");
		}
	}catch(SQLException e){
		e.printStackTrace();
	}try{
		con.close();
	}catch(SQLException e){
		e.printStackTrace();
	}
}
}