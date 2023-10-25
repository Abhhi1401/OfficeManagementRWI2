package in.railworld.app.model;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class NoticeDisplay {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long NoticeDisplay;
	private String title;
	private String content;
	private Date date;
	
	
	
	public NoticeDisplay() {
		super();
		// TODO Auto-generated constructor stub
	}



	public NoticeDisplay(Long noticeDisplay, String title, String content, Date date) {
		super();
		NoticeDisplay = noticeDisplay;
		this.title = title;
		this.content = content;
		this.date = date;
	}



	public Long getNoticeDisplay() {
		return NoticeDisplay;
	}



	public void setNoticeDisplay(Long noticeDisplay) {
		NoticeDisplay = noticeDisplay;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	@Override
	public String toString() {
		return "NoticeDisplay [NoticeDisplay=" + NoticeDisplay + ", title=" + title + ", content=" + content + ", date="
				+ date + "]";
	}
	
	
	
	
}
