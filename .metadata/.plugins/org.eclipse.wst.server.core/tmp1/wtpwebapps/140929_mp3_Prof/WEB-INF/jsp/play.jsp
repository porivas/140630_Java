<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <h2>${param.song}</h2>

    <audio controls="controls" src="playSong?song=${param.song}" autoplay="autoplay"></audio>