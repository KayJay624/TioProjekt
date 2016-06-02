package com.mycompany;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import com.utils.DatabaseConnection;

public class TransactionDAO {

	public static void addTransaction(Transact transaction, int userId) {
			Connection c = DatabaseConnection.getInstance().getPsqlConnection();
			try {
				PreparedStatement statement = c.prepareStatement(
						"INSERT INTO transactions (user_id, transaction_date, "
						+ "position_id, comment, state) VALUES (?, ?, ?, ?, ?)");
				statement.setInt(1, userId);
				//DateFormat df = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
				//Date result =  df.parse(new Date().toString());
				//statement.setDate(2, new java.sql.Date(result.getTime()));
				statement.setDate(2, new java.sql.Date(0));
				statement.setInt(3, transaction.getPosition().getId());
				statement.setString(4, "pusto");
				statement.setBoolean(5, false);
				statement.executeUpdate();
				statement.close();
				c.commit();
				System.out.println("sdfsdf");
									
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		
	public static void updateTransactionComment(int transactionId, String comment){
			Connection c = DatabaseConnection.getInstance().getPsqlConnection();
			try {
				PreparedStatement statement = c.prepareStatement("UPDATE transactions SET comment = ? where transaction_id=?");
				statement.setString(1, comment);
				statement.setInt(2, transactionId);


				statement.executeUpdate();
				statement.close();
				c.commit();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	public static void updateTransactionState(int transactionId, boolean state){
			Connection c = DatabaseConnection.getInstance().getPsqlConnection();
			try {
				PreparedStatement statement = c.prepareStatement("UPDATE transactions SET state = ? where transaction_id=?");
				statement.setBoolean(1, state);
				statement.setInt(2, transactionId);


				statement.executeUpdate();
				statement.close();
				c.commit();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	public static LinkedList<Transact> getTransactions (int userId, String from, String to)  {
		Connection c = DatabaseConnection.getInstance().getPsqlConnection();
		
		try {
			Statement stmt = c.createStatement();
			String query="select * from transactions";

			query += " where user_id = " + userId;
			if (from != null && to != null) {
				query+=" and transaction_date BETWEEN '" + from +"' AND '" + to +"'";
			}

			final LinkedList<Transact> result = new LinkedList<Transact>();
			System.out.println(query);
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
					int id  = rs.getInt("transaction_id");
					int pos = rs.getInt("position_id");
					String date = rs.getString("transaction_date");
					String comment = rs.getString("comment");
					boolean state  = rs.getBoolean("state");
					PositionDOA posDoa = new PositionDOA();

					result.add(new Transact(id, date, posDoa.getPositionById(pos), state, comment));
			}

			stmt.close();


			return result;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;


	}


}
