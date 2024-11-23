import java.util.*;
class Example{
	static Scanner input=new Scanner(System.in);
	
	
	static int genID = 1;             
	static String[] phonenumber=new String[0];
	static String[] size=new String[0];
	static int[] qty=new int[0];
	static float[]amount=new float[0];
	static String []ordernumber=new String[0]; 
	static String tag="";
    static int count=0;
    static float prize=0;
	static String[] orderstatus={"PROCESSING","DELIVERING","DELIVERED"};
	static String[] orderstatusar=new String[0];
	
	
	public static void main(String args[]){
	homepage();		
	}
	public static void homepage(){
		
	System.out.println(" $$$$$$$$\\                 $$\\       $$\\                            $$$$$$\\  $$\\");                        
	System.out.println(" $$  _____|                $$ |      \\__|                          $$  __$$\\ $$ |");                          
	System.out.println(" $$ |   $$$$$$\\   $$$$$$$\\ $$$$$$$\\  $$\\  $$$$$$\\  $$$$$$$\\        $$ /  \\__|$$$$$$$\\   $$$$$$\\   $$$$$$\\");  
	System.out.println(" $$$$$\\ \\____$$\\ $$  _____|$$  __$$\\ $$ |$$  __$$\\ $$  __$$\\       \\$$$$$$\\  $$  __$$\\ $$  __$$\\ $$  __$$\\"); 
	System.out.println(" $$  __|$$$$$$$ |\\$$$$$$\\  $$ |  $$ |$$ |$$ /  $$ |$$ |  $$ |       \\____$$\\ $$ |  $$ |$$ /  $$ |$$ /  $$ |");
	System.out.println(" $$ |  $$  __$$ | \\____$$\\ $$ |  $$ |$$ |$$ |  $$ |$$ |  $$ |      $$\\   $$ |$$ |  $$ |$$ |  $$ |$$ |  $$ |");
	System.out.println(" $$ |  \\$$$$$$$ |$$$$$$$  |$$ |  $$ |$$ |\\$$$$$$  |$$ |  $$ |      \\$$$$$$  |$$ |  $$ |\\$$$$$$  |$$$$$$$  |");
	System.out.println(" \\__|   \\_______|\\_______/ \\__|  \\__|\\__| \\______/ \\__|  \\__|       \\______/ \\__|  \\__| \\______/ $$  ____/ ");
	System.out.println("                                                                                                $$ |");      
	System.out.println("                                                                                                $$ |");      
	System.out.println("                                                                                                \\__|");
	
	System.out.println("\n\n\n___________________________________________________________________________________________________________________");

	System.out.println("[1] Place Order\t\t\t\t[2] Search Customer\n");
	System.out.println("[3] Search Order\t\t\t[4] View Reports\n");
	System.out.println("[5] Set Order Status\t\t\t[6] Delete Order\n\n\n");

	System.out.print("Input Option :");
	int x=input.nextInt();
	
	switch(x){
		case 1:
		placeorder();
		break;
		case 2:
		searchcustomer();
		break;
		case 3:
		searchorder();
		break;	
		case 4:
		viewreports();
		break;
		case 5:
		setorderstatus();
		break;
		case 6:
		deleteorder();	
		break;
		default :
		homepage();
		}
		}
	public static void placeorder(){
		
		
	System.out.println("  _____  _                   ____          _          "); 
	System.out.println(" |  __ \\| |                / __ \\ \\       | |         "); 
	System.out.println(" | |__) | | __ _  ___ ___  | |  | |_ __ __| | ___ _ __ ");
	System.out.println(" |  ___/| |/ _` |/ __/ _ \\ | |  | | '__/ _` |/ _ \\ '__|");
	System.out.println(" | |    | | (_| | (_|  __/ | |__| | | | (_| |  __/ |   ");
	System.out.println(" |_|    |_|\\__,_|\\___\\___|  \\____/|_|  \\__,_|\\___|_|   ");
	System.out.println("\n___________________________________________________________________________________________________________________");
  
    //ordernumber                                      
	String orderID1="ODR#"+ String.format("%05d", genID);
	genID++;
    System.out.println("\nEnter Order ID :"+orderID1);
   
    //method link
    String number=inputphonenumber();
    boolean check=checkphonenumber(number);
    while(check==false){
		System.out.println("\n\tInvalid Phone number.. Try again");
		System.out.println("\nDo you want to enter phone number again? (y/n) : ");
		String a=input.next();
		if(a.equalsIgnoreCase("Y")){
		    number=inputphonenumber();
			check=checkphonenumber(number);
		}
		else{
			genID--;
			homepage();
			
			}
		}
    
		tag=size();
		count=qty();
		while(count<0){
			
			count=qty();
			}
		prize=amount(tag,count);
		
	//place order
	boolean x=orderplace();
	if(x){
//save data


	//orderstatus
	
	String[] temp6=new String[orderstatusar.length+1];
              for(int i=0;i<orderstatusar.length;i++){
				  temp6[i+1]=orderstatusar[i];
				  } 
		                                        
		temp6[0]=orderstatus[0];
		orderstatusar=temp6;	
		
	
	//ordernumber
	
	String[] temp5=new String[ordernumber.length+1];
              for(int i=0;i<ordernumber.length;i++){
				  temp5[i+1]=ordernumber[i];
				  } 
		                                        
		temp5[0]=orderID1;
		ordernumber=temp5;	
		
	//phone number
	     String[] temp=new String[phonenumber.length+1];
     
              for(int i=0;i<phonenumber.length;i++){
				  temp[i+1]=phonenumber[i];
				  } 
		                                        
		temp[0]=number;
		phonenumber=temp;
//size
		String[] temp1=new String[size.length+1];
		for(int i=0;i<size.length;i++){
			temp1[i+1]=size[i];
			}
		temp1[0]=tag;
		size=temp1;
//quantity	

		int[] temp2=new int[qty.length+1];
		for(int i=0;i<qty.length;i++){
			temp2[i+1]=qty[i];
			}
		if(count>0){
		temp2[0]=count;
		qty=temp2;
	}	
//price
		float[] temp3=new float[amount.length+1];
		for(int i=0;i<amount.length;i++){
			temp3[i+1]=amount[i];
			}
			
		temp3[0]=prize;
		amount=temp3;



	System.out.print("\nDo you want place another order?(y/n) : ");
	String responce3=input.next();
		if(responce3.equalsIgnoreCase("y")){
			clearscreen();
			placeorder();
		}else{
			homepage();
			}

    }else{
	genID--;
	System.out.print("\nDo you want place another order?(y/n) : ");
	String responce4=input.next();
		if(responce4.equalsIgnoreCase("y")){
			clearscreen();
			placeorder();
		}else{
			homepage();
			}

		}
	  

	}
	



