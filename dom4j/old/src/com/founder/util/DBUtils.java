package com.founder.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import oracle.sql.BLOB;
import oracle.sql.CLOB;

public class DBUtils {

	private static Log log = LogFactory.getLog(DBUtils.class);

	/**
	 * 根据某种条件更新指定的CLOB字段 主要用于需要利用多个键值确定CLOB字段的情况
	 * 
	 * @param conn
	 *            数据库连接
	 * @param table
	 *            数据表
	 * @param cond
	 *            条件
	 * @param contentField
	 *            内容字段的名称
	 * @param content
	 *            要写入的大文本内容
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public static void writeOracleClob(Connection conn, String table,
			String cond, String contentField, String content) throws Exception {
		StringBuffer updateSQL = new StringBuffer();
		updateSQL.append("update ").append(table);
		updateSQL.append(" set ").append(contentField).append("=EMPTY_CLOB()");
		updateSQL.append(" where ").append(cond);
		StringBuffer selectSQL = new StringBuffer();
		selectSQL.append("select ").append(contentField);
		selectSQL.append(" from ").append(table);
		selectSQL.append(" where ").append(cond);
		selectSQL.append(" for update");
		
		Statement st = null;
		ResultSet rs = null;
		Writer writer = null;

		try {
			st = conn.createStatement();
			st.executeUpdate(updateSQL.toString());
			st.close();
			st = conn.createStatement();
			rs = st.executeQuery(selectSQL.toString());
			if (rs.next()) {
				Object clob = rs.getClob(1);
				/* 如果appSvr是Weblogic 则用weblogic.jdbc.common.OracleClob */
				if (clob instanceof weblogic.jdbc.common.OracleClob) {
					weblogic.jdbc.common.OracleClob clobfield = (weblogic.jdbc.common.OracleClob) clob;
					writer = new BufferedWriter(clobfield
							.getCharacterOutputStream());
				}
				/* 如果不是Weblogic 而是Tomcat WebSphere则用oracle的oracle.jdbc.CLOB */
				else {
					CLOB clobfield = (CLOB) clob;
					writer = new BufferedWriter(clobfield.getCharacterOutputStream());
				}
				writer.write(content);
				writer.flush();
			}
		} catch (Exception ex) {
			log.error("Can not write CLOB field", ex);
			throw ex;
		} finally {
			writer.close();
			writer = null;
			close(rs, st);
			rs = null;
			st = null;
		}
	}

	/**
	 * 写字符串内容到Oracle的CLOB类型字段中
	 * 
	 * @param conn
	 *            数据库连接
	 * @param table
	 *            表名
	 * @param pkField
	 *            主键字段名
	 * @param pk
	 *            主键值
	 * @param contentField
	 *            CLOB类型字段名称
	 * @param content
	 *            要写入CLOB类型字段的字符串内容值
	 */
	public static void writeOracleClob(Connection conn, String table, String pkField,
			String pk, String contentField, String content) throws Exception {
		String cond = pkField + "='" + pk + "'";
		writeOracleClob(conn, table, cond, contentField, content);
	}

	/**
	 * 写内容到oracle的blob字段中
	 * 
	 * @param conn
	 *            数据库连接
	 * @param table
	 *            数据表
	 * @param pkField
	 *            主键字段
	 * @param pk
	 *            主键
	 * @param contentField
	 *            BLOB字段
	 * @param content
	 *            内容，以输入流的形式提供
	 * @throws Exception
	 */
	public static void writeOracleBlob(Connection conn, String table,
			String pkField, String pk, String contentField, InputStream content)
			throws Exception {

		StringBuffer updateSQL = new StringBuffer();
		updateSQL.append("update ").append(table);
		updateSQL.append(" set ").append(contentField).append("=EMPTY_BLOB()");
		updateSQL.append(" where ").append(pkField).append("='").append(pk).append("'");
		StringBuffer selectSQL = new StringBuffer();
		selectSQL.append("select ").append(contentField);
		selectSQL.append(" from ").append(table);
		selectSQL.append(" where ").append(pkField).append("='").append(pk).append("'");
		selectSQL.append(" for update");

		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			st.executeUpdate(updateSQL.toString());
			st.close();
			st = conn.createStatement();
			rs = st.executeQuery(selectSQL.toString());
			if (rs.next()) {
				Object blob = rs.getBlob(1);
				BLOB clobfield = (BLOB) blob;
				OutputStream os = clobfield.setBinaryStream(0);
				byte[] bContent = new byte[clobfield.getBufferSize()];
				int length = 0;
				while ((length = content.read(bContent)) != -1) {
					os.write(bContent, 0, length);
				}
				os.close();
			}
		} catch (Exception ex) {
			throw ex;
		} finally {
			close(rs, st);
			rs = null;
			st = null;
		}
	}

	/**
	 * 根据某种条件更新指定的CLOB字段 主要用于需要利用多个键值确定CLOB字段的情况
	 * 
	 * @param conn
	 *            数据库连接
	 * @param table
	 *            数据表名称
	 * @param cond
	 *            条件
	 * @param contentField
	 *            大文本字段名
	 * @return 大文本内容
	 */
	public static String readOracleClob(Connection conn, String table,
			String cond, String contentField) {
		StringBuffer selectSQL = new StringBuffer();
		selectSQL.append("select ").append(contentField);
		selectSQL.append(" from ").append(table);
		selectSQL.append(" where ").append(cond);

		Statement st = null;
		ResultSet rs = null;
		Clob clob = null;
		Reader reader = null;
		StringBuffer result = new StringBuffer(1024);

		try {
			st = conn.createStatement();
			rs = st.executeQuery(selectSQL.toString());
			if (rs.next()) {
				clob = rs.getClob(1);
				if (clob == null) {
					return "";
				}
				reader = clob.getCharacterStream();
				char[] szContent = new char[8192];
				int iReaded = 0;
				while ((iReaded = reader.read(szContent)) > 0) {
					result.append(szContent, 0, iReaded);
				}
			}
		} catch (Exception ex) {
			log.error("Can not read CLOB field. ", ex);
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
			}
			reader = null;
			close(rs, st);
			rs = null;
			st = null;
		}
		return result.toString();
	}

	/**
	 * 读取Oracle的clob类型的字段内容
	 * 
	 * @param conn
	 *            数据库连接
	 * @param table
	 *            表名
	 * @param pkField
	 *            主键字段名
	 * @param pk
	 *            主键的值
	 * @param contentField
	 *            clob类型字段的名称
	 * @return clob类型字段的值
	 */
	public static String readOracleClob(Connection conn, String table,
			String pkField, String pk, String contentField) {
		String cond = pkField + "='" + pk + "'";
		return readOracleClob(conn, table, cond, contentField);
	}

	/**
	 * 取Oracle数据库中Sequeence的值
	 * 
	 * @param con
	 *            数据库连接
	 * @param seqName
	 *            数据库中的序列名称
	 * @return 可用的序列号
	 */
	public static long getSequeenceValue(Connection con, String seqName) {
		long lRet = -1;
		Statement stat = null;
		ResultSet res = null;
		String sSQL = "select " + seqName + ".nextVal from dual";
		try {
			stat = con.createStatement();
			res = stat.executeQuery(sSQL);
			while (res.next()) {
				lRet = res.getLong("nextVal");
			}
		} catch (Exception ex) {
			log.error("no Such Sequeence:" + seqName);
		} finally {
			close(res,stat);
			stat = null;
			res = null;
		}
		return lRet;
	}


	/**
	 * 简单执行一个SQL语句（INSERT/UPDATE/DELETE）
	 * 
	 * @param con
	 *            数据库连接
	 * @param sSQL
	 *            SQL语句
	 * @return 操作所影响的记录数
	 */
	public static int excuteSQL(Connection con, String sSQL) {
		int iRet = -1;
		Statement stat = null;
		try {
			stat = con.createStatement();
			iRet = stat.executeUpdate(sSQL);
		} catch (Exception ex) {
			log.error("excuteUpdate Error:" + sSQL);
		} finally {
			close(stat);
			stat = null;
		}
		return iRet;
	}


	/**
	 * 从数据库中获取一个字符串结果，根据指定的SQL语句
	 * 
	 * @param 数据库连接
	 * @param sql
	 *            指定SQL语句
	 * @return 字符结果
	 * @exception SQLException
	 */
	public static String getStringBySql(Connection conn, String sql)
			throws SQLException {
		Statement st = null;
		ResultSet rs = null;
		String ret = null;

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				ret = rs.getString(1);
			}
		} catch (Exception ex) {
			throw new SQLException(ex.getMessage());
		} finally {
			close(rs, st);
			rs = null;
			st = null;
		}

		return ret;
	}


	/**
	 * 从数据库中获取一个Date结果，根据指定的SQL语句
	 * 
	 * @param conn
	 *            数据库连接
	 * @param sql
	 *            指定SQL语句
	 * @return Date 日期类型的结果
	 * @exception SQLException
	 */
	public static Date getDateBySql(Connection conn, String sql)
			throws SQLException {
		Statement st = null;
		ResultSet rs = null;
		Date ret = null;

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				ret = rs.getTimestamp(1);
			}
		} catch (Exception ex) {
			throw new SQLException(ex.getMessage());
		} finally {
			close(rs, st);
			rs = null;
			st = null;
		}

		return ret;
	}


	/**
	 * 从数据库中方便的获取一个整型值，根据指定的SQL语句 通常象select count(*) from xxx语句可以方便的得到结果
	 * 
	 * @param conn
	 *            指定的数据库连接
	 * @param sql
	 *            指定查询SQL语句
	 * @return 查询到的结果
	 * @exception SQLException
	 */
	public static int getIntBySql(Connection conn, String sql)
			throws SQLException {
		int ret = 0;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			if (rs.next()) {
				ret = rs.getInt(1);
			}
		} catch (Exception ex) {
			throw new SQLException(ex.getMessage());
		} finally {
			close(rs, pst);
			rs = null;
			pst = null;
		}
		return ret;
	}

	public static long getNextId(Connection conn, String name)
			throws SQLException {
		long lRet = -1;
		ResultSet rs = null;
		Statement stat = null;
		String strSql = "select " + name + ".nextval as newval from dual";
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(strSql);
			if (rs.next())
				lRet = rs.getLong(1);
			else
				lRet = -1;
		} catch (SQLException ex) {
			throw ex;
		} finally {
			close(rs, stat);
		}
		return lRet;
	}

	/**
	 * 关闭数据库连接所使用的资源
	 * 
	 * @param rs
	 *            记录集
	 * @param st
	 *            预处理语句
	 * @param conn
	 *            数据库连接
	 */
	public static void close(ResultSet rs, Statement st, Connection conn) {
		try {
			rs.close();
		} catch (Exception e) {
		}

		try {
			st.close();
		} catch (Exception e) {
		}

		try {
			conn.close();
		} catch (Exception e) {
		}
	}

	/**
	 * 关闭数据库连接所使用的资源
	 * 
	 * @param rs
	 *            记录集
	 * @param st
	 *            预处理语句
	 * @param conn
	 *            数据库连接
	 */
	public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
		org.apache.commons.dbutils.DbUtils.closeQuietly(conn, stmt, rs);
	}

	/**
	 * 关闭数据库连接所使用的资源
	 * 
	 * @param st
	 *            预处理语句
	 * @param conn
	 *            数据库连接
	 */
	public static void close(Statement st, Connection conn) {
		close(null, st, conn);
	}

	/**
	 * 关闭数据库连接所使用的资源
	 * 
	 * @param conn
	 *            数据库连接
	 */
	public static void close(Connection conn) {
		close(null, null, conn);
	}

	/**
	 * 关闭数据库连接所使用的资源
	 * 
	 * @param rs
	 *            记录集
	 * @param st
	 *            预处理语句
	 */
	public static void close(ResultSet rs, Statement st) {
		close(rs, st, null);
	}

	/**
	 * 关闭数据库连接所使用的资源
	 * 
	 * @param rs
	 *            记录集
	 */
	public static void close(ResultSet rs) {
		close(rs, null, null);
	}

	/**
	 * 关闭数据库连接所使用的资源
	 * 
	 * @param st
	 *            预处理语句
	 */
	public static void close(Statement st) {
		close(null, st, null);
	}

	/**
	 * 回滚连接
	 * 
	 * @param conn
	 */
	public static void rollback(Connection conn) {
		try {
			conn.rollback();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
}
