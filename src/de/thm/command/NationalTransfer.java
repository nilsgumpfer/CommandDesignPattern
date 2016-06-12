package de.thm.command;

/**
 * Created by Nils on 08.05.2016.
 */
public class NationalTransfer implements Transfer {
    private double dAmount;
    private Account aFromAccount;
    private Account aToAccount;

    public NationalTransfer(double dAmount, Account aFromAccount, Account aToAccount){
        this.dAmount        = dAmount;
        this.aFromAccount   = aFromAccount;
        this.aToAccount     = aToAccount;
    }

    @Override
    public void execute() {
        aFromAccount.disburseFromAccount(dAmount);
        aToAccount.depositToAccount(dAmount);
    }

    @Override
    public void revoke() {
        aToAccount.disburseFromAccount(dAmount);
        aFromAccount.depositToAccount(dAmount);
    }
}
