package com.yanqi.utils;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.util.DruidPasswordCallback;

/**
 * Druid多数据源 密码回调
 * @Description TODO
 * @author yanqi
 * @Date 2019年9月18日
 */
public class DbPasswordCallback extends DruidPasswordCallback{

	private static final Logger logger = LoggerFactory.getLogger(DbPasswordCallback.class);
	
	@Override
	public void setProperties(Properties properties){
		super.setProperties(properties);
		//获取application.yml 里面配置的密码和公钥
        String password = (String) properties.get("password");
        String publickey = (String) properties.get("publicKey");
        try {
            String dbpassword = ConfigTools.decrypt(publickey, password);
            setPassword(dbpassword.toCharArray());
        } catch (Exception e) {
        	logger.error("Druid ConfigTools.decrypt", e);
        }
	}
}
