package in.railworld.app.controller.dto;

import org.springframework.stereotype.Component;

@Component
public class ResponseDto {
      
	    public String status;
	    
	    public String message;
	    
	    
	    public String token;
	    
	    public boolean success;
	    
	    
	    
	    public ResponseDto() {
			// TODO Auto-generated constructor stub
		}



		public ResponseDto(String status, String message, String token, boolean success) {
			super();
			this.status = status;
			this.message = message;
			this.token = token;
			this.success = success;
		}



		public String getStatus() {
			return status;
		}



		public void setStatus(String status) {
			this.status = status;
		}



		public String getMessage() {
			return message;
		}



		public void setMessage(String message) {
			this.message = message;
		}



		public String getToken() {
			return token;
		}



		public void setToken(String token) {
			this.token = token;
		}



		public boolean isSuccess() {
			return success;
		}



		public void setSuccess(boolean success) {
			this.success = success;
		}



		@Override
		public String toString() {
			return "ResponseDto [status=" + status + ", message=" + message + ", token=" + token + ", success="
					+ success + "]";
		}
	    
	    
	    
}
