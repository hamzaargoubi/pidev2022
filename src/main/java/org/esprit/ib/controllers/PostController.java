package org.esprit.ib.controllers;

import java.util.List;
import java.util.UUID;

import org.esprit.ib.domain.entities.Client;
import org.esprit.ib.domain.entities.Post;
import org.esprit.ib.domain.entities.Transaction;
import org.esprit.ib.services.interfaces.IClientService;
import org.esprit.ib.services.interfaces.IPostService;
import org.esprit.ib.services.interfaces.ITransactionService;
import org.esprit.ib.utils.TokenPlayLoadExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("post")
public class PostController {
	@Autowired
    private IPostService postService;
	
	@Autowired
	private IClientService clientService;

    @PostMapping("")
    public void addPost(@RequestBody Post post , @RequestHeader("Authorization") String token) {
    	Client client = clientService.getClientByEmail(TokenPlayLoadExtractor.extract(token).get("sub"));
    	post.setClient(client);
    	postService.save(post);
    }

    @PutMapping("")
    public void updatePost(@RequestHeader("Authorization") String token,@RequestBody Post post) {
    	Client client = clientService.getClientByEmail(TokenPlayLoadExtractor.extract(token).get("sub"));
    	if(client.getUuid().equals(post.getClient().getUuid()))
    	{
    		post.setClient(client);
    		postService.save(post);
    	}
    	
    }
    
    @DeleteMapping("/{uuid}")
    public void deletePost(@PathVariable("uuid") UUID uuid,@RequestHeader("Authorization") String token) {
    	Client client = clientService.getClientByEmail(TokenPlayLoadExtractor.extract(token).get("sub"));
    	Post post = postService.getPostById(uuid);
    	if(client.getUuid().equals(post.getClient().getUuid()))
    	{
    	postService.delete(uuid);
    	}
    }

    @GetMapping("/{uuid}")
    public Post getPost(@PathVariable("uuid") UUID uuid) {
        return postService.getPostById( uuid);
    }

    @GetMapping("")
    public List<Post> getPosts(){
        return postService.getPosts();
    }
    
    @GetMapping("user-posts")
    public List<Post> getClientPosts(@RequestHeader("Authorization") String token) {
    	Client client = clientService.getClientByEmail(TokenPlayLoadExtractor.extract(token).get("sub"));
    	return postService.getPostsByClient(client);
    }
}
