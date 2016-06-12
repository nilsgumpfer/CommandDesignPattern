package de.thm.command;

/**
 * Created by Nils on 08.05.2016.
 */
public interface Account {
    public void depositToAccount(double dAmount);
    public void disburseFromAccount(double dAmount);
    public double getdBalance();
}
