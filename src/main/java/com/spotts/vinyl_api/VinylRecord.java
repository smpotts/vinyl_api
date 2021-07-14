package com.spotts.vinyl_api;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class VinylRecord {

    private @Id
    @GeneratedValue
    Long recordId;
    private String name;
    private String artist;

    public VinylRecord(String name, String artist) {
        this.name = name;
        this.artist = artist;
    }
}
