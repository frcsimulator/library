/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sun.cldc.jna;

import net.sourceforge.frcsimulator.internals.CRIO;

/**
 *
 * @author wolf
 */
public class BlockingFunction extends Function {
	public void setTaskExecutor(TaskExecutor te) {
            if(CRIO.getInstance().isDebugging()) System.err.println("fixme:TaskExecutor needs to be replaced");
        }
}
