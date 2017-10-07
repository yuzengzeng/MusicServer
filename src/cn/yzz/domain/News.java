package cn.yzz.domain;

public class News {
	private int id;
	private int type;
	private String title;
	private String description;
	private String imageRrc;
	private String date;
	private String url;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageRrc() {
		return imageRrc;
	}
	public void setImageRrc(String imageRrc) {
		this.imageRrc = imageRrc;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public News() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "News [id=" + id + ", type=" + type + ", title=" + title
				+ ", description=" + description + ", imageRrc=" + imageRrc
				+ ", date=" + date + ", url=" + url + "]";
	}
	
	
}
