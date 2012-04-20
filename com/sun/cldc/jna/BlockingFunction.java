/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sun.cldc.jna;

import net.sourceforge.frcsimulator.internals.CRIO;
import net.sourceforge.frcsimulator.mistware.Simulator;

/**
 *
 * @author wolf
 */
public class BlockingFunction extends Function {
	public void setTaskExecutor(TaskExecutor te) {
            Simulator.fixme(BlockingFunction.class, Thread.currentThread(), "BlockingFunction should not be used");
        }
}
