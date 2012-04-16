package net.sourceforge.frcsimulator.internals;

/**
 * A class used by the simulator that represents a hardware CRIO.
 * @todo Is the control data part of the cRIO?
 * @author benjamin
 */
public class CRIO implements FrcBotSimComponent{
    private static CRIO m_kCRIO = new CRIO();
    private int m_year = 2010;
    private short m_control = 0x0;
    //10000000
    public static final short RESET_CONTROL_BIT = 0x80;
    //01000000
    public static final short ESTOP_CONTROL_BIT = 0x40;
    //00100000
    public static final short ENABLED_CONTROL_BIT = 0x20;
    //00010000
    public static final short AUTONOMOUS_CONTROL_BIT = 0x10;
    //00001000
    public static final short FMS_ATTATCHED_CONTROL_BIT = 0x08;
    //00000100
    public static final short RESYNCH_CONTROL_BIT = 0x04;
    //00000010
    public static final short CRIO_CHECK_SUM_CONTROL_BIT = 0x02;
    //00000001
    public static final short FPGA_CHECK_SUM_CONTROL_BIT = 0x01;
    private CRIOModule[] m_modules = new CRIOModule[8];
    /**
     * Adds a simulated module at the given location to the CRIO.
     * @param module The module to be added.
     * @param id Where to insert the module.
     * @throws InvalidModuleException If the module equals null.
     * @throws ModuleSlotOutOfBoundsException If the id would not fit on a hardware CRIO.
     */
    public void addModule(CRIOModule module, int id) throws ModuleException{ //@TODO throw InvalidModuleException if not the right type for given id
        if(module == null){throw new InvalidModuleException();}
        if(id < 1 || id > 8){throw new ModuleSlotOutOfBoundsException();}
        m_modules[id-1] = module;
    }
    /**
     * Removes a module from the given location on the CRIO.
     * @param id Where to remove the module from.
     * @throws ModuleSlotOutOfBoundsException If the id would not be on a hardware CRIO.
     */
    public void removeModule(int id) throws ModuleException{
        if(id < 1 || id > 8){throw new ModuleSlotOutOfBoundsException();}
        m_modules[id-1] = null;
    }
    /**
     * Gets a module from the given location on the CRIO.
     * @param id Where the module is located.
     * @return An object representing the module on the CRIO.
     * @throws ModuleSlotOutOfBoundsException If the id would not be on a hardware CRIO.
     * @throws ModuleNotFoundException If the module does not exist at that location.
     */
    public CRIOModule getModule(int id) throws ModuleException{
        if(id < 1 || id > 8){throw new ModuleSlotOutOfBoundsException();}
        if(m_modules[id-1] == null){throw new ModuleNotFoundException();}
        return m_modules[id-1];
    }
    /**
     * Gets the control bits used by FRCCommonControlData and DriverStation.
     * @return A short representation of the control bits.
     */
    public short getControlBits(){
        return m_control;
    }
    /**
     * Sets the control bits used by FRCCommonControlData and DriverStation.
     * @param control What to set the bits to.
     */
    public void setControlBits(short control){
        m_control = control;
    }
    /**
     * Constructs a CRIO object with default parameters.
     */
    private CRIO(){}
    /**
     * Constructs a CRIO object with the given year(used for different configurations, like the difference between 2012 and pre-2012).
     * @param year The year of the CRIO model that this class will imitate.
     */
    private CRIO(int year){m_year=year;}
    /**
     * Gets the current instance of the CRIO being run by the simulator.
     * @return The current CRIO instance.
     */
    public static CRIO getInstance(){
        return m_kCRIO;
    }
    /**
     * Gets the properties of this component that can later be parsed by the simulator or an external program.
     * @return The FrcBotSimProperties of this object.
     */
    @Override
    public FrcBotSimProperties getSimProperties() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
