package org.esprit.ib.services.interfaces;

import java.util.List;
import java.util.UUID;

import org.esprit.ib.domain.entities.Client;
import org.esprit.ib.domain.entities.Post;


public interface IPostService {
	public List<Post> getPostsByClient(Client client);
	public void save(Post post);
	public void delete(UUID uuid);
	public Post getPostById(UUID uuid);
	public List<Post> getPosts();

}
