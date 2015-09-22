package shixun;

public class shixun5 {

	/**
	 * @author Administrator
	 */
	public static void main(String[] args) {
		
		MyThread thread = new MyThread();
		thread.start();
		Thread  t1 = new Thread(new MyRunnable());
		t1.start();
		Thread  t2 = new Thread(new MyRunnable());
		t2.start();

	}
	
}
//继承thread类
class MyThread extends Thread{
	 public void run(){
		 System.out.println("线程1");
	 }
}
//通过runnable接口的方式实现
class MyRunnable implements Runnable{
	public void run() {
		System.out.println("MyRunnable");

	}
	
}

