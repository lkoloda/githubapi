package com.testTask.gitapp.domain.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class AbstractEntity implements Serializable {
    private static final long serialVersionUID = -1798070786993154676L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @Column(name = "created", updatable = false)
    LocalDateTime created;
    @Column(name = "updated", insertable = false)
    LocalDateTime updated;


//    public Long getId() {
//        return id;
//    }
//
//    public LocalDateTime getCreated() {
//        return created;
//    }
//
//    public LocalDateTime getUpdated() {
//        return updated;
//    }

    @PrePersist
    public void toCreate(){
        setCreated(LocalDateTime.now());
    }

    @PreUpdate
    public void toUpdtate(){
        setUpdated(LocalDateTime.now());
    }
}
