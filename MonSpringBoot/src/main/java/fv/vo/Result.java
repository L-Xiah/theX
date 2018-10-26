package fv.vo;

import java.io.Serializable;

public class Result implements Serializable {
	private static final long serialVersionUID = -4192087809568619922L;
	public Result() {
		super();
	}
	protected boolean success;//是否成功
	protected String code;//结果码
	protected String detail;//详情
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}




	
}