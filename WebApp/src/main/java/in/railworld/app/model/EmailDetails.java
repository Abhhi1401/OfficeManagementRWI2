package in.railworld.app.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmailDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fromEmail;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

	public EmailDetails(Long id, String fromEmail) {
		super();
		this.id = id;
		this.fromEmail = fromEmail;
	}

	public EmailDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EmailDetails [id=" + id + ", fromEmail=" + fromEmail + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(fromEmail, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmailDetails other = (EmailDetails) obj;
		return Objects.equals(fromEmail, other.fromEmail) && Objects.equals(id, other.id);
	}
    
    
}

