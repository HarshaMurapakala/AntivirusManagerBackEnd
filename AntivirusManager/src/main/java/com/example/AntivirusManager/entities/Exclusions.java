package com.example.AntivirusManager.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Exclusions{



    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "host_name", nullable = false)
    private Host host;

    @Id
    @Column(name= "ip_address")
    private String ipAddress;

    private String folderPath;

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getFolderPath() {
        return folderPath;
    }

    public void setFolderPath(String folderPath) {
        this.folderPath = folderPath;
    }
}
