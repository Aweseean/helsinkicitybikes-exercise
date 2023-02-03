package io.aweseean.assignments.helsinkicitybikes.data.model;
/*
    Notice that CSV datasets have FID as first field and stationID as second..
 */
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="stations")
public class Station {
    @Id
    @Column(name="station_name")
    private String stationName;
    @Column(name="fid")
    private int fid;
    @Column(name="station_id")
    private String stationId;
    @Column(name="station_name_fi")
    private String stationNameFI;
    @Column(name="station_name_se")
    private String stationNameSE;
    @Column(name="address_fi")
    private String addressFI;
    @Column(name="address_se")
    private String addressSE;
    @Column(name="city_fi")
    private String cityFI;
    @Column(name="city_se")
    private String citySE;
    @Column(name="operator")
    private String operator;
    @Column(name="capacity")
    private int capacity;
    @Column(name="coordinate_x")
    private double x;
    @Column(name="coordinate_y")
    private double y;
    /*@OneToMany(mappedBy= "departureStation",
            fetch=FetchType.EAGER,
            cascade=CascadeType.ALL)
    private List<Journey> journeysFrom;
    @OneToMany(mappedBy="returnStation",
            fetch=FetchType.EAGER,
            cascade=CascadeType.ALL)
    private List<Journey> journeysTo;*/

    public Station(String stationName, int fid,
                   String stationId, String stationNameFI,
                   String stationNameSE, String addressFI,
                   String addressSE, String cityFI,
                   String citySE, String operator,
                   int capacity, double x, double y) {
        this.stationName = stationName;
        this.fid = fid;
        this.stationId = stationId;
        this.stationNameFI = stationNameFI;
        this.stationNameSE = stationNameSE;
        this.addressFI = addressFI;
        this.addressSE = addressSE;
        this.cityFI = cityFI;
        this.citySE = citySE;
        this.operator = operator;
        this.capacity = capacity;
        this.x = x;
        this.y = y;
    }

    protected Station() {}

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getStationNameFI() {
        return stationNameFI;
    }

    public void setStationNameFI(String stationNameFI) {
        this.stationNameFI = stationNameFI;
    }

    public String getStationNameSE() {
        return stationNameSE;
    }

    public void setStationNameSE(String stationNameSE) {
        this.stationNameSE = stationNameSE;
    }

    public String getAddressFI() {
        return addressFI;
    }

    public void setAddressFI(String addressFI) {
        this.addressFI = addressFI;
    }

    public String getAddressSE() {
        return addressSE;
    }

    public void setAddressSE(String addressSE) {
        this.addressSE = addressSE;
    }

    public String getCityFI() {
        return cityFI;
    }

    public void setCityFI(String cityFI) {
        this.cityFI = cityFI;
    }

    public String getCitySE() {
        return citySE;
    }

    public void setCitySE(String citySE) {
        this.citySE = citySE;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Station{");
        sb.append("stationName='").append(stationName).append('\'');
        sb.append(", fid=").append(fid);
        sb.append(", stationId='").append(stationId).append('\'');
        sb.append(", stationNameFI='").append(stationNameFI).append('\'');
        sb.append(", stationNameSE='").append(stationNameSE).append('\'');
        sb.append(", addressFI='").append(addressFI).append('\'');
        sb.append(", addressSE='").append(addressSE).append('\'');
        sb.append(", cityFI='").append(cityFI).append('\'');
        sb.append(", citySE='").append(citySE).append('\'');
        sb.append(", operator='").append(operator).append('\'');
        sb.append(", capacity=").append(capacity);
        sb.append(", x=").append(x);
        sb.append(", y=").append(y);
        sb.append('}');
        return sb.toString();
    }
}
