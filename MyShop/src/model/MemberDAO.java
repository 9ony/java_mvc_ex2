package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import DBConnection.conn;
public class MemberDAO {
	Connection con;
	PreparedStatement pstm;
	ResultSet rs;
	
	public void close() {
		try {
			if(rs!=null) rs.close();
			if(pstm!=null) pstm.close();
			if(con!=null) con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	//회원가입
	public int Memberinsert(Member m) {
		try {
		con=conn.getCon();
		StringBuilder buf = new StringBuilder("insert into t_member(idx,name,id,pwd,tel1,tel2,tel3,indate)")
				.append(" values(t_member_idx_sq.nextval,?,?,?,?,?,?,sysdate)");
		pstm = con.prepareStatement(buf.toString());
		
		pstm.setString(1, m.getName());
		pstm.setString(2, m.getId());
		pstm.setString(3, m.getPw());
		pstm.setString(4,m.getTel1());
		pstm.setString(5, m.getTel2());
		pstm.setString(6, m.getTel3());
		
		int n = pstm.executeUpdate();
		
		return n;
		}catch(SQLException e) {
			close();
			e.printStackTrace();
			return 0;
		}
		finally {
			close();
		}
	}
	public boolean MemberCheck(String id , String pwd) {
		try {
			con=conn.getCon();
			StringBuilder buf = new StringBuilder("select id,pwd from t_member where id=?");
			pstm = con.prepareStatement(buf.toString());
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			if(rs.next()) { //buf 쿼리에 값이 나오면 true 반환 로그인하려는 아이디가 있으면 true반환함
				System.out.println(pwd.equals(rs.getString("pwd")));
				if (!pwd.equals(rs.getString("pwd"))) {
					System.out.println("비밀번호가 일치하지 않습니다");
					return false;
				}else {
					System.out.println("로그인 성공");
					return true;
				}
			}else {
				System.out.println("아이디가 일치하지 않습니다"); 
				return false;
			}
		}catch(SQLException e) {
			close();
			e.printStackTrace();
			return false;
		}finally {
			close();
		}
	}
}
