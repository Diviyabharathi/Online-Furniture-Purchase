package Furniture_World;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class Furniture_Details implements DAOInterface{

	Scanner s=new Scanner(System.in);
	@Override
	public void register() {
		// TODO Auto-generated method stub
		System.out.println("=============Welcome to Register Page=============");
		System.out.println("Please Register Yourself Here...........");
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpro","root","");
			PreparedStatement st=con.prepareStatement("insert into login values(?,?)");
			System.out.println("Enter User Name");
			String uname=s.next();
			System.out.println("Enter Password");
			String password=s.next();
			st.setString(1, uname);
			st.setString(2, password);
			int k=st.executeUpdate();
			
			System.out.println("Records Saved Successfully.....");
			System.out.println("---------------------------------");
			System.out.println("Thank you for Registering Yourself..");
			
			login();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	@Override
	public void login() {
		// TODO Auto-generated method stub
		System.out.println("=====================Welcome To Login Page====================");
		try
		{
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpro","root",""); 
		  Statement stmt = con.createStatement();  
		  System.out.print("Enter the User Name : ");  
		  String str1 = s.next();  
		  System.out.print("Enter the Password : ");  
		  String str2 = s.next();  
		  ResultSet rs = stmt.executeQuery("select * from login where uname='" + str1 + "' and password='" + str2 + "'");  
		  if (rs.next())  
		  {
			  System.out.println("Welcome to our furniture world::: " + str1); 
			  Purchase_Furnitures();
		  }
		  else  
		  {
		   System.out.println("Invalid user name and password");  
		   System.out.println("Please Login with correct user name and password");
		   login();
		  }
		  con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	@Override
	public void Purchase_Furnitures() {
		// TODO Auto-generated method stub
		System.out.println("=======================================================");
		System.out.println("Enter the Number of Furnitures You want to purchase: ");
        int n = s.nextInt();
        System.out.println("=======================================================");
        try 
        {
            for (int i = 1; i<=n ; i++)
            {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpro","root","");
			PreparedStatement st1=con1.prepareStatement("insert into furnitures values(?,?,?,?,?,?,?,?)");
			System.out.println("Enter Furniture ID: ");
			int fur_id=s.nextInt();
			System.out.println("Enter Furniture Name: ");
			String fur_name=s.next();
			System.out.println("Enter Number of Quantity Required: ");
			int Quantity=s.nextInt();
			System.out.println("Enter Price of the Material: ");
			int Price=s.nextInt();
			int Total_Amount=Quantity*Price;
			
			System.out.println("Enter GST in % :");
			int GST_in_Perc=s.nextInt();
			
			int GST_in_Amount=((Total_Amount)*GST_in_Perc)/100;
			int Final_Amount=Total_Amount+GST_in_Amount;
			
			
			st1.setInt(1, fur_id);
			st1.setString(2, fur_name);
			st1.setInt(3, Quantity);
			st1.setInt(4, Price);
			st1.setInt(5, Total_Amount);
			st1.setInt(6, GST_in_Perc);
			st1.setInt(7, GST_in_Amount);
			st1.setInt(8, Final_Amount);
			int k=st1.executeUpdate();
			
			System.out.println("Records Saved Successfully.....");
			System.out.println("---------------------------------");
			System.out.println("Thank you for Your Order..");
            }
			System.out.println("===========================================================");
			System.out.println("Any Updation is Required in Purchase--('Yes')");
			String opt3=s.next();
			if(opt3.equalsIgnoreCase("Yes"))
			{
				Update_Materials();
			}	
			
			
			
			/*System.out.println("1.If you are willing to Purchase Again--('ADD')");
			System.out.println("2.If you are willing to remove any materials that you have already purchased--('REMOVE')");
			System.out.println("3.To view Your Purchased Furnitures Details--('DISPLAY')");
			
			String opt3=s.next();
				switch(opt3)
				{
				case "ADD":
					Add_Materials();
					break;
				case "REMOVE":
					cancel_Materials();
					break;
				case "DISPLAY":
					List_Of_Materials();
					break;
				
				default:
					System.out.println("Invalid Option");			
				}*/
            
        }
            catch(Exception e)
            {
            	System.out.println(e);
            }
		
	}
	@Override
	public void Update_Materials() {
		// TODO Auto-generated method stub
		List_Of_Materials();
			
			System.out.println("========================================================================================");
			System.out.println("1.If you are willing to add Number of quantities in Purchased Materials");
			System.out.println("2.If you are willing to do add new furnitures");
			int opt4=s.nextInt();
			System.out.println("========================================================================================");
			switch(opt4)
			{
				case 1:
					Add_Materials();
					break;
					
					
				case 2:
					Purchase_Furnitures();
					break;
				default:
					System.out.println("Invalid Option");
			
			}
		
	}
	
	@Override
	public void Add_Materials() {
		
		// TODO Auto-generated method stub
		System.out.println("======================================================");
		System.out.println("Please Update the Materials Quantity here............");
		System.out.println("======================================================");
		try 
        {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpro","root","");
			PreparedStatement st1=con1.prepareStatement("update furnitures set fur_name=?,Quantity=?,Price=?,Total_Amount=?,GST_in_Perc=?,GST_in_Amount=?,Final_Amount=? where fur_id=?");
	
			System.out.println("Enter Furniture Name");
			String fur_name=s.next();
			System.out.println("Enter Number of Quantity Required");
			int Quantity=s.nextInt();
			System.out.println("Enter Price of the Material");
			int Price=s.nextInt();
			
			int Total_Amount=Quantity*Price;
			
			System.out.println("Enter GST in %");
			int GST_in_Perc=s.nextInt();
			
			int GST_in_Amount=((Total_Amount)*GST_in_Perc)/100;
			int Final_Amount=Total_Amount+GST_in_Amount;
	
			System.out.println("Enter Furniture ID");
			int fur_id=s.nextInt();
			
			st1.setInt(1, fur_id);
			st1.setString(2, fur_name);
			st1.setInt(3, Quantity);
			st1.setInt(4, Price);
			st1.setInt(5, Total_Amount);
			st1.setInt(6, GST_in_Perc);
			st1.setInt(7, GST_in_Amount);
			st1.setInt(8, Final_Amount);
			
			int k=st1.executeUpdate();
	
			System.out.println("Records Updated Successfully....."+k);
			cancel_Materials();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	

	@Override
	public void cancel_Materials() {
		// TODO Auto-generated method stubtry 
        List_Of_Materials();
        System.out.println("How many Item Have You Remove form Your Order:");
        int number = s.nextInt();
        for (int i = 1; i<=number ; i++)
        {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpro","root","");
			PreparedStatement st1=con1.prepareStatement("delete from furnitures where fur_id=?");
			
			System.out.println("Enter Furniture ID");
			int fur_id=s.nextInt();
			
			st1.setInt(1, fur_id);
			
			int k=st1.executeUpdate();
			
			System.out.println("Record Deleted Successfully.....");
            
         }
		catch(Exception e)
		{
			System.out.println(e);
		}
        }
		
	}

	@Override
	public void List_Of_Materials() {
		// TODO Auto-generated method stub
		System.out.println("***************************************HERE THE LIST OF FURNITURES YOU PURCHASED***************************************");
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpro","root","");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from furnitures");
			System.out.println("Furniture ID \t Furniture Name \t Quantity \t Unit Price \t Total Price \t GST in % \t GST in Amount \t Final Amount");
			while(rs.next())
			{
				System.out.println("\t"+rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t   "+rs.getInt(3)+"\t\t"+rs.getInt(4)+"\t\t"+rs.getInt(5)+"\t\t"+rs.getInt(6)+"\t\t"+rs.getInt(7)+"\t\t"+rs.getInt(8));
			}
			//int Payable_Amount=
			//System.out.println();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
