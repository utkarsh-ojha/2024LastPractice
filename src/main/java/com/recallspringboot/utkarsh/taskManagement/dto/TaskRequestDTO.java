package com.recallspringboot.utkarsh.taskManagement.dto;

import com.recallspringboot.utkarsh.userManagement.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskRequestDTO {
    public String title;
    public String description;
    public String priority;
    public String dueDate;
    public long assignedToUserId;

}
