package app.consumer;
import app.service.NotificationService;
public class MyApp implements Consumer{
	private NotificationService service;
	public MyApp (NotificationService svc){
		this.service=svc;
	}  
	public MyApp (){}
 	public void setService ( NotificationService service) {
		this.service = service;
	}   
	@Override
	public void processMessages(String msg, String dest){
		this.service.notify (msg, dest);
	}
}
