import java.util.*;
class caursework1{
	static Scanner input = new Scanner(System.in);
	
	static int[][] marks = new int[0][2];
	static String[][] names = new String[0][2];
	
public static void main(String args[]){
	
	do{
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("|                      WELCOME TO GDSE MARKS MANAGEMENT SYSTEM                      |");	
		System.out.println("-------------------------------------------------------------------------------------");
		
		System.out.println();
		System.out.print("[1] Add New Student\t\t\t");
		System.out.println("[2] Add New Student With Mark");
		System.out.print("[3] Add Mark\t\t\t\t");
		System.out.println("[4] Update Student Details");
		System.out.print("[5] Update Mark\t\t\t\t");
		System.out.println("[6] Delete Student");
		System.out.print("[7] Print Student Details\t\t");
		System.out.println("[8] Print Student Ranks");
		System.out.print("[9] Best in Programming Fundamengtals\t");
		System.out.println("[10] Best in Database Management System\n");
		
		System.out.print("Enter And Option To Continue > ");
		int option = input.nextInt();
		
			switch(option){
				case 1 :							
						option1();
					break;
				case 2 :
						option2();
					break;
					
				case 3 :
						option3();
					break;
					
				case 4 :
						option4();
					break;
					
				case 5 :
						option5();
					break;
					
				case 6 :
						option6();
					break;
					
				case 7 :
						option7();
					break;
					
				case 8 :
						option8();
					break;
					
				case 9 :
						option9();
					break;
					
				case 10 :
						option10();
					break;
					
				default :
					System.out.println("Invalid Input...");
			}//switch case end		
			clearConsole();
		} while(true);//while end	
}//main method end
	
public static void extendArr(){
		int[][] tempM = new int[marks.length + 1][2];
		String[][] tempN = new String[names.length + 1][2];
	
			for(int i = 0; i < marks.length; i++){
				    
				tempM[i][0] = marks[i][0];
				tempM[i][1] = marks[i][1];
				
				tempN[i][0] = names[i][0];
				tempN[i][1] = names[i][1];
			}//for end
			marks = tempM;
			names = tempN;
	}//method end

public static void narrowArr(){
	String[][] tNames = new String[names.length - 1][2];
	int[][] tMarks = new int[marks.length-1][2];

		for(int i = 0; i < marks.length-1; i++){
			
			tMarks[i][0] = marks[i][0];
			tMarks[i][0] = marks[i][1];
			
			tNames[i][0] = names[i][0];
			tNames[i][1] = names[i][1];
		}//for end
		
}//method end

public static int[][] rankSub(int x){
		
		int[][] rank = new int[marks.length][3];
		
		for(int i = 0; i < marks.length; i++){
			
			rank[i][0] = i;
			rank[i][2] = marks[i][x];
			
			}
		
		for(int j = 0; j < rank.length; j++){
			
			for(int i = 0; i < rank.length - 1; i++){
				
				if(rank[i+1][2] > rank[i][2]){
					
					int temp = rank[i][2];
					rank[i][2] = rank[i+1][2];
					rank[i+1][2] = temp;
					
					int tempMark = rank[i][0];
					rank[i][0] = rank[i+1][0];
					rank[i+1][0] = tempMark;
					
					}
				
				}
				
			}
			
		for(int i = 0; i < rank.length; i++){
			
			rank[i][1] = i+1 ;
			
			}	
			
		for(int j = 0; j < rank.length - 1; j++){
							
			if(rank[j][2] == rank[j+1][2])rank[j+1][1] = rank[j][1];
							
			}	
	
		return(rank);
		
		}	

public static int [][] rankStudent(){
			
	int st [][]=new int [marks.length][3];
			
		for (int i = 0; i < marks.length; i++){
				st[i][0]=i;
				st[i][2]=marks[i][0]+marks[i][1];
		}
			
		for (int b = 0; b < st.length; b++){
				
				for (int a = 0; a <st.length -1 ; a++){
					
					if (st[a+1][2] > st [a][2]){
						
						int temp = st[a][2];
						st[a][2] = st[a + 1][2];
						st[a+1][2] = temp;
						
						int tempMark = st[a][0];
						st[a][0] = st[a + 1][0];
						st[a + 1][0] = tempMark;						
					}					
				}					
		}//for end
			
		for (int i = 0; i< st.length; i++){				
				st[i][1]=i + 1;				
		}
			
		for(int a = 0; a < st.length-1; a++){ 				
				if(st[a][2] == st[a + 1][2])
					st[a + 1][1] = st[a][1];				
		}
			
		return (st);
						
}//end method
	
