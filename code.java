import java.util.*; 

class video6019{ 

String title; //variable to store title 

boolean check; //variable to check if video is available 

int rating=0; //rating given by user 

void getRating(int x) { //function to get rating 

System.out.println("Rating accepted"); 

rating = x; 

} 

void rent() { //changes status of video 

check = false; 

} 

boolean checked() { //checks if video is available 

return check; 

} 

} 

class videoStore6019{ 

static int count=0; //global scope in class 

Scanner s1 = new Scanner(System.in); //scanner object for inputs 

video6019 v[] = new video6019[10]; //video objects created 

void listInventory() { // function to display video list 

if(count==0) { // if list is empty 

System.out.println("List is empty"); 

} 

else { 

System.out.println("VIDEOS"); 

for(int i=1; i<=count; i++) { // printing video list 

System.out.print(i+": "+v[i].title); 

System.out.print("\t\tRating: "); 

if(v[i].rating==0) // if rating is not available 

System.out.println("Not available"); 

else 

System.out.println(v[i].rating+"/5"); 

} 

} 

} 

void returnVideo() { //function to return video 

if(count==0) //if no video to return  

System.out.println("You have no video to return"); 

else { 

System.out.println("Enter the video to return: "); 

String def = s1.nextLine(); 

int present = 0; 

for(int i=1; i<=count; i++) { 

if(def.equalsIgnoreCase(v[i].title)) 

present = i; 

} 

if(present==0) // if video not in list 

System.out.println("Video not found"); 

else { 

if(v[present].check == true) // if video already returned 

System.out.println("Video already in store"); 

else { 

v[present].check = true; 

System.out.println("Video returned"); 

} 

} 

} 

} 

void addVideo() { 

if(count>10) //if inventory limit exceeded 

System.out.println("Inventory limit exceeded"); 

else { 

count++; //global scope of count 

v[count] = new video6019(); //object constructor 

System.out.println("Enter the title"); 

v[count].title = s1.nextLine();  

v[count].check = true; 

System.out.println("Video added successfully"); 

} 

} 

void checkOut() { //renting the video 

System.out.println("Enter the name of video to rent"); 

String abc = s1.nextLine(); 

int present = 0; 

for(int i=1; i<=count; i++) { //video search 

if(abc.equalsIgnoreCase(v[i].title)) 

present = i; 

} 

if(present==0) // if video not found 

System.out.println("Video not found"); 

else { 

     if(v[present].checked()) { 

    	 System.out.println("Video rented successfully"); 

    	 v[present].rent(); 

     } 

     else 

    	 System.out.println("Sorry, video not available"); 

} 

} 

void recieveRating() { //getting rating for video 

int present = 0; 

System.out.println("Enter the video name to enter rating: "); 

String pr = s1.nextLine(); 

for(int i=1; i<=count; i++) { //video search 

if(pr.equalsIgnoreCase(v[i].title)) 

present = i; 

} 

if(present==0) 

System.out.println("Video not found"); //if video not found 

else { 

System.out.println("Enter the rating: "); 

int x = s1.nextInt(); //getting rating from user 

if(x==0)  

System.out.println("Invalid rating"); 

else { 

v[present].getRating(x); 

} 

} 

} 

} 

public class VideoLauncher6019 {  

public static void main(String[] args) { 

Scanner s1 = new Scanner(System.in); 

int choice1, choice2=1, choice3, choice4; 

videoStore6019 store = new videoStore6019(); 

while(choice2 == 1) { // outer most loop 

   System.out.println("**************MENU**************"); //different login types 

   System.out.println("1: Login as Admin"); 

   System.out.println("2: Login as User"); 

   System.out.println("Enter the corresponding number as your choice: "); 

   choice1 = s1.nextInt(); 

   switch (choice1){ 

      case 1:{ // if logged in as admin 

    	  int cont1=1; 

    	  while(cont1==1) { // second loop 

    		  System.out.println("1: List inventory"); 

    	  System.out.println("2: Add video"); 

    	  System.out.println("Enter the corresponding number as your choice: "); 

    	  choice3 = s1.nextInt(); 

    	  switch(choice3) { 

    	        case 1:{ 

    	        	System.out.println("INVENTORY"); 

    	        	store.listInventory(); 

    	        	break; 

    	        } 

    	        case 2:{ 

    	        	System.out.println("ADD VIDEO"); 

    	        	store.addVideo(); 

    	        	break; 

    	        } 

    	        default:{ 

    	        	System.out.println("Invalid choice entered"); 

    	        } 

    	  } 

    	  System.out.println("Enter 1 to continue as admin, any other key to exit"); 

    	  cont1 = s1.nextInt(); 

    	  } 

    	  break; 

      } // end loop 

      case 2:{ // if logged in as user  

    	  int cont2=1; 

    	  while(cont2==1) { //second loop 

    		  System.out.println("1: List inventory"); 

    		  System.out.println("2: Rent Video"); 

    		  System.out.println("3: Enter the rating of video"); 

    		  System.out.println("4: Return video"); 

    		  choice4 = s1.nextInt(); 

    		  switch (choice4) { 

    		       case 1:{ 

    		    	   System.out.println("INVENTORY"); 

    		    	   store.listInventory(); 

    		    	   break; 

    		       } 

    		       case 2:{ 

    		    	   System.out.println("RENTAL"); 

    		    	   store.checkOut(); 

    		    	   break; 

    		       } 

    		       case 3:{ 

    		    	   System.out.println("RATING"); 

    		    	   store.recieveRating(); 

    		    	   break; 

    		       } 

    		       case 4:{ 

    		    	   System.out.println("RETURN"); 

    		    	   store.returnVideo(); 

    		    	   break; 

    		       } 

    		       default:{ 

    		    	   System.out.println("Invalid choice entered"); 

    		       } 

    		  } 

    		  System.out.println("Enter 1 to continue as user, any other key to exit: "); 

    		  cont2 = s1.nextInt(); 

    	  } // end loop 

    	  break; 

      } 

      default:{ 

    	  System.out.println("Invalid choice entered"); 

    	  break; 

      } 

 }  

 System.out.println("Press 1 to continue interface, any other key to exit"); 

 choice2 = s1.nextInt(); 

} // end outermost loop 

    s1.close(); // scanner object closed to prevent memory leak 

System.out.println("Exit Successful"); // exit from interface 

  } // end of main 

} 