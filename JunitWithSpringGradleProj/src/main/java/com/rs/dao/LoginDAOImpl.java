package com.rs.dao;

import java.sql.CallableStatement;
import java.sql.Types;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository(value="loginDAO")
public class LoginDAOImpl implements LoginDAO {
	@Autowired
	HibernateTemplate ht;
	
	@Override
	public int checkLogin(String username, String password) {
		String QUERY="{call P_LOGIN_CHECK(?,?,?)}";
		Session session=null;
		System.out.println(username+" "+password);
		int count=0;
		
		ht.setCheckWriteOperations(false);
		session=ht.getSessionFactory().openSession();
		count=session.doReturningWork(conn->{
			CallableStatement cstmt=null;
			int flag=0;
			cstmt=conn.prepareCall(QUERY);
			cstmt.setString(1,username);
			cstmt.setString(2,password);
			cstmt.registerOutParameter(3,Types.INTEGER);
			cstmt.execute();
			flag=cstmt.getInt(3);
			
			return flag;
		});
		System.out.println("Count: "+count);
		return count;
	}

}
