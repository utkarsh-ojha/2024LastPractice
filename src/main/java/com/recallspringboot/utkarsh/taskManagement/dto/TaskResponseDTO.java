package com.recallspringboot.utkarsh.taskManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskResponseDTO {

    public long id;
    public String title;
    public String status;
    public String priority;
    public Assineee assigedTo;
    public String dueDate;
}
