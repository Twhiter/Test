package com.nchu.wiper2.agent;

import com.nchu.wiper2.brush.Brush;
import com.nchu.wiper2.dial.Dial;
import com.nchu.wiper2.lever.Lever;

public abstract class AbstractAgent {

	protected Brush brush;
	protected Dial dial;
	protected Lever lever;

	public abstract void dealSpeed();
	public abstract void show();

	public AbstractAgent() {

	}

	public AbstractAgent(Brush brush, Dial dial, Lever lever) {
		this.brush = brush;
		this.dial = dial;
		this.lever = lever;
	}

	/**
	 * 调用成员变量lever的升档方法
	 */
	public void upLever() {
		this.lever.upPosition();
	}

	/**
	 * 调用成员变量lever的降档方法
	 */
	public void downLever() {
		this.lever.downPosition();
	}

	/**
	 * 调用成员便变量dial的升档方法
	 */
	public void upDial() {
		this.dial.upPosition();
	}

	/**
	 * 调用成员便变量dial的降档方法
	 */
	public void downDial() {
		this.dial.downPosition();
	}

	/**
	 *
	 * @return 成员变量brush的速度
	 */
	public int getSpeed() {
		return this.brush.getSpeed();
	}

	/**
	 *此方法会改变成员变量brush的成员变量speed的值
	 * @param speed 需要调整到的速度
	 */
	public void setSpeed(int speed) {
		this.brush.setSpeed(speed);
	}

	public Lever getLever() {
		return lever;
	}

	public Dial getDial() {
		return dial;
	}

	public Brush getBrush() {
		return brush;
	}
}


