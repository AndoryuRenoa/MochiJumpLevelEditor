package com.mochijump.leveleditor;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mochijump.leveleditor.Level;

// CRUD refers Create, Read, Update, Delete

public interface LevelRepository extends CrudRepository<Level, Long> {
	public List<Level> findByLevelName (String levelName);
	
	// In order to get a list of names you'll have to use the @Query annotation
	// note: HQL wants the Entity name and object name in my code, the below will work:
	// @Query ("SELECT levelName FROM Level")
	// public List<?> getLevelNames();

}
