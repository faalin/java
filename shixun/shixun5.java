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
//�̳�thread��
class MyThread extends Thread{
	 public void run(){
		 System.out.println("�߳�1");
	 }
}
//ͨ��runnable�ӿڵķ�ʽʵ��
class MyRunnable implements Runnable{
	public void run() {
		System.out.println("MyRunnable");

	}
	
}

