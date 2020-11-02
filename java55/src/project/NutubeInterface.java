package project;

import java.util.ArrayList;

public interface NutubeInterface {
	void showThumbnail();					//영상썸네일+영상정보보여주기
	ArrayList<Movie> recommendedList();	//추천리스트반환
	ArrayList<Movie> search();				//검색결과반환
	void like();								//좋아요
	void addMyList();							//마이리스트
	void comment();							//댓글
}