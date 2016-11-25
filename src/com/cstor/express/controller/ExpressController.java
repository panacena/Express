/**
 * Project Name:Express
 * File Name:ExpressController.java
 * Package Name:com.cstor.express.controller
 * Date:2016年11月22日下午4:15:49
 * Copyright (c) 2016, douyoubin@cstor.com All Rights Reserved.
 *
*/

package com.cstor.express.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.cstor.express.model.BillInfo;
import com.cstor.express.service.ExpressService;

/**
 * ClassName:ExpressController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年11月22日 下午4:15:49 <br/>
 * @author   douyoubin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Controller
public class ExpressController {
	
	@Autowired
	private ExpressService expressService;
	
	@RequestMapping(value = "/save")
	@ResponseBody
	public JSONObject save(HttpServletRequest request,HttpServletResponse response) {
		JSONObject jsonData = new JSONObject();
		String bill = request.getParameter("bill");
		if(org.apache.commons.lang3.StringUtils.isBlank(bill)){
			jsonData.put("code", -1);
			jsonData.put("msg", "运单号不能为空");
			return jsonData;
		}
		
		if(expressService.countByBill(bill)>0){
			jsonData.put("code", -1);
			jsonData.put("msg", "运单号已存在");
			return jsonData;
		}
		
		
		String senderPhone = request.getParameter("senderPhone");
		String recieveName = request.getParameter("recieveName");
		String recievePhone = request.getParameter("recievePhone");
		String senderName = request.getParameter("senderName");
		String sex = request.getParameter("sex");
		String nation = request.getParameter("nation");
		String birthday = request.getParameter("birthday");
		String addr = request.getParameter("addr");
		String idcard = request.getParameter("idcard");
		String revieveAddr = request.getParameter("revieveAddr");
		String idImg= "";
		String goodImg = "";
		String billImg = "";
		
		String p = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+p+"/";
		
		try{
		 //创建一个通用的多部分解析器  
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
        //判断 request 是否有文件上传,即多部分请求  
        if(multipartResolver.isMultipart(request)){  
            //转换成多部分request    
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
            //取得request中的所有文件名  
            Iterator<String> iter = multiRequest.getFileNames();  
            int i=1; //用于标记第几个文件
            while(iter.hasNext()){  
                //记录上传过程起始时的时间，用来计算上传时间  
                int pre = (int) System.currentTimeMillis();  
                //取得上传文件  
                MultipartFile file = multiRequest.getFile(iter.next());  
                if(file != null){  
                    //取得当前上传文件的文件名称  
                    String myFileName = file.getOriginalFilename();  
                    //如果名称不为“”,说明该文件存在，否则说明该文件不存在  
                    if(myFileName.trim() !=""){  
                        //重命名上传后的文件名  
                        String fileName = "";  
                        //定义上传路径  
                        String path = "";
                        if(i==1){
                        	path = request.getSession().getServletContext().getRealPath("/idcardimg/");
                        	fileName="idcard"+bill+ "." + myFileName.substring(myFileName.lastIndexOf(".")+1);
                        	idImg = basePath + "idcardimg/" + fileName;
                        }else if(i==2){
                        	path = request.getSession().getServletContext().getRealPath("/goodimg/");
                        	fileName="good"+bill+ "." + myFileName.substring(myFileName.lastIndexOf(".")+1);
                        	goodImg = basePath+"goodimg/" + fileName;
                        }else if(i==3){
                        	path = request.getSession().getServletContext().getRealPath("/billimg/");
                        	fileName="bill"+bill+ "." + myFileName.substring(myFileName.lastIndexOf(".")+1);
                        	billImg=basePath + "billimg/" + fileName;
                        }
                        i++;
                        path = path +File.separatorChar+ fileName ;  
                        System.err.println(path);
                        File localFile = new File(path);  
                        file.transferTo(localFile);  
                    }  
                }  
                //记录上传该文件后的时间  
            }  
              
        } 
        BillInfo bi = new BillInfo(bill, senderPhone, recievePhone, recieveName, 
        			senderName, sex, nation, birthday, addr, idcard, revieveAddr,idImg, 
        			goodImg, billImg, new Date(), new Date());
        expressService.insertBill(bi);
        jsonData.put("code", 0);
		}catch(Exception e){
			jsonData.put("code", -1);
			e.printStackTrace();
		}
		return jsonData;
	}
	
	@RequestMapping(value = "/recordlist")
	@ResponseBody
	public JSONObject recordList(HttpServletRequest request,HttpServletResponse response) {
		JSONObject jsonOb = new JSONObject();
		List<BillInfo> list =expressService.listAll();
		
		jsonOb.put("code", 0);
		jsonOb.put("list", list);
		return jsonOb;
	}
	
	@RequestMapping(value = "/detail")
	@ResponseBody
	public JSONObject detail(HttpServletRequest request,HttpServletResponse response) {
		JSONObject jsonOb = new JSONObject();
		 String bill = request.getParameter("bill");
		 if(StringUtils.isBlank(bill)){
			 jsonOb.put("code", -1);
			 jsonOb.put("msg", "运单号不能为空");
			 return jsonOb;
		}
		 BillInfo bi = expressService.detailByBill(bill);
		 jsonOb.put("code", 0);
		 jsonOb.put("billDetail", bi);
		
		return jsonOb;
	}

}

