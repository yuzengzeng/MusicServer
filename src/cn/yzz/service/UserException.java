package cn.yzz.service;

public class UserException extends Exception {
	/**
	 * 自定义一个异常类，只需要给出父类中的构造器即可，以方便来创建对象
	 * 
	 */
	public UserException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
