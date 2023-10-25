package in.railworld.app.util;

import in.railworld.app.controller.dto.BulkEmailDto;

public interface EmailService {
	//public void sendEmail(String to,String sub,String msg);
	
	public void SendBulkEmail(BulkEmailDto bulkemail);
}
