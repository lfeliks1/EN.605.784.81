package app.service;

public class EmailServiceImpl implements NotificationService {

	@Override
	public void notify (String msg, String dest) {
		//logic to send email
		System.out.println("Email sent to " + dest + " with Message=" + msg);
	}

}