 public static void option1(){
		char s = 'n';
		String inputsid = " ";
		extendArr();
		int count = 1;
		
	do{
				clearConsole();
				System.out.println("-------------------------------------------------------------------------------------");
				System.out.println("|                                ADD NEW STUDENT                                    |");	
				System.out.println("-------------------------------------------------------------------------------------");			
		
		count = 1;
		
		while(count == 1){
			System.out.print("Enter student id : ");
			inputsid = input.next();
			
			count = 0;
			
			for(int i = 0; i < names.length; i++){
					
				if(inputsid .equals (names[i][0])){
					
					count = 1;
					System.out.println("Duplicate Input.Try Again...");
					System.out.println();
					break;
				}					
				else{
					count = 0;
				}			
			}//for end
		}//while end
			
			if(count == 0){
				names[names.length-1][0] = inputsid;
							
				System.out.print("Enter student name : ");
				String inputname = input.next();
				
				names[names.length-1][1] = inputname;
				
				System.out.println("Student has been added Successfully");
				System.out.println();						
			}//if end
			 			
				while(true){
				System.out.print("Do you want to add a new student(y/n) : ");
				s = input.next().charAt(0);
				System.out.println();
				
					if (s == 'y' || s == 'n'){
						break;
					}
					else{
						System.out.println("Invalid Input.try again...");
					}
				}//while end	
							
			if (s == 'n'){				
				break;
			}
			
		}while(s == 'y');//main while end
		clearConsole();
	}//method end
	
public static void option2(){
	char s = 'n'; 
		String inputsid = "a";
		
		do{		clearConsole();
				System.out.println("-------------------------------------------------------------------------------------");
				System.out.println("|                            ADD NEW STUDENT WITH MARKS                             |");	
				System.out.println("-------------------------------------------------------------------------------------");	
				
			extendArr();
						
			System.out.print("Enter student id : ");
			inputsid = input.next();
			
			int count = 0;
			
				for(int i = 0; i < names.length; i++){
						
					if(inputsid .equals (names[i][0])){
						
						count = 1;
						break;
					}
					
				}					

					if(count == 0){
						names[names.length-1][0] = inputsid;
									
						System.out.print("Enter student name : ");
						String inputname = input.next();						
						System.out.println();
						
						names[names.length-1][1] = inputname;
						
						while(true){								
							System.out.print("Enter Programing Fudamental Marks : ");
							marks[marks.length - 1][0] = input.nextInt();
								
							if (marks[marks.length - 1][0]>0 && marks[marks.length - 1][0]<100){
								break;
							}
							else{
								System.out.print("invalid Marks.Please Enter Correct Marks...");
								System.out.println();							
							}	
						}//while end						
						
						while(true){
								
							System.out.print("Enter database managemnet Marks : ");
							marks[marks.length - 1][1] = input.nextInt();
							System.out.println();
																							
							if (marks[marks.length - 1][1]>0 && marks[marks.length - 1][1]<100){
								System.out.println("Marks has been added Successfully");
								break;
							}
							else{
								System.out.println("invalid marks.Please Enter Correct Marks...");
								System.out.println();
							}	
						}//while end
									
					} else{
						
						System.out.println("Student ID already exists.");
						
						}//if end
			
						
				while(true){
					System.out.print("Do you want to add a new student(y/n) : ");
					s = input.next().charAt(0);
				
						if (s == 'y' || s == 'n'){
							break;
						}
						else{
							System.out.println("Invalid Input.try again...");
						}
				}	
			
				
			if (s=='n'){
				
				break;
			}
		}while(s == 'y');
	}
	
public static void option3(){
			
	clearConsole();
	char yn = 'y';
		while (yn == 'y'){
		
				System.out.println("-------------------------------------------------------------------------------------");
				System.out.println("|                                   ADD MARKS                                       |");	
				System.out.println("-------------------------------------------------------------------------------------");		     
			
			int studentCount = -1;
			char yn1 = 'y';
				
				while (true){
					System.out.print("Student ID : ");
					String studentSid=input.next();
		  
					for (int i = 0; i <names.length; i++){
						if (studentSid.equals(names[i][0])){
							studentCount = i;
						}
					}
		  
					if (studentCount == -1){
						System.out.print("Student Details Not Included...\n");	  
		  
						while (true){
							System.out.print("Do you want to add marks to student again(y/n) : ");
							yn1 =input.next().charAt(0);
			  
							if (yn1 == 'y' || yn1 == 'n'){
								break;
							}
							else{
								System.out.print("Invalid Input...");
							}
						}//while end					
					}
					
					else{
						System.out.print("Student name "+names[studentCount][1]);
						System.out.println();
						break;
					}
					if (yn1 == 'n'){
						break;
					}
	  
				}	
				
			if (marks[studentCount][0] >0 || marks[studentCount][1] > 0){
				System.out.println("This student's marks have been already added.\nIf you want to update the marks, please use [4] Update marks option.\n");		
			}
			else{	
					while(true){
						System.out.print("\nEnter programming fundamental marks : ");
						marks[studentCount][0] = input.nextInt();
				  
						if (marks[studentCount][0] > 0 && marks[studentCount][0] < 100){
							break;
						}
						else{
							System.out.println("invalid Marks.Please Enter Correct Marks...");
						}		  
                    } //while end                  
                    	  
					while(true){
						System.out.print("Enter Database management System Marks : :");
						marks[studentCount][1] = input.nextInt();
				  
						if (marks[studentCount][1] > 0 && marks[studentCount][1] < 100){
							break;
						}else{
							System.out.println("invalid Marks.Please Enter Correct Marks...");
						}		  
					} //while end            
					System.out.print("\nMarks have been successfully added...\n ");     
                    
			}//end else
		
			while (true){
				System.out.print("Do you want to add marks for another student?(y/n) : ");
				yn = input.next().charAt(0);
	    
				if(yn =='y' ||yn =='n'){
						break;
				}
				else{
					System.out.print("Invalid Input...");
				}
			}//while end		
			clearConsole();
		}//main while loop	  	
 }//end method	
 
public static void option4(){
	 	char yn = 'q';
					
	while(true){
		clearConsole();
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("|                          	UPDATE STUDENT DETAIL                                   |");	
		System.out.println("-------------------------------------------------------------------------------------");					
			
		System.out.print("Student ID : ");
		String studentSid=input.next();
		  
			for (int i = 0; i <names.length; i++){
				if (studentSid.equals(names[i][0])){
					
					System.out.println("Student name : "+names[i][1]);
					
					System.out.print("Enter the new Student name : ");
					names[i][1] = input.next();
					System.out.println("Student Details has been update successfully...");
				}
			}
			
		while(true){
			System.out.print("Do you want to add another student details ? (y/n) : ");
			yn = input.next().charAt(0);
				
				if(yn =='y' ||yn =='n'){
						break;
				}
				else{
					
					System.out.print("Invalid Input...");
				}
		}//while end
		if(yn == 'n'){
		
			break;
		}
			
	}//main while end
	clearConsole();
	
}//method end

public static void option5(){
	 	char yn = 'q';
					
	while(true){
		clearConsole();
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("|                          	UPDATE STUDENT DETAIL                                   |");	
		System.out.println("-------------------------------------------------------------------------------------");					
			
		System.out.print("Student ID : ");
		String studentSid=input.next();
		  
			for (int i = 0; i < names.length; i++){
				if (studentSid.equals(names[i][0])){
					
					System.out.println("Student name : " + names[i][1]);
					
					if(marks[i][0] == 0 && marks[i][1] == 0){
						System.out.println("This student's marks yet to be added...\n");
						break;
					}
					
					System.out.println("\nPRF Mark : " + marks[i][0]);
					System.out.println("DBMS Mark : " + marks[i][1]);
					
					System.out.print("\nEnter the new PRF marks : ");
					marks[i][0] = input.nextInt();
					
					System.out.print("Enter the new DBMS marks : ");
					marks[i][1] = input.nextInt();
					System.out.println("Student Details has been update successfully...");
				}
			}
			
		while(true){
			System.out.print("Do you want to add another student marks ? (y/n) : ");
			yn = input.next().charAt(0);
				
				if(yn =='y' ||yn =='n'){
						break;
				}
				else{
					System.out.print("Invalid Input...");
				}
		}//while end
		if(yn == 'n'){
			break;
		}
			
	}//main while end
	clearConsole();
}//method End

public static void option6(){
	   Scanner input=new Scanner(System.in);
	   
	   char opt='y';
	   char opt1=' ';
	   
		while (opt=='y'){
	         clearConsole();
		     System.out.println("------------------------------------------------------------------------------------------------");
		     System.out.println("|                                   DELETE STUDENT                                             |");
		     System.out.println("------------------------------------------------------------------------------------------------");	  
      
			 int idNo = -1;
        			 
			 while (true){
				System.out.print("Enter Student ID : ");
				String id=input.next();
		  
				for (int i = 0; i <names.length; i++){
					if (id.equals(names[i][0])){
						idNo = i;
					}
				}
		  	  
				if(idNo == -1){
					System.out.print("Invalid ID...");
			 
					while (true){
						System.out.print("Do you want search again (y/n)? : ");
						opt1=input.next().charAt(0);
				 
						if (opt1 == 'y' || opt1 == 'n'){
							break;
						}
						else{
							System.out.print("Invalid Option...");
						}
					}//while end
			 	 
			 	    if (opt1=='n'){
		                break;
	                }  
			   }
			   else{
					break;
			   }
			}//while end    
    
			for (int y = idNo; y <names.length-1; y++){
				for (int x = 0; x < 2; x++){
					names[y][x] = names[y + 1][x];
				}
					
				String [][] tempdelete1=new String [names.length - 1][2];
				int [][] tempdelete2 = new int [marks.length - 1][2];
		
				for (int a = 0; a < names.length - 1; a++){
					for (int b = 0; b < 2; b++){
						tempdelete1[a][b] = names[a][b];
						tempdelete2[a][b] = marks[a][b];
					}	
				}//for end
				
				names=tempdelete1;
				marks=tempdelete2;
	  
			}//for end
     
			System.out.println("Student has been deleted succussfully.");
     
			while(true){ 
				System.out.print("do you want to delete another student(y/n).");
				opt = input.next().charAt(0);
     
				if(opt == 'y' || opt == 'n'){
					break;
				}
				else{
					System.out.println("Invalid Option...");
				}
			}//while end
     
			if (opt == 'n'){
				break;
			}
            
		}//main while end  
      clearConsole();      
}  //end method

public static void option7(){
			
			clearConsole();
			 System.out.println("------------------------------------------------------------------------------------------------");
		     System.out.println("|                                PRINT STUDENT DETAILS                                         |");
		     System.out.println("------------------------------------------------------------------------------------------------");			
			 System.out.println();			
	String id = "";
	int i = 0;
		
	while (true){	
		int count = 0;
					
			System.out.print("Enter Student ID : ");
			id = input.next();
															
			for (i = 0; i < names.length; i++){ 
				
				if(names[i][0].equals (id)){							
					count = 1;
					break;
				}								
			}//for end
				if(count == 1){					
					int[][] st = rankStudent(); 					
					int j = 0;					
					
					for(j = 0; j < st.length; j++){						
						if(st[j][0] == i)break;						
						}
					
					System.out.println("student name :  " + names[i][1] );
					System.out.println("student  prf marks :  " + marks[i][0] );
					System.out.println("student database marks : " + marks[i][1] );
					System.out.println("Rank : " + st[j][1]);
					System.out.println("Sum :" + (marks[i][0]+marks[i][1]));
					System.out.println("Avarage : " + (marks[i][0] + marks[i][1])/2);					
				}//if end					
					else{						
						System.out.println("Invalid student id.");						
					}
						
		char a;
		
		while (true){
			System.out.print("Do you want print another student details (y/n)? : ");
			a = input.next().charAt(0);
		
				if (a == 'n' || a == 'y'){
					break;
				}		
				else{
					System.out.print("invalid number...");
				}
		
		}//while end  
	  if(a=='n') break;			  	
	}//main while end
} //method end

public static void option8(){
	clearConsole();	
		System.out.println(" -------------------------------------------------------------------------------------");
		System.out.println(" |                                PRINT STUDENT RANKS                                |");
		System.out.println(" -------------------------------------------------------------------------------------");
		
		System.out.println();
		
		System.out.println("  +--------+--------+------------+----------+----------+");
		
		System.out.printf("  |%-8s|%-8s|%-12s|%-10s|%-10s|", "Rank", "ID", "Name", "Tot.Marks", "Avg.Marks");
		System.out.println();
		
		System.out.println("  +--------+--------+------------+----------+----------+");
		
		int[][] rank = rankStudent();
		
		for(int i = 0; i < rank.length; i++){			
			if(!(marks[rank[i][0]][0] == (-1) || marks[rank[i][0]][1] == (-1))){
			
				System.out.printf("  |%-8s|%-8s|%-12s|%-10s|%-10s|" , "" + rank[i][1] , "" + names[rank[i][0]][0] , "" + names[rank[i][0]][1] , "" + rank[i][2] , "" + (rank[i][2]/2));
				System.out.println();			
			}
			
		}//for end
		
		System.out.println("  +--------+--------+------------+----------+----------+");
		
		System.out.println();
		System.out.println(" Enter any key and press Enter to continue..");
		input.next();
		
}//method end

public static void option9(){
	clearConsole();	
		System.out.println(" -------------------------------------------------------------------------------------");
		System.out.println(" |                         BEST IN PROGRAMMING FUNDAMENTALS                          |");
		System.out.println(" -------------------------------------------------------------------------------------");
		
		System.out.println();
		
		System.out.println("  +--------+------- ----+----------+----------+");
		
		System.out.printf("  |%-8s|%-12s|%-10s|%-10s|", "ID", "Name", "Prf.Marks", "Dbms.Marks");
		System.out.println();
		
		System.out.println("  +--------+------- ----+----------+----------+");
		
		int[][] rank = rankSub(0);
		
		for(int i = 0; i < rank.length; i++){
			
			if(!(marks[rank[i][0]][0] == (-1) || marks[rank[i][0]][1] == (-1))){
			
				System.out.printf("  |%-8s|%-12s|%-10s|%-10s|" , "" + names[rank[i][0]][0] , "" + names[rank[i][0]][1] , "" + marks[rank[i][0]][0] , "" + marks[rank[i][0]][1]);
				System.out.println();
			}			
		}
		
		System.out.println("  +--------+------- ----+----------+----------+");
		
		System.out.println();
		System.out.println(" Enter any key and press Enter to continue..");
		input.next();
	
}//end method
		
public static void option10(){
	clearConsole();
		System.out.println(" -------------------------------------------------------------------------------------");
		System.out.println(" |                        BEST IN DATABASE MANAGEMENT SYSTEM                         |");
		System.out.println(" -------------------------------------------------------------------------------------");
		
		System.out.println();
		
		System.out.println("  +--------+------- ----+----------+----------+");
		
		System.out.printf("  |%-8s|%-12s|%-10s|%-10s|", "ID", "Name", "Prf.Marks", "Dbms.Marks");
		System.out.println();
		
		System.out.println("  +--------+------- ----+----------+----------+");
		
		int[][] rank = rankSub(1);
		
		for(int i = 0; i < rank.length; i++){
			
			if(!(marks[rank[i][0]][0] == (-1) || marks[rank[i][0]][1] == (-1))){
			
				System.out.printf("  |%-8s|%-12s|%-10s|%-10s|" , "" + names[rank[i][0]][0] , "" + names[rank[i][0]][1] , "" + marks[rank[i][0]][0] , "" + marks[rank[i][0]][1]);
				System.out.println();			
			}			
		}//for end
		
		System.out.println("  +--------+------- ----+----------+----------+");
		
		System.out.println();
		System.out.println(" Enter any key and press Enter to continue..");
		input.next();	
}//end method	

public final static void clearConsole(){ 
		 try {
				final String os = System.getProperty("os.name"); 
				if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				} 
				
				else {
						System.out.print("\033[H\033[2J"); 
						System.out.flush();
				}
		
		} 
		 catch (final Exception e) {
			e.printStackTrace();
			// Handle any exceptions.
		 }
	}

}//class end
