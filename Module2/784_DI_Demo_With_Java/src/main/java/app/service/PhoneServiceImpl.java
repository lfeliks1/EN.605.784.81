package app.service;

public class PhoneServiceImpl implements NotificationService {

	@Override
	public void notify (String msg, String dest) {
		
        //logic to make phonecall

		System.out.println("Phone call made to " + dest + " with Message="+msg);
	}

}
