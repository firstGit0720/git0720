package com.mmsg.cms.dbutil;

public class Page {
	//设置显示条目
	private int showNumber;
	//设置条目总数
	private int totalNumber;
	//设置当前页
	private int currentNumber;
	
	
	//构造访啊
	public Page() {
		super();
	}


	public Page(int showNumber, int totalNumber, int currentNumber) {
		super();
		this.showNumber = showNumber;
		this.totalNumber = totalNumber;
		this.currentNumber = currentNumber;
	}


	public int getShowNumber() {
		return showNumber;
	}


	public void setShowNumber(int showNumber) {
		this.showNumber = showNumber;
	}


	public int getTotalNumber() {
		return totalNumber;
	}


	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}


	public int getCurrentNumber() {
		return currentNumber;
	}


	public void setCurrentNumber(int currentNumber) {
		this.currentNumber = currentNumber;
	}
	
	//计算总页数的方法
	public int getToral(){
		if(totalNumber % showNumber == 0){
			return totalNumber/showNumber; 
		}else{
			return totalNumber/showNumber + 1;
		}
	}
	//计算初始位置
	public int getStartIndex(){
		return (currentNumber - 1) * showNumber;
	}
	
	//求上一页
	public int getPrevPage(){
		int temp = currentNumber-1;
		if(temp < 1){
			temp = 1;
		} 
		return temp;
	}
	
	//求下一页
	public int getNextPage(){
		int temp = currentNumber + 1;
		if(temp >this.getToral()){
			temp = this.getToral();
		}
		return temp;
	}
	
	
}
