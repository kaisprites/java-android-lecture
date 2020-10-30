package com.mega.mvc08;

public class ProductVO {
	@Override
	public String toString() {
		return "ProductVO [id=" + id + ", title=" + title + ", content=" + content + ", price=" + price + ", tel=" + tel
				+ "]";
	}
	int id;
	String title;
	String content;
	int price;
	String tel;
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
}
