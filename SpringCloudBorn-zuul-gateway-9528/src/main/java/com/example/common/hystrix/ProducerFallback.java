package com.example.common.hystrix;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
// 没有成功
/*当我们的后端服务出现异常的时候，我们不希望将异常抛出给最外层，期望服务可以自动进行一降级。
 Zuul给我们提供了这样的支持。当某个服务出现异常时，直接返回我们预设的信息。*/
@Component
public class ProducerFallback implements ZuulFallbackProvider{
	 private final Logger logger = LoggerFactory.getLogger(ZuulFallbackProvider.class);
	 
	//指定要处理的 service。
	@Override
	public String getRoute() {
		System.out.println("skip to SpringCloudBorn-dept");
		return "SpringCloudBorn-dept";
	}

	@Override
	public ClientHttpResponse fallbackResponse() {
		 return new ClientHttpResponse() {
	            @Override
	            public HttpStatus getStatusCode() throws IOException {
	                return HttpStatus.OK;
	            }

	            @Override
	            public int getRawStatusCode() throws IOException {
	                return 200;
	            }

	            @Override
	            public String getStatusText() throws IOException {
	                return "OK";
	            }

	            @Override
	            public void close() {

	            }

	            @Override
	            public InputStream getBody() throws IOException {
	                return new ByteArrayInputStream("The service is unavailable.".getBytes());
	            }

	            @Override
	            public HttpHeaders getHeaders() {
	                HttpHeaders headers = new HttpHeaders();
	                headers.setContentType(MediaType.APPLICATION_JSON);
	                return headers;
	            }
	        };
	}
	
//	@Override
//    public ClientHttpResponse fallbackResponse(Throwable cause) {
//        if (cause != null && cause.getCause() != null) {
//            String reason = cause.getCause().getMessage();
//            logger.info("Excption {}",reason);
//        }
//        return fallbackResponse();
//    }

}
