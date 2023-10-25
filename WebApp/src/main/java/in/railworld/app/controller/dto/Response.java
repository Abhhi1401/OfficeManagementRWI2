package in.railworld.app.controller.dto;

public class Response<T> {
         
	   public String status;
	   	   
	   public String token;
	   
	   public boolean success;
	   
	   
	   public T  res;
	   
	   public Response() {
		// TODO Auto-generated constructor stub
	}

	public Response(String status, String token, boolean success, T res) {
		super();
		this.status = status;
		
		this.token = token;
		this.success = success;
		this.res = res;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public T getRes() {
		return res;
	}

	public void setRes(T res) {
		this.res = res;
	}

	@Override
	public String toString() {
		return "Response [status=" + status + ", token=" + token + ", success=" + success
				+ ", res=" + res + "]";
	}
	   
	   
	   
}
