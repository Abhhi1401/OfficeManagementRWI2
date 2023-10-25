package in.railworld.app.model;


import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "Person")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int personId;
	private String firstName;
	private String lastName;
	private String emailId;
	private Date personDOB;
	private String contact;
	private String address;
	
	@OneToOne
	@JoinColumn(name = "employeeId")
	private Employee employee;
	
	
	@ManyToOne
    @JoinColumn(name = "addressId")
    private Address addressObj; 


}
