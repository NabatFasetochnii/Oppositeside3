package com.nabat.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.pay.PurchaseObserver;
import com.badlogic.gdx.pay.Transaction;

public class MyObserver implements PurchaseObserver {

    MyGame myGame;

    public MyObserver(MyGame myGame) {
        this.myGame = myGame;

    }

    @Override
    public void handleInstall() {
        Gdx.app.log("IAP", "Installed");
        myGame.purchaseManager.purchaseRestore();


    }

    @Override
    public void handleInstallError(Throwable e) {
        Gdx.app.error("IAP", "Error when trying to install PurchaseManager", e);
    }

    @Override
    public void handleRestore(Transaction[] transactions) {
        if (transactions != null && transactions.length > 0)
            for (Transaction t : transactions) {
                handlePurchase(t, true);
            }


    }

    @Override
    public void handleRestoreError(Throwable e) {

    }

    @Override
    public void handlePurchase(Transaction transaction) {
        handlePurchase(transaction, false);
    }

    protected void handlePurchase(final Transaction transaction, final boolean fromRestore) {
        Gdx.app.postRunnable(new Runnable() {
            @Override
            public void run() {
                if (transaction.isPurchased()) {
                    if (transaction.getIdentifier().equals(myGame.getSKU())) {
                        Consts.setRemoveAds(true);
                        myGame.getAdsController().hideBannerForStart();

                    }

                }
            }
        });
    }

    @Override
    public void handlePurchaseError(Throwable e) {

    }

    @Override
    public void handlePurchaseCanceled() {

    }
}
