package com.example.UserNotification.services;

import com.example.UserNotification.exceptions.ResourceNotFoundException;
import com.example.UserNotification.model.UserNotifications;
import com.example.UserNotification.repositories.UserNotificationRepository;
import com.example.UserNotification.utils.Util;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.example.UserNotification.utils.Response;

import java.util.Optional;

@Service
@Slf4j
public class UserNotificationService {
    private final UserNotificationRepository userNotificationRepository;

    public UserNotificationService(UserNotificationRepository userNotificationRepository) {
        this.userNotificationRepository = userNotificationRepository;
    }

    @SneakyThrows
    public Response save(UserNotifications userNotifications) {
        userNotifications = userNotificationRepository.save(userNotifications);
        return Util.getOkRequest(userNotifications.getId());
    }

    @SneakyThrows
    public Response findNotificationByNameOrCity(Integer pageNumber, Integer pageSize, String name, String city) {
        pageSize = pageSize == null ? 10 : pageSize;
        pageNumber = pageNumber == null ? 0 : pageNumber;
        name = name == null ? "" : name;
        city = city == null ? "" : city;
        return Util.getOkRequest(userNotificationRepository.findByNameContainingOrCityContainingIgnoreCaseAndDeletedIsFalse(name,city, PageRequest.of(pageNumber,pageSize)));

    }
    @SneakyThrows
    public Response delete(String userNotificationId) {
        UserNotifications userNotifications = Optional.ofNullable(userNotificationRepository.findById(userNotificationId)
                .orElseThrow(() -> new ResourceNotFoundException("could not find userNotifications with id " + userNotificationId))).get();

        userNotifications.setDeleted(true);
        return Util.getOkRequest(userNotificationRepository.save(userNotifications));
    }
}
