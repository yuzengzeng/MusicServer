package cn.yzz.domain;

public class Discuss {
	String newsTitle;
	String newsDescription;
	String newsUrl;
	String username;
	String date;
	String discussContent;
	int newsId;
	
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public String getNewsDescription() {
		return newsDescription;
	}
	public void setNewsDescription(String newsDescription) {
		this.newsDescription = newsDescription;
	}
	public String getNewsUrl() {
		return newsUrl;
	}
	public void setNewsUrl(String newsUrl) {
		this.newsUrl = newsUrl;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDiscussContent() {
		return discussContent;
	}
	public void setDiscussContent(String discussContent) {
		this.discussContent = discussContent;
	}
	
	@Override
	public String toString() {
		return "Discuss [newsTitle=" + newsTitle + ", newsDescription="
				+ newsDescription + ", newsUrl=" + newsUrl + ", username="
				+ username + ", date=" + date + ", discussContent="
				+ discussContent + ", newsId=" + newsId + "]";
	}
	public Discuss() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
