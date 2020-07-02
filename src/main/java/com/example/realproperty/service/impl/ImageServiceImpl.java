package com.example.realproperty.service.impl;

import com.example.realproperty.dao.ImageDao;
import com.example.realproperty.entity.Image;
import com.example.realproperty.entity.Property;
import com.example.realproperty.model.ImageDTO;
import com.example.realproperty.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageDao imageDao;

    @Override
    public void addImage(ImageDTO imageDTO) {
        Image image = new Image();
        image.setImage(imageDTO.getImage());
        if (imageDTO.getPropertyId() != null) {
            image.setProperty(new Property(imageDTO.getPropertyId()));
        }

        imageDao.addImage(image);
        imageDTO.setId(image.getId());
    }

    @Override
    public ImageDTO getImageByID(Integer id) {
        Image image = imageDao.getImageByID(id);
        ImageDTO imageDTO = new ImageDTO();

        imageDTO.setId(image.getId());
        imageDTO.setImage(image.getImage());
        if (image.getProperty() != null) {
            imageDTO.setPropertyId(image.getProperty().getId());
        }

        return imageDTO;
    }

    @Override
    public List<ImageDTO> getAllImageByPropertyID(Integer id) {
        List<Image> images = imageDao.getAllImage();
        List<ImageDTO> imageDTOs = new ArrayList<ImageDTO>();

        images.forEach(image -> {
            if (image.getProperty().getId() == id) {
                ImageDTO imageDTO = new ImageDTO();

                imageDTO.setId(image.getId());
                imageDTO.setImage(image.getImage());
                if (image.getProperty() != null) {
                    imageDTO.setPropertyId(image.getProperty().getId());
                }

                imageDTOs.add(imageDTO);
            }
        });

        return imageDTOs;
    }
}