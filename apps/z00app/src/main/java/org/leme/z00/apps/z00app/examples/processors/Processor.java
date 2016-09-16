package org.leme.z00.apps.z00app.examples.processors;

public abstract class Processor {

	public void processHeader(Message msg){
		System.out.println(msg.getClass());
	}

	public abstract void processBody(Message msg);
	
	public void process(Message msg){
		processHeader(msg);
		processBody(msg);
	}
}
