package com.example.UserNotification.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user_notification")
public class UserNotifications {

    @Id
    private String id;

    @JsonProperty(value = "created_date")
    @Field("created_date")
    @CreatedDate
    private Date createdDate;

    @Field("name")
    private String name;

    @Field("address")
    private String address;

    @Field("city")
    private String city;

    @Field("gender")
    private String gender;

    @Field("deleted")
    private boolean deleted;
}
