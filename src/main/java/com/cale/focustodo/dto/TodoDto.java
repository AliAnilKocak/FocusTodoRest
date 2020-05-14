package com.cale.focustodo.dto;

import com.cale.focustodo.entity.Action;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoDto {

    private int id;

    @NotNull
    private String title;
    private String description;
    private int is_favorite;
    private String time;
    private String energy;
    private Date dueDate;
    private int action_id;
    private Action action;

}
