package com.alvin137.testmod;

public class ClientProxy extends CommonProxy {
	public void proxy() {
		Runtime runtime = Runtime.getRuntime();
    	runtime.exit(0);
	}
}
