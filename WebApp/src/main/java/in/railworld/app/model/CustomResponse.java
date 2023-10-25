package in.railworld.app.model;

import java.util.Objects;

public class CustomResponse {

	private String status;
    private String message;
    private boolean success;
    private String token;
    
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
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public int hashCode() {
		return Objects.hash(message, status, success, token);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomResponse other = (CustomResponse) obj;
		return Objects.equals(message, other.message) && Objects.equals(status, other.status)
				&& success == other.success && Objects.equals(token, other.token);
	}
	@Override
	public String toString() {
		return "CustomResponse [status=" + status + ", message=" + message + ", success=" + success + ", token=" + token
				+ "]";
	}
	public CustomResponse(String status, String message, boolean success, String token) {
		super();
		this.status = status;
		this.message = message;
		this.success = success;
		this.token = token;
	}
	public CustomResponse() {
		super();
	}
    
    
}
