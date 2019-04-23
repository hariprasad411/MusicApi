package com.music.album.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.music.album.entity.Album;

@Repository
public interface MusicRepository extends CrudRepository<Album, Integer>{

	void saveAll(List<com.music.album.domain.Album> albumEntityList);

}
