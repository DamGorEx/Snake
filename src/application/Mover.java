package application;

public class Mover extends Thread {

	public Mover() {
		// TODO Auto-generated constructor stub
	}

	public Mover(Runnable target) {
		super(target);
		// TODO Auto-generated constructor stub
	}

	public Mover(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public Mover(ThreadGroup group, Runnable target) {
		super(group, target);
		// TODO Auto-generated constructor stub
	}

	public Mover(ThreadGroup group, String name) {
		super(group, name);
		// TODO Auto-generated constructor stub
	}

	public Mover(Runnable target, String name) {
		super(target, name);
		// TODO Auto-generated constructor stub
	}

	public Mover(ThreadGroup group, Runnable target, String name) {
		super(group, target, name);
		// TODO Auto-generated constructor stub
	}

	public Mover(ThreadGroup group, Runnable target, String name, long stackSize) {
		super(group, target, name, stackSize);
		// TODO Auto-generated constructor stub
	}

}
