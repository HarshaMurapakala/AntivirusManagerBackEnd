package com.example.AntivirusManager.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
public class Host implements Serializable {

    @Id
   @Column(name= "host_name")
    private String hostName;


    private Boolean antispywareEnabled;
    private long antispywareSignatureAge;
    private String antispywareSignatureLastUpdated;
    private String antispywareSignatureVersion;
    private Boolean antivirusEnabled;
    private long antivirusSignatureAge;
    private String antivirusSignatureLastUpdated;
    private String antivirusSignatureVersion;
    private Boolean behaviorMonitorEnabled;
    private String computerID;


    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "host")
    @JsonIgnore
    private Exclusions exclusions;

    public Boolean getAntispywareEnabled() {
        return antispywareEnabled;
    }

    public void setAntispywareEnabled(Boolean AntispywareEnabled) {
        antispywareEnabled = AntispywareEnabled;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getHostName() {
        return hostName;
    }

    public long getAntispywareSignatureAge() {
        return antispywareSignatureAge;
    }

    public void setAntispywareSignatureAge(long AntispywareSignatureAge) {
        antispywareSignatureAge = AntispywareSignatureAge;
    }

    public String getAntispywareSignatureLastUpdated() {
        return antispywareSignatureLastUpdated;
    }

    public void setAntispywareSignatureLastUpdated(String AntispywareSignatureLastUpdated) {
        antispywareSignatureLastUpdated = AntispywareSignatureLastUpdated;
    }

    public String getAntispywareSignatureVersion() {
        return antispywareSignatureVersion;
    }

    public void setAntispywareSignatureVersion(String AntispywareSignatureVersion) {
        antispywareSignatureVersion = AntispywareSignatureVersion;
    }

    public Boolean getAntivirusEnabled() {
        return antivirusEnabled;
    }

    public void setAntivirusEnabled(Boolean AntivirusEnabled) {
        antivirusEnabled = AntivirusEnabled;
    }

    public long getAntivirusSignatureAge() {
        return antivirusSignatureAge;
    }

    public void setAntivirusSignatureAge(long AntivirusSignatureAge) {
        antivirusSignatureAge = AntivirusSignatureAge;
    }

    public String getAntivirusSignatureLastUpdated() {
        return antivirusSignatureLastUpdated;
    }

    public void setAntivirusSignatureLastUpdated(String AntivirusSignatureLastUpdated) {
        antivirusSignatureLastUpdated = AntivirusSignatureLastUpdated;
    }

    public String getAntivirusSignatureVersion() {
        return antivirusSignatureVersion;
    }

    public void setAntivirusSignatureVersion(String AntivirusSignatureVersion) {
        antivirusSignatureVersion = AntivirusSignatureVersion;
    }

    public Boolean getBehaviorMonitorEnabled() {
        return behaviorMonitorEnabled;
    }

    public void setBehaviorMonitorEnabled(Boolean BehaviorMonitorEnabled) {
        behaviorMonitorEnabled = BehaviorMonitorEnabled;
    }

    public String getComputerID() {
        return computerID;
    }

    public void setComputerID(String ComputerID) {
        computerID = ComputerID;
    }
}
