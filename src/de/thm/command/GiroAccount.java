package de.thm.command;

/**
 * Created by Nils on 08.05.2016.
 */
public class GiroAccount implements Account {
    private double dBalance;

    public GiroAccount(double dBalance){
        this.dBalance = dBalance;
    }

    @Override
    public void depositToAccount(double dAmount) {
        dBalance = dBalance + dAmount;
    }

    @Override
    public void disburseFromAccount(double dAmount) {
        dBalance = dBalance - dAmount;
    }

    @Override
    public double getdBalance() {
        return dBalance;
    }

    public void setdBalance(double dBalance) {
        this.dBalance = dBalance;
    }
}
