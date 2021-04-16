package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import db.DBClose;
import db.DBConnection;
import dto.Dto;

//singleton
public class EmpDao { // DB와 접속하는 class
	
	private static EmpDao dao = null;
	
	private EmpDao() {
		
	}
	
	public static EmpDao getInstance() {
		if(dao == null) {
			dao = new EmpDao();
		}
		return dao;
	}
			
		public int Insert(String ename, int eno, String depname, String hiredate) {	// 추가하기
			
			// query 준비
			String sql = " INSERT INTO EMP_LOYEES(ENAME, ENO, DEPNAME, HIREDATE) "
					+" VALUES ('"+ ename + "','" + eno +"','" + depname +"',"+"'" + hiredate + "') ";
			System.out.println(sql);
			
			// DB connect
			
			Connection conn = DBConnection.getConnection();
			Statement stmt = null;
			int count = 0;
			
			// DB process
			try {
				stmt = conn.createStatement();
				count = stmt.executeUpdate(sql);
		
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
			DBClose.close(conn, stmt,null);
		
		}
			return count;
	}

		
		
		public int delete(String ename) { // 삭제하기
			String sql = " DELETE FROM EMP_LOYEES "
					+ " WHERE ENAME = '" + ename +"'";
			System.out.println(sql);
			
			Connection conn = DBConnection.getConnection();
			Statement smtm = null;
			int count = 0;
			
			//DB process
			try {
				smtm = conn.createStatement();
				count = smtm.executeUpdate(sql);
				
				System.out.println("성공적으로 삭제됐습니다");
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
				DBClose.close(conn, smtm, null);
		
				}
			return count;
			}

		
	public int update(String ename, String depname) {	// 수정하기
		String sql = " UPDATE EMP_LOYEES "
				+ " SET DEPNAME = '" + depname +"' "
						+ " WHERE ENAME = '" + ename +"' ";
		System.out.println(sql);
		
		Connection conn = DBConnection.getConnection();
		Statement stmt = null;
		
		int count = 0;
		// db processing
				try {
					stmt = conn.createStatement();
					count = stmt.executeUpdate(sql);
					
					System.out.println("수정됐습니다");
				}catch(SQLException e){
					e.printStackTrace();
				}finally {
					try {
						if(stmt != null) {
							stmt.close();
						}
						if(conn != null) {
							conn.close();
						}
						
					}catch(SQLException e) {
						e.printStackTrace();
					}
				}
				return count;
	}
	

	
	public Dto nameSelect(String ename) {	// 이름으로 검색
		String sql = " SELECT ENAME, ENO, DEPNAME, HIREDATE "
				+ " FROM EMP_LOYEES "
				+ " WHERE ENAME = '" + ename + "' ";
		
		System.out.println(sql);
		
		Connection conn = DBConnection.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;	
		
		Dto dto = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			if(rs.next()) {	
				String ename1 = rs.getString("ename");
				int eno1 = rs.getInt("eno");
				String depname1 = rs.getString("depname");
				String hiredate1 = rs.getString("hiredate");
			
				
				dto = new Dto(ename1, eno1, depname1, hiredate1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(conn, stmt, rs);
		}
		return dto;
	}
	

	
public List<Dto> getList() { //전체 검색
	
	String sql = " SELECT * "
			+ " FROM EMP_LOYEES ";
	
	Connection conn = DBConnection.getConnection();
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	List<Dto> list = new ArrayList<Dto>();
	
	try {			
		psmt = conn.prepareStatement(sql);
		
		rs = psmt.executeQuery();
		
		while(rs.next()) {
			String ename1 = rs.getString("ename");
			int eno1 = rs.getInt("eno");
			String depname1 = rs.getString("depname");
			String hiredate1 = rs.getString("hiredate");
		
			
			Dto dto = new Dto(ename1, eno1, depname1, hiredate1);
			
			list.add(dto);

		}
	} catch (SQLException e) {
	
		e.printStackTrace();
	}finally {
		DBClose.close(conn, psmt, rs);
	}
	return list;	
}
	
public List<Dto> day(){	// 날짜 순
	String sql = " SELECT * "
			+ " FROM EMP_LOYEES "
			+ " ORDER BY HIREDATE ";
	
	Connection conn = DBConnection.getConnection();
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	List<Dto> list = new ArrayList<Dto>();
	
	try {
		psmt = conn.prepareStatement(sql);
		rs = psmt.executeQuery();
		
		while(rs.next()) {
			String ename1 = rs.getString("ename");
			int eno1 = rs.getInt("eno");
			String depname1 = rs.getString("depname");
			String hiredate1 = rs.getString("hiredate");
		
			
			Dto dto = new Dto(ename1, eno1, depname1, hiredate1);
			
			list.add(dto);
		}
	
	} catch (SQLException e) {
		
		e.printStackTrace();
	}finally {
		DBClose.close(conn, psmt, rs);
	}
	return list;

	}


}
