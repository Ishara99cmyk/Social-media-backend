package vau.ac.lk.ICAE022022.Model;

import java.sql.Date;

public class Comment {
	private int id;
	private String comment;
	private Date comentedDate;
	private User commentedBy;
	private Post commentedIn;
	
	public Comment() {
		
	}

	public Comment(int id, String comment, Date comentedDate, User commentedBy, Post commentedIn) {
		super();
		this.id = id;
		this.comment = comment;
		this.comentedDate = comentedDate;
		this.commentedBy = commentedBy;
		this.commentedIn = commentedIn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getComentedDate() {
		return comentedDate;
	}

	public void setComentedDate(Date comentedDate) {
		this.comentedDate = comentedDate;
	}

	public User getCommentedBy() {
		return commentedBy;
	}

	public void setCommentedBy(User commentedBy) {
		this.commentedBy = commentedBy;
	}

	public Post getCommentedIn() {
		return commentedIn;
	}

	public void setCommentedIn(Post commentedIn) {
		this.commentedIn = commentedIn;
	}
	
}
