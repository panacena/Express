package com.cstor.express.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cstor.express.dao.ExpressDao;
import com.cstor.express.model.BillInfo;


@Service("ExpressService")
public class ExpressService {

	@Autowired
	private ExpressDao expressDao;

	public void insertBill(BillInfo bi) {
		expressDao.insertBill(bi);
	}
	
	public int countByBill(String billNo){
		return expressDao.countByBill(billNo);
	}
	
	public List<BillInfo> listAll(){
		return expressDao.listAll();
	}

	public BillInfo detailByBill(String bill) {
		return expressDao.detailByBill(bill);
	}
	
	
}