	//phone number methods
	public static String inputphonenumber(){
		System.out.print("\nEnter Customer Phone Number :");
		String number=input.next();
		
		return number;
		}

	public static boolean checkphonenumber(String number){
		if(number.length()==10 && number.charAt(0)=='0'){
			return true;
			}
		return false;
		}
	
	//size methods
	public static String size(){
    System.out.print("\nEnter T-Shirt Size : (XS/S/M/L/XL/XXL) :");
	String tag=input.next();
		
		return tag;
		}	
	
	//qty methods
	public static int qty(){
	System.out.print("\nEnter QTY :");
	int count=input.nextInt();
		
		return count;
		}	
	
	//amount calculate method
	public static float amount(String tag,int count){
	
	if(tag.equalsIgnoreCase("XS")){
		prize=600*count;		
		}
	else if(tag.equalsIgnoreCase("S")){
		prize=800*count;
		}
	else if(tag.equalsIgnoreCase("M")){
		prize=900*count;		
		}
	else if(tag.equalsIgnoreCase("L")){
		prize=1000*count;		
		}
	else if(tag.equalsIgnoreCase("XL")){
		prize=1100*count;		
		}
	else if(tag.equalsIgnoreCase("XXL")){
		prize=1200*count;		
		}
	System.out.print("\nAmount : "+prize);		
		return prize;
		}	

	//place order method
	public static boolean orderplace(){
	System.out.print("\nDo you want to place this order?(y/n) : ");
	String responce=input.next();
	if(responce.equalsIgnoreCase("Y")){
	System.out.println("\n\tOrder Placed..!");
	return true;
	}
	return false;
	
	}
		
				
	public static void clearscreen(){
				 try {
		 final String os = System.getProperty("os.name"); 
		 if (os.contains("Windows")) {
		 new ProcessBuilder("cmd", "/c", 
		"cls").inheritIO().start().waitFor();
		 } else {
		 System.out.print("\033[H\033[2J"); 
		 System.out.flush();
		 }
		 } catch (final Exception e) {
		 e.printStackTrace();
		 // Handle any exceptions.
		 }

		}
		
		
	public static boolean phonenumbervalidation(String num,String phonenumber[]){
		for(int i=0;i<phonenumber.length;i++){
			if(num.equals(phonenumber[i])){
				return true;
				}
			
			}
	return false;
	}
		
	public static void searchcustomer(){
		
System.out.println("   _____                     _        _____          _                            ");
System.out.println("  / ____|                   | |      / ____|        | |                           ");
System.out.println(" | (___   ___  __ _ _ __ ___| |__   | |    _   _ ___| |_ ___  _ __ ___   ___ _ __ ");
System.out.println("  \\___ \\ / _ \\/ _` | '__/ __| '_ \\  | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__|");
System.out.println("  ____) |  __/ (_| | | | (__| | | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |   ");
System.out.println(" |_____/ \\___|\\__,_|_|  \\___|_| |_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|   ");
                                                                                  
                                                                                  

		 System.out.print("\n\nEnter Customer Phone Number : "); 
		 String num=input.next();
		 boolean valid=phonenumbervalidation(num,phonenumber);
		 if(valid){
			 	System.out.println("+--------------------+---------------------+------------------------------+");
				System.out.println("|         Size       |         QTY         |              Amount          |"); 
				System.out.println("+--------------------+---------------------+------------------------------+");
				
		 float total=0;
		
		 for(int i=0;i<phonenumber.length;i++){

			 if(phonenumber[i].equals(num)){
				
				 total+=amount[i];
				 System.out.printf("| %-18s | %-19d | %-28.2f |\n", size[i], qty[i], amount[i]);
				 System.out.println("+--------------------+---------------------+------------------------------+");
		
				 }
				
			 }
			 System.out.printf("| %-18s | %-19s | %-28.2f |\n", "", "Total:", total);
			 System.out.println("+--------------------+---------------------+------------------------------+");

			 
		}else{
				

		System.out.print("\n\tInvalid ID..");
		
	}			 
		System.out.print("\nDo you want search another customer?(y/n) : ");
		String responce=input.next();
		if(responce.equalsIgnoreCase("y")){
			clearscreen();
			searchcustomer();
			}
		else{
			homepage();
			}
			 
		
		}
	
