package de.thm.command;

import java.util.ArrayList;

/**
 * Created by Nils on 08.05.2016.
 */
public class TransferMainClass {
    private Account aAccountBerlin                  = new GiroAccount(1000);
    private Account aAccountMunich                  = new GiroAccount(1000);
    private Account aAccountBoston                  = new GiroAccount(1000);
    private Account aAccountBlackHole               = new GiroAccount(0);
    private ArrayList<Transfer> lAllTransfers       = new ArrayList<>();
    private ArrayList<Transfer> lTransfersQueue     = new ArrayList<>();

    public static void main(String[] args) {
        TransferMainClass tmcMainClass = new TransferMainClass();

        tmcMainClass.printBalances();
        System.out.println("-----------");

        tmcMainClass.doTestTransfers();
        tmcMainClass.printBalances();
        System.out.println("-----------");

        tmcMainClass.revokeLastTransactions(8);
        tmcMainClass.printBalances();

    }

    public void doTestTransfers(){
        lTransfersQueue.add(new InternationalTransfer(100,aAccountBerlin,aAccountBoston,aAccountBlackHole));
        lTransfersQueue.add(new InternationalTransfer(100,aAccountBerlin,aAccountBoston,aAccountBlackHole));
        lTransfersQueue.add(new InternationalTransfer(100,aAccountBerlin,aAccountBoston,aAccountBlackHole));

        lTransfersQueue.add(new InternationalTransfer(300,aAccountBoston,aAccountMunich,aAccountBlackHole));
        lTransfersQueue.add(new InternationalTransfer(300,aAccountBoston,aAccountMunich,aAccountBlackHole));
        lTransfersQueue.add(new InternationalTransfer(300,aAccountBoston,aAccountMunich,aAccountBlackHole));

        lTransfersQueue.add(new NationalTransfer(200,aAccountBerlin,aAccountMunich));
        lTransfersQueue.add(new NationalTransfer(200,aAccountBerlin,aAccountMunich));
        lTransfersQueue.add(new NationalTransfer(200,aAccountBerlin,aAccountMunich));

        executeTransactions();
    }

    public void executeTransactions(){
        for (Transfer tTransfer: lTransfersQueue){
                tTransfer.execute();
                lAllTransfers.add(tTransfer);
        }

        lTransfersQueue.clear();
    }

    public void revokeLastTransactions(Integer iNumber){
        Integer i = lAllTransfers.size()-1;
        ArrayList<Integer> lToRemove = new ArrayList<>();

        while(i>=0 && iNumber>0) {
            lAllTransfers.get(i).revoke();
            lToRemove.add(i);

            iNumber--;
            i--;
        }

        for (int iIndex:lToRemove){
            lAllTransfers.remove(iIndex);
        }
    }

    public void printBalances(){
        System.out.println("Berlin: " + aAccountBerlin.getdBalance());
        System.out.println("Munich: " + aAccountMunich.getdBalance());
        System.out.println("Boston: " + aAccountBoston.getdBalance());
        System.out.println("Black Hole: " + aAccountBlackHole.getdBalance());
    }

    public void printAllTransactions(){
        for (Transfer tTransfer: lAllTransfers) {
            System.out.println(tTransfer.toString());
        }
    }

    public void printTransactionsQueue(){
        for (Transfer tTransfer: lTransfersQueue) {
            System.out.println(tTransfer.toString());
        }
    }
}
