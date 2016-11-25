package com.cstor.express.dao;

import java.util.List;

import com.cstor.express.model.BillInfo;



public interface ExpressDao {

	void insertBill(BillInfo bi);
	int countByBill(String billNo);
	List<BillInfo> listAll();
	BillInfo detailByBill(String bill);
	
	
}
