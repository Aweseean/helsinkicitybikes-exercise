package io.aweseean.assignments.helsinkicitybikes.data.model;


import jakarta.persistence.*;

@Entity
@Table(name="journeys")
public class Journey {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "journeys_generator")
    @SequenceGenerator(name="journeys_generator", sequenceName = "journeys_seq", allocationSize = 1)
    @Column(name="journey_id", updatable = false, nullable = false)
    private Long id;
    @Column(name="departure_date")
    private String departureDate;
    @Column(name="return_date")
    private String returnDate;
    @Column(name="departure_station_id")
    private String departureStationId;
    @Column(name="departure_station")
    private String departureStation;
    @Column(name="return_station_id")
    private String returnStationId;
    @Column(name="return_station")
    private String returnStation;
    @Column(name="distance_meters")
    private int distanceMeters;
    @Column(name="duration_seconds")
    private int durationSeconds;
    @Transient
    private String distanceKilometers;

    public Journey(String departureDate, String returnDate,
                   String departureStationId, String departureStation,
                   String returnStationId, String returnStation,
                   int distanceMeters, int durationSeconds) {
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.departureStationId = departureStationId;
        this.departureStation = departureStation;
        this.returnStationId = returnStationId;
        this.returnStation = returnStation;
        this.distanceMeters = distanceMeters;
        this.durationSeconds = durationSeconds;
    }

    protected Journey() {}

    /*@ManyToOne
    @JoinColumn(name="departure_station", referencedColumnName="station_id")
    private Station departureStation;
    @ManyToOne
    @JoinColumn(name="return_station", referencedColumnName="station_id")
    private Station returnStation;
    @JoinTable(name="journey_stations", joinColumns={
            @JoinColumn(name="fk_journey_id", referencedColumnName="journey_id"),
            @JoinColumn(name="fk_departure_station_id", referencedColumnName="departure_station_id"),
            @JoinColumn(name="fk_return_station_id", referencedColumnName="return_station_id")
    })
    private List<Journey> journeyStations;
    @JoinTable(name="journey_stations")
    @JoinColumn(name="journey_return_station_id", referencedColumnName="return_station_id"))*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getDistanceKilometers() {
        return distanceKilometers;
    }

    public void setDistanceKilometers(String distanceKilometers) { this.distanceKilometers = distanceKilometers;}

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Journey{");
        sb.append("id=").append(id);
        sb.append(", departureDate='").append(departureDate).append('\'');
        sb.append(", returnDate='").append(returnDate).append('\'');
        sb.append(", departureStationId='").append(departureStationId).append('\'');
        sb.append(", departureStation=").append(departureStation);
        sb.append(", returnStationId='").append(returnStationId).append('\'');
        sb.append(", returnStation=").append(returnStation);
        sb.append(", distanceMeters=").append(distanceMeters);
        sb.append(", durationSeconds=").append(durationSeconds);
        sb.append('}');
        return sb.toString();
    }


}
