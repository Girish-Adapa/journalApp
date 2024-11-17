package net.engineeringdigest.journalApp.service;

import org.springframework.stereotype.Service;

@Service
public class SentimentalAnalysisService {

    public String getSentiment(String text) {
        return "Hi [Recipient's Name],\n" +
                "\n" +
                "Thank you for signing up for [Your Service Name]! We're excited to have you on board.\n" +
                "\n" +
                "Here’s a quick overview of what you can expect:\n" +
                "\n" +
                "Feature 1: [Brief description of the feature]\n" +
                "Feature 2: [Brief description of the feature]\n" +
                "Feature 3: [Brief description of the feature]\n" +
                "To get started, click the button below:\n" +
                "\n" +
                "[Get Started Now]\n" +
                "\n" +
                "If you have any questions, feel free to reach out to our support team at [support@example.com].\n" +
                "\n" +
                "Best regards,\n" +
                "The [Your Service Name] Team";
    }
}
