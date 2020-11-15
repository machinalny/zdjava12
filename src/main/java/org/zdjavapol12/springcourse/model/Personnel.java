package org.zdjavapol12.springcourse.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Personnel {
    private Long id;
    private String firstName;
    private String lastName;
    private String position;
    private LocalDate hireDate;
    private Double salary;
    private boolean sickLeave;
    // Dodac plec jako ENUM. Salary liczone na podstawie sickLeave, Data urodzenia
}
