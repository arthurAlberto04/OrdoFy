package com.br.ordofy.ordofy_api.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime start;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime end;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "professional_Id")
    private Professional professional;

    public Schedule() {
    }

    public Schedule(LocalDate date, LocalTime end, Professional professional, Service service, LocalTime start, User user) {
        this.date = date;
        this.end = end;
        this.professional = professional;
        this.service = service;
        this.start = start;
        this.user = user;
    }

    public LocalDate getDate() {
        return date;
    }

    public User getUser() {
        return user;
    }

    public LocalTime getStart() {
        return start;
    }

    public Service getService() {
        return service;
    }

    public Professional getProfessional() {
        return professional;
    }

    public Integer getId() {
        return id;
    }

    public LocalTime getEnd() {
        return end;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(getId(), schedule.getId()) && Objects.equals(getService(), schedule.getService()) && Objects.equals(getUser(), schedule.getUser()) && Objects.equals(getProfessional(), schedule.getProfessional());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getService(), getUser(), getProfessional());
    }
}
