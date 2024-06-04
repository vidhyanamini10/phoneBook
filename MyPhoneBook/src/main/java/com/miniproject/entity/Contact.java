package com.miniproject.entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Contact_Info")
@Data
@XmlRootElement
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contactId;
    private String contactName;
    private String contactEmail;
    private Long contactNumber;
}