	public static int orderint(String orderid,String ordernumber[]){
	for(int i=0;i<ordernumber.length;i++){
		if(orderid.equals(ordernumber[i])){
			return i;
			}
 
		}
		return -2;
	}

	public static void searchorder(){
		

	System.out.println("  ____                      _        ___          _           ");
	System.out.println(" / ___|  ___  __ _ _ __ ___| |__    / _ \\ _ __ __| | ___ _ __ ");
	System.out.println(" \\___ \\ / _ \\/ _` | '__/ __| '_ \\  | | | | '__/ _` |/ _ \\ '__|");
	System.out.println("  ___) |  __/ (_| | | | (__| | | | | |_| | | | (_| |  __/ |   ");
	System.out.println(" |____/ \\___|\\__,_|_|  \\___|_| |_|  \\___/|_|  \\__,_|\\___|_|   ");
                                                              
	System.out.print("\nEnter order ID :");
	String orderid=input.next();
	int x=orderint(orderid,ordernumber);
		if(x>=0){
		printorderdetails(x);
		System.out.print("\nDo you want to search another order?(y/n) : ");
		String responce=input.next();
		if(responce.equalsIgnoreCase("y")){
			clearscreen();
			searchorder();
			}
		else{
			homepage();
			}
		
			}
		else{
		System.out.println("\n\tInvalid ID..");
		System.out.print("\nDo you want to search another order?(y/n) : ");
		String responce=input.next();
		if(responce.equalsIgnoreCase("y")){
			clearscreen();
			searchorder();
			}
		else{
			homepage();
			}
			
			
			}
		
		
		
		

		}
	public static void printorderdetails(int x){
		System.out.println("\nPhone Number : "+phonenumber[x]);	
		System.out.println("\nSize         : "+size[x]);	
		System.out.println("\nQTY          : "+qty[x]);	
		System.out.println("\nAmount       : "+amount[x]);	
		System.out.println("\nStatus       : "+orderstatusar[x]);		
		
		}
		
