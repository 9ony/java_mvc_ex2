package model;

import java.sql.Date;

public class Product {
	private int pnum;
	private String pname;
	private String img_link;
	private int price;
	private int pqty;
	private String company;
	private Date pindate;
	public Product() {
		
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getImg_link() {
		return img_link;
	}
	public void setImg_link(String img_link) {
		this.img_link = img_link;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPqty() {
		return pqty;
	}
	public void setPqty(int pqty) {
		this.pqty = pqty;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Date getPindate() {
		return pindate;
	}
	public void setPindate(Date pindate) {
		this.pindate = pindate;
	}
	
}
