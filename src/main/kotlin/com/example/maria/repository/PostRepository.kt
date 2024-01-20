package com.example.maria.repository

import com.example.maria.Entity.PostEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository: JpaRepository<PostEntity, Long>

//JpaRepository 상속 받은 PostRepository