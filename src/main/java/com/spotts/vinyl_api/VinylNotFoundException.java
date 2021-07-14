package com.spotts.vinyl_api;

/**
 * Custom exception for when the record cannot be found.
 */
public class VinylNotFoundException extends RuntimeException {

    public VinylNotFoundException(Long id) {
        super("Could not find record " + id);
    }
}
