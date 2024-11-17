package net.engineeringdigest.journalApp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTests {

    @Autowired
    private EmailService emailService;

    @Autowired
    private SentimentalAnalysisService sentimentalAnalysisService;

    @Test
    public void testSendMail() {
        emailService.sendEmail("allambellam1312@gmail.com", "Testing Java mail sender - SMTP", sentimentalAnalysisService.getSentiment("test"));
    }
}