	public static void deleteorder(){

	System.out.println("  _____       _      _          ____          _           ");
	System.out.println(" |  __ \\     | |    | |        / __ \\        | |          ");
	System.out.println(" | |  | | ___| | ___| |_ ___  | |  | |_ __ __| | ___ _ __ ");
	System.out.println(" | |  | |/ _ \\ |/ _ \\ __/ _ \\ | |  | | '__/ _` |/ _ \\ '__|");
	System.out.println(" | |__| |  __/ |  __/ ||  __/ | |__| | | | (_| |  __/ |   ");
	System.out.println(" |_____/ \\___|_|\\___|\\__\\___|  \\____/|_|  \\__,_|\\___|_|   ");
                                                          
	System.out.print("\nEnter order ID :");
	String orderid=input.next();
	int x=orderint(orderid,ordernumber);
		if(x>=0){
		printorderdetails(x);
		System.out.print("\nDo you want to delete this order?(y/n) : ");
		String responce=input.next();
		if(responce.equalsIgnoreCase("y")){
			//deleting part
			
			//order number
			if(ordernumber.length>0){
			String[] temp=new String[ordernumber.length-1];
			for(int i=0,k=0;i<ordernumber.length;i++){
				if(i!=x){
					temp[k++]=ordernumber[i];
					}
			}
			ordernumber=temp;
			}
			//phone number
			if(phonenumber.length>0){
			String[] temp1=new String[phonenumber.length-1];
			for(int i=0,k=0;i<phonenumber.length;i++){
				if(i!=x){
					temp1[k++]=phonenumber[i];
					}
			}
			phonenumber=temp1;
			}
			//size
			if(size.length>0){
			String[] temp2=new String[size.length-1];
			for(int i=0,k=0;i<size.length;i++){
				if(i!=x){
					temp2[k++]=size[i];
					}
			}
			size=temp2;
		}
			//qty
			if(qty.length>0){
			int[] temp3=new int[qty.length-1];
			for(int i=0,k=0;i<qty.length;i++){
				if(i!=x){
					temp3[k++]=qty[i];
					}
			}
			qty=temp3;
		}
			//amount
			if(amount.length>0){
			float[] temp4=new float[amount.length-1];
			for(int i=0,k=0;i<amount.length;i++){
				if(i!=x){
					temp4[k++]=amount[i];
					}
			}
			amount=temp4;
		}
			//orderstatus
			if(orderstatusar.length>0){
			String[] temp5=new String[orderstatusar.length-1];
			for(int i=0,k=0;i<orderstatusar.length;i++){
				if(i!=x){
					temp5[k++]=orderstatusar[i];
					}
			}
			orderstatusar=temp5;									
			}
		System.out.print("\nDo you want to delete another order?(y/n) : ");
		String responce1=input.next();
		if(responce1.equalsIgnoreCase("y")){
			clearscreen();
			deleteorder();
			}
		else{
			homepage();
			}
			
		
			}
		else{
		System.out.println("\n\tInvalid ID..");
		System.out.print("\nDo you want enter order number again?(y/n) : ");
		String responce2=input.next();
		if(responce2.equalsIgnoreCase("y")){
			clearscreen();
			deleteorder();
			}
		else{
			homepage();
			}
                                                         
		
		
		
		
		
		}	
		
	}else{
		System.out.println("Invalid order ID");
		deleteorder();
		}
	}
	public static void viewreports(){
	System.out.println("  _____                       _       ");
	System.out.println(" |  __ \\                     | |      ");
	System.out.println(" | |__) |___ _ __   ___  _ __| |_ ___ ");
	System.out.println(" |  _  // _ \\ '_ \\ / _ \\| '__| __/ __|");
	System.out.println(" | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\");
	System.out.println(" |_|  \\_\\___| .__/ \\___/|_|   \\__|___/");
	System.out.println("            | |                       ");
	System.out.println("            |_|                       ");
	System.out.println("\n____________________________________________");
	System.out.println("\n\t[1]Customer Reports");
	System.out.println("\n\t[2]Item Reports");
	System.out.println("\n\t[3]Order Reports");
	System.out.print("\n\n\nEnter option :");
	int x=input.nextInt();
	switch(x){
		case 1:
		customerreports();
		break;
		case 2:
		itemreport();
		break;		
		case 3:
		orderreports();
		break;
		}


	
		}
		
		
	public static void itemreport(){

	System.out.println("  _____ _                   _____                       _       ");
	System.out.println(" |_   _| |                 |  __ \\                     | |      ");
	System.out.println("   | | | |_ ___ _ __ ___   | |__) |___ _ __   ___  _ __| |_ ___ ");
	System.out.println("   | | | __/ _ \\ '_ ` _ \\  |  _  // _ \\ '_ \\ / _ \\| '__| __/ __|");
	System.out.println("  _| |_| ||  __/ | | | | | | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\");
	System.out.println(" |_____|\\__\\___|_| |_| |_| |_|  \\_\\___| .__/ \\___/|_|   \\__|___/");
	System.out.println("                                      | |                       ");
	System.out.println("                                      |_|                       ");
	System.out.println("\n___________________________________________________________________________");
	System.out.println("\n\t[1]Best Selling Categories Sorted by QTY");
	System.out.println("\n\t[2]Best Selling Categories Sorted by Amount");
	System.out.print("\n\n\nEnter option :");
	int x=input.nextInt();
	switch(x){
		case 1:
		bestsellingcategoriesqty();
		break;
		case 2:
		bestsellingcategoriesamount();
		break;		
		}
		
		
		}
		
		
	public static void bestsellingcategoriesamount(){

	System.out.println("   _____            _           _   ____                                               _   ");
	System.out.println("  / ____|          | |         | | |  _ \\            /\\                               | |  ");
	System.out.println(" | (___   ___  _ __| |_ ___  __| | | |_) |_   _     /  \\   _ __ ___   ___  _   _ _ __ | |_ ");
	System.out.println("  \\___ \\ / _ \\| '__| __/ _ \\/ _` | |  _ <| | | |   / /\\ \\ | '_ ` _ \\ / _ \\| | | | '_ \\| __|");
	System.out.println("  ____) | (_) | |  | ||  __/ (_| | | |_) | |_| |  / ____ \\| | | | | | (_) | |_| | | | | |_ ");
	System.out.println(" |_____/ \\___/|_|   \\__\\___|\\__,_| |____/ \\__, | /_/    \\_\\_| |_| |_|\\___/ \\__,_|_| |_|\\__|");
	System.out.println("                                           __/ |                                           ");
	System.out.println("                                          |___/                                            ");
		
		String tempsize[]=new String[6];
		tempsize[0]="XS";
		tempsize[1]="S";
		tempsize[2]="M";
		tempsize[3]="L";
		tempsize[4]="XL";
		tempsize[5]="XXL";

		int [] tempqty=new int[6];
		float[] tempamount=new float[6];
		for(int i=0;i<phonenumber.length;i++){
			String temptag=size[i].toUpperCase();
				switch(temptag){
				case "XS" :
				tempqty[0]+=qty[i];
				tempamount[0]+=amount[i];
				break;
				case "S" :
				tempqty[1]+=qty[i];
				tempamount[1]+=amount[i];
				break;
				case "M" :
				tempqty[2]+=qty[i];
				tempamount[2]+=amount[i];
				break;
				case "L" :
				tempqty[3]+=qty[i];
				tempamount[3]+=amount[i];
				break;
				case "XL" : 
				tempqty[4]+=qty[i];
				tempamount[4]+=amount[i];
				break;
				case "XXL" : 
				tempqty[5]+=qty[i];
				tempamount[5]+=amount[i];
				break;
					
					
					}
			}
			
		for(int i=1;i<6;i++){
			for(int j=0;j<i;j++){
				if(tempamount[j]<tempamount[i]){
					int temp=tempqty[j];
					tempqty[j]=tempqty[i];
					tempqty[i]=temp;
					
					float temp1=tempamount[j];
					tempamount[j]=tempamount[i];
					tempamount[i]=temp1;
					
					String temp2=tempsize[j];
					tempsize[j]=tempsize[i];
					tempsize[i]=temp2;					
					}
				
				}
			
			}
			
		System.out.println("+------------+------------+-------------------+");
		System.out.println("|  Size      |    QTY     |   Total Amount    | ");
		System.out.println("+------------+------------+-------------------+");
		for(int i=0;i<6;i++){
		System.out.printf("|%-12s|%-12d|%-19.2f|\n",tempsize[i],tempqty[i],tempamount[i]);

			}
		System.out.println("+------------+------------+-------------------+");
		System.out.print("To access the Main Menu ,please enter O :");
		int x=input.nextInt();
		if(x==0){
			homepage();
			}		


		
		
		}	
		
		
	public static void bestsellingcategoriesqty(){
		

	System.out.println("   _____            _           _   ____           ____ _________     __");
	System.out.println("  / ____|          | |         | | |  _ \\         / __ \\\\__   __\\ \\   / /");
	System.out.println(" | (___   ___  _ __| |_ ___  __| | | |_) |_   _  | |  | | | |   \\ \\_/ / ");
	System.out.println("  \\___ \\ / _ \\| '__| __/ _ \\/ _` | |  _ <| | | | | |  | | | |    \\   /  ");
	System.out.println("  ____) | (_) | |  | ||  __/ (_| | | |_) | |_| | | |__| | | |     | |   ");
	System.out.println(" |_____/ \\___/|_|   \\__\\___|\\__,_| |____/ \\__, |  \\___\\_\\ |_|     |_|   ");
	System.out.println("                                           __/ |                        ");
	System.out.println("                                          |___/                         ");
			
		String tempsize[]=new String[6];
		tempsize[0]="XS";
		tempsize[1]="S";
		tempsize[2]="M";
		tempsize[3]="L";
		tempsize[4]="XL";
		tempsize[5]="XXL";
		int [] tempqty=new int[6];
		float[] tempamount=new float[6];
		for(int i=0;i<phonenumber.length;i++){
			String temptag=size[i].toUpperCase();
				switch(temptag){
				case "XS" :
				tempqty[0]+=qty[i];
				tempamount[0]+=amount[i];
				break;
				case "S" :
				tempqty[1]+=qty[i];
				tempamount[1]+=amount[i];
				break;
				case "M" :
				tempqty[2]+=qty[i];
				tempamount[2]+=amount[i];
				break;
				case "L" :	
				tempqty[3]+=qty[i];
				tempamount[3]+=amount[i];
				break;
				case "XL" : 
				tempqty[4]+=qty[i];
				tempamount[4]+=amount[i];
				break;
				case "XXL" :
				tempqty[5]+=qty[i];
				tempamount[5]+=amount[i];
				break;
					
					
					}
			}
			
		for(int i=1;i<6;i++){
			for(int j=0;j<i;j++){
				if(tempqty[j]<tempqty[i]){
					int temp=tempqty[j];
					tempqty[j]=tempqty[i];
					tempqty[i]=temp;
					
					float temp1=tempamount[j];
					tempamount[j]=tempamount[i];
					tempamount[i]=temp1;
					
					String temp2=tempsize[j];
					tempsize[j]=tempsize[i];
					tempsize[i]=temp2;					
					}
				
				}
			
			}
			
		System.out.println("+------------+------------+-------------------+");
		System.out.println("|  Size      |    QTY     |   Total Amount    | ");
		System.out.println("+------------+------------+-------------------+");
		for(int i=0;i<6;i++){
		System.out.printf("|%-12s|%-12d|%-19.2f|\n",tempsize[i],tempqty[i],tempamount[i]);
			}
		System.out.println("+------------+------------+-------------------+");
		System.out.print("To access the Main Menu ,please enter O :");
		int x=input.nextInt();
		if(x==0){
			homepage();
			}		


		}
		
	public static void orderreports(){
		

	System.out.println("   ____          _             _____                       _       ");
	System.out.println("  / __ \\        | |           |  __ \\                     | |      ");
	System.out.println(" | |  | |_ __ __| | ___ _ __  | |__) |___ _ __   ___  _ __| |_ ___ ");
	System.out.println(" | |  | | '__/ _` |/ _ \\ '__| |  _  // _ \\ '_ \\ / _ \\| '__| __/ __|");
	System.out.println(" | |__| | | | (_| |  __/ |    | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\");
	System.out.println("  \\____/|_|  \\__,_|\\___|_|    |_|  \\_\\___| .__/ \\___/|_|   \\__|___/");
	System.out.println("                                         | |                       ");
	System.out.println("                                         |_|                       ");
	System.out.println("\n___________________________________________________________________________");
	System.out.println("\n\t[1]All Orders");
	System.out.println("\n\t[2]Orders By Amount");
	System.out.print("\n\n\nEnter option :");
	int x=input.nextInt();
	switch(x){
		case 1:
		allorders();
		break;
		case 2:
		orderbyamount();
		break;		
		}
				
		}
		
		
	public static void allorders(){

	System.out.println(" __      ___                  ____          _               ");
	System.out.println(" \\ \\    / (_)                / __ \\        | |              ");
	System.out.println("  \\ \\  / / _  _____      __ | |  | |_ __ __| | ___ _ __ ___ ");
	System.out.println("   \\ \\/ / | |/ _ \\ \\ /\\ / / | |  | | '__/ _` |/ _ \\ '__/ __|");
	System.out.println("    \\  /  | |  __/\\ V  V /  | |__| | | | (_| |  __/ |  \\__ \\");
	System.out.println("     \\/   |_|\\___| \\_/\\_/    \\____/|_|  \\__,_|\\___|_|  |___/");
	System.out.println("\n___________________________________________________________________________\n\n");
                                                          
    System.out.println("+---------------+---------------+------+-----+----------+-----------+ ");                                                       
	System.out.println("|    Order ID   |  Customer ID  | Size | QTY |  Amount  | Status    |");
    System.out.println("+---------------+---------------+------+-----+----------+-----------+ ");  
	for(int i=0;i<ordernumber.length;i++){
	System.out.printf("|%-15s|%-15s|%-6s|%-5d|%-10.2f|%-11s|\n",ordernumber[i],phonenumber[i],size[i],qty[i],amount[i],orderstatusar[i]);	
		}
		
    System.out.println("+---------------+---------------+------+-----+----------+-----------+ \n\n");                                                       
    System.out.print("To access the Main Menu ,please enter O :");
    int x=input.nextInt();
    if(x==0){
		homepage();
		}		
		}
		
		
		
	public static void  orderbyamount(){
		

	System.out.println("   ____          _           ____                                               _   ");
	System.out.println("  / __ \\        | |         |  _ \\            /\\                               | |  ");
	System.out.println(" | |  | |_ __ __| | ___ _ __| |_) |_   _     /  \\   _ __ ___   ___  _   _ _ __ | |_ ");
	System.out.println(" | |  | | '__/ _` |/ _ \\ '__|  _ <| | | |   / /\\ \\ | '_ ` _ \\ / _ \\| | | | '_ \\| __|");
	System.out.println(" | |__| | | | (_| |  __/ |  | |_) | |_| |  / ____ \\| | | | | | (_) | |_| | | | | |_ ");
	System.out.println("  \\____/|_|  \\__,_|\\___|_|  |____/ \\__, | /_/    \\_\\_| |_| |_|\\___/ \\__,_|_| |_|\\__|");
	System.out.println("                                    __/ |                                           ");
	System.out.println("                                   |___/                                            ");
	System.out.println("\n______________________________________________________________________________________");
		
		
		String[] tempphonenumber=new String[phonenumber.length];
		String[] tempordernumber=new String[ordernumber.length];
		String[] temporderstatusar=new String[orderstatusar.length];
		String[] tempsize=new String[size.length];
		int[] tempqty=new int[qty.length];
		float[] tempamount=new float[amount.length];
		
				
		for(int i=0;i<amount.length;i++){
			tempamount[i]=amount[i];
			tempphonenumber[i]=phonenumber[i];
			tempordernumber[i]=ordernumber[i];
			temporderstatusar[i]=orderstatusar[i];
			tempqty[i]=qty[i];
			tempsize[i]=size[i];
			}
		for(int i=1;i<amount.length;i++){
			for(int j=0;j<i;j++){
				if(tempamount[j]<tempamount[i]){
				float temp4=tempamount[j];
				tempamount[j]=tempamount[i];
				tempamount[i]=temp4;
				
				String temp1=tempphonenumber[j];
				tempphonenumber[j]=tempphonenumber[i];
				tempphonenumber[i]=temp1;

				int temp3=tempqty[j];
				tempqty[j]=tempqty[i];
				tempqty[i]=temp3;

				String temp2=tempsize[j];
				tempsize[j]=tempsize[i];
				tempsize[i]=temp2;

				String temp5=tempordernumber[j];
				tempordernumber[j]=tempordernumber[i];
				tempordernumber[i]=temp5;	
				
				String temp6=temporderstatusar[j];
				temporderstatusar[j]=temporderstatusar[i];
				temporderstatusar[i]=temp1;
							
				}
			}
		}
    System.out.println("+---------------+---------------+------+-----+----------+-----------+ ");                                                       
	System.out.println("|    Order ID   |  Customer ID  | Size | QTY |  Amount  | Status    |");
    System.out.println("+---------------+---------------+------+-----+----------+-----------+ ");  
		
                                                         
	for(int i=0;i<tempordernumber.length;i++){
	System.out.printf("|%-15s|%-15s|%-6s|%-5d|%-10.2f|%-11s|\n",tempordernumber[i],tempphonenumber[i],tempsize[i],tempqty[i],tempamount[i],temporderstatusar[i]);	
		
		}
    System.out.println("+---------------+---------------+------+-----+----------+-----------+ \n\n");                                                       
		
    System.out.print("To access the Main Menu ,please enter O :");
    int x=input.nextInt();
    if(x==0){
		homepage();
		}		
		
		
	}	
		
		
		
	public static void customerreports(){

	System.out.println("   _____          _                              _____                       _       ");
	System.out.println("  / ____|        | |                            |  __ \\                     | |      ");
	System.out.println(" | |    _   _ ___| |_ ___  _ __ ___   ___ _ __  | |__) |___ _ __   ___  _ __| |_ ___ ");
	System.out.println(" | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__| |  _  // _ \\ '_ \\ / _ \\| '__| __/ __|");
	System.out.println(" | |___| |_| \\__ \\ || (_) | | | | | |  __/ |    | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\");
	System.out.println("  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|    |_|  \\_\\___| .__/ \\___/|_|   \\__|___/");
	System.out.println("                                                           | |                       ");
	System.out.println("                                                           |_|                       ");
	System.out.println("\n__________________________________________________________________________________________");
	System.out.println("\n\t[1]Best in Customers");
	System.out.println("\n\t[2]View Customers");
	System.out.println("\n\t[3]All Customer Reports");
	System.out.print("\n\n\nEnter option :");
	int x=input.nextInt();
	switch(x){
		case 1:
		bestincustomers();
		break;
		case 2:
		viewcustomers();
		break;		
		case 3:
		allcustomerreport();
		break;
		}
		
		
		}
		
		
		
		
		
	public static void allcustomerreport(){

	System.out.println("           _ _    _____          _                              _____                       _   ");
	System.out.println("     /\\   | | |  / ____|        | |                            |  __ \\                     | |  ");
	System.out.println("    /  \\  | | | | |    _   _ ___| |_ ___  _ __ ___   ___ _ __  | |__) |___ _ __   ___  _ __| |_ ");
	System.out.println("   / /\\ \\ | | | | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__| |  _  // _ \\ '_ \\ / _ \\| '__| __|");
	System.out.println("  / ____ \\| | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |    | | \\ \\  __/ |_) | (_) | |  | |_ ");
	System.out.println(" /_/    \\_\\_|_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|    |_|  \\_\\___| .__/ \\___/|_|   \\__|");
	System.out.println("                                                                          | |                   ");
	System.out.println("                                                                          |_|                   ");
	System.out.println("\n_____________________________________________________________________________________________________");
		

		
			
		String [] temp_customer = new String [phonenumber.length];
		double [] total_amount = new double [amount.length];		
		int [][] size_count = new int [size.length][6];
		
		int unique_count = 0;
		
		
		for (int i=0;i<ordernumber.length;i++){
			String cust_id = phonenumber[i];   
			boolean found = false; 
				
				
				
			for(int j=0;j<unique_count;j++){
				
				
				if(temp_customer[j]!=null && temp_customer[j].equals(cust_id)){
					size_count[j][size(size[i])]+=  qty[i];
					total_amount [j] += amount[i];
					found=true;
					break;
					
					}
				}
				
				if(!found){
					temp_customer[unique_count]= cust_id;
					size_count[unique_count][size(size[i])]=qty[i];
					total_amount[unique_count]=amount[i];
					unique_count++;
				}
			
			}
			
			
		System.out.print("\t\t+------------------+--------+---------+--------+---------+--------+---------+------------------+");
		System.out.printf("\n\t\t|  %-14s  |  %-4s  |   %-4s  |  %-4s  |   %-4s  |  %-4s  |   %-4s  |  %-14s  |","Phone number","XS","S","M","L","XL","XXL","Totl");
		System.out.print("\n\t\t+------------------+--------+---------+--------+---------+--------+---------+------------------+");
		
	
		for (int i=0;i<unique_count;i++){
			
				
		System.out.printf("\n\t\t|  %-14s  |  %-4s  |   %-4s  |  %-4s  |   %-4s  |  %-4s  |   %-4s  |  %-14s  |",temp_customer[i],+size_count[i][0],+size_count[i][1],+size_count[i][2],+size_count[i][3],+size_count[i][4],+total_amount[i]);
		
		}
		System.out.println("\n\t\t+------------------+--------+---------+--------+---------+--------+---------+------------------+");

			
		System.out.print("\n\n\n\tTo access the Menu, Please enter 0 : ");
		String yes_no= input.next();
		homepage();	
	}	








	public static int size(String size){
	
		switch (size){
			
			case "XS" :
			return 0;
			case "S" :
			return 1;
			case "M" :
			return 2;
			case "L" :
			return 3;
			case "XL" : 
			return 4;
			case "XXL" : 
			return 5;
			default : 
			return -1;
		
		}
		
	}	


		
		
	public static void viewcustomers(){

	System.out.println(" __      ___                  _____          _                                ");
	System.out.println(" \\ \\    / (_)                / ____|        | |                               ");
	System.out.println("  \\ \\  / / _  _____      __ | |    _   _ ___| |_ ___  _ __ ___   ___ _ __ ___ ");
	System.out.println("   \\ \\/ / | |/ _ \\ \\ /\\ / / | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__/ __|");
	System.out.println("    \\  /  | |  __/\\ V  V /  | |___| |_| \\__ \\ || (_) | | | | | |  __/ |  \\__ \\");
	System.out.println("     \\/   |_|\\___| \\_/\\_/    \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|  |___/");
                                                                              
                                                                          
                                                                           
	String[] tempphonenumber=new String[phonenumber.length];
	int [] tempqty=new int[qty.length];
	float[] tempamount=new float[amount.length]; 
	
	int uniquecount=0;
	
	for(int i=0;i<phonenumber.length;i++){
		String customerid=phonenumber[i];
		boolean repeat=false;
		
		
		
	for(int j=0;j<phonenumber.length;j++){
		if(tempphonenumber[j]!=null && tempphonenumber[j].equals(customerid)){
			tempqty[j]+=qty[i];
			tempamount[j]=amount[i];
			repeat=true;
			break;
			}
		}
	if(!repeat){
		tempphonenumber[uniquecount]=customerid;
		tempqty[uniquecount]=qty[i];
		tempamount[uniquecount]=amount[i];
		uniquecount++;
		
		}	
		
	}
	
	
		System.out.print("+-----------------------+-----------+-------------------------+");
		System.out.printf("\n|   %-17s   |  %-7s  |   %-20s  |","Customer ID","All Qty","Total amount");
		System.out.print("\n+-----------------------+-----------+-------------------------+");


		
		
		for(int i=0;i<uniquecount;i++){
			
			System.out.printf("\n|   %-17s   |  %-7s  |   %-20s  |",tempphonenumber[i],+tempqty[i],+tempamount[i]);

		
		
		}System.out.print("\n+-----------------------+-----------+-------------------------+");
		
		System.out.print("\n\n\n\tTo access the Menu, Please enter 0 : ");
		String responce= input.next();
		homepage();			
		}
		
		
		
		
		
		
	public static void bestincustomers(){

	System.out.println("  ____            _     _____          _____          _                                ");
	System.out.println(" |  _ \\          | |   |_   _|        / ____|        | |                               ");
	System.out.println(" | |_) | ___  ___| |_    | |  _ __   | |    _   _ ___| |_ ___  _ __ ___   ___ _ __ ___ ");
	System.out.println(" |  _ < / _ \\/ __| __|   | | | '_ \\  | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__/ __|");
	System.out.println(" | |_) |  __/\\__ \\ |_   _| |_| | | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |  \\__ \\");
	System.out.println(" |____/ \\___||___/\\__| |_____|_| |_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|  |___/");
   	System.out.println("\n__________________________________________________________________________________________");
     
   
                                                                           
	String[] tempphonenumber=new String[phonenumber.length];
	int [] tempqty=new int[qty.length];
	float[] tempamount=new float[amount.length]; 
	
	int uniquecount=0;
	
	for(int i=0;i<phonenumber.length;i++){
		String customerid=phonenumber[i];
		boolean repeat=false;
		
		
		
	for(int j=0;j<phonenumber.length;j++){
		if(tempphonenumber[j]!=null && tempphonenumber[j].equals(customerid)){
			tempqty[j]+=qty[i];
			tempamount[j]=amount[i];
			repeat=true;
			break;
			}
		}
	if(!repeat){
		tempphonenumber[uniquecount]=customerid;
		tempqty[uniquecount]=qty[i];
		tempamount[uniquecount]=amount[i];
		uniquecount++;
		
		}	
		
	}
	
	for(int i=1;i<phonenumber.length;i++){
		for(int j=0;j<i;j++){
			if(tempamount[j]>tempamount[i]){
				float temp=tempamount[j];
				tempamount[j]=tempamount[i];
				tempamount[i]=temp;

				int temp1=tempqty[j];
				tempqty[j]=tempqty[i];
				tempqty[i]=temp1;
				
				String temp2=tempphonenumber[j];
				tempphonenumber[j]=tempphonenumber[i];
				tempphonenumber[i]=temp2;
				
				
		
				}
			
			}	
		}
		System.out.print("+-----------------------+-----------+-------------------------+");
		System.out.printf("\n|   %-17s   |  %-7s  |   %-20s  |","Customer ID","All Qty","Total amount");
		System.out.print("\n+-----------------------+-----------+-------------------------+");


		
		
		for(int i=0;i<uniquecount;i++){
			
			System.out.printf("\n|   %-17s   |  %-7s  |   %-20s  |",tempphonenumber[i],+tempqty[i],+tempamount[i]);

		
		
		}System.out.print("\n+-----------------------+-----------+-------------------------+");
		
		System.out.print("\n\n\n\tTo access the Menu, Please enter 0 : ");
		String responce= input.next();
		homepage();	
		
		
		
				
					}
					
					
					
					
					
					
	public static int phonenumberindex(String[] phonenumber ){	
		for(int j=0;j<phonenumber.length;j++){
			for(int i=1;i<phonenumber.length;i++){
				if(phonenumber[j].equals(phonenumber[i])){
						return i;
					}
				
				}
			}
		return -1;
		}
		
		
	public static int uniquecount(String[] phonenumber){
		int count=0;
		for(int j=1;j<phonenumber.length;j++){
			for(int i=0;i<phonenumber.length;i++){
				if(phonenumber[i]!=phonenumber[j]){
						count++;
					}
				
				}
			}
		return count;
		
		}
		
		
		
	public static void setorderstatus(){

	System.out.println("   ____      _              _____ _        _             ");
	System.out.println("  / __ \\    | |            / ____| |      | |            ");
	System.out.println(" | |  | | __| | ___ _ __  | (___ | |_ __ _| |_ _   _ ___ ");
	System.out.println(" | |  | |/ _` |/ _ \\ '__|  \\___ \\| __/ _` | __| | | / __|");
	System.out.println(" | |__| | (_| |  __/ |     ____) | || (_| | |_| |_| \\__ \\");
	System.out.println("  \\____/ \\__,_|\\___|_|    |_____/ \\__\\__,_|\\__|\\__,_|___/");
   	System.out.println("\n________________________________________________________________");
                                                       
    System.out.print("Enter order ID : ");                                                     
	String orderid=input.next();	
	int x=orderint(orderid,ordernumber);
	if(x>=0){
		printorderdetails(x);
		System.out.print("Do you want to change this order status? (y/n) :");	
		String responce=input.next();
		if(responce.equalsIgnoreCase("y")){	

		if(orderstatusar[x].equalsIgnoreCase("processing")){
		
			System.out.println("\n\t[1]Order Delivering");
			System.out.println("\n\t[2]Order Delivered");	
		
		System.out.print("Enter option");
		int y=input.nextInt();
		if(y==1){
		orderstatusar[x]=orderstatus[1];
		System.out.println("\n\tstatus updated");
		
			
		}
		else if(y==2){
		orderstatusar[x]=orderstatus[2];
		System.out.println("\n\tstatus updated");
		
		
		}
		}
		else if(orderstatusar[x].equalsIgnoreCase("delivering")){
			System.out.println("\n\t[1]Order Delivered");			
		System.out.print("Enter option");
		int y=input.nextInt();
		if(y==1){
		orderstatusar[x]=orderstatus[2];
		System.out.println("\n\tstatus updated");
		
		}
			
			
		}
		else if(orderstatusar[x].equalsIgnoreCase("delivered")){
			System.out.println("\t\nCan't change this order status,Order already delivered..!");
		}
		
		}else{
			System.out.println("\t\nInvalid order ID");
		}
			System.out.println("\n\nDo you want to change another order status? (y/n) :");
			String responce1=input.next();
			if(responce1.equalsIgnoreCase("Y")){
				setorderstatus();
				}else{
				clearscreen();
				homepage();	
				}
			
			
			}
		

			
			
			}
		
		}
		
		
			
	
	
	
	

	
	
                                                                                       
			
			
			

