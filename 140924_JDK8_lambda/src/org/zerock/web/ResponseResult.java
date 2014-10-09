package org.zerock.web;

/**
 * contain nextPage, redirect info
 * 
 * @author Zerock
 *
 */
public class ResponseResult {

	private final String nextPage;
	private final Boolean forward;
	
	public ResponseResult(String nextPage) {
		this(nextPage, true);
	}	
	
	public ResponseResult(String nextPage, Boolean forward) {
		this.nextPage = nextPage;
		this.forward = forward;
	}

	public String getNextPage() {
		return nextPage;
	}

	public Boolean getForward() {
		return forward;
	}
	
	
}
