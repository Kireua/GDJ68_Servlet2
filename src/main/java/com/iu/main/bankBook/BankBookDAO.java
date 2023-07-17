package com.iu.main.bankBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.main.utill.DbConnector;

public class BankBookDAO {
	
	//상품 N개 조회
	public ArrayList<BankBookDTO> bankBookSearch(String s) throws Exception{
		ArrayList<BankBookDTO> ar = new ArrayList<BankBookDTO>();
		Connection con = DbConnector.getConnection();
		
		String sql = "SELECT * FROM BANKBOOK WHERE BOOKNAME LIKE ? ORDER BY BOOKNUM DESC";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, "%"+s+"%");
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			BankBookDTO bankBookDTO = new BankBookDTO();
			bankBookDTO.setBookNum(rs.getLong("BOOKNUM"));
			bankBookDTO.setBookName(rs.getString("BOOKNAME"));
			bankBookDTO.setBookRate(rs.getDouble("BOOKRATE"));
			bankBookDTO.setBookSale(rs.getInt("BOOKSALE"));
			ar.add(bankBookDTO);
		}
		if(ar.size()==0) {
			System.out.println("찾는 데이터가 없습니다.");
		}

		
		DbConnector.disConnect(rs, st, con);
		return ar;
	}
	
	//상품 N개 조회
	public ArrayList<BankBookDTO> bankBookList() throws Exception{
		ArrayList<BankBookDTO> ar = new ArrayList<BankBookDTO>();
		
		//1. DB 연결
		Connection con = DbConnector.getConnection();
		//2. query문
		String sql = "SELECT * FROM BANKBOOK ORDER BY BOOKNUM DESC";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		//5. 최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			BankBookDTO bankBookDTO = new BankBookDTO();
			bankBookDTO.setBookNum(rs.getLong("BOOKNUM"));
			bankBookDTO.setBookName(rs.getString("BOOKNAME"));
			bankBookDTO.setBookRate(rs.getDouble("BOOKRATE"));
			bankBookDTO.setBookSale(rs.getInt("BOOKSALE"));
			ar.add(bankBookDTO);
		}
		
		DbConnector.disConnect(rs, st, con);
		return ar;
	}
	
	//insert
	//bankBookAdd
	
	public int bankBookAdd(BankBookDTO bankBookDTO) throws Exception {
		
		//1. DB 연결
		Connection con = DbConnector.getConnection();
		//2. 쿼리문 작성
		String insertsql= "INSERT INTO BANKBOOK VALUES (BANK_SEQ.NEXTVAL,?,?,?,?)";
		
		//3. 쿼리문 미리 전송
		PreparedStatement st = con.prepareStatement(insertsql);
		
		//4.? 값 세팅
		st.setString(1, bankBookDTO.getBookName());
		st.setDouble(2, bankBookDTO.getBookRate());
		st.setInt(3, bankBookDTO.getBookSale());
		st.setString(4, bankBookDTO.getBookContents());
		//5. 최종 전송 및 결과 처리
		int result = st.executeUpdate();
		
		DbConnector.disConnect(st, con);
		return result;
		
	}
	
	public BankBookDTO bankBookDetail(BankBookDTO bankBookDTO) throws Exception {
		Connection con = DbConnector.getConnection();
		String sql= "SELECT * FROM BANKBOOK WHERE BOOKNUM = ?";
		
	
		PreparedStatement st = con.prepareStatement(sql);
		

		st.setLong(1, bankBookDTO.getBookNum());
		ResultSet rs = st.executeQuery();
		
		//한 줄 읽기
		if(rs.next()) {
			bankBookDTO.setBookNum(rs.getLong("BOOKNUM"));
			bankBookDTO.setBookName(rs.getString("BOOKNAME"));
			bankBookDTO.setBookRate(rs.getDouble("BOOKRATE"));
			bankBookDTO.setBookSale(rs.getInt("BOOKSALE"));
			bankBookDTO.setBookContents(rs.getString("BOOKCONTENTS"));
		}else {
			bankBookDTO=null;
		}
		DbConnector.disConnect(rs, st, con);
		return bankBookDTO;
	}

	public int bankBookDelete(BankBookDTO bankBookDTO) throws Exception {
		//1. DB 연동
		Connection con = DbConnector.getConnection();
		//2. query문 작성
		String sql="DELETE BANKBOOK WHERE BOOKNUM=?";
		//3. 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		//4. ? 세팅
		st.setLong(1, bankBookDTO.getBookNum());
		//5. 최종전송 및 결과 처리
		int result = st.executeUpdate();
		
		System.out.println("Db Delete");
		
		DbConnector.disConnect(st, con);
		return result;
	}
	
	public int bankBookUpdate(BankBookDTO bankBookDTO) throws Exception{
		int result = 0;
		
		Connection con = DbConnector.getConnection();
		
		String sql="UPDATE BANKBOOK SET BOOKNAME=?, BOOKCONTENTS=?, BOOKRATE=?, BOOKSALE=? WHERE BOOKNUM=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, bankBookDTO.getBookName());
		st.setString(2, bankBookDTO.getBookContents());
		st.setDouble(3, bankBookDTO.getBookRate());
		st.setInt(4, bankBookDTO.getBookSale());
		st.setLong(5, bankBookDTO.getBookNum());
		
		result = st.executeUpdate();
		
		DbConnector.disConnect(st, con);
		return result;
		
	}
}
