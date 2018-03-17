package com.wawcode.smogue.domain.persistence;

import javax.persistence.*;

@Entity
@Table(name = "Subscribers")
public class Subscriber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private int number;
    @Column
    private String email;
    @Column
    private boolean emailSent;
    @Column
    private boolean activeUser;

}
