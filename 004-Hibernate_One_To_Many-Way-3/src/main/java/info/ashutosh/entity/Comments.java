package info.ashutosh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;

@Data
@Entity
@Table(name = "comment3")
public class Comments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comment_id")
	private Long comment_id;

	@Type(type = "text")
	private String commentDescription;

	@ManyToOne
	@JoinColumn(name = "post_fid")
	private Post post;

	public Comments(String commentDescription) {
		super();
		this.commentDescription = commentDescription;
	}

	public Comments() {
		// TODO Auto-generated constructor stub
	}

//	@ManyToOne
//	@JoinColumn(name = "post_fid")
//	private Post post;

//	public Comments(String commentDescription, Post post) {
//		super();
//		this.commentDescription = commentDescription;
//		this.post = post;
//	}

//	@Temporal(TemporalType.TIMESTAMP)
//	@CreationTimestamp
//	Date createAt;
//
//	@Temporal(TemporalType.TIMESTAMP)
//	Date updatedAt;
}