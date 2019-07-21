package com.revature.project1.beans;

import java.sql.Date;

import oracle.sql.BLOB;

public class Receipt {
	private int rec_id;
	private int re_id;
	private double amount;
	private String vendor_name;
	private BLOB photo;
	public int getRec_id() {
		return rec_id;
	}
	public void setRec_id(int rec_id) {
		this.rec_id = rec_id;
	}
	public int getRe_id() {
		return re_id;
	}
	public void setRe_id(int re_id) {
		this.re_id = re_id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getVendor_name() {
		return vendor_name;
	}
	public void setVendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}
	public BLOB getPhoto() {
		return photo;
	}
	public void setPhoto(BLOB photo) {
		this.photo = photo;
	}
	public Receipt(int rec_id, int re_id, double amount, String vendor_name) {
		super();
		this.rec_id = rec_id;
		this.re_id = re_id;
		this.amount = amount;
		this.vendor_name = vendor_name;
	}
	public Receipt(int re_id, double amount, String vendor_name) {
		super();
		this.re_id = re_id;
		this.amount = amount;
		this.vendor_name = vendor_name;
	}
	
}
