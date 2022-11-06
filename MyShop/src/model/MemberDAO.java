package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		System.out.println(con);
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
		}finally {
			close();
		}
	}
}
