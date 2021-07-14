package com.spotts.vinyl_api;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface with methods supporting creating, reading, updating, and deleting records
 * against a backend data store. Allows us to sidestep data store specifics.
 */
public interface VinylRepository extends JpaRepository<VinylRecord, Long> {
}
