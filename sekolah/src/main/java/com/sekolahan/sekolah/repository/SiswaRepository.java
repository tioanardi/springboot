package com.sekolahan.sekolah.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sekolahan.sekolah.model.Siswa;


@Repository
public interface SiswaRepository extends JpaRepository<Siswa, Long>{

}