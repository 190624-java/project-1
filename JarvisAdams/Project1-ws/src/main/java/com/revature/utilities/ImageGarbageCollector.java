package com.revature.utilities;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class ImageGarbageCollector implements HttpSessionBindingListener{

	
	private List<Integer> receiptFileNameInts;
	
	public ImageGarbageCollector() {
		receiptFileNameInts = new LinkedList<>();
	}
	
	public void addReceiptID(Integer id) {
		this.receiptFileNameInts.add(id);
	}
	
	/**
	 * //TODO 
	 * For each image id stored,
	 * find the associated string filename that will have an extension *.jpg or *.jpeg
	 * get the File object by calling it's path (all stored locally from the database and named with the convention:
	 *  {receiptID}.jpg
	 * call the file object's delete() method.
	 */
	private void garbageCollectAllAssociatedImages() {
		
	}
	
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		// do nothing
		
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		// TODO find and delete all image receipt files stored on the server named with the receiptID.
		
	}

}
