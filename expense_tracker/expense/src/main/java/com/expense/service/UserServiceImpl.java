package com.expense.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.expense.dbutil.DBUtil;

@Service
public class UserServiceImpl implements UserService {

	Connection connection;
	int flag=0;
	
	public UserServiceImpl() throws SQLException {
		
		connection=DBUtil.getconnection();
	}
	
	@Override
	public int loginValidation(String username, String password) {
		
		try {
			PreparedStatement statement =connection.prepareStatement("SELECT *FROM user_table WHERE username='"+username+"'");
			ResultSet rs=statement.executeQuery();
			
			while(rs.next()) {
				if(rs.getString(3).equals(username) && rs.getString(4).equals(password)) {
					flag=1;
				}
				else {
					System.out.println("Invalid username/password");
					flag=0;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	
}
