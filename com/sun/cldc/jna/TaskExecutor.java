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
public class TaskExecutor {
	public TaskExecutor(String name) {
            if(CRIO.getInstance().isDebugging()) System.err.println("fixme:TaskExecutor needs to be replaced");
        }
}
