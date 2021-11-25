package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.user.Employee;
import com.udacity.jdnd.course3.critter.user.EmployeeSkill;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
public class Schedule {
    @Id
    @GeneratedValue
    private long id;

    @ManyToMany(
            fetch = FetchType.LAZY)
    @JoinTable(
            name = "ScheduleEmployee",
            joinColumns = @JoinColumn(name = "scheduleId"),
            inverseJoinColumns = @JoinColumn(name = "employeeId"))
    private Set<Employee> employees;

    @ManyToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinTable(
            name = "SchedulePet",
            joinColumns = @JoinColumn(name = "scheduleId"),
            inverseJoinColumns = @JoinColumn(name = "petId"))
    private Set<Pet> pets;

    private LocalDate date;

    @ElementCollection
    private Set<EmployeeSkill> activities;
}
