/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sun.cldc.jna;

/**
 *
 * @author wolf
 */
public class BlockingFunction extends Function {
	public void setTaskExecutor(TaskExecutor te) {
		throw new UnsupportedOperationException("Calls to BlockingFunction need to be replaced in the simulator!");
	}
}
