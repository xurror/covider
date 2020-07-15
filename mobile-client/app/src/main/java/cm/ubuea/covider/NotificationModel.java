package cm.ubuea.covider;

public class NotificationModel {
    private String title, notification, date;

    public NotificationModel() {
    }

    public NotificationModel(String title, String notification, String date) {
        this.title = title;
        this.notification = notification;
        this.date = date;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotification() { return notification; }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
