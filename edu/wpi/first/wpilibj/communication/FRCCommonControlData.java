/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008-2012. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.communication;

import com.sun.cldc.jna.Structure;
import net.sourceforge.frcsimulator.internals.FrcBotSimProperties;
import net.sourceforge.frcsimulator.internals.FrcBotSimProperty;

/**
 * Structure for data exchanged between the robot and the driver station.
 */
public final class FRCCommonControlData extends Structure {
	FrcBotSimProperties properties;
	public FrcBotSimProperties getSimProperties() {
		return properties;
	}

	public FRCCommonControlData() {
		// Status bytes
		properties.put("reset", new FrcBotSimProperty<Boolean>());
		properties.put("estop", new FrcBotSimProperty<Boolean>());
		properties.put("enabled", new FrcBotSimProperty<Boolean>());
		properties.put("autonomous", new FrcBotSimProperty<Boolean>());
		properties.put("fms-attached", new FrcBotSimProperty<Boolean>());
		properties.put("resynch",new FrcBotSimProperty<Boolean>());

		// Miscellaney
		properties.put("packetIndex",new FrcBotSimProperty<Integer>());
		properties.put("team",new FrcBotSimProperty<Integer>(0));
		properties.put("alliance",new FrcBotSimProperty<Character>('R'));
		properties.put("position",new FrcBotSimProperty<Character>('1'));
		properties.put("digitalIn",new FrcBotSimProperty<Short>());

		// Joysticks
		properties.put("stick0axes",new FrcBotSimProperty<byte[]>());
		properties.put("stick0buttons",new FrcBotSimProperty<Short>());
		properties.put("stick1axes",new FrcBotSimProperty<byte[]>());
		properties.put("stick1buttons",new FrcBotSimProperty<Short>());
		properties.put("stick2axes",new FrcBotSimProperty<byte[]>());
		properties.put("stick2buttons",new FrcBotSimProperty<Short>());
		properties.put("stick3axes",new FrcBotSimProperty<byte[]>());
		properties.put("stick3buttons",new FrcBotSimProperty<Short>());

		// Analog inputs
		properties.put("analog1",new FrcBotSimProperty<Short>());
		properties.put("analog2",new FrcBotSimProperty<Short>());
		properties.put("analog3",new FrcBotSimProperty<Short>());
		properties.put("analog4",new FrcBotSimProperty<Short>());
	}

    public static final short RESET_BIT = 0x80;
    public static final short ESTOP_BIT = 0x40;
    public static final short ENABLED_BIT = 0x20;
    public static final short AUTONOMOUS_BIT = 0x10;
    public static final short FMS_ATTATCHED = 0x08;
    public static final short RESYNCH = 0x04;
    public static final short CRIO_CHECK_SUM = 0x02;
    public static final short FPGA_CHECK_SUM = 0x01;

    /**
     * The index of the packet
     */
    public /*UINT16*/ int packetIndex;
    /**
     * The control mode e.g. Autonomous, E-stop, enabled ...
     */
    public /*UINT8*/ short control;
    // { reset, notEStop, enabled, autonomous, fmsAttached, resync, cRIOChkSum, fpgaChkSum }

    /**
     * Determine if the robot should be enabled
     * @return true if the robot is enabled
     */
    public boolean enabled() {
        return (control & ENABLED_BIT) == ENABLED_BIT;
    }

    /**
     * Determine if the robot should be in autonomous
     * @return true if the robot is in autonomous
     */
    public boolean autonomous() {
        return (control & AUTONOMOUS_BIT) == AUTONOMOUS_BIT;
    }
    /**
     * The state of the digital inputs on the ds
     */
    public /*UINT8*/ short dsDigitalIn;
    /**
     * The team number from the ds
     */
    public /*UINT16*/ int teamID;
    /**
     * Which alliance the robot is on
     */
    public char dsID_Alliance;
    /**
     * The position of the controls on the alliance station wall.
     */
    public char dsID_Position;
    /**
     * Position of the axes of the first js
     */
    public byte[] stick0Axes = new byte[6];
    /**
     * Button state of the first js
     */
    public short stick0Buttons;		// Left-most 4 bits are unused
    /**
     * Position of the axes of the second js
     */
    public byte[] stick1Axes = new byte[6];
    /**
     * Button state of the second js
     */
    public short stick1Buttons;		// Left-most 4 bits are unused
    /**
     * Position of the axes of the third js
     */
    public byte[] stick2Axes = new byte[6];
    /**
     * Button state of the third js
     */
    public short stick2Buttons;		// Left-most 4 bits are unused
    /**
     * Position of the axes of the fourth js
     */
    public byte[] stick3Axes = new byte[6];
    /**
     * Button state of the fourth js
     */
    public short stick3Buttons;		// Left-most 4 bits are unused
    //Analog inputs are 10 bit right-justified
    /** Driver Station analog input */
    public short analog1;
    /** Driver Station analog input */
    public short analog2;
    /** Driver Station analog input */
    public short analog3;
    /** Driver Station analog input */
    public short analog4;

    // Other fields are used by the lower-level comm system and not needed by robot code:

    /**
     * Method to free the memory used by this structure
     */
    protected void free() {
        freeMemory();
    }

    /**
     * Read new data in the structure
     */
    public void read() {
        packetIndex = (Integer)properties.get("packetIndex").get();
        control = (short)(
				((Boolean)properties.get("reset").get()?RESET_BIT:0x0) |
				((Boolean)properties.get("estop").get()?ESTOP_BIT:0x0) |
				((Boolean)properties.get("enabled").get()?ENABLED_BIT:0x0) |
				((Boolean)properties.get("autonomous").get()?AUTONOMOUS_BIT:0x0) |
				((Boolean)properties.get("fms-attached").get()?FMS_ATTATCHED:0x0) |
				((Boolean)properties.get("resynch").get()?RESET_BIT:0x0)
				// TODO Checksums?
				);

        dsDigitalIn = (Short)properties.get("digitalIn").get();
        teamID = (Integer)properties.get("team").get();

        dsID_Alliance = (Character)properties.get("alliance").get();
        dsID_Position = (Character)properties.get("position").get();

		stick0Axes = (byte[])properties.get("stick0axes").get();
        stick0Buttons = (Short)properties.get("stick0buttons").get();
		stick1Axes = (byte[])properties.get("stick1axes").get();
        stick1Buttons = (Short)properties.get("stick1buttons").get();
		stick2Axes = (byte[])properties.get("stick2axes").get();
        stick2Buttons = (Short)properties.get("stick2buttons").get();
		stick3Axes = (byte[])properties.get("stick3axes").get();
        stick3Buttons = (Short)properties.get("stick3buttons").get();

        analog1 = (Short)properties.get("analog1").get();
        analog2 = (Short)properties.get("analog2").get();
        analog3 = (Short)properties.get("analog3").get();
        analog4 = (Short)properties.get("analog4").get();

        // Other fields are used by the lower-level comm system and not needed by robot code
	}

    /**
     * Write new data in the structure
     */
	@Override
    public void write() {
        throw new IllegalStateException("FRCCommonControlData is not writable");
    }

    /**
     * Get the size of the structure
     * @return size of the structure
     */
    public int size() {
        return 80;
    }

}
