package appliedChapter9;

import java.sql.*;

public class Practice1 {
	
	public static void main(String[] args) throws SQLException {
		String useDB = "java_practice";
		Connection connection = connectDB(useDB);
		String dropTableQuery = "drop table if exists item";
		dMLQuery(connection, dropTableQuery, useDB);
		String createTableQuery = "create table if not exists item "
				+ "(name varchar(255), price int, weight int)";
		dDLQuery(connection, createTableQuery, useDB);
		String describeTableQuery = "describe item";
		selectQuery(connection, describeTableQuery, useDB);
		String insertQuery = "insert into item values('약초', 5, 2),('해독제', 7, 2)";
		dMLQuery(connection, insertQuery, useDB);
		String selectAllQuery = "select * from item";
		selectQuery(connection, selectAllQuery, useDB);
	}
	public static Connection connectDB (String useDB) {
		final String ID = "root";
		final String PASSWORD = "qortjf90";
		StringBuilder sb = new StringBuilder();
		String useDB_SERVER = "localhost:3306";
		String useDB_URL_Option = sb.append("?useUnicode=true&characterEncoding=utf8")
					.append("&serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true")
					.append("&useSSL=false").toString();
		Connection connection = null;
		sb.setLength(0);
		String DB_URL = sb.append("jdbc:mysql://").append(useDB_SERVER)
				.append("/").append(useDB).append(useDB_URL_Option).toString();
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
		} catch (SQLException e) {
			System.err.println("Error] Connection fail: " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("---- DB connection complete ----");
		return connection;
	}
	public static void dDLQuery(Connection connection, String query, String useDB) {
		PreparedStatement preStatement = null;
		try {
			preStatement = connection.prepareStatement(query);
			System.out.println("Query: " + query);
			/**PreparedStatement.executeUpdate()
		     * Executes the SQL statement in this <code>PreparedStatement</code> object,
		     * which must be an SQL Data Manipulation Language (DML) statement, 
		     * such as <code>INSERT</code>, <code>UPDATE</code> or <code>DELETE</code>;
			 * or an SQL statement that returns nothing, such as a DDL statement.
		     * @return either (1) the row count for SQL Data Manipulation Language (DML) 
		     * 		   statements or (2) 0 for SQL statements that return nothing
		     * @exception SQLException if a database access error occurs;
		     * this method is called on a closed  <code>PreparedStatement</code>
		     * or the SQL statement returns a <code>ResultSet</code> object
		     * @throws SQLTimeoutException when the driver has determined that the
		     * timeout value that was specified by the {@code setQueryTimeout}
		     * method has been exceeded and has at least attempted to cancel
		     * the currently running {@code Statement}
		     */
			preStatement.executeUpdate();
			System.out.println("----   Query O.K.   ----");
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
	}	// end stmtQuery method
	
	public static void selectQuery(Connection connection, String query, String useDB) {
		ResultSet resultSet = null;
		ResultSetMetaData rsmd = null;
		Statement statement = null;
		try {
			statement = connection.createStatement();
			System.out.println("Query: " + query);
			/**@return statement class.excuteQuery(@param) @throws
		     * Executes the given SQL statement, which returns a single
		     * <code>ResultSet</code> object.
		     *<p>
		     * <strong>Note:</strong>This method cannot be called on a
		     * <code>PreparedStatement</code> or <code>CallableStatement</code>.
		     * @param sql an SQL statement to be sent to the database, typically a
		     *        static SQL <code>SELECT</code> statement
		     * @return a <code>ResultSet</code> object that contains the data produced
		     *         by the given query; never <code>null</code>
		     * @exception SQLException if a database access error occurs,
		     * this method is called on a closed <code>Statement</code>, the given
		     *            SQL statement produces anything other than a single
		     *            <code>ResultSet</code> object, the method is called on a
		     * <code>PreparedStatement</code> or <code>CallableStatement</code>
		     * @throws SQLTimeoutException when the driver has determined that the
		     * timeout value that was specified by the {@code setQueryTimeout}
		     * method has been exceeded and has at least attempted to cancel
		     * the currently running {@code Statement}
		     */
			if((resultSet = statement.executeQuery(query)) != null) {
				System.out.println("----   Query O.K.   ----");
				rsmd = (ResultSetMetaData) resultSet.getMetaData();
			}
			while (resultSet != null && resultSet.next()) {
				if(rsmd.getColumnCount() > 1) {
					for(int i = 1; i <= rsmd.getColumnCount(); i++) {
						String str = resultSet.getString(i);
						if(i!=rsmd.getColumnCount()) {
							System.out.print(" " + str);
						} else {
							System.out.println(" " + str);
						}
					}
				} else {
					for(int i = 1; i <= rsmd.getColumnCount(); i++) {
						String str = resultSet.getString(i);
						System.out.println(" " + str);
					} 	// end for
				}	//end if else
			}	// end while
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if(statement != null) {
					statement.close();
				}	
			} catch(SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}	// end finally try 
		}	// end try
//		return resultSet == null ? null: resultSet;
	}	// end stmtQuery method
	
	// Insert, Update, Delete
	public static void dMLQuery(Connection connection, String query, String useDB) {
		Statement statement = null;
		try {
			System.out.println("Query: " + query);
			statement = connection.createStatement();
			/**statement.excuteUpdate(Query)
		     * Executes the given SQL statement, which may be an <code>INSERT</code>,
		     * <code>UPDATE</code>, or <code>DELETE</code> statement or an
		     * SQL statement that returns nothing, such as an SQL DDL statement.
		     *<p>
		     * <strong>Note:</strong>This method cannot be called on a
		     * <code>PreparedStatement</code> or <code>CallableStatement</code>.
		     * @param sql an SQL Data Manipulation Language (DML) statement, such as 
		     * <code>INSERT</code>, <code>UPDATE</code> or <code>DELETE</code>;
		     * or an SQL statement that returns nothing, such as a DDL statement.
		     * @return either (1) the row count for SQL Data Manipulation Language (DML) 
		     * 		   statements or (2) 0 for SQL statements that return nothing
		     * @exception SQLException if a database access error occurs,
		     * this method is called on a closed <code>Statement</code>, the given
		     * SQL statement produces a <code>ResultSet</code> object, the method is 
		     * called on a <code>PreparedStatement</code> or <code>CallableStatement</code>
		     * @throws SQLTimeoutException when the driver has determined that the
		     * timeout value that was specified by the {@code setQueryTimeout}
		     * method has been exceeded and has at least attempted to cancel
		     * the currently running {@code Statement}
		     */
			if(statement.executeUpdate(query) >= 0) {
				System.out.println("----   Query O.K.   ----");
			} else {
				System.err.println("Error] Execute fail");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if(statement != null) {
					statement.close();
				}	
			} catch(SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}	// end finally try 
		}	// end try
	}
}	// end
//		List<Item> itemList = new ArrayList<>();
//rsmd = (ResultSetMetaData) resultSet.getMetaData();
//while(resultSet != null && resultSet.next()) {
//	for(int i = 1; i <= rsmd.getColumnCount(); i++) {
//		itemList.add(new Item(resultSet.getString("name"),
//				resultSet.getInt("price"),
//				resultSet.getInt("weight")));
//	}
//}
//System.out.println(itemList.toString());
