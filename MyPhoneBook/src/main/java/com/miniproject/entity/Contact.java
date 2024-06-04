package com.miniproject.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Contact_Info")
@Data
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contactId;
    private String contactName;
    private String contactEmail;
    private Long contactNumber;
}
