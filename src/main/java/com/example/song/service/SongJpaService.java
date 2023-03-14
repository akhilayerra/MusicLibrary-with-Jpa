
package com.example.song.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.song.repository.SongJpaRepository;
import com.example.song.repository.SongRepository;
import java.util.*;
import com.example.song.model.Song;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;


@Service
public class SongJpaService implements SongRepository {

  @Autowired
  private SongJpaRepository songJpaRepository;

  @Override
  public ArrayList<Song> getSongs(){
    List<Song> songs1=songJpaRepository.findAll();
    ArrayList<Song> songs=new ArrayList<>(songs1);
    return songs;
  }
  @Override
  public Song getSongById(int songId){
    try{
    Song song=songJpaRepository.findById(songId).get();
    return song;
    } catch (Exception e) {

      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  }

   @Override
  public Song addSong(Song playlist) {

    try {
      songJpaRepository.save(playlist);
      return playlist;
    }catch(Exception e){
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  }
  @Override
  public Song updateSong(int songId, Song playlist) {
    try {
      Song newSong =songJpaRepository.findById(songId).get();
      if (playlist.getSongName() != null) {
        newSong.setSongName(playlist.getSongName());
      }
      if (playlist.getLyricist() != null) {
        newSong.setLyricist(playlist.getLyricist());
      }
      if (playlist.getSinger() != null) {
        newSong.setSinger(playlist.getSinger());
      }
      if (playlist.getMusicDirector() != null) {
        newSong.setMusicDirector(playlist.getMusicDirector());
      }
      songJpaRepository.save(newSong);

      return newSong;

    } catch(Exception e){

      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

  }
    @Override
  public void deleteSong(int songId) {
    try {

      songJpaRepository.deleteById(songId);
    } catch (Exception e) {

      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
      
  }

  
}