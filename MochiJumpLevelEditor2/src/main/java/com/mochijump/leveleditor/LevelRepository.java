package com.mochijump.leveleditor;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mochijump.leveleditor.Level;

// CRUD refers Create, Read, Update, Delete

public interface LevelRepository extends CrudRepository<Level, Long> {
	public List<Level> findByLevelName (String levelName);
	
	// In order to get a list of names you'll have to use the @Query annotation
	// @Query ("SELECT level_name FROM level")
	// public List<?> getLevelNames(); <- should work but want to check db table for correct column name

}
