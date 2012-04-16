/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.fpga;

/**
 * Pretends to be the FPGA watchdog.
 * @author wolf
 */
public class tWatchdog extends tSystem {
	private static long expiration;
	private static boolean immortal;
	public tWatchdog() {
		super();
	}
	@Override
	protected void finalize() {
		super.finalize();
	}
	public static final int kNumSystems = 1;
	
	public static long readExpiration() {
		return expiration;
	}
	public static boolean readImmortal() {
		return immortal;
	}
	public static boolean readStatus_Alive() {
		throw new UnsupportedOperationException("Not implemented yet.");
	}
	public static short readStatus_DisableCount() {
		throw new UnsupportedOperationException("Not implemented yet.");
	}
	public static short readStatus_SysDisableCount() {
		throw new UnsupportedOperationException("Not implemented yet.");
	}
	public static boolean readStatus_SystemActive() {
		throw new UnsupportedOperationException("Not implemented yet.");
	}
	public static int readStatus() {
		throw new UnsupportedOperationException("Not implemented yet.");
	}
	public static long readTimer() {
		throw new UnsupportedOperationException("Not implemented yet.");
	}
	public static void strobeFeed() {
		throw new UnsupportedOperationException("Not implemented yet.");
	}
	public static void strobeKill() {
		throw new UnsupportedOperationException("Not implemented yet.");
	}
	public static void writeExpiration(long value) {
		expiration=value;
	}
	public static void writeImmortal(boolean value)  {
		immortal=value;
	}
}
