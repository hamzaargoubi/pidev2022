package org.esprit.ib.repositories;

import java.util.List;
import java.util.UUID;

import org.esprit.ib.domain.entities.Client;
import org.esprit.ib.domain.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID>{

	@Query("SELECT p FROM Post p WHERE p.client = :client")
	public List<Post> findByClient(@Param(value = "client") Client client);
}
