package com.insigma.webservice.client;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import com.caucho.hessian.client.HessianProxyFactory;
import com.insigma.webservice.exception.AppException;
import com.insigma.webservice.hessianservice.HessianService;
import com.insigma.webservice.infostruct.Input;
import com.insigma.webservice.infostruct.Result;
import com.insigma.webservice.infostruct.dto.keyword.Jk001Keyword;
import com.insigma.webservice.infostruct.enums.BusCode;

/**
 * ���÷���
 * 
 * @author wengsh
 *
 */
public class ClientCall {
	
	//����hessian��Զ�̷�����õ�ַ
	private String HESSIAN_SERVICE_URL="http://127.0.0.1:8091/sxjsywebservice/hessianService";  
	

	public List<Result> jk_001(List<Jk001Keyword> keywordlist) throws AppException {
		List<Input> inputlist=new ArrayList<Input>();
		for (Jk001Keyword keyword:keywordlist){
			Input input=new Input();
			input.setKeyword(keyword.toString());
			inputlist.add(input);;
		}
		return call(BusCode.JK_001,inputlist);
	}
	
	/**
	 * ����hessian�Ľӿڵ���
	 * @param requestmsg
	 * @param buscode
	 * @return
	 * @throws AppException
	 */
	private List<Result> call(BusCode buscode,List<Input> inputlist) throws AppException {
        HessianProxyFactory factory = new HessianProxyFactory();  
        try {  
        	HessianService hessianservice = (HessianService) factory.create(HessianService.class, HESSIAN_SERVICE_URL);  
    		 return hessianservice.hessianRpcCall(buscode, inputlist);
        } catch (MalformedURLException e) {  
            e.printStackTrace();  
            throw new  AppException("Զ�̵���ʧ��,�����ַ�Ƿ���ȷ"+HESSIAN_SERVICE_URL);
        }  
	}
	
}
