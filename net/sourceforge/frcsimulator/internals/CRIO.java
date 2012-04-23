package net.sourceforge.frcsimulator.internals;

import edu.wpi.first.wpilibj.communication.FRCCommonControlData;

/**
 * A class used by the simulator that represents a hardware CRIO.
 * @todo Is the control data part of the cRIO?
 * @todoAnwswer In reality yes, it probably should be changed to FrcBotSimProperties though
 * @author benjamin
 */
public class CRIO implements FrcBotSimComponent{
    private static CRIO m_kCRIO = new CRIO();
    private int m_year = 2010;
    private boolean debug;
    private short m_control = 0x0;
    private CRIOModule[] m_modules = new CRIOModule[8];
    private FRCCommonControlData frcControlData = new FRCCommonControlData();
    /**
     * Adds a simulated module at the given location to the CRIO.
     * @param module The module to be added.
     * @param id Where to insert the module.
     * @throws InvalidModuleException if the module equals null.
     * @throws ModuleSlotOutOfBoundsException if the id would not fit on a hardware CRIO.
     */
    public void addModule(CRIOModule module, int id) throws ModuleException{ //@TODO throw InvalidModuleException if not the right type for given id
        if(module == null){throw new InvalidModuleException();}
        if(id < 1 || id > 8){throw new ModuleSlotOutOfBoundsException();}
        m_modules[id-1] = module;
    }
    /**
     * Removes a module from the given location on the CRIO.
     * @param id Where to remove the module from.
     * @throws ModuleSlotOutOfBoundsException if the id would not be on a hardware CRIO.
     */
    public void removeModule(int id) throws ModuleException{
        if(id < 1 || id > 8){throw new ModuleSlotOutOfBoundsException();}
        m_modules[id-1] = null;
    }
    /**
     * Gets a module from the given location on the CRIO.
     * @param id Where the module is located.
     * @return An object representing the module on the CRIO.
     * @throws ModuleSlotOutOfBoundsException if the id would not be on a hardware CRIO.
     * @throws ModuleNotFoundException if the module does not exist at that location.
     */
    public CRIOModule getModule(int id) throws ModuleException{
        if(id < 1 || id > 8){throw new ModuleSlotOutOfBoundsException();}
        if(m_modules[id-1] == null){throw new ModuleNotFoundException();}
        return m_modules[id-1];
    }
    /**
     * Gets the control data used by the DriverStation
     * @return Th FRCCommonControlData used by the CRIO.
     */
    public FRCCommonControlData getControlData(){
        return frcControlData;
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
     * Returns whether or not the CRIO is in debug mode.
     * @return The current debugging mode.
     */
    public boolean isDebugging(){
        return debug;//@TODO levels of debugging
    }
    /**
     * Sets whether or not the CRIO is in debug mode.
     * @param debug The debugging mode to be set to.
     */
    public void setDebugging(boolean debug){
        this.debug = debug;
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
