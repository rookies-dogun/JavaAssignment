package mylab.notification.di.annot;


import mylab.notification.di.annot.config.NotificationConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = NotificationConfig.class)
public class NotificationConfigTest {

    @Autowired
    private NotificationManager notificationManager;

    @Test
    public void test() {

        notificationManager.sendNotificationByEmail("이메일 테스트");

        notificationManager.sendNotificationBySms("sms 테스트");
    }
}
