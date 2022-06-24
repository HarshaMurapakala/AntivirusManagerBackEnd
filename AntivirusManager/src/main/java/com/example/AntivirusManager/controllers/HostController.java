package com.example.AntivirusManager.controllers;

import com.example.AntivirusManager.entities.Host;
import com.example.AntivirusManager.repositories.HostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class HostController {

    @Autowired
    private HostRepository hostRepository;

    @PostMapping("/addHost")
    public Host addHostDetails(@RequestBody Host host) {
        return hostRepository.save(host);
    }


    @GetMapping("/getHostById/{id}")
    public ResponseEntity<Host> getHostByName(@PathVariable(value = "id") String hostName) {
        Host host = hostRepository.findById(hostName).get();
        return ResponseEntity.ok().body(host);
    }

    @GetMapping("/getAllHosts")
    public ResponseEntity<List<Host>> getAllHosts() {
        List<Host> hosts = hostRepository.findAll();
        return ResponseEntity.ok().body(hosts);
    }
   

}
