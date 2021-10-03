package com.tolgakmbl.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tolgakmbl.hrms.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language, String>{

}
