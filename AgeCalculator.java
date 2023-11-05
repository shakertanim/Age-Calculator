import java.time.LocalDate; // Library for time operation
import java.util.Scanner; // Library for user input operation

public class AgeCalculator {

    public static boolean leapyearcheck(int year) {
        boolean leap =false;
        if (year%4==0 &&  year%100!=0) {
            leap = true;
        }
        else if (year%4==0 && year%100==0 && year%400==0) {
            leap = true;
        }
        else {
            leap = false;
        }
        return(leap);
    }

    
    public static void main(String[] args) {

        // create an object of Scanner
        Scanner input = new Scanner(System.in);

        LocalDate currentdate = LocalDate.now();     
        int currentDay = currentdate.getDayOfMonth();
        int currentMonth = currentdate.getMonthValue();
        int currentYear = currentdate.getYear();

        int myDay=1;                // User's birth day
        int myMonth=1;              // User's birth month
        int myYear=2023;            // User's birth year 
        int myAgeYear;              // User's age in year
        int myAgeMonth;             // User's age in remaining month
        int myAgeDay;               // User's age in remaining day
        boolean leapyear = false;
        boolean notLeap = false;

        
        // User's first input for the birth day
        do {
            System.out.print("Enter your Birthday (1 to 31): ");
            myDay = input.nextInt();
        }while(myDay<1 || myDay>31);

        do {
            if(myDay<=30){                                                      // Check if the birth day falls under 30 day month
                do {       
                    myMonth = birthmonth(input);                                     // User's second input for the birth month
                }while(myMonth<1 && myMonth>12);                                    // Check if there is invalid input for the month
            }else if (myDay<=31) {                                              // Check if the birth day falls under 31 day month
                do {
                myMonth = birthmonth(input);
            }while(myMonth!=1 && myMonth!=3 && myMonth!=5 && myMonth!=7 && myMonth!=8 && myMonth!=10 && myMonth!=12);
            }
        } while(myMonth<1 || myMonth>12);


        do {
        if(myMonth==2 && myDay<=28) {
                notLeap = true;
                myYear = birthyear(notLeap, input);
        }else if(myMonth==2 && myDay<=29) {
        do {
                notLeap = false;
                myYear = birthyear(notLeap, input);
                leapyear = leapyearcheck(myYear);
        }while(!leapyear);
    }else if (myMonth!=2 && myDay<=31) {
            do {
                notLeap = true;
                myYear = birthyear(notLeap, input);
            }while(myYear==0);
        }
    }while(myYear>currentYear);

    
        myAgeYear = currentYear - myYear;
        if (currentMonth > myMonth){
            myAgeMonth = currentMonth - myMonth; 
        }
        else {
            myAgeYear = myAgeYear - 1;
            myAgeMonth = myMonth - currentMonth;
            myAgeMonth = 12 - myAgeMonth;
            if (myAgeMonth==12){
                myAgeYear = myAgeYear + 1;
                myAgeMonth = 0;
            }
        }
        if(myDay > currentDay) {
            if (myAgeMonth==12){ 
                myAgeYear = myAgeYear - 1;
                myAgeMonth = myAgeMonth - 1;
            }
            else {
                myAgeMonth = myAgeMonth - 1;
            }
            myAgeDay = myDay - currentDay;
            if (currentMonth==1 || currentMonth==3 || currentMonth==5 || currentMonth==7 || currentMonth==8 || currentMonth==10 || currentMonth==12) {
                myAgeDay = 31 - myAgeDay + 1;
            }
            else if (currentMonth==2 && leapyear){
                myAgeDay = 29 - myAgeDay + 1;
            }
            else if (currentMonth==2 && !leapyear) {
                myAgeDay = 28 - myAgeDay + 1;
            }
            else {
                myAgeDay = 30 - myAgeDay + 1;
            }
        }
        else {

            myAgeDay = currentDay - myDay;
        }
        if (myAgeMonth != 0) {
            System.out.println("Your Age is : " + (myAgeYear) + " Year " + myAgeMonth + " Months " + myAgeDay + " Days.");
        } else {
            System.out.println("Your Age is : " + (myAgeYear) + " Year " + myAgeMonth + " Months " + myAgeDay + " Days.");
        }


        input.close();
    }
    
    public static int birthmonth(Scanner scanner) {
        int myMonth =1;
        System.out.print("Enter your Birth Month (1 to 12): ");         // User's second input for the birth month
        myMonth = scanner.nextInt();
        return(myMonth);
        
    }

    public static int birthyear(boolean notLeap, Scanner scanner) {
        int myYear =1;
        if(notLeap) {
            System.out.print("Enter your Birth Year: ");
            myYear = scanner.nextInt();
        }
        else {
            System.out.print("Enter your Birth Year (Must be the Leap Year): ");
            myYear = scanner.nextInt();
        }
        return(myYear);
    }
  
}
