package shixun;

public class xiancheng {
	public static void main(String [] arg){
		//创建两个线程执行买票的操作
		TicketThread t1 = new TicketThread();
		TicketThread t2 = new TicketThread();
		t1.start();
		t2.start();
	}
}
class TicketThread extends Thread{
	//static 静态的 属于类本身的。
	//所有对象共享
	static  int ticket = 100 ;
//	static Random random = new Random();
	
	public void run(){
		while(true){
			//查票
			//唯一的对象
			synchronized (xiancheng.class) {
				
				if(ticket !=0){
					System.out.println(
							this.getName()+"查询到了"+ticket+"张票");
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					//买票
					ticket -- ;
					System.out.println(
							this.getName()+"买了1张票，还剩"+ticket+"张票。");
				}
				
			}
		}
	}
}
