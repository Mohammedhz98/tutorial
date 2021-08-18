import java.util.*;
public class passwordMaker {

    // Scoring is rated from 1-10 (inclusive of 1 and 10).
    public static int score(String password) {
        int strScore;
        if(password.length() >= 10 && upperCheck(password) && hasNumber(password)) {
           strScore = 10;
        }
        else if((password.length() >= 10 && upperCheck(password)) ||
                (password.length() >= 10 && hasNumber(password))  ||
                (hasNumber(password) && upperCheck(password))) {
            strScore = 6;
        }
        else if(password.length() >= 10 || upperCheck(password) || hasNumber(password)) {
            strScore = 3;
        }
        else {
            strScore = 1;
        }
        return strScore;
    }

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
        boolean allPasswordsAdded = false;
        ArrayList<String> passwords = new ArrayList<String>();
        while (!allPasswordsAdded) {
            System.out.println("Please input a new password: ");
            Scanner read = new Scanner(System.in);
            String newPassword = read.nextLine();
            passwords.add(newPassword);
            System.out.println("Would you like to input another password? ");
            Scanner ask = new Scanner(System.in);
            String response = read.nextLine();
            if (response.equals("no")) {
                allPasswordsAdded = true;
            }
        }
        System.out.println(passwords.size());
        for (int i=0; i<passwords.size(); i++) {
            boolean minimumStandardsMet = false;
            while (!minimumStandardsMet) {
                if (passwords.get(i).length() < 10) {
                    minimumStandardsMet = false;
                    System.out.println("The password: '" + passwords.get(i) + "' has a score of: " + score(passwords.get(i)));
                    System.out.println("The password you made was too short. it must have at least 10 letters please make a new one.");
                    Scanner retry = new Scanner(System.in);
                    passwords.set(i,retry.nextLine());
                } else if (!upperCheck(passwords.get(i))) {
                    minimumStandardsMet = false;
                    System.out.println("The password: '" + passwords.get(i) + "' has a score of: " + score(passwords.get(i)));
                    System.out.println("Your password has no uppercase numbers please input an uppercase letter into your password.");
                    Scanner retry = new Scanner(System.in);
                    passwords.set(i,retry.nextLine());
                } else if (!hasNumber(passwords.get(i))) {
                    minimumStandardsMet = false;
                    System.out.println("The password: '" + passwords.get(i) + "' has a score of: " + score(passwords.get(i)));
                    System.out.println("Your password has no numbers in it please input a number into your password.");
                    Scanner retry = new Scanner(System.in);
                    passwords.set(i,retry.nextLine());
                } else {
                    minimumStandardsMet = true;
                    System.out.println("The password: '" + passwords.get(i) + "' has a score of: " + score(passwords.get(i)));
                    System.out.println("This password meets the minimum requirements to be used for your password.");
                }
            }
        }
    }
}
