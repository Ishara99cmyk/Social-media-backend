package vau.ac.lk.ICAE022022.Model;

public class UserView extends User {
	private int numberofPosts;
	private int numberofComments;
	
	public UserView() {
		
	}

	public UserView(String id, String firstName, String lastName, int age, String email, int numberofPosts,
			int numberofComments) {
		super(id, firstName, lastName, age, email);
		this.numberofPosts = numberofPosts;
		this.numberofComments = numberofComments;
	}

	public int getNumberofPosts() {
		return numberofPosts;
	}

	public void setNumberofPosts(int numberofPosts) {
		this.numberofPosts = numberofPosts;
	}

	public int getNumberofComments() {
		return numberofComments;
	}

	public void setNumberofComments(int numberofComments) {
		this.numberofComments = numberofComments;
	}
}
