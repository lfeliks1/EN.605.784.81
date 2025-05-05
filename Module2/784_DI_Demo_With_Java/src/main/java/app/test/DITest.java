package app.test;

import app.consumer.Consumer;
import app.container_injector.EmailServiceInjector;
import app.container_injector.NotificationServiceInjector;
import app.container_injector.PhoneServiceInjector;

public class DITest {

	public static void main(String[] args) {
		
		String msg = "Hi 784 class! ";
		String email = "784class@jhu.edu";
		String phone = "012-345-6789";
		
		NotificationServiceInjector injector = null;
		Consumer app = null;
		
		//Send email
		injector = new EmailServiceInjector();
		app = injector.getConsumer();
		app.processMessages(msg, email);
		
		//Make call
		injector = new PhoneServiceInjector();
		app = injector.getConsumer();
		app.processMessages(msg, phone);
	}

}
