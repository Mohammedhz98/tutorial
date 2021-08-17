import java.util.*;
public class passwordMaker {

    public static boolean upperCheck(String pass) {
        boolean isUpper = false;
        for(int i=0; i<pass.length(); i++) {
            char passLetter = pass.charAt(i);
            if(Character.isUpperCase(passLetter)) {
                isUpper = true;
                return isUpper;
            }
        }
        return isUpper;
    }

    public static boolean hasNumber(String pass) {
        boolean number = false;
        for(int i=0; i<pass.length(); i++) {
            char passLetter = pass.charAt(i);
            if(Character.isDigit(passLetter)) {
                number = true;
                return number;
            }
        }
        return number;
    }
    public static void main(String[] args) {
        //System.out.println(upperCheck("password"));
        System.out.println("Please input a new password: ");
        Scanner read = new Scanner(System.in);
        String newPassword = read.nextLine();

        boolean minimumStandardsMet = false;
        while(!minimumStandardsMet) {
            if (newPassword.length() < 10) {
                minimumStandardsMet = false;
                System.out.println("The password you made was too short please make a one.");
                Scanner retry = new Scanner(System.in);
                newPassword = retry.nextLine();
            }
            else if (!upperCheck(newPassword)) {
                minimumStandardsMet = false;
                System.out.println("Your password has no uppercase numbers please input an uppercase letter into your password.");
                Scanner retry = new Scanner(System.in);
                newPassword = retry.nextLine();
            }
            else if (!hasNumber(newPassword)) {
                minimumStandardsMet = false;
                System.out.println("Your password has no numbers in it please input a number into your password.");
                Scanner retry = new Scanner(System.in);
                newPassword = retry.nextLine();
            }
            else {
                minimumStandardsMet = true;
                System.out.println("This password meets the minimum requirements to be used for your password.");
            }
        }
    }
}
