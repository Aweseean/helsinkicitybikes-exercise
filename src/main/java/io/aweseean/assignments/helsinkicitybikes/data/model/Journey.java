package io.aweseean.assignments.helsinkicitybikes.data.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="journeys")
public class Journey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="journey_id")
    private Long id;
    @Column(name="departure_date")
    private String departureDate;
    @Column(name="return_date")
    private String returnDate;
    @Column(name="departure_station_id") // number with zero on ahead? not int, maybe just string?
    private String departureStationId;
    @Column(name="departure_station")
    private String departureStation;
    @Column(name="return_station_id") // number with zero on ahead? not int, maybe just string?
    private String returnStationId;
    @Column(name="return_station")
    private String returnStation;
    @Column(name="distance_meters")
    private int distanceMeters;
    @Column(name="duration_seconds")
    private int durationSeconds;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getDepartureStationId() {
        return departureStationId;
    }

    public void setDepartureStationId(String departureStationId) {
        this.departureStationId = departureStationId;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(String departureStation) {
        this.departureStation = departureStation;
    }

    public String getReturnStationId() {
        return returnStationId;
    }

    public void setReturnStationId(String returnStationId) {
        this.returnStationId = returnStationId;
    }

    public String getReturnStation() {
        return returnStation;
    }

    public void setReturnStation(String returnStation) {
        this.returnStation = returnStation;
    }

    public int getDistanceMeters() {
        return distanceMeters;
    }

    public void setDistanceMeters(int distanceMeters) {
        this.distanceMeters = distanceMeters;
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(int durationSeconds) {
        this.durationSeconds = durationSeconds;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Journey{");
        sb.append("id=").append(id);
        sb.append(", departureDate='").append(departureDate).append('\'');
        sb.append(", returnDate='").append(returnDate).append('\'');
        sb.append(", departureStationId='").append(departureStationId).append('\'');
        sb.append(", departureStation='").append(departureStation).append('\'');
        sb.append(", returnStationId='").append(returnStationId).append('\'');
        sb.append(", returnStation='").append(returnStation).append('\'');
        sb.append(", distanceMeters=").append(distanceMeters);
        sb.append(", durationSeconds=").append(durationSeconds);
        sb.append('}');
        return sb.toString();
    }
}
