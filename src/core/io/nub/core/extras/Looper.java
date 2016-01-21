package io.nub.core.extras;

import io.nub.core.util.Function;

public class Looper
{
	private final Loop loop;
	private final int rate;
	private int frame;
	private Function func;
	
	public boolean running;
	
	public Looper(int min, int max, int startFrame, int rate, Function f)
	{
		this.loop = new Loop(min, max, startFrame);
		this.rate = rate;
		this.running = true;
		this.func = f;
	}
	public Looper(int min, int max, int startFrame, int rate) {
		this(min, max, startFrame, rate, new Function(){
			@Override
			public void call() {
			}
		});
	}
	
	public int val()
	{
		return loop.val();
	}
	
	public void update()
	{
		if (running) {
			int f = (int) (System.currentTimeMillis() / rate);
			if (f != frame) {
				loop.inc();
				func.call();
			}
			frame = f;
		}
	}
	
	public void inc()
	{
		this.loop.inc();
	}
}
