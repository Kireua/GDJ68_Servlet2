package com.iu.main.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.iu.main.bankBook.BankBookDTO;
import com.iu.main.utill.DbConnector;

public class MemberDAO {
	
	public int join(MemberDTO memberDTO) throws Exception{

		//1. DB 연결
		Connection con = DbConnector.getConnection();
		//2. 쿼리문 작성
		String sql = "INSERT INTO MEMBER (ID,PW,NAME,EMAIL,BIRTH) VALUES (?,?,?,?,?)";
		
		//3. 쿼리문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4.? 값 세팅
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		st.setString(3, memberDTO.getName());
		st.setString(4, memberDTO.getEmail());
		st.setDate(5, memberDTO.getBirth());
		//5. 최종 전송 및 결과 처리
		int result = st.executeUpdate();
		
		DbConnector.disConnect(st, con);
		return result;
	}
	
	public MemberDTO login(MemberDTO memberDTO) throws Exception {
		Connection con = DbConnector.getConnection();
		
		String sql= "SELECT ID,NAME FROM MEMBER WHERE ID = ? AND PW = ?";
	
		PreparedStatement st = con.prepareStatement(sql);
		

		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		
		ResultSet rs = st.executeQuery();
		
		
		//한 줄 읽기
		if(rs.next()) {
			memberDTO = new MemberDTO();
			memberDTO.setId(rs.getString("ID"));
			memberDTO.setName(rs.getString("NAME"));	
		}else {
			memberDTO=null;
		}
		
		DbConnector.disConnect(rs, st, con);
		
		return memberDTO;
	} 

}
