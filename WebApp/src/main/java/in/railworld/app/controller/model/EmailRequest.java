package in.railworld.app.controller.model;

import java.util.List;
import java.util.Objects;

public class EmailRequest {

    private List<String> toEmails;
    private String body;
    
	public List<String> getToEmails() {
		return toEmails;
	}
	public void setToEmails(List<String> toEmails) {
		this.toEmails = toEmails;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	@Override
	public int hashCode() {
		return Objects.hash(body, toEmails);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmailRequest other = (EmailRequest) obj;
		return Objects.equals(body, other.body) && Objects.equals(toEmails, other.toEmails);
	}
	@Override
	public String toString() {
		return "EmailRequest [toEmails=" + toEmails + ", body=" + body + "]";
	}
	public EmailRequest() {
		super();
	}
	public EmailRequest(List<String> toEmails, String body) {
		super();
		this.toEmails = toEmails;
		this.body = body;
	}

   
}

