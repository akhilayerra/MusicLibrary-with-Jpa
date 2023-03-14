package com.example.song.repository;

import com.example.song.model.Song;

import java.util.ArrayList;
public interface SongRepository{
    ArrayList<Song> getSongs();
    Song getSongById(int songId);
    Song addSong(Song playlist);
    Song updateSong(int songId,Song playlist);
    void deleteSong(int songId);
}