package cn.yzz.domain;

import java.util.List;

public class NewsList {
	public  List<News> list=null;
	int pageNum;
	int totlaPageNum;
	public NewsList(){
	}
	
	public List<News> getList() {
		return list;
	}
	
	
	public int getTotlaPageNum() {
		return totlaPageNum;
	}

	public void setTotlaPageNum(int totlaPageNum) {
		this.totlaPageNum = totlaPageNum;
	}

	public void setList(List<News> list) {
		this.list = list;
	}
	
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	
}
