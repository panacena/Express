/*
 * 文 件 名:  Config.java
 * 版    权:  Archermind.NANJING 2014-12-5,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  Administrator
 * 修改时间:  2014-12-5   上午10:51:32
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.cstor.express.util;

import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 
 * ClassName: Config 
 * Function: TODO ADD FUNCTION. 
 * Reason: TODO ADD REASON(可选). 
 * date: 2016年10月19日 下午3:20:31 
 *
 * @author douyoubin@cstor.cn
 * @version 
 * @since JDK 1.8
 */
public final class Config{
    private static Properties prop = null;
    
    public static Object getProperties(String key){
        try{
            if (prop == null){
                prop = new Properties();
                InputStream is = Config.class.getClassLoader()
                        .getResourceAsStream("init.properties");
                prop.load(is);
                is.close();
            }
            return prop.getProperty(key);
        }
        catch (Exception e){
          e.printStackTrace();
        }
        return null;
        
    }
    
    public static Object getPropertiesImmediately(String key) {
        try{
        
        	Properties  prop = new Properties();
            InputStream is = Config.class.getClassLoader()
                    .getResourceAsStream("init.properties");
            prop.load(is);
            is.close();
            
            return prop.getProperty(key);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public static boolean isEmpty(String obj){
        if (null == obj || "".equals(obj.trim()) || "null".equals(obj)){
            return true;
        }
        return false;
    }
}
