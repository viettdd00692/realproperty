package com.example.realproperty.dao;

import com.example.realproperty.entity.Image;

import java.util.List;

public interface ImageDao {
    void addImage(Image image);

    Image getImageByID(Integer id);

    List<Image> getAllImage();
}
