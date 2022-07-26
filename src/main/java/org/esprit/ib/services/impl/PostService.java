package org.esprit.ib.services.impl;

import java.util.List;
import java.util.UUID;

import org.esprit.ib.domain.entities.Client;
import org.esprit.ib.domain.entities.Post;
import org.esprit.ib.repositories.PostRepository;
import org.esprit.ib.services.interfaces.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService implements IPostService{

	@Autowired
	private PostRepository postRepository;
	@Override
	public void save(Post post) {
		postRepository.save(post);
		
	}

	@Override
	public void delete(UUID uuid) {
		postRepository.deleteById(uuid);
	}

	@Override
	public Post getPostById(UUID uuid) {
		// TODO Auto-generated method stub
		return postRepository.findById(uuid).orElse(null);
	}

	@Override
	public List<Post> getPosts() {
		// TODO Auto-generated method stub
		return postRepository.findAll();
	}

	@Override
	public List<Post> getPostsByClient(Client client) {
		// TODO Auto-generated method stub
		return postRepository.findByClient(client);
	}

}
