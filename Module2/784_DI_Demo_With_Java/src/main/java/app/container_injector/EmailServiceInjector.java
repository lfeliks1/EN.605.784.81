package app.container_injector;

import app.consumer.Consumer;
import app.consumer.MyApp;
import app.service.EmailServiceImpl;

public class EmailServiceInjector implements NotificationServiceInjector {

	@Override
	public Consumer getConsumer() {
		MyApp app = new MyApp();
		app.setService(new EmailServiceImpl());
		return app;
	}

}
