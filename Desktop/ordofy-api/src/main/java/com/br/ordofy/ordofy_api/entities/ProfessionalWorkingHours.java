package com.br.ordofy.ordofy_api.entities;

import com.br.ordofy.ordofy_api.entities.enums.DayOfWeek;
import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.Objects;

@Entity
public class ProfessionalWorkingHours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;

    private LocalTime startTime;
    private LocalTime endTime;

    @ManyToOne
    private Professional professional;

    public ProfessionalWorkingHours(DayOfWeek dayOfWeek, LocalTime endTime, Professional professional, LocalTime startTime) {
        this.dayOfWeek = dayOfWeek;
        this.endTime = endTime;
        this.professional = professional;
        this.startTime = startTime;
    }

    public ProfessionalWorkingHours() {
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public int getId() {
        return id;
    }

    public Professional getProfessional() {
        return professional;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProfessionalWorkingHours that = (ProfessionalWorkingHours) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getProfessional(), that.getProfessional());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProfessional());
    }
}
