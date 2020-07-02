package com.example.realproperty.service;

import com.example.realproperty.model.ImageDTO;

import java.util.List;

public interface ImageService {
    void addImage(ImageDTO imageDTO);

    ImageDTO getImageByID(Integer id);

    List<ImageDTO> getAllImageByPropertyID(Integer id);
}
