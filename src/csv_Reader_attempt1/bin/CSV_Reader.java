package csv_Reader_attempt1.bin;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CSV_Reader {
   
	   //customer CSV
	   static  public ArrayList<String> customerCodes = new ArrayList<>();
	   static  public ArrayList<String> first = new ArrayList<>();
	   static  public ArrayList<String> last = new ArrayList<>();
	   
	   static  public ArrayList<String> customerCodesInvoice = new ArrayList<>();
	   static  public ArrayList<String> invoiceCodes = new ArrayList<>();
	   static  public ArrayList<String> amounts = new ArrayList<>();
	   static  public ArrayList<String> dates = new ArrayList<>();
	   
	   static  public ArrayList<String> invoiceCodesItem = new ArrayList<>();
	   static  public ArrayList<String> itemCode = new ArrayList<>();
	   static  public ArrayList<String> amountsCode = new ArrayList<>();
	   static  public ArrayList<String> quantity = new ArrayList<>();
	   
	   static public ArrayList<String> invoiceWithName = new ArrayList<>();
	/*   
	   static  public HashSet<String,String> customerLookup = new HashMap<String,String>();
	   
	 public static void createNames(ArrayList<String> first, ArrayList<String>last) {
		 for (int i=0 ; i < first.size(); i++) customerLookup.put(first.get(i), last.get(i));
	 }
	 */
	   //
	   
	   
	   //
	   // For each CSV, create an atomized-by-column table structure. 
	   // When ORM is implemented, will use Hibernate/MySQL instead
	 public static void readCustomer() throws IOException {
		    BufferedReader reader = new BufferedReader(new FileReader("Customer.csv"));
		   
		    String line;
		    String[] tokens;
		    while ((line = reader.readLine()) != null) {
		      tokens = line.split(",");
		     // if (tokens.length != 2) { // Skip any "weird" (e.g., empty) line
		      //  continue;
		     // }
		      customerCodes.add(tokens[0].trim().replace("\"", ""));
		      first.add(tokens[1].trim().replace("\"", ""));
		      last.add(tokens[2].trim().replace("\"", ""));
		     
		    }
		    //Testing the output
		    System.out.println("customercodes\tfirst\tlast");
		    for (int i = 1; i < customerCodes.size(); i++) { // IDs and names have the same size
		      System.out.println(customerCodes.get(i) + "\t" + first.get(i) + "\t" + last.get(i));
		    }
		  }
	 
	 
	 public static void readInvoice() throws IOException {
		    BufferedReader reader = new BufferedReader(new FileReader("Invoice.csv"));
		   
		    String line;
		    String[] tokens;
		    while ((line = reader.readLine()) != null) {
		      tokens = line.split(",");
		     // if (tokens.length != 2) { // Skip any "weird" (e.g., empty) line
		      //  continue;
		     // }
		      customerCodesInvoice.add(tokens[0].trim().replace("\"", ""));
		      invoiceCodes.add(tokens[1].trim().replace("\"", ""));
		      amounts.add(tokens[2].trim().replace("\"", ""));
		      dates.add(tokens[3].trim().replace("\"", ""));
		     
		    }
		    //Testing the output
		    System.out.println("customerCodesInvoice\tinvoiceCodes\tamounts\tdates");
		    for (int i = 1; i < customerCodesInvoice.size(); i++) { // IDs and names have the same size
		      System.out.println(customerCodesInvoice.get(i) + "\t" + invoiceCodes.get(i) + "\t" + amounts.get(i)
		      + "\t" + dates.get(i));
		    }
		  }
	 
	 public static void readInvoiceItem() throws IOException {
		    BufferedReader reader = new BufferedReader(new FileReader("InvoiceItem.csv"));
		   
		    String line;
		    String[] tokens;
		    while ((line = reader.readLine()) != null) {
		      tokens = line.split(",");
		     // if (tokens.length != 2) { // Skip any "weird" (e.g., empty) line
		      //  continue;
		     // }
		      invoiceCodesItem.add(tokens[0].trim().replace("\"", ""));
		      itemCode.add(tokens[1].trim().replace("\"", ""));
		      amountsCode.add(tokens[2].trim().replace("\"", ""));
		      quantity.add(tokens[3].trim().replace("\"", ""));
		     
		    }
		    //Testing the output
		    System.out.println("customerCodesInvoice\tinvoiceCodes\tamounts\tdates");
		    for (int i = 1; i < customerCodesInvoice.size(); i++) { // IDs and names have the same size
		      System.out.println(invoiceCodesItem.get(i) + "\t" + itemCode.get(i) + "\t" + amountsCode.get(i)
		      + "\t" + quantity.get(i));
		    }
		  }
	
	
	 public static void loadCSVs() {
		 try {
				readCustomer();
				readInvoice();
				readInvoiceItem();
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	 }
	 
	 public static int accessSystem() {
			Scanner pick =  new Scanner(System.in);
			   System.out.println("What do you want to do?" +"\n "
			   		+ "1)Customer Purchase History " + "\n" +
					     "2)Add a new Customer "+ "\n" +
					     "3)Add a new Order ");

			   	return Integer.parseInt(pick.nextLine().trim());   
	 }
	 
	 public static void printCustomerOrders() {
		   
		    //createNames(first,last);
		Scanner firstn = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Enter First Name of the Customer that you want");
	    
	    String firstName  = firstn.nextLine();  // Read user input
	    
		Scanner lastn = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Enter Last Name of the Customer that you want");
	    
	    String lastName  = lastn.nextLine();  // Read user input
	    System.out.println("You want  " + firstName +" "+ lastName);  // Output user inpu
		// At this point, all the data is processed into the "database"
		// Retrieve all the invoices for requested customer. 
	    int index = -1; 
	    

	   for (int i=0; i<last.size(); i++) {
		   if (lastName.contentEquals( last.get(i).substring(1, last.get(i).length()-1)));
		   {
			   
			   for( int j =0; j <first.size(); j++) {
			   if (firstName.contentEquals(first.get(j).substring(1, first.get(j).length()-1))) {
				  if(i==j) index= i; 
			   }
		   }
	   }
	   }
	        
	  // System.out.println(index);
	    invoiceWithName.add(" \"" +firstName + " "+ lastName + "\"" );
	                    
	        	
	
	    if (index > -1) {
	    for (int k = 0; k < customerCodesInvoice.size(); k++)
	    {
	   // 	System.out.println(customerCodesInvoice.get(k));
	    	if( customerCodesInvoice.get(k).contentEquals(customerCodes.get(index) ))
	    	{
	    		
	    		invoiceWithName.add(invoiceCodes.get(k));
	    		invoiceWithName.add("           ");
	    		//MSystem.out.println(invoiceCodes.get(k).contentEquals(invoiceCodesItem.get(j)));
	    		// Add the candies 
	    		for(int j= 0; j< invoiceCodesItem.size();j++) {
		    	//	System.out.println(invoiceCodes.get(k));
		    	//	System.out.println("item: "+ invoiceCodesItem.get(j));

	    			if( invoiceCodes.get(k).substring(1, invoiceCodes.get(k).length()-1).
	     contentEquals( invoiceCodesItem.get(j).substring(1, invoiceCodesItem.get(j).length()-1))){
	    				invoiceWithName.add(itemCode.get(j));
	    				invoiceWithName.add(amountsCode.get(j));
	    				invoiceWithName.add(quantity.get(j));
	    				invoiceWithName.add("   ");
	    		}
	    	 }
	    	
	        }
	      }
	    
	    }
	    else System.out.println("They aren't in here.");
	     
	    
	    File csvFile = new File("CustomerSample.csv");
	    try (PrintWriter csvWriter = new PrintWriter(new FileWriter(csvFile));){
	      for(String item : invoiceWithName){
	        csvWriter.println(item);
	      }
	    } catch (IOException e) {
	        //Handle exception
	        e.printStackTrace();
	    }
	    //writer.write(collect);
	    //writer.close();
	    
	}
	
	 public static void addNewCustomer() {
			Scanner firstn = new Scanner(System.in);  // Create a Scanner object
		    System.out.println("Enter First Name of the Customer that you want to add.");
		    
		    String firstName  = firstn.nextLine();  // Read user input
		    
			Scanner lastn = new Scanner(System.in);  // Create a Scanner object
		    System.out.println("Enter Last Name of the Customer that you want to add");
		    
		    String lastName  = lastn.nextLine();  // Read user input
		    
		    boolean good= false;
		    String custCode= " ";
		    
		    while(!good) {
			Scanner customerCode = new Scanner(System.in);  // Create a Scanner object
		    System.out.println("Enter the customer code of the new customer.");
		    
		    
		     String pattern = "^CUST00000\\d{6}";

		      // Create a Pattern object
		      Pattern r = Pattern.compile(pattern);
		      
		      // Now create matcher object.
		    custCode  = customerCode.nextLine();  // Read user input
		    Matcher m = r.matcher(custCode);
		    good = m.find();
		    }    	   
		    	
			    System.out.println("You are adding  " + firstName +" "+ lastName);  // Output user input
			    // Perform the logic
			    customerCodes.add(" \"" +custCode+"\"");
				 first.add(" \"" +firstName+"\"");
				  last.add(" \"" +lastName+"\"");
				  
				  File csvFile = new File("CustomerSample.csv");
				    try (PrintWriter csvWriter = new PrintWriter(new FileWriter(csvFile));){
				      for(int i=0;i < customerCodes.size();i++){
				        csvWriter.print(customerCodes.get(i) +",");
				        csvWriter.print(first.get(i) + ",");
				        csvWriter.print(last.get(i) + ",");
				        csvWriter.println(" ");
				        
				      }
				    } catch (IOException e) {
				        //Handle exception
				    	
				        e.printStackTrace();
				    }
						    }
		
			// At this point, all the data is processed into the "database"
			// Retrieve all the invoices for requested customer. 
		 
	 
	 
	 
	public static void main(String[] args) throws IOException {
		
		loadCSVs();
	   
		switch(accessSystem()) {
		case 1:
			printCustomerOrders();
			accessSystem();
		break;
		case 2: 
			addNewCustomer();
			accessSystem();
		break;
		//case: 3:
		//	addNewOrder();
	    // break;
		default: 
			accessSystem();
		}
     }
}
