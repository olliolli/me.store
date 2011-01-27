/*
creation date: 14.01.2011
created by: Falzer, Marcel

HISTORY OF MODIFICATION
=============================================================================
modification date | modified from | description | version number
-----------------------------------------------------------------------------
 
decription of the main function:  methods to exectute each sql statement.

* */ 
package DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class DBControl {
	
	private static Connection conn = null;
	private static String driver = "com.mysql.jdbc.Driver";
	private static String path = "jdbc:mysql://localhost/buchclub";
	private static String user = "root";
	private static String pwd = "";
	
	/**
	 * @author Falzer, Marcel
	 * @version 1.0
	 * @since 13.01.2011
	 * @exception ClassNotFoundException
	 * @exception SQLException
	 * @param sqlStatement - (STRING) the sql statement to execute
	 * @return result - (ArrayList<STRING>) the result list of the sql statement execution
	 */
	public static ArrayList<String[]> ExecuteQuery(String sqlStatement){
		ArrayList<String[]> result = new ArrayList<String[]>();
		try{
			Class.forName(driver);		
			conn = DriverManager.getConnection(path, user, pwd);
			Statement stmt = conn.createStatement();
			stmt.execute(sqlStatement);
			ResultSet r = stmt.getResultSet();
			ResultSetMetaData rmd = r.getMetaData();
			while (r.next()){
				String[] row = new String[rmd.getColumnCount()];
				for(int i = 0; i < rmd.getColumnCount();i++)
				{					
					row[i] = r.getString(i+1);
				}
				result.add(row);			
			}
			conn.close();
		}
		catch (ClassNotFoundException err){
			System.out.println("DB-Driver nicht gefunden!");
			System.out.println(err);
		}
		catch (SQLException err){
			System.out.println("Connect nicht möglich!");
			System.out.println(err);
		}
		return result;
	}
/**
 * @author Falzer, Marcel
 * @version 1.0
 * @since 20.01.2011
 * @exception ClassNotFoundException
 * @exception SQLException
 * @param sqlStatement - (STRING) the sql statement to execute
 * @param params - (ArrayList<STRING>) the parameter list
 * @return result - (ArrayList<STRING>) the result list of the sql statement execution
 */
	public static ArrayList<String[]> ExecuteQuery(String sqlStatement,ArrayList<String> params){
		if (params.isEmpty()){
			return ExecuteQuery(sqlStatement);			
		}
		else
		{			
			ArrayList<String[]> result = new ArrayList<String[]>();
			try{
				Class.forName(driver);		
				conn = DriverManager.getConnection(path, user, pwd);
				PreparedStatement stmt = conn.prepareStatement(sqlStatement);
				int _paramCount= 1;
				for (Iterator iter = params.iterator(); iter.hasNext();) {
			  		stmt.setString(_paramCount, (String) iter.next());
			  		_paramCount++;
				}				
				stmt.execute();
				ResultSet r = stmt.getResultSet();
				ResultSetMetaData rmd = r.getMetaData();
				while (r.next()){
					String[] row = new String[rmd.getColumnCount()];
					for(int i = 0; i < rmd.getColumnCount();i++)
					{					
						row[i] = r.getString(i+1);
					}
					result.add(row);			
				}
				stmt.close();
				conn.close();
			}
			catch (ClassNotFoundException err){
				System.out.println("DB-Driver nicht gefunden!");
				System.out.println(err);
			}
			catch (SQLException err){
				System.out.println("Connect nicht möglich!");
				System.out.println(err);
			}
			return result;
		}
	}
}
