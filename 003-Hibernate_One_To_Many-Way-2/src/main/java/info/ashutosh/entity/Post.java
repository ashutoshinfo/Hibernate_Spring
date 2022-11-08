package info.ashutosh.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "post2")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id")
	private Long postId;

	private String title;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "post_fid")
	private List<Comments> comments = new ArrayList<>();

	public void setComments(Comments comments) {
		this.comments.add(comments);
	}

//	@Temporal(TemporalType.TIMESTAMP)
//	@CreationTimestamp
//	Date createAt;
//
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date updatedAt;
}