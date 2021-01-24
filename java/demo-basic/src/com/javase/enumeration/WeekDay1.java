package com.javase.enumeration;

/**
 * 
 * @author lenovo
 *
 */
public abstract class WeekDay1 {
	private WeekDay1(){}
	
	public final static WeekDay1 SUN = new WeekDay1(){
		@Override
		public WeekDay1 nextDay() {
			return MON;
		}
	};
	public abstract WeekDay1 nextDay();
	public final static WeekDay1 MON = new WeekDay1(){

		@Override
		public WeekDay1 nextDay() {
			// TODO Auto-generated method stub
			return SUN;
		}
		
	};	
	
	
	
/*	public WeekDay nextDay(){
		if(this == SUN){
			return  MON;
		}else{
			return SUN;
		}
	}
*/
	
	public String toString(){
		return this==SUN?"SUN":"MON";
	}
}
