package com.liuhe.common;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class ControllerInterceptor {

	@ExceptionHandler(CmsException.class)
	@ResponseBody
	public MsgResult interceptorException(CmsException exception){
		System.out.println("错误是"+exception);
		return new MsgResult(100,exception.getMessage(),null);
	}
	
	@ExceptionHandler(CmsExceptionHtml.class)
	public ModelAndView  interceptorExceptionHtml(CmsExceptionHtml excetion) {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error");// 跳转到jsp
		modelAndView.addObject("errorInfo", excetion.getMessage());
		return modelAndView;
		
	}	
}
