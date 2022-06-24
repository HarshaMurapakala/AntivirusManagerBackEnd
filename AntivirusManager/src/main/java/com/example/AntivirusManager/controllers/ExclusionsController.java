package com.example.AntivirusManager.controllers;

import com.example.AntivirusManager.entities.Exclusions;
import com.example.AntivirusManager.entities.Host;
import com.example.AntivirusManager.repositories.ExclusionsRepository;
import com.example.AntivirusManager.repositories.HostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/exclusions")
public class ExclusionsController {

    @Autowired
    private ExclusionsRepository exclusionsRepository;
    private HostRepository hostRepository;

    @PostMapping("/addExclusion")
    public Exclusions addExclusion(@RequestBody Exclusions exclusion) {
//        Exclusions temp = new Exclusions();

        return exclusionsRepository.save(exclusion);
    }

    @GetMapping("/getExclusionsByHostName/{id}")
    public Exclusions getExclusionsByHostName(@PathVariable(value = "id") String hostName) {
//        String temp = hostName;
//        Host host = hostRepository.findById(hostName).get();
//        Exclusions exclusions= exclusionsRepository.findById(host.getHostName()).get();
//        Exclusions exclusion = exclusionsRepository.findByHost(host);
        Exclusions exclusion = exclusionsRepository.findByHostName(hostName);

        return exclusion;
    }
}
