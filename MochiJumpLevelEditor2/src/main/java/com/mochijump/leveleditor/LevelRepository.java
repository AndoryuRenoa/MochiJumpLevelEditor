package com.mochijump.leveleditor;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mochijump.leveleditor.Level;

// CRUD refers Create, Read, Update, Delete

public interface LevelRepository extends CrudRepository<Level, Long> {
	public List<Level> findByLevelName (String levelName);
	

	@Query ("SELECT levelName FROM Level")
	public List<?> getLevelNames();

}
