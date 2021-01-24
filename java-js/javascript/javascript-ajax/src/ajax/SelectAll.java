package ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectAll extends HttpServlet {

	/**
	 *  by 飞天猫熊之小白侠--姜宇
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		DataUtils ds = DataUtils.getInstance();
		Connection conn = ds.getConnection();
		String sql = "select * from empoo where id="+id;
		String sql2 = "select * from empoo";
		Statement st = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		/**
		 *  by 飞天猫熊之小白侠--姜宇
		 */
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()){
				rs1 = st.executeQuery(sql2);
				/**
				 *  by 飞天猫熊之小白侠--姜宇
				 */
				out.print("<table border='1' color='gree' width='70%'>");
				while(rs1.next()){
					out.print("<tr><td>");
					out.print(rs1.getObject(1));
					out.print("</td><td>");
					out.print(rs1.getObject(2));
					out.print("</td><td>");
					out.print(rs1.getObject(3));
					out.print("</td><td>");
					out.print(rs1.getObject(4));
					out.print("</td></tr>");
				}
				out.print("</table>");
			}else{
				out.print("输入的ID号码不存在!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ds.close(conn, st, rs1);
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 *  by 飞天猫熊之小白侠--姜宇
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
