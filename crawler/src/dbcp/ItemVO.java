package dbcp;

import java.util.Vector;

public class ItemVO {

	String name;
	String text;
	String address;
	String tel;
	String lat;
	String lng;
	String keyword;
	String tag;
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	@Override
	public String toString() {
		return "ItemVO [name=" + name + ", text=" + text + ", address=" + address + ", tel=" + tel + ", lat=" + lat
				+ ", lng=" + lng + ", keywords=" + keyword + ", tag="
				+ tag + "]";
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
}
