/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sun.squawk;

import net.sourceforge.frcsimulator.internals.CRIO;

/**
 *
 * @author wolf
 */
public class UWord {
	public int toPrimitive() {
		if(CRIO.getInstance().isDebugging()) System.err.println("fixme:UWord should not be used");
                return 0;
	}
}
