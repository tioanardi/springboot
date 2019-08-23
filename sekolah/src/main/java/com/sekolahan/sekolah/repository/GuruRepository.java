package com.sekolahan.sekolah.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sekolahan.sekolah.model.Guru;

@Repository
public interface GuruRepository extends JpaRepository<Guru, Long>{

}
