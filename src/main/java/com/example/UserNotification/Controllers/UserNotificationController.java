package com.example.UserNotification.Controllers;

import com.example.UserNotification.model.UserNotifications;
import com.example.UserNotification.services.UserNotificationService;
import com.example.UserNotification.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/user_notification")
public class UserNotificationController {

    private final UserNotificationService userNotificationService;

    @Autowired
    public UserNotificationController(UserNotificationService userNotificationService){
        this.userNotificationService = userNotificationService;
    }

    @PostMapping("/")
    public ResponseEntity<Response> save(@RequestBody UserNotifications userNotifications) {
        userNotifications.setCreatedDate(new Date());
        userNotifications.setDeleted(false);
        Response response = userNotificationService.save(userNotifications);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping("/")
    public ResponseEntity<Response> findNotificationByUserIdOrMessageEn(@RequestParam(name = "page_number",required = false) Integer pageNumber,@RequestParam(name = "page_size",required = false) Integer pageSize,@RequestParam(name = "name",required = false) String name,@RequestParam(name = "city",required = false) String city) {
        Response response = userNotificationService.findNotificationByNameOrCity(pageNumber,pageSize,name,city);
        return new ResponseEntity<>(response,response.getHttpStatus());
    }

    @DeleteMapping("/")
    public ResponseEntity<Response> delete(@RequestParam(name = "id",required = false) String userNotificationId) {
        Response response = userNotificationService.delete(userNotificationId);
        return new ResponseEntity<>(response,response.getHttpStatus());
    }
}
