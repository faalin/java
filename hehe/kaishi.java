package hehe;

import java.util.Arrays;
public class kaishi {
	public static void main(String [] args){
		//数组的三种定义方式
//		int [] arr = new int[5];
//		int [] arr1 = new int[]{1,2,3,4,5};
//		int [] arr2 = {1,2,3,4,5};			
		//冒泡排序
		int [] arr4 ={98,23,55,14,3};
		for(int i =0 ; i <arr4.length-1;i++){
			for(int j = 0 ;j<arr4.length-1-i;j++){
				if(arr4[j]>arr4[j+1]){
					int temp = arr4[j+1];
					arr4[j+1]=arr4[j];
					arr4[j]=temp;
				}
			}
		}
		//借助数组的工具类 Arrays
		//导包快捷键：ctrl+shift+o
		System.out.println(Arrays.toString(arr4));
	}
}
