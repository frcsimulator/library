/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj;

import edu.wpi.first.wpilibj.parsing.IInputOutput;
import net.sourceforge.frcsimulator.internals.FrcBotSimProperties;
import net.sourceforge.frcsimulator.internals.FrcBotSimComponent;
import net.sourceforge.frcsimulator.internals.UnimplementedOperationException;

/**
 *
 * @author wolf
 */
public class DriverStationEnhancedIO implements FrcBotSimComponent, IInputOutput {
	public DriverStationEnhancedIO() {
		super();
	}
	@Override
	public FrcBotSimProperties getSimProperties() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	void updateData() {
		//throw new UnimplementedOperationException("Not implemented yet.");
            //@TODO actually get working, as of now, just stubbed so stuff will work
	}
}
