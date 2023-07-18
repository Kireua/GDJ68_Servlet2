package com.iu.main.test;

import com.iu.main.member.MemberDAO;
import com.iu.main.member.MemberDTO;

public class MemberMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemberDTO memberDTO = new MemberDTO();
		MemberDAO memberDAO = new MemberDAO();
		
		memberDTO.setId("akakak");
		memberDTO.setPw("123123");
		memberDTO.setName("sssss");
		memberDTO.setEmail("asdf@asdfa");
		
		
		try {
			int result = memberDAO.join(memberDTO);
			System.out.println(result==1);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

}
