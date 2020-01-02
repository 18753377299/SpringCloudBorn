package com.example.common.hystrix;

import org.springframework.http.client.ClientHttpResponse;

public interface ZuulFallbackProvider {
	/**
	 * The route this fallback will be used for.
	 * @return The route the fallback will be used for.
	 */
	public String getRoute();

	/**
	 * Provides a fallback response.
	 * @return The fallback response.
	 */
	public ClientHttpResponse fallbackResponse();
}
