package in.railworld.app.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class EmailConfig {
         @Id
         @GeneratedValue(strategy = GenerationType.IDENTITY)
	     private Integer emailConfigId;
	     private String host;
	     private int port;
	     private String username;
	     private String password;
	    
	    
	    public EmailConfig() {
			// TODO Auto-generated constructor stub
		}


		


		public EmailConfig(Integer emailConfigId, String host, int port, String username, String password) {
			super();
			this.emailConfigId = emailConfigId;
			this.host = host;
			this.port = port;
			this.username = username;
			this.password = password;
		}





		public Integer getEmailConfigId() {
			return emailConfigId;
		}





		public void setEmailConfigId(Integer emailConfigId) {
			this.emailConfigId = emailConfigId;
		}





		public String getHost() {
			return host;
		}


		public void setHost(String host) {
			this.host = host;
		}


		public int getPort() {
			return port;
		}


		public void setPort(int port) {
			this.port = port;
		}


		public String getUsername() {
			return username;
		}


		public void setUsername(String username) {
			this.username = username;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}





		@Override
		public String toString() {
			return "EmailConfig [emailConfigId=" + emailConfigId + ", host=" + host + ", port=" + port + ", username="
					+ username + ", password=" + password + "]";
		}


		
	    
	    
	    
}
