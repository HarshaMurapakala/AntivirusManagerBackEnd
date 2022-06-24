package com.example.AntivirusManager.repositories;

import com.example.AntivirusManager.entities.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostRepository extends JpaRepository<Host,String> {
}
