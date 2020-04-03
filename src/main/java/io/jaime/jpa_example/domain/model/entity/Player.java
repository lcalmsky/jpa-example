package io.jaime.jpa_example.domain.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "PLAYER")
public class Player {
    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "GOAL")
    private Integer goal;
    @Column(name = "ASSIST")
    private Integer assist;
}