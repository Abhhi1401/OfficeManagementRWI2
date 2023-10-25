package in.railworld.app.controller.dto;

public class NoticeDto {
    private Long id;
    private String title;
    private String content;

    // Constructors, getters, setters, and other methods

    // Default constructor
    public NoticeDto() {
    }

	public NoticeDto(Long id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "NoticeDto [id=" + id + ", title=" + title + ", content=" + content + "]";
	}
    
    
}