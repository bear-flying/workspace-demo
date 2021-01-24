package com.jdbc.content;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jdbc.datasource.DataSource;
/**
 * 
 * @author JiangYu
 * JDBC批处理demo
 *
 */
public class Play05 {
	public static void main(String[] args) throws SQLException {
		DataSource ds = DataSource.getInstance();
		Connection conn = ds.getConnection();
		String sql = "insert into aax values(?)";
		conn.setAutoCommit(false);
		PreparedStatement pstmt = conn.prepareStatement(sql);
		for (int i = 0; i < 20011; i++) {
			pstmt.setInt(1, i);
			// 添加批语句
			pstmt.addBatch();
			if (i % 2000 == 0) {// 添加了2000个批语之后
				pstmt.executeBatch();// 在批执行
				conn.commit();
			}
			// 在循环中执行批语句之后，一定要清除批语句不清除的话，下次执行的时候还有
			pstmt.clearBatch();
		}
		// 执行批语句 i<20011 后11条不够除以2000的，所以，在循环之外还要执行
		pstmt.executeBatch();// conn.commit();
	}
}
