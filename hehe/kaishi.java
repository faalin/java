package hehe;

import java.util.Arrays;
public class kaishi {
	public static void main(String [] args){
		//��������ֶ��巽ʽ
//		int [] arr = new int[5];
//		int [] arr1 = new int[]{1,2,3,4,5};
//		int [] arr2 = {1,2,3,4,5};			
		//ð������
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
		//��������Ĺ����� Arrays
		//������ݼ���ctrl+shift+o
		System.out.println(Arrays.toString(arr4));
	}
}
