package in.railworld.app.exception;

import java.time.LocalDateTime;

public class MyErrorDetails {
       
	    public LocalDateTime timeStamp;
	    
	    public String message;
	    
	    public String url;
	    
	    
	    public MyErrorDetails() {
			// TODO Auto-generated constructor stub
		}

		public MyErrorDetails(LocalDateTime timeStamp, String message, String url) {
			super();
			this.timeStamp = timeStamp;
			this.message = message;
			this.url = url;
		}

		public LocalDateTime getTimeStamp() {
			return timeStamp;
		}

		public void setTimeStamp(LocalDateTime timeStamp) {
			this.timeStamp = timeStamp;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		@Override
		public String toString() {
			return "MyErrorDetails [timeStamp=" + timeStamp + ", message=" + message + ", url=" + url + "]";
		}		
	    
}
