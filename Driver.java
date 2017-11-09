package jdbcdemo;
import java.sql.*;

public class Driver {

	static String url = "jdbc:mysql://localhost:3306/labfour?useSSL=false";
	static String user = "root";
	static String password = "1234liu";
	
	public static void main(String[] args) {
		
//		QuestionNumberOne();
//		QuestionNumberTwoA();
//		QuestionNumberTwoB();
//		QuestionNumberTwoC();
//		QuestionNumberTwoD();
//		QuestionNumberThree();
//		QuestionNumberFour();
//		QuestionNumberFive();
//		QuestionNumberSix();
//		QuestionNumberSeven();
//		QuestionNumberEight();
		
	}
	
	public static void QuestionNumberOne(){
		try{
			//get connection
			Connection myConn = DriverManager.getConnection(url,user,password);
			//create a statement
			Statement myStmt = myConn.createStatement();
			//execute SQL query
			String query ="select t.StartLocationName,t.DestinationName,tf.Date,tf.ScheduledArriualTime,tf.ScheduledStartTime,tf.DriverName,tf.BusID"
						+" from Trip t ,TripOffering tf"
						+" where t.TripNumber = tf.TripNumber";
					     
			ResultSet myRs = myStmt.executeQuery(query);
			while(myRs.next()){
				System.out.println(myRs.getString("StartLocationName")+"  "+myRs.getString("DestinationName")
						+"  "+myRs.getString("Date")+"  "+myRs.getString("ScheduledStartTime")
						+"  "+myRs.getString("ScheduledArriualTime")+"  "+myRs.getString("DriverName")
						+"  "+myRs.getString("BusID"));
			}
			myConn.close();
			myStmt.close();
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
	}
	
	public static void QuestionNumberTwoA(){
		String TripNum = "7";
		String Date = "2017-04-06";
		String StartTime = "8:00:00";
		QuestionNumberTwoPartA(TripNum,Date,StartTime);
	}
	
	public static void QuestionNumberTwoPartA(String tripN,String date,String starttime){
		try{
			//get connection
			Connection myConn = DriverManager.getConnection(url,user,password);
			//create a statement
			Statement myStmt = myConn.createStatement();
			//execute SQL query
			String query ="delete"
						+" from TripOffering"
						+" where"+" date = "+"'"+date+"'"
						+" and "+ "ScheduledStartTime = "+"'"+starttime+"'"
						+" and "+ "TripNumber = "+"'"+tripN+"'";
			int rowAffected = myStmt.executeUpdate(query);
			System.out.println("Rows affected: "+rowAffected+"\n complete Delete");
			myConn.close();
			myStmt.close();
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
	}
	
	public static void QuestionNumberTwoB(){
		String tripNum = "8";
		String Date = "2017-04-07";
		String StartTime = "8:00:00";
		String arrivalTime = "14:00:00";
		String driverName = "Joe";
		String busId = "3";
		QuestionNumberTwoPartB(tripNum,Date,StartTime,arrivalTime,driverName,busId);
	}
	public static void QuestionNumberTwoPartB(String tripN,String date,String starttime,String arrivaltime,String drivername,String busid){
		try{
			//get connection
			Connection myConn = DriverManager.getConnection(url,user,password);
			//create a statement
			Statement myStmt = myConn.createStatement();
			//execute SQL query
			String query =
						" insert into TripOffering"
						+" (TripNumber, Date, ScheduledStartTime, ScheduledArriualTime, DriverName, BusID)"
						+" values ("  +" '"+tripN+"', "+"'"+date+"', "+"'"+starttime+"', " 
						+"'"+arrivaltime+"', "+"'"+drivername+"', "+"'"+busid+"'"+ ")";
			myStmt.executeUpdate(query);
			System.out.println("Insert a row completed!");
			myConn.close();
			myStmt.close();
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
	}
	
	
	public static void QuestionNumberTwoC(){
		String tripNum = "6";
		String Date = "2017-04-05";
		String StartTime = "16:00:00";
		String DriverName = "John";
		QuestionNumberTwoPartC(tripNum,Date,StartTime,DriverName);
	}
	public static void QuestionNumberTwoPartC(String tripN,String date,String starttime,String driverchange){
		try{
			//get connection
			Connection myConn = DriverManager.getConnection(url,user,password);
			//create a statement
			Statement myStmt = myConn.createStatement();
			//execute SQL query
			String query =" update TripOffering"
						+" set DriverName='"+driverchange+"'"
						+" where"+" date = "+"'"+date+"'"
						+" and "+ "ScheduledStartTime = "+"'"+starttime+"'"
						+" and "+ "TripNumber = "+"'"+tripN+"'";
						
			myStmt.executeUpdate(query);
			System.out.println("Date Update completed!");
			myConn.close();
			myStmt.close();
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
	}
	
	public static void QuestionNumberTwoD(){
		String tripNum = "6";
		String Date = "2017-04-05";
		String StartTime = "16:00:00";
		String BusId = "5";
		QuestionNumberTwoPartD(tripNum,Date,StartTime,BusId);
	}
	public static void QuestionNumberTwoPartD(String tripN,String date,String starttime,String buschange){
		try{
			//get connection
			Connection myConn = DriverManager.getConnection(url,user,password);
			//create a statement
			Statement myStmt = myConn.createStatement();
			//execute SQL query
			String query =" update TripOffering"
						+" set BusID='"+buschange+"'"
						+" where"+" date = "+"'"+date+"'"
						+" and "+ "ScheduledStartTime = "+"'"+starttime+"'"
						+" and "+ "TripNumber = "+"'"+tripN+"'";
						
			myStmt.executeUpdate(query);
			System.out.println("Date Update completed!");
			myConn.close();
			myStmt.close();
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
	}
	
	
	public static void QuestionNumberThree(){
		try{
			//get connection
			Connection myConn = DriverManager.getConnection(url,user,password);
			//create a statement
			Statement myStmt = myConn.createStatement();
			//execute SQL query
			String query ="select *"
						+" from TripStopInfo t ,Stop s"
						+" where t.StopNumber = s.StopNumber";
					     
			ResultSet myRs = myStmt.executeQuery(query);
			while(myRs.next()){
				System.out.println(myRs.getString("TripNumber")+"  "+myRs.getString("StopNumber")
						+"  "+myRs.getString("SequenceNumber")+"  "+myRs.getString("DrivingTime")
						+"  "+myRs.getString("StopAddress"));
			}
			myConn.close();
			myStmt.close();
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
	}
	
	public static void QuestionNumberFour(){
		String driverName = "Joe";
		String date = "2017-04-02";
		QuestionNumberFourFunc(driverName,date);
	}
	public static void QuestionNumberFourFunc(String driverName,String date){
		try{
			//get connection
			Connection myConn = DriverManager.getConnection(url,user,password);
			//create a statement
			Statement myStmt = myConn.createStatement();
			//execute SQL query
			String query ="select t.StartLocationName,t.DestinationName,tf.Date,tf.ScheduledArriualTime,tf.ScheduledStartTime,tf.BusID"
						+" from Trip t ,TripOffering tf"
						+" where tf.DriverName = '" + driverName + "'"
						+" and "+"tf.date = '" +  date + "'"
						+" and "+"t.TripNumber = tf.TripNumber";
					     
			ResultSet myRs = myStmt.executeQuery(query);
			while(myRs.next()){
				System.out.println(myRs.getString("StartLocationName")+"  "+myRs.getString("DestinationName")
						+"  "+myRs.getString("Date")+"  "+myRs.getString("ScheduledStartTime")
						+"  "+myRs.getString("ScheduledArriualTime")
						+"  "+myRs.getString("BusID"));
			}
			myConn.close();
			myStmt.close();
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
	}
	
	public static void QuestionNumberFive(){
		String driverName = "Boo"; 
		String driverPhoneNum ="6678923";
		QuestionNumberFiveFunc(driverName,driverPhoneNum);
	}
	public static void QuestionNumberFiveFunc(String driverName,String driverPhoneNum){
		try{
			//get connection
			Connection myConn = DriverManager.getConnection(url,user,password);
			//create a statement
			Statement myStmt = myConn.createStatement();
			//execute SQL query
			String query =
						" insert into Driver"
						+" (DriveName,PhoneNumber)"
						+" values ("  +" '"+driverName+"', "+"'"+driverPhoneNum+"')";
			myStmt.executeUpdate(query);
			System.out.println("Insert a row completed!");
			myConn.close();
			myStmt.close();
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
	}
	
	public static void QuestionNumberSix(){
		//add
		String busId = "8";
		String model="Hy";
		String year="2017";
		QuestionNumberSixFunc(busId,model,year);
	}
	public static void QuestionNumberSixFunc(String busId,String model,String year){
		try{
			//get connection
			Connection myConn = DriverManager.getConnection(url,user,password);
			//create a statement
			Statement myStmt = myConn.createStatement();
			//execute SQL query
			String query =
						" insert into Bus"
						+" (BusID,Model,Year)"
						+" values ("  +" '"+busId+"', "+"'"+model+"', "
						+"'"+year+"')";
			myStmt.executeUpdate(query);
			System.out.println("Insert a row completed!");
			myConn.close();
			myStmt.close();
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
	}
	
	public static void QuestionNumberSeven(){
		String BusId = "7";
		String Model ="Nissan";
		String Year = "2017";
		QuestionNumberSevenFunc(BusId,Model,Year);
	}
	public static void QuestionNumberSevenFunc(String BusID,String model,String year){
		try{
			//get connection
			Connection myConn = DriverManager.getConnection(url,user,password);
			//create a statement
			Statement myStmt = myConn.createStatement();
			//execute SQL query
			String query ="delete"
						+" from Bus"
						+" where"+" BusID = "+"'"+BusID+"'"
						+" and "+ "Model = "+"'"+model+"'"
						+" and "+ "Year = "+"'"+year+"'";
			int rowAffected = myStmt.executeUpdate(query);
			System.out.println("Rows affected: "+rowAffected+"\n complete Delete");
			myConn.close();
			myStmt.close();
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
	}

	public static void QuestionNumberEight(){
		String [] info = new String[11];
		info[0] = "10";
		info[1] = "2017-04-08";
		info[2] = "9:00:00";
		info[3] = "13:00:00";
		info[4] = "eric";
		info[5] = "4";
		info[6] = "17";
		info[7] = "9:00:00";
		info[8] = "13:00:00";
		info[9] = "10";
		info[10] = "9";
		
		QuestionNumeberEightFunc(info);
		
	}
	public static void QuestionNumeberEightFunc(String [] info){
		try{
			//get connection
			Connection myConn = DriverManager.getConnection(url,user,password);
			//create a statement
			Statement myStmt = myConn.createStatement();
			//execute SQL query
			//
			String queryOne =
						" insert into TripOffering"
						+" (TripNumber, Date, ScheduledStartTime, ScheduledArriualTime, DriverName, BusID)"
						+" values ("  +" '"+info[0]+"', "+"'"+info[1]+"', "+"'"+info[2]+"', " 
						+"'"+info[3]+"', "+"'"+info[4]+"', "+"'"+info[5]+"'"+ ")";
			String queryTwo = 
					" insert into ActualTripStopInfo"
							+" (TripNumber, Date, ScheduledStartTime, StopNumber, ScheduledArrialTime,ActualStartTime,ActualArrialTime,NumberOfPassengerIn,NumberOfPassengerOut)"
							+" values ("  +" '"+info[0]+"', "+"'"+info[1]+"', "+"'"+info[2]+"', " 
							+"'"+info[6]+"', "+"'"+info[3]+"', "+"'"+info[7]+"', "+ "'"+info[8]+"', "    
							+"'"+info[9]+"', "+"'"+info[10]+"'"+")";
			
			myStmt.executeUpdate(queryOne);
			myStmt.executeUpdate(queryTwo);
			System.out.println("Insert a row completed!");
			myConn.close();
			myStmt.close();
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
	}
	
}
