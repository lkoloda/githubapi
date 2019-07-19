package com.testTask.gitapp.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name="package")
//@EqualsAndHashCode(callSuper = false)
//@NoArgsConstructor
//@AllArgsConstructor
public class VersionEntity //extends AbstractEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @Column(name = "created", updatable = false)
    LocalDateTime created;
    @Column(name = "updated", insertable = false)
    LocalDateTime updated;
    Long version;
    @Column(name="package_version")
    public Long getVersion(){return this.version;}

    @PrePersist
    public void toCreate(){
        setCreated(LocalDateTime.now());
    }

    @PreUpdate
    public void toUpdtate(){
        setUpdated(LocalDateTime.now());
    }
}
