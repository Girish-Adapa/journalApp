package net.engineeringdigest.journalApp.repository;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

// it is not bean
// as it is an interface, spring will implement and sends an instance
public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId> {

}