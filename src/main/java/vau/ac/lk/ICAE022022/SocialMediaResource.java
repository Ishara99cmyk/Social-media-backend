package vau.ac.lk.ICAE022022;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import vau.ac.lk.ICAE022022.Model.Post;
import vau.ac.lk.ICAE022022.Model.UserView;
import vau.ac.lk.ICAE022022.Repo.SocialMediaRepo;

@Path("/SM")
public class SocialMediaResource {
	private SocialMediaRepo repo=new SocialMediaRepo();
	@GET
	@Path("/post/{id}")
	public Post getPost(@PathParam("id") int id) {
		return repo.getPostwithcomments(id);
	}
	
	@GET
	@Path("/users")
	public List<UserView> getAll(){
		return repo.getUsers();
	}

}
