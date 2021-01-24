package com.jiangyu.pojo;

public class MovietoCinema {
    private Integer id;

    private Integer movieId;

    private Integer cinemaId;

    
    
    public MovietoCinema() {
		super();
	}

	public MovietoCinema(Integer movieId, Integer cinemaId) {
		super();
		this.movieId = movieId;
		this.cinemaId = cinemaId;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Integer cinemaId) {
        this.cinemaId = cinemaId;
    }
}