package de.thm.command;

/**
 * Created by Nils on 08.05.2016.
 */
public class InternationalTransfer implements Transfer {
    private double dAmount;
    private Account aFromAccount;
    private Account aToAccount;
    private Account aFeeAccount;

    public InternationalTransfer(double dAmount, Account aFromAccount, Account aToAccount, Account aFeeAccount){
        this.dAmount        = dAmount;
        this.aFromAccount   = aFromAccount;
        this.aToAccount     = aToAccount;
        this.aFeeAccount    = aFeeAccount;
    }

    @Override
    public void execute() {
        aFromAccount.disburseFromAccount(dAmount);
        aToAccount.depositToAccount(dAmount);

        aFromAccount.disburseFromAccount(dAmount*0.1);
        aFeeAccount.depositToAccount(dAmount*0.1);
    }

    @Override
    public void revoke() {
        aToAccount.disburseFromAccount(dAmount);
        aFromAccount.depositToAccount(dAmount);

        aFeeAccount.disburseFromAccount(dAmount*0.1);
        aFromAccount.depositToAccount(dAmount*0.1);
    }
}
