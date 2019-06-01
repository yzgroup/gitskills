package com.cdintelligent.znzx.common.exception;

public class ZnzxException extends RuntimeException {

	private static final long serialVersionUID = -4711943928832656208L;

	/**
	 * 构造函数
	 * 
	 * @param errorMsg
	 *            错误消息
	 */
	public ZnzxException(String errorMsg) {
		super(errorMsg);
	}

	/**
	 * 构造函数
	 * 
	 * @param errorMsg
	 *            错误消息
	 * @param e
	 *            继承上一次错误描述
	 */
	public ZnzxException(String errorMsg, Throwable e) {
		super(errorMsg, e);
	}

}
