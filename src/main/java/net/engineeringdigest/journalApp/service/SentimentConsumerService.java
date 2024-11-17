package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.model.SentimentData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SentimentConsumerService {

    @Autowired
    private EmailService emailService;

    // no server is set for KAFKA either in local or in cloud
    // confluent cloud is asking for credit details and it is not free
//    @KafkaListener(topics = "weekly-sentiments", groupId = "weekly-sentiment-group")
//    public void consume(SentimentData sentimentData) {
//        sendEmail(sentimentData);
//    }

    private void sendEmail(SentimentData sentimentData) {
        emailService.sendEmail(sentimentData.getEmail(), "Sentiment for previous week", sentimentData.getSentiment());
    }
}