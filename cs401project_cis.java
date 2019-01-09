import java.io.FileInputStream;
import java.util.Scanner;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.IOException;

public class cs401project_cis
{
	protected static coupon strt;
	static double[] p_price= new double[50];
	private static HSSFWorkbook xlWBook;
    private static HSSFSheet xlSheet;
    private static HSSFRow xlRow;
    private static HSSFCell xlCell;
    private static String filePath = "D:\\";
    private static String fileName = "testdata.xls";
          
    public static void main(String[] args) throws IOException
    {
		String Coupon_provider = null, product_name = null, coupon_status = null;
		double price = 0, discount_rate = 0, expiration_period = 0, Coupon_ID = 0, Discounted_price = 0 ;
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		Scanner scan1 = new Scanner(System.in);
		LinkedList list = new LinkedList();
		char ch;
		FileInputStream xlFile = new FileInputStream(filePath + fileName);
        xlWBook = new HSSFWorkbook(xlFile); // Access the required test data sheet
        xlSheet = xlWBook.getSheet("Data"); // Assuming your data is in Sheet1- if not use your own sheet name
        int noOfRows = xlSheet.getPhysicalNumberOfRows(); // gives row count in sheet
        xlRow = xlSheet.getRow(0);// gives column count in sheet
        int noOfColumns = xlRow.getLastCellNum();
        for (int r = 0; r < noOfRows; r++)
        {
        	xlRow = xlSheet.getRow(r);
                for (int c = 0; c < noOfColumns; c++)
                {
                    
                    xlCell = xlRow.getCell(c);
                    switch (c)
                    {
    	            case 0:
                        Coupon_provider = xlCell.getStringCellValue();
                        break;
                    case 1:
                        product_name = xlCell.getStringCellValue();
                        break;
                    case 2:
                        price = xlCell.getNumericCellValue();
                        break;
                    case 5:
                        coupon_status = xlCell.getStringCellValue(); 
                        break;
                    case 3:
                        discount_rate = xlCell.getNumericCellValue();
                        break;
                    case 4:
                        expiration_period = xlCell.getNumericCellValue();
                        break;
                    case 6:
                        Coupon_ID = xlCell.getNumericCellValue();
                        break;                  
                    
                   }
                  
                         
            

                }
                Discounted_price= price*(1-(discount_rate/100));
                list.insert(Coupon_provider, product_name, coupon_status, price, discount_rate, expiration_period,
						Coupon_ID, Discounted_price);
                //System.out.println(Coupon_provider + " " + product_name + " " + coupon_status + " " + price + " " + discount_rate + " " + expiration_period + " " +
						//Coupon_ID + " " + Discounted_price);
        }
                        
        /* catch (IOException e) {
            e.printStackTrace();
        }*/
        
        System.out.println();
        System.out.println();
        //list.display();
		do {
			System.out.println("Hello and Welcome :)\n");
			System.out.println("1. Add coupon details");
			System.out.println("2. Search");
			System.out.println("3. Display SORTED list in accordance with Coupon ID, Price, Discount Rate, Discounted Price and Expiration days");
			System.out.println("4. Display coupons in accordance with various filters ");
			System.out.println("5. Delete some details");
			System.out.println("6. Display");
			int choice = scan.nextInt();
			switch (choice)
			{
			case 1:
				System.out.println("Enter the Coupon ID of the product to insert");
				Coupon_ID = scan.nextInt();
				System.out.println("Enter name of the Coupon Provider to insert" + scan.nextLine());
				Coupon_provider = scan.nextLine();
				System.out.println("Enter the name of the product to insert");
				product_name = scan.nextLine();
				System.out.println("Enter the product price to insert");
				price = scan.nextInt();
				System.out.println("Enter the dicounted percentage product to insert");
				discount_rate = scan.nextInt();
				System.out.println("Enter the Expiration period to insert");
				expiration_period = scan.nextInt();
				System.out.println("Enter the status of the coupon");
				coupon_status = scan1.nextLine();
				System.out.println("All done :)");
                Discounted_price = price*(1-(discount_rate/100));
                list.insert(Coupon_provider, product_name, coupon_status, price, discount_rate, expiration_period,
						Coupon_ID, Discounted_price);
                list.display();
				break;
			case 2:
					System.out.println("Enter the Coupon ID of the product for search");
					Coupon_ID = scan.nextDouble();
					System.out.println("Using Linear search: ");
					if(list.Linearsearch(Coupon_ID) == true)
						System.out.println("Coupon found by Linear search :) " + "\n" );
					else 
						System.out.println("coupon not found :("  );	
					
					System.out.println("Using Binary search");
					int y;
					y = list.BinarySearch(Coupon_ID);
					if (y == -1)
			            System.out.println("Coupon not found :(");
			        else
			            System.out.println("Coupon found by Binary Search :) ");
				break; 
			case 3:
				System.out.println("sort by what?:" +"\n"+"Enter 1 for Discount rate" + "\n" + "Enter 2 for Coupon ID" + "\n"+ "Enter 3 for Discounted Price" + "\n"+ "Enter 4 for Price" + "\n" + "Enter 5 for Expiration period" + "\n");
				int a= scan.nextInt();
				switch(a)
				{
				case 1:list.lowtohigh();
					break;
				case 2: list.lowtohigh_couponID();
					break;
				case 3: list.lowtohigh_Discounted_price();
					break;
				case 4: list.lowtohigh_price();
					break;
				case 5: list.lowtohigh_expiration();
					break;
					
				}
				
				
				break;
			case 4:System.out.println("Enter the field name for filtering" +"\n"+"Enter 1 for Discount Rate" +"\n"+"Enter 2 for Discounted Price"+"\n"+"Enter 3 for Price"+"\n"+"Enter 4 for Expiration period"+"\n"+"Enter 5 for Coupon ID"+"\n"+"Enter 6 for Coupon Provider"+"\n"+"Enter 7 for Product Name");
				int b =scan.nextInt();
				switch(b)
				{
				case 1: System.out.println("Enter a value");
					double dr= scan.nextDouble();
					System.out.println("Thank you for your input. Do you need coupon details greater than or equal to (Enter 1) or lesser (Enter 2) than the mentioned discount rate?");
					int gl=scan.nextInt();
					list.filter_discount_rate(dr,gl);
					break;
				case 2: System.out.println("Enter a value");
					dr= scan.nextDouble();
					System.out.println("Thank you for your input. Do you need coupon details greater than or equal to(Enter 1) or lesser (Enter 2) than the mentioned discount rate?");
					gl=scan.nextInt();
					list.filter_discounted_price(dr, gl);;
					break;
			
				case 3: System.out.println("Enter a value");
					dr= scan.nextDouble();
					System.out.println("Thank you for your input. Do you need coupon details greater than or equal to(Enter 1) or lesser (Enter 2) than the mentioned discount rate?");
					gl=scan.nextInt();
					list.filter_price(dr, gl);
					break;
				case 4: System.out.println("Enter a value");
					dr= scan.nextDouble();
					System.out.println("Thank you for your input. Do you need coupon details greater than or equal to(Enter 1) or lesser (Enter 2) than the mentioned discount rate?");
					gl=scan.nextInt();
					list.filter_expiration(dr, gl);
					break;
				case 5: System.out.println("Enter a value");
					dr= scan.nextDouble();
					System.out.println("Thank you for your input. Do you need coupon details greater than or equal to(Enter 1) or lesser (Enter 2) than the mentioned discount rate?");
					gl=scan.nextInt();
					list.filter_couponID(dr, gl);
					break;
				case 6: System.out.println("Enter a Coupon Provider: ");
					String val= scan1.nextLine();
					list.filter_Coupon_Provider(val);
					break;
				
				case 7: System.out.println("Enter Product name: ");
					val= scan1.nextLine();
					list.filter_Product_name(val);
					break;
			
					
				}
				break;
			case 5:System.out.println("Enter the Coupon ID that needs to be deleted");
					double x= scan.nextDouble();
					list.delete(x);
					list.display();
					break;
			case 6:list.display();
					break;
	
			}
			System.out.println("\nDo you want to continue (Type y or n) \n");
			ch = scan.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');

		//System.out.println("final list of products is as follows" );
		//list.display();
	
		}
 }
	