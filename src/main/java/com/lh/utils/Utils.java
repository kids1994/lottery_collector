package com.lh.utils;

import javax.swing.JLabel;

public class Utils{

	private int res;

	private boolean flag;
	
	int count;

	public void getRedBall(boolean flag ,JLabel LB_num,int count) {
		
		res = 1;
		
		this.count =count;
		this.flag =flag;
		while (flag) {
			// System.out.println(res);
			res++;
			LB_num.setText(res+"");
			if (res >= 34) {
				res = 1;
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}
	
	

//	public void getBlueBall(boolean flag) {
//
//		Thread th = new Thread();
//		res = 0;
//		th.run();
//		this.flag =flag;
//		while (flag) {
//
//			res++;
//			if (res >= 16) {
//				res = 1;
//			}
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		th.stop();
//
//		
//	}

	public Utils(int res, boolean flag) {
		super();
		this.res = res;
		this.flag = flag;
	}

	public int getRes() {
		return res;
	}

	public void setRes(int res) {
		this.res = res;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public void setCount() {
		this.count++;
	}

}
