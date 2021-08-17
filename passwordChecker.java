import java.util.*;
public class passwordChecker {
    public static boolean check(String password, String attempt) {
        if(password.equals(attempt)) {
            return true;
        }
        else
          return false;
    }
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String attempt = read.nextLine();
        String password  = "passWord";
        String fail = "You have incorrectly inputted the password";
        String success = "The password you have inputted is correct";
        int passLen = password.length();
        System.out.println(passLen);
        if(attempt.length() == passLen) {
           if(check(password,attempt) == true) {
               System.out.println(success);
           }
           else {
               System.out.println(fail);
           }
        }
        else {
            System.out.println(fail);
        }

    }
}
