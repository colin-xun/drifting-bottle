package com.moudao.util;

public class ResultMall {
	 // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;
    
    private Integer count ;
    
    

	public Integer getCount() {
		return count;
	}


	public void setCount(Integer count) {
		this.count = count;
	}

	
	public ResultMall( String msg) {
		super();
		this.status = 200;
		this.msg = msg;
	}
	
	public ResultMall(Integer count){
		super();
		this.status = 200;
		this.count = count;
	}
	public ResultMall(Integer status, String msg) {
		super();
		this.status = status;
		this.msg = msg;
	}


	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
    
    
}
