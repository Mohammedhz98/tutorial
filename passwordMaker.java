import java.util.*;
public class passwordMaker {
    public static ArrayList<String> passwords = new ArrayList<>();

    /**
     * This method is used to determine the score of a password inputted based on how strong it is.
     * it takes 3 things into consideration which are: password length, password digits contained and
     * password upper case letters contained within the password.
     * @param password The password that you would like to check the strength of.
     * @return Returns a score of type "int"  on a scale form 1-10.
     */
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

    /**
     * A simple method which checks weather the inputted password contains an uppercase letter or not.
     * @param pass The password that you would like to check to see if there are uppercase letters or not.
     * @return Returns a boolean statement of true or false if the password has an uppercase letter or not.
     */
    public static boolean upperCheck(String pass) {
        for(int i=0; i<pass.length(); i++) {
            char passLetter = pass.charAt(i);
            if(Character.isUpperCase(passLetter)) {
                return true;
            }
        }
        return false;
    }

    /**
     * A simple method which checks weather the inputted password contains a number or not.
     * @param pass The password that you would like to check to see if there are numbers or not.
     * @return Returns a boolean statement of true or false if the password has a number or not.
     */
    public static boolean hasNumber(String pass) {
        for(int i=0; i<pass.length(); i++) {
            char passLetter = pass.charAt(i);
            if(Character.isDigit(passLetter)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean allPasswordsAdded = false;
        while (!allPasswordsAdded) {
            System.out.println("Please input a new password: ");
            Scanner read = new Scanner(System.in);
            String newPassword = read.nextLine();
            passwords.add(newPassword);
            System.out.println("Would you like to input another password? ");
            Scanner ask = new Scanner(System.in);
            String response = ask.nextLine();
            if (response.equals("no")) {
                allPasswordsAdded = true;
            }
        }
        for (int i=0; i<passwords.size(); i++) {
            boolean minimumStandardsMet = false;
            while (!minimumStandardsMet) {
                if (passwords.get(i).length() < 10) {
                    System.out.println("The password: '" + passwords.get(i) + "' has a score of: " + score(passwords.get(i)));
                    System.out.println("The password you made was too short. it must have at least 10 letters please make a new one.");
                    Scanner retry = new Scanner(System.in);
                    passwords.set(i,retry.nextLine());
                } else if (!upperCheck(passwords.get(i))) {
                    System.out.println("The password: '" + passwords.get(i) + "' has a score of: " + score(passwords.get(i)));
                    System.out.println("Your password has no uppercase numbers please input an uppercase letter into your password.");
                    Scanner retry = new Scanner(System.in);
                    passwords.set(i,retry.nextLine());
                } else if (!hasNumber(passwords.get(i))) {
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
