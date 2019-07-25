package com.revature.beans;

public class Receipt {

	private int receiptID;
	private byte[] image;
	private int reqID;
	
	public Receipt() {}

	public Receipt(int receiptID, byte[] image, int reqID) {
		super();
		this.receiptID = receiptID;
		this.image = image;
		this.reqID = reqID;
	}

	public int getReceiptID() {
		return receiptID;
	}
	
	public void setReceiptID(int receiptID) {
		this.receiptID = receiptID;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public int getReqID() {
		return reqID;
	}

	public void setReqID(int reqID) {
		this.reqID = reqID;
	}
	
	
}
