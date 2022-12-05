package Furniture_World;

import java.util.Scanner;

public class Main_class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("***********************************************************");
		System.out.println("------------------Welcome to Furniture World---------------");
		System.out.println("***********************************************************");
		System.out.println("Are you willing Order Furnitures in our site--('YES/NO')");
		Scanner s=new Scanner(System.in);
		String opt=s.next();
		if(opt.equalsIgnoreCase("yes"))
		{
			System.out.println("-----------Please Enroll Yourself---------");
			Furniture_Details fd=new Furniture_Details();
			System.out.println("Are you new to this site--('YES/NO')");
			String opt1=s.next();
			if(opt1.equalsIgnoreCase("yes"))
			{
				fd.register();
			}
			else
				fd.login();
		}
		else
		{
			System.out.println("Thank you for show interest in our site");
			System.exit(0);
		}
		
	}

}
