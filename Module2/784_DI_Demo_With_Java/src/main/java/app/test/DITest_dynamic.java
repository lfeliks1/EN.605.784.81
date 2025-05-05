package app.test;

import app.service.*;

public class DITest_dynamic {

//    NotificationService notifSrv = null;
    String service = null;

    public DITest_dynamic() {};

    public DITest_dynamic (String str){
		this.service=str;
    }

    public static void main(String args[]) throws Exception{

    String serviceClassName = args[0];
    String message = args[1];
    String destination = args[2];
    
    System.out.println("Class name to be instantiated is :" + serviceClassName);
    System.out.println("Notification message is :" + message);
    System.out.println("Notification destination  is :" + destination);
    
    //    aBar = (Bar) Class.forName(barClassName).getDeclaredConstructor().newInstance();
    
    NotificationService notifSrv = (NotificationService)Class.forName(serviceClassName).getDeclaredConstructor().newInstance();
    
    notifSrv.notify (message, destination);  
    
        }
}

