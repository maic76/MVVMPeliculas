package mx.lania.mvvmpeliculas.UI.interfaces;

import mx.lania.mvvmpeliculas.POJOS.PushNotification;

import java.util.ArrayList;

public interface PushNotificationContract {
    interface View extends BaseView<Presenter> {

        void showNotifications(ArrayList<PushNotification> notifications);

        void showEmptyState(boolean empty);

        void popPushNotification(PushNotification pushMessage);
    }

    interface Presenter extends BasePresenter {

        void registerAppClient();

        void loadNotifications();

        void savePushMessage(String title, String description,
                             String expiryDate, String discount);
    }
}