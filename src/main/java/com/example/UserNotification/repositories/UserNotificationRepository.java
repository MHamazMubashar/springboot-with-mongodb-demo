package com.example.UserNotification.repositories;

import com.example.UserNotification.model.UserNotifications;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserNotificationRepository extends MongoRepository<UserNotifications,String> {

    List<UserNotifications> findByNameContainingOrCityContainingIgnoreCaseAndDeletedIsFalse(String name, String city, Pageable pageable);
}
