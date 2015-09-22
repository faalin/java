package hehe;

import java.util.Arrays;
import java.util.Random;

public class shijian{
	public static void main(String [] args){
		//演示Arrays提供的排序算法
		
		//构造一个超大的数组
		int [] arr = new int[50000];
		//定义随机数的对象
		//Math   Random
		Random random = new Random();
		for(int i= 0 ;i <50000;i++){
			arr[i] = random.nextInt(50000);
		}
		//记录开始排序的时间
		//获取当前的时间
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
		//记录排序结束的时间
		long end = System.currentTimeMillis();
		long time = end-start ;
		System.out.println("冒泡排序所用的时间："+time);
		System.out.println("---------");
		//数组的复制，扩容
		int [] arr1 = new int [5];
		for(int i= 0 ;i <arr1.length;i++){
			arr1[i]= i ;
		}
		System.out.println(Arrays.toString(arr1));
		int [] arr2 =Arrays.copyOf(arr1, 4);
		System.out.println(Arrays.toString(arr2));
		
	}
}