package com.wy.tests.util;

import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import javax.validation.ValidationException;

import org.springframework.http.MediaType;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerMethodExceptionResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;



public class MethodValidationExceptionResolver extends AbstractHandlerMethodExceptionResolver {
	
	  private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
	    private static final String NOT_AVAILABLE = "N/A";
	    private static final String ERROR_TEMPLATE = "URL: %s, MSG: %s";
	    private static final MediaType[] supportedMediaTypes;
	    private final MappingJackson2JsonView jacksonView = new MappingJackson2JsonView();
	    private volatile boolean inspectionMode = false;

	    private static boolean hasLength(CharSequence str) {
	        return str != null && str.length() > 0;
	    }

	    public void setOrder(int order) {
	        super.setOrder(order);
	    }

	    private static boolean isCompatibleWithJson(HttpServletRequest request) {
	        List acceptedMediaTypes = (new ServletServerHttpRequest(request)).getHeaders().getAccept();
	        MediaType[] var2 = supportedMediaTypes;
	        int var3 = var2.length;

	        for(int var4 = 0; var4 < var3; ++var4) {
	            MediaType supportedMediaType = var2[var4];
	            Iterator var6 = acceptedMediaTypes.iterator();

	            while(var6.hasNext()) {
	                MediaType acceptedMediaType = (MediaType)var6.next();
	                if(supportedMediaType.isCompatibleWith(acceptedMediaType)) {
	                    return true;
	                }
	            }
	        }

	        return false;
	    }

	    public MethodValidationExceptionResolver() {
	        this.jacksonView.setExtractValueFromSingleKeyModel(true);
	    }

	    public void inspectionMode(boolean inspectionMode) {
	        this.inspectionMode = inspectionMode;
	    }

	    protected ModelAndView doResolveHandlerMethodException(HttpServletRequest request, HttpServletResponse response, HandlerMethod handlerMethod, Exception e) {
	        if(request == null) {
	            return null;
	        } else {
	            Map eM = this.buildErrorMessage(handlerMethod, e);
	            if(this.logger.isErrorEnabled()) {
	                this.logger.error(String.format("URL: %s, MSG: %s", new Object[]{request.getRequestURL(), eM.get("errorMessage")}), e);
	            }

	            return isCompatibleWithJson(request)?(new ModelAndView(this.jacksonView)).addObject(eM):null;
	        }
	    }

	    private Map<String, Object> buildErrorMessage(String rootBeanName, String propertyPath, String errorMessage, boolean logicalError, Object invalidValue) {
	        LinkedHashMap msgMap = new LinkedHashMap(4, 1.0F);
	        boolean e = hasLength(errorMessage);
	        boolean hasCode = e && errorMessage.contains("~");
	        String[] vars = null;
	        if(hasCode) {
	            vars = errorMessage.split("~");
	            hasCode = vars.length >= 2;
	        }

	        msgMap.put("code", hasCode?vars[0]:"N/A");
	        msgMap.put("errorMessage", e?(hasCode?vars[1]:errorMessage):"N/A");
	        msgMap.put("logicalError", Boolean.valueOf(logicalError));
	        if(hasLength(rootBeanName)) {
	            msgMap.put("rootBeanName", rootBeanName);
	        }

	        if(hasLength(propertyPath)) {
	            msgMap.put("propertyPath", propertyPath);
	        }

	        if(this.inspectionMode) {
	            try {
	                msgMap.put("runtimeValue", invalidValue != null?JsonUtils.toJson(invalidValue):"N/A");
	            } catch (Exception var10) {
	                msgMap.put("runtimeValue", invalidValue != null?invalidValue:"N/A");
	            }
	        }

	        return msgMap;
	    }

	    private Map<String, Object> buildErrorMessage(String rootBeanName, String propertyPath, String code, String errorMessage, boolean logicalError, Object invalidValue) {
	        LinkedHashMap msgMap = new LinkedHashMap(4, 1.0F);
	        msgMap.put("code", hasLength(code)?code:"N/A");
	        msgMap.put("errorMessage", hasLength(errorMessage)?errorMessage:"N/A");
	        msgMap.put("logicalError", Boolean.valueOf(logicalError));
	        if(hasLength(rootBeanName)) {
	            msgMap.put("rootBeanName", rootBeanName);
	        }

	        if(hasLength(propertyPath)) {
	            msgMap.put("propertyPath", propertyPath);
	        }

	        if(this.inspectionMode) {
	            try {
	                msgMap.put("runtimeValue", invalidValue != null?JsonUtils.toJson(invalidValue):"N/A");
	            } catch (Exception var9) {
	                msgMap.put("runtimeValue", invalidValue != null?invalidValue:"N/A");
	            }
	        }

	        return msgMap;
	    }

	    private Map<String, Object> buildErrorMessage(HandlerMethod handlerMethod, Exception e) {
	        String message;
	        Class beanType2;
	        Method method1;
	        if(e instanceof DefinedMessageException) {
	            beanType2 = handlerMethod == null?null:handlerMethod.getBeanType();
	            method1 = handlerMethod == null?null:handlerMethod.getMethod();
	            message = e.getMessage();
	            String rootBeanClass1 = ((DefinedMessageException)e).getCode();
	            return this.buildErrorMessage(beanType2 == null?null:beanType2.getName(), method1 == null?null:method1.getName(), rootBeanClass1, hasLength(message)?message:e.getClass().getName(), e instanceof ValidationException, (new StringBuilder("hashCode")).append(" = ").append(e.hashCode()));
	        } else {
	            if(e instanceof MethodArgumentNotValidException) {
	                BindingResult beanType = ((MethodArgumentNotValidException)e).getBindingResult();
	                if(beanType.hasFieldErrors()) {
	                    FieldError method2 = beanType.getFieldError();
	                    return this.buildErrorMessage(method2.getObjectName(), method2.getField(), method2.getDefaultMessage(), false, method2.getRejectedValue());
	                }
	            }

	            if(e instanceof ConstraintViolationException) {
	                Set beanType1 = ((ConstraintViolationException)e).getConstraintViolations();
	                if(beanType1 != null) {
	                    Iterator method = beanType1.iterator();
	                    if(method.hasNext()) {
	                        ConstraintViolation message1 = (ConstraintViolation)method.next();
	                        Class rootBeanClass = message1.getRootBeanClass();
	                        Path propertyPath = message1.getPropertyPath();
	                        return this.buildErrorMessage(rootBeanClass == null?null:rootBeanClass.getName(), propertyPath == null?null:propertyPath.toString(), message1.getMessage(), true, message1.getInvalidValue());
	                    }
	                }
	            }

	            beanType2 = handlerMethod == null?null:handlerMethod.getBeanType();
	            method1 = handlerMethod == null?null:handlerMethod.getMethod();
	            message = e.getMessage();
	            return this.buildErrorMessage(beanType2 == null?null:beanType2.getName(), method1 == null?null:method1.getName(), hasLength(message)?message:e.getClass().getName(), e instanceof ValidationException, (new StringBuilder("hashCode")).append(" = ").append(e.hashCode()));
	        }
	    }

	    static {
	        supportedMediaTypes = new MediaType[]{new MediaType("application", "json", DEFAULT_CHARSET), new MediaType("application", "*+json", DEFAULT_CHARSET)};
	    }

}
