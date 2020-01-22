package csv_Reader_attempt1.bin;

import java.io.*;
import java.util.*;
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
	
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//File file = new File(".");
		//for(String fileNames : file.list()) System.out.println(fileNames);
		try {
			readCustomer();
			readInvoice();
			readInvoiceItem();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	    
	  //  System.out.println(lastName);
	 //   System.out.println(lastName.contentEquals( last.get(1).substring(1, last.get(1).length()-1)));
	 //   System.out.println(firstName.indexOf(firstName));
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
	    invoiceWithName.add(" \"" +firstName + " " + lastName + " \"" );
	                    
	        	
	
	    if (index > -1) {
	    for (int k = 0; k < customerCodesInvoice.size(); k++)
	    {
	   // 	System.out.println(customerCodesInvoice.get(k));
	    	if( customerCodesInvoice.get(k).contentEquals(customerCodes.get(index) ))
	    	{
	    		
	    		invoiceWithName.add(invoiceCodes.get(k));
	    		
	    		// Add the candies 
	    	}
	    }
	     
	    
	    }
	    else System.out.println("They aren't in here.");
	     
	    
	  //  for(int i=0; i<invoiceWithName.size(); i++)
	   // System.out.println(invoiceWithName.get(i));
	    
		FileWriter	writer = new FileWriter("CustomerSample.csv");

	    String collect = invoiceWithName.stream().collect(Collectors.joining(","));
	    System.out.println(collect);

	    writer.write(collect);
	    writer.close();
	    
	}
	
	
}
