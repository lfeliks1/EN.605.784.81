package app.container_injector;
import app.consumer.Consumer;
import app.consumer.MyApp;
import app.service.PhoneServiceImpl;

public class PhoneServiceInjector implements NotificationServiceInjector {

	@Override
	public Consumer getConsumer() {
		return new MyApp (new PhoneServiceImpl());
	}
}
