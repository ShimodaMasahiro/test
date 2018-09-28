import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * <p>MySQLに接続する為のユーティリティクラスです。<br>
 * ルートアカウントにてDBに接続されます。</p>
 * */
public class DBConnector {
/*
 * JDBCドライバー名
 */
	private static String driverName="com.mysql.jdbc.Driver";//mySQL内のクラス(com.mysql～)//
/*
 * データベース接続URL
 */
	private static String url=
	"jdbc:mysql://localhost/testdb?autoRconnect=true&useSSL=false";
	//jdbc...はDB(mySQK)の接続先のURLorDBサーバ名//

/*
 * データベース接続ユーザ名
 * */
	private static String user ="root";
/**
 * データベース接続パスワード
 **/
	private static String password="mysql";
//ここからメソッドの定義//
public Connection getConnection(){
	Connection con =null;
	try
	{Class.forName(driverName);
	//ドライバーを実際に使えるようにするための一文(driverNameはドライバークラス名)//
	con=DriverManager.getConnection(url,user,password);
	//conはConnection型の変数。()内の値を使ってドライバーマネージャークラスのもつgetConnectionメソッドを行う(今定義しているgetConnectionメソッドとは捌物)//
	}//例外(エラー)の派生する可能性のある処理//
	catch (ClassNotFoundException e)//例外の種類(ここではクラスが見つからないという例外,eは例外を代入するための変数)//
	{
		e.printStackTrace();
	}//例外が発生した時に行う処理{}内の処理はエラーに至る履歴をコンソール上に示すという意味//
	catch (SQLException e){
		e.printStackTrace();
	}
	return con;//呼び出し元に対して戻り値を返す(その際Connection型で返す)//
}
}
