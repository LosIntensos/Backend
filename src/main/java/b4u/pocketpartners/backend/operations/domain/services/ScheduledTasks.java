package b4u.pocketpartners.backend.operations.domain.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * ScheduledTasks is a Spring component that runs scheduled tasks.
 *
 * @author Fiorella Jarama Peñaloza
 */
@Component
public class ScheduledTasks {

    private final ExpensesNotificationService paymentNotificationService;

    public ScheduledTasks(ExpensesNotificationService paymentNotificationService) {
        this.paymentNotificationService = paymentNotificationService;
    }

    @Scheduled(cron = "0 0 9,17 * * ?") // Ejecutar a las 9:00 AM y 5:00 PM
    public void sendDailyPaymentReminders() {
        paymentNotificationService.sendPaymentReminders();
    }
}