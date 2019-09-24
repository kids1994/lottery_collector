package com.lh.main;

import com.lh.utils.Utils;

public class InitRunner implements Runnable{
	BlueBall bb;
	RedBall[] rbList;
	Utils utils;
	boolean flag;
	@Override
	public void run() {
		bb = new BlueBall(0);
		rbList = new RedBall[7];
		for (int i = 0; i < 7; i++) {
			rbList[i] = new RedBall(0);
		}
		flag = true;

		utils = new Utils(0, flag);

		// utils.getRedBall(flag);
		
	}

}
