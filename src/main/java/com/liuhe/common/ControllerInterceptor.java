package com.liuhe.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerInterceptor {

	@ExceptionHandler(CmsException.class)
	@ResponseBody
	public MsgResult interceptorException(CmsException exception){
		System.out.println("错误是"+exception);
		return new MsgResult(100,exception.getMessage(),null);
	}
	
}
