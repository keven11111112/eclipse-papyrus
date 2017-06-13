/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.moka.fuml.Semantics;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.Execution;

public class ExecutionQueueManager {
	
	// The queue handled by the execution manager
	protected ExecutionQueue queue;
	
	// The manager is a singleton
	private static ExecutionQueueManager INSTANCE;
	
	public static ExecutionQueueManager getInstance(){
		// Instantiate the manager if required and return the
		// singleton instance 
		if(INSTANCE == null){
			INSTANCE = new ExecutionQueueManager();
		}
		return INSTANCE;
	}
	
	private ExecutionQueueManager(){
		this.queue = new ExecutionQueue();
	}
	
	public void enqueue(Execution execution){
		// Add an execution to the queue
		this.queue.offer(execution);
	}
	
	public void start(RootExecution execution){
		// Add an execution to the queue and start the execution
		// loop.
		this.enqueue(execution);
		this.run();
	}
	
	public void run(){
		// Execute all execution in the queue until
		// the queue is empty
		while(!this.queue.isEmpty()){
			this.runNext();
		}
	}
	
	public void step(){
		// Run the execution at the head of the queue
		this.runNext();
	}
	
	private boolean runNext(){
		// If the queue is not empty, then the head execution is removed
		// and executed. True is returned. False is only returned if the
		// queue was empty.
		if(!this.queue.isEmpty()){
			this.queue.poll().execute();
			return true;
		}
		return false;
	}
}
