package shixun;

public class xiancheng {
	public static void main(String [] arg){
		//���������߳�ִ����Ʊ�Ĳ���
		TicketThread t1 = new TicketThread();
		TicketThread t2 = new TicketThread();
		t1.start();
		t2.start();
	}
}
class TicketThread extends Thread{
	//static ��̬�� �����౾��ġ�
	//���ж�����
	static  int ticket = 100 ;
//	static Random random = new Random();
	
	public void run(){
		while(true){
			//��Ʊ
			//Ψһ�Ķ���
			synchronized (xiancheng.class) {
				
				if(ticket !=0){
					System.out.println(
							this.getName()+"��ѯ����"+ticket+"��Ʊ");
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					//��Ʊ
					ticket -- ;
					System.out.println(
							this.getName()+"����1��Ʊ����ʣ"+ticket+"��Ʊ��");
				}
				
			}
		}
	}
}
