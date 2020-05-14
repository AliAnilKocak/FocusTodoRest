package com.cale.focustodo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "action")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Action extends BaseEntity {

    @Id
    @GeneratedValue
    @JsonIgnore
    private int id;

    private String name;



}
