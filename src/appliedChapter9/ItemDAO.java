package appliedChapter9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO <E> {
	private static final String DB_NAME = "java_practice";
	private static final String COLUMN_NAME = "name";
	private static final String COLUMN_PRICE = "price";
	private static final String COLUMN_WEIGHT = "weight";
	private static final String ID = "root";
	private static final String PASSWORD = "qortjf90";
	
	private static Connection connection;
	
	public static Connection connectDB () {
		PreparedStatement preStatement = null;
		ResultSet resultSet = null;
		StringBuilder sb = new StringBuilder();
		String useDB_SERVER = "localhost:3306";
		String useDB_URL_Option = sb.append("?useUnicode=true&characterEncoding=utf8")
					.append("&serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true")
					.append("&useSSL=false").toString();
		String dbSql = "SELECT * FROM Information_schema.SCHEMATA WHERE SCHEMA_NAME = ?";

		sb.setLength(0);
		String DB_URL = sb.append("jdbc:mysql://").append(useDB_SERVER)
				.append("/").append(useDB_URL_Option).toString();
		sb.setLength(0);
		// driver 존재 여부 확인
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		    System.err.println("ERROR] JDBC Driver load: " + e.getMessage());
		    e.printStackTrace();
		}
		// Open a connection
		try {
			System.out.println("---- Connecting DB ----");
			connection = DriverManager.getConnection(DB_URL, ID, PASSWORD);
			preStatement = connection.prepareStatement(dbSql);
			preStatement.setString(1,  DB_NAME);
			resultSet = preStatement.executeQuery();
			if(!resultSet.next()) {
				System.out.println("Database not found");
			}
			// 데이터베이스를 변환 (use DB_NAME)
			connection.setCatalog(DB_NAME);
		} catch (SQLException e) {
			System.err.println("Error] Connection fail: " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("---- DB connection complete ----");
		// connection을 살려서 반환
		return connection;
	}
	
	public static List<Item> findByMinimumPrice(int minPrice) {
		List<Item> result = new ArrayList<>();
		PreparedStatement preStatement = null;
		ResultSet resultSet = null;
		ResultSetMetaData rsmd = null;
		Connection connection = connectDB();
		String query = "select * from item where price > ?";
		try {
			preStatement = connection.prepareStatement(query);
			preStatement.setInt(1, minPrice);
			System.out.println("Query: " + query);
			if((resultSet = preStatement.executeQuery()) != null) {
				System.out.println("----   Query O.K.   ----");
				rsmd = (ResultSetMetaData) resultSet.getMetaData();
			}
			while (resultSet != null && resultSet.next()) {
				result.add(new Item(resultSet.getString(COLUMN_NAME),
								    resultSet.getInt(COLUMN_PRICE),
								    resultSet.getInt(COLUMN_WEIGHT)));
			}	// end while
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if(preStatement != null) {
					preStatement.close();
				}	
			} catch(SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}	// end finally try 
		}	// end try
		return result;
	}
}
