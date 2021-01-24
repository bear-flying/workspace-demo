package com.javasky.datas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public interface IDataSource {

	public abstract Connection getConnection();

	public abstract void close(Connection conn);

	public abstract void close(Connection conn, Statement stmt);

	public abstract void close(Connection conn, Statement stmt, ResultSet rs);

}