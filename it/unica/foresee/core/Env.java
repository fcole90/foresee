package it.unica.foresee.core;

import it.unica.foresee.datasets.interfaces.Dataset;

import static it.unica.foresee.utils.Tools.warn;

import java.io.File;


/**
 * Represents the runtime environment.
 */
public class Env implements it.unica.foresee.core.interfaces.Env
{
    /**
     * flag to force exit
     */
    private boolean forceExit = false;

    /**
     * exit status
     */
    private int exitStatus = 0;

    /**
     * the command in execution or just executed
     */
    private String currentCommand = null;

    /**
     * loaded dataset
     */
    private Dataset dataset = null;

    /**
     * The work directory is where temporary files, buffers and snapshots are stored.
     */
    private String workDirectory = "." + File.separator + "workdir" + File.separator;

    /**
     * Create a default environment.
     */
    public Env(){}

    /* Getter */

    /**
     * {@inheritDoc}
     */
    @Override
    public String getCurrentCommand() {
        return currentCommand;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Dataset getDataset() {
        return dataset;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getExitStatus() {
        return exitStatus;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getWorkDirectory() {
        return workDirectory;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isAbnormalStatus()
    {
        return this.exitStatus != 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isForceExit() {
        return forceExit;
    }


    /* Setter */

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAbnormalExitStatus(int status)
    {
        if (this.exitStatus == 0 && status != 0)
        {
            this.exitStatus = status;
            warn("Exit status is now set to " + status);
        }
        else if (status == 0)
        {
            throw new IllegalArgumentException("The status parameter cannot be set to 0");
        }
        else if (this.exitStatus != 0)
        {
            warn("The exit status is already in an abnormal state: " + this.exitStatus);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setCurrentCommand(String currentCommand) {
        this.currentCommand = currentCommand;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDataset(Dataset dataset) {
        this.dataset = dataset;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setForceExit(boolean forceExit) {
        this.forceExit = forceExit;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setWorkDirectory(String workDirectory) {
        this.workDirectory = workDirectory;
    }

}