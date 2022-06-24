package com.example.AntivirusManager.repositories;

import com.example.AntivirusManager.entities.Exclusions;
import com.example.AntivirusManager.entities.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExclusionsRepository extends CrudRepository<Exclusions,String> {
//    public Exclusions findByHost(Host host);

    @Query("select s from Exclusions s where s.host.hostName = :name")
    Exclusions findByHostName(@Param("name") String name);
}
