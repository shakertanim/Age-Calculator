import java.time.LocalDate;
import java.util.Scanner;

public class AgeCalculator {
    public static void main(String[] args) {

        // create an object of Scanner
        Scanner input = new Scanner(System.in);

        LocalDate currentdate = LocalDate.now();
        int currentDay = currentdate.getDayOfMonth();
        int currentMonth = currentdate.getMonthValue();
        int currentYear = currentdate.getYear();

        int myDay;
        int myMonth=1;
        int myYear=2023;
        int myAgeYear;
        int myAgeMonth;

        

        do {
            System.out.print("Enter your Birthday (1 to 31): ");
            myDay = input.nextInt();
        }while(myDay<1 || myDay>31);

        do {
            if(myDay<=30){
            do {
                System.out.print("Enter your Birth Month (1 to 12): ");
                myMonth = input.nextInt();
            }while(myMonth<=1 && myMonth>=12);
            }else if (myDay==31) {
                do {
                System.out.print("Enter your Birth Month (1 to 12): ");
                myMonth = input.nextInt();
            }while(myMonth!=1 && myMonth!=3 && myMonth!=5 && myMonth!=7 && myMonth!=8 && myMonth!=10 && myMonth!=12);
            }
        } while(myMonth<1 || myMonth>12);

        if(myMonth==2 && myDay<=28) {
                System.out.print("Enter your Birth Year: ");
                myYear = input.nextInt();
    }else if(myMonth==2 && myDay<=29) {
        do {
                System.out.print("Enter your Birth Year (Must be the Leap Year): ");
                myYear = input.nextInt();
        }while(myYear%4!=0);
    }else if (myMonth!=2 && myDay!=29) {
            do {
            System.out.print("Enter your Birth Year: ");
            myYear = input.nextInt();
            }while(myYear==0);
        }

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
        if (myAgeMonth != 0) {
            System.out.println("Your Age is : " + (myAgeYear) + " Year " + myAgeMonth + " Months");
        } else {
            System.out.println("Your Age is : " + (myAgeYear) + " Year ");
        }
    }

    
}
