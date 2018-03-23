package javaExam;

public class SingleTon {
	private static SingleTon singleton;
	private SingleTon() {
		
	}
	public static synchronized SingleTon getInstance() {
		if(singleton==null) {
			singleton = new SingleTon();
		}
		return singleton;
	}
}
