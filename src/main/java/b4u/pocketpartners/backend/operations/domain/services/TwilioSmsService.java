package b4u.pocketpartners.backend.operations.domain.services;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

@Service
public class TwilioSmsService {

    private final String ACCOUNT_SID = "AC7919f3fd9d979ab723d2ed5034d1dfae"; // Replace with your actual Twilio Account SID
    private final String AUTH_TOKEN = "3c5e8e66808d46c39b4f9e8565c733fd";   // Replace with your actual Twilio Auth Token
    private final String FROM_PHONE = "+18647774489"; // Your Twilio phone number

    public TwilioSmsService() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    public void sendReminder(String toPhoneNumber, String dueDate) {
        String messageBody = String.format("Reminder: Your payment is due on %s.", dueDate);

        Message.creator(
                new PhoneNumber(toPhoneNumber), // To phone number
                new PhoneNumber(FROM_PHONE),    // From Twilio number
                messageBody
        ).create();
    }
}
