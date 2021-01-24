import java.sql.*;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			conn = DriverManager.getConnection("jdbc:odbc:renda", "", "");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select db_headline as title,db_day as pubtime,db_content as content,db_author as author,db_lanmu as keyword,db_source as sourcename FROM »À¥ÛºÚ±®");
			while (rs.next()) {
				String title = rs.getString("title");
				String pubtime = rs.getString("pubtime");
				String content = rs.getString("content");
				String author = rs.getString("author");
				System.out.println(title+"   "+pubtime+"   "+content.length()+"   "+author);
			}
		} catch (Exception el) {
			el.printStackTrace();
		}finally{
			org.apache.commons.dbutils.DbUtils.closeQuietly(conn, stmt, rs);
		}
	}

}
