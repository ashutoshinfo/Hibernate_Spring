package info.ashutosh.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "post")
public class Post {

	private Integer id;

}
