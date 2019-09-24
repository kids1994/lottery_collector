package com.lh.main;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.lh.utils.Utils;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GetMoney {

	private JFrame frame;

	BlueBall bb;
	RedBall[] rbList;
	Utils utils;
	boolean flag;
	static int count = 0;
	// Thread th2;
	Thread th1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GetMoney window = new GetMoney();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the application.
	 */
	public GetMoney() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel LB_1 = new JLabel("0");
		LB_1.setHorizontalAlignment(SwingConstants.CENTER);
		LB_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		LB_1.setBounds(25, 10, 55, 47);
		panel.add(LB_1);

		JLabel LB_2 = new JLabel("0");
		LB_2.setHorizontalAlignment(SwingConstants.CENTER);
		LB_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		LB_2.setBounds(25, 91, 55, 47);
		panel.add(LB_2);

		JLabel LB_3 = new JLabel("0");
		LB_3.setHorizontalAlignment(SwingConstants.CENTER);
		LB_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		LB_3.setBounds(25, 180, 55, 47);
		panel.add(LB_3);

		JLabel LB_4 = new JLabel("0");
		LB_4.setHorizontalAlignment(SwingConstants.CENTER);
		LB_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		LB_4.setBounds(88, 10, 55, 47);
		panel.add(LB_4);

		JLabel LB_5 = new JLabel("0");
		LB_5.setHorizontalAlignment(SwingConstants.CENTER);
		LB_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		LB_5.setBounds(88, 91, 55, 47);
		panel.add(LB_5);

		JLabel LB_6 = new JLabel("0");
		LB_6.setHorizontalAlignment(SwingConstants.CENTER);
		LB_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		LB_6.setBounds(88, 180, 55, 47);
		panel.add(LB_6);

		JLabel LB_7 = new JLabel("0");
		LB_7.setHorizontalAlignment(SwingConstants.CENTER);
		LB_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		LB_7.setBounds(153, 10, 55, 47);
		panel.add(LB_7);

		JLabel LB_num = new JLabel("0");
		LB_num.setForeground(Color.RED);
		LB_num.setBackground(Color.WHITE);
		LB_num.setHorizontalAlignment(SwingConstants.CENTER);
		LB_num.setFont(new Font("Tahoma", Font.PLAIN, 49));
		LB_num.setBounds(179, 91, 136, 127);
		panel.add(LB_num);

		JLabel[] labelList = { LB_1, LB_2, LB_3, LB_4, LB_5, LB_6, LB_7 };

		JButton btn_start = new JButton("\u5F00\u59CB");
		btn_start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				init(LB_num, count);

			}
		});
		btn_start.setFont(new Font("STXihei", Font.PLAIN, 16));
		btn_start.setBounds(335, 121, 89, 63);
		panel.add(btn_start);

		JLabel LB_result = new JLabel("0");
		LB_result.setHorizontalAlignment(SwingConstants.LEFT);
		LB_result.setFont(new Font("Tahoma", Font.PLAIN, 28));
		LB_result.setBounds(10, 221, 263, 29);
		panel.add(LB_result);

		JButton btn_getNum = new JButton("\u9009\u53F7");
		btn_getNum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println(count);
				// System.out.println("------");
				if (count < 6) {
					start();
					// utils.setCount();
					// th2.interrupt();

					// System.out.println(rbList[count].value);

					labelList[count].setText(rbList[count].value + "");
					count++;
				} else {
					StringBuffer str = new StringBuffer();
					labelList[count].setText(getBlueBall() + "");
					for (RedBall rb : rbList) {
						str.append(rb.value + ",");
					}
					str.append(getBlueBall());
					LB_result.setText(str.toString());
					th1.stop();
				}
			}
		});
		btn_getNum.setFont(new Font("STXihei", Font.PLAIN, 16));
		btn_getNum.setBounds(335, 38, 89, 63);
		panel.add(btn_getNum);

	}

	public void init(JLabel LB_num, int count) {

		bb = new BlueBall(0);
		rbList = new RedBall[6];
		for (int i = 0; i < 6; i++) {
			rbList[i] = new RedBall(0);
		}
		flag = true;
		th1 = new Thread(new Runnable() {

			@Override
			public void run() {
				utils = new Utils(0, flag);

				utils.getRedBall(flag, LB_num, count);// TODO Auto-generated method stub

			}
		});
		th1.start();

	}

	public int getValue() {

		return utils.getRes();

	}

	public boolean containsSameBall(int value) {
		for (RedBall tmp : rbList) {
			if (tmp.value == value) {
				return true;
			}
		}

		return false;
	}

	public void start() {
		// th2 = new Thread(new Runnable() {
		//
		// @Override
		// public void run() {
		System.out.println("getRedBall");
		// System.out.println("-------");

		// System.out.println(parse);

		rbList[count].value = getValue();
		for (int i = 0; i < 5; i++) {
			if (containsSameBall(rbList[count].value)) {
				rbList[count].value++;
				if (rbList[count].value > 33) {
					rbList[count].value = 1;
				}
			}
		}

		// });
		// th2.start();
		System.out.println(rbList[count].value);

	}

	public int getBlueBall() {
		System.out.println("getBlueBall");
		int res = getValue() - 17;
		if (res <= 0) {
			res += 17;
		}
		return res;
	}
}
