package com.inisgma.webservice.client;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.insigma.webservice.client.ClientCall;
import com.insigma.webservice.exception.AppException;
import com.insigma.webservice.infostruct.Result;
import com.insigma.webservice.infostruct.dto.Control;
import com.insigma.webservice.infostruct.dto.data.Jk001Data;
import com.insigma.webservice.infostruct.dto.keyword.Jk001Keyword;

/**
 * junit测试
 * @author Administrator
 *
 */
public class TestJk001  extends TestCase {
	
	public void test(){
		try{
			List<Jk001Keyword> keywordlist=new ArrayList<Jk001Keyword>();
			Jk001Keyword jk001keyword=new Jk001Keyword();
			jk001keyword.setAac002("610426198704182814");
			jk001keyword.setAac003("苟勃勃");
			keywordlist.add(jk001keyword);
			
			jk001keyword=new Jk001Keyword();
			jk001keyword.setAac002("610403198001300517");
		    jk001keyword.setAac003("陈明涛");
		    keywordlist.add(jk001keyword);	
		    
		    
		    jk001keyword=new Jk001Keyword();
			jk001keyword.setAac002("610403196202122033");
		    jk001keyword.setAac003("张发银");
		    keywordlist.add(jk001keyword);	
			
		    
		    jk001keyword=new Jk001Keyword();
			jk001keyword.setAac002("610403196611042018");
		    jk001keyword.setAac003("魏社谋");
		    keywordlist.add(jk001keyword);	
		    
		    
		    jk001keyword=new Jk001Keyword();
			jk001keyword.setAac002("610324198811284252");
		    jk001keyword.setAac003("田大冬");
		    keywordlist.add(jk001keyword);	
				    
			//请求
			List<Result> resultlist=new ClientCall().jk_001(keywordlist);
			for(Result result:resultlist){
				Control control=new Control(result.getControl());
				/**
				 *  NOERROR -成功，无错误无警告
					WARNING -成功，但有警告
					REERROR –失败，业务数据错误
					PEERROR –失败，系统错误
				 */
				System.out.println("代码:"+control.getResultcode()+"错误信息:"+control.getResultmsg());
				if(control.getResultcode().equals("NOERROR")){
					Jk001Data data= new Jk001Data(result.getData());
					System.out.println("省级人员id:"+data.getSjid());
				}
			}
		
		}catch(AppException e){
			e.printStackTrace();
		}
	}
	
	

}
