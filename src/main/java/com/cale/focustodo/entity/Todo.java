package com.cale.focustodo.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "todo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Todo extends BaseEntity {

    @Id
    @GeneratedValue
    private int id;

    private String title;
    private String description;
    private int is_favorite;
    private String time;
    private String energy;
    private Date dueDate;




}
