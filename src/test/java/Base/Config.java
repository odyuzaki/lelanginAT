package Base;

public class Config {

    // URL

    public static final String URL = "http://blogapp-s3.s3-website-ap-southeast-1.amazonaws.com/";

    // Browser
    public static String Browser = BrowserType.Chrome;// Change Browser here

    // Features
    public static final String Feature = Features.ImplementCoin;// Change folder to execute
    // delay time
    public static void delayTime()throws InterruptedException{
        Thread.sleep(2000);// in millisecond
    }

    //LoginElement Credential
    public static final String Role_User = "user";
    public static final String Role_Admin = "admin";
    public static final String Admin_user = "admin";
    public static final String Admin_pass = "P@ssw0rd";
    public static final String Username = "preco"; // Change valid email here
    public static String Password = "Password_123"; // change valid password here
    public static String Password_Change = "Test_20201"; // change valid password here
    public static final String Invalid_Mail = "Invalid@email.com"; // change invalid email here
    public static final String Invalid_Password = "Invalid_1"; // change invalid password here
    public static final String forgetMail = "testingcuy@mailsac.com"; // change email here
    public static final String forgetPass = "Test_2020"; // change password here

    //Healthcare filter data in self report list
    public static final String Name = "adam";
    public static final String HealthCareName = "adam";
    public static final String HealthCareComment = "Please write your comment here...";
}
