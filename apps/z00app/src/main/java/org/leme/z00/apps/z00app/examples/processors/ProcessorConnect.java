package org.leme.z00.apps.z00app.examples.processors;

public class ProcessorConnect extends Processor {

	public ProcessorConnect() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void processBody(Message msg) {
		validateCredentials(msg);
	}

	private void validateCredentials(Message msg){
	}
	
	
}
