package com.javase.condition;

public class Simple {

	/*
	 *  A
		BC
		DEF
		GHIK
	 * */
	public static void main(String[] args) {
		
		for(int i=0;i<5;i++){
			
			switch(i){
				case 1:
					System.out.println("A");
					break;
				case 2:
					System.out.println("BC");
					break;
				case 3:
					System.out.println("DEF");
					break;
				case 4:
					System.out.println("GHIK");
					break;
			}
			
		}
	}

}
