package com.iu.main.utill;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbConnector {

	public static Connection getConnection() throws Exception {
		String user ="user01";
		String password="user01";
		String url="jdbc:oracle:thin:@3.34.137.106:1521:xe";
		String driver="oracle.jdbc.driver.OracleDriver";
		
		//1. 드라이버를 메모리에 로딩
		Class.forName(driver);
		
		//2. DB 연결
		Connection con = DriverManager.getConnection(url, user, password);
		
		//reference type인 con이기 때문에 위의 명령어로 주소를 받아오면 성공했다고 볼 수 있음
		System.out.println(con);
		
		return con;
		
	}
	
	public static void disConnect(ResultSet rs, PreparedStatement st, Connection con )throws Exception {
		rs.close();
		st.close();
		con.close();
		
	}
	
	public static void disConnect(PreparedStatement st, Connection con) throws Exception {
		st.close();
		con.close();
	}
}
