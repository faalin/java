package hehe;

import java.util.Arrays;
import java.util.Random;

public class shijian{
	public static void main(String [] args){
		//��ʾArrays�ṩ�������㷨
		
		//����һ�����������
		int [] arr = new int[50000];
		//����������Ķ���
		//Math   Random
		Random random = new Random();
		for(int i= 0 ;i <50000;i++){
			arr[i] = random.nextInt(50000);
		}
		//��¼��ʼ�����ʱ��
		//��ȡ��ǰ��ʱ��
		long start = System.currentTimeMillis();
		for(int i =0 ; i <arr.length-1;i++){
			for(int j = 0 ;j<arr.length-1-i;j++){
				if(arr[j]>arr[j+1]){
					int temp = arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=temp;
				}
			}
		}
		//Arrays.sort(arr);
		//��¼���������ʱ��
		long end = System.currentTimeMillis();
		long time = end-start ;
		System.out.println("ð���������õ�ʱ�䣺"+time);
		System.out.println("---------");
		//����ĸ��ƣ�����
		int [] arr1 = new int [5];
		for(int i= 0 ;i <arr1.length;i++){
			arr1[i]= i ;
		}
		System.out.println(Arrays.toString(arr1));
		int [] arr2 =Arrays.copyOf(arr1, 4);
		System.out.println(Arrays.toString(arr2));
		
	}
}