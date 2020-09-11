package com.nabat.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.pay.PurchaseObserver;
import com.badlogic.gdx.pay.Transaction;

public class MyObserver implements PurchaseObserver {

    private final MyGame myGame;
    private final String TAG = "PurchaseObserver";


    public MyObserver(MyGame myGame) {
        this.myGame = myGame;

    }

    @Override
    public void handleInstall() {
        Gdx.app.log(TAG, "Installed");
        myGame.purchaseManager.purchaseRestore();


    }

    @Override
    public void handleInstallError(Throwable e) {
        Gdx.app.error(TAG, "Error when trying to install PurchaseManager", e);
    }

    @Override
    public void handleRestore(Transaction[] transactions) {
        Gdx.app.log(TAG, "handleRestore");
        if (transactions != null && transactions.length > 0)
            for (Transaction t : transactions) {
                handlePurchase(t, true);
            }


    }

    @Override
    public void handleRestoreError(Throwable e) {
        Gdx.app.log(TAG, "handleRestoreError", e);
    }

    @Override
    public void handlePurchase(Transaction transaction) {
        Gdx.app.log(TAG, "handlePurchase");
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
        Gdx.app.log(TAG, "handlePurchaseError", e);
    }

    @Override
    public void handlePurchaseCanceled() {
        Gdx.app.log(TAG, "handlePurchaseCanceled");
    }
}
