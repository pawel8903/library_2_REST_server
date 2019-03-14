package pl.pawel.restServerSide.entity;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="books")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="author")
	private String author;
	
	@Column(name="description")
	private String description;
	
	@Column(name="available_number")
	private int availableNumber;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="book_type",
			joinColumns=@JoinColumn(name="FK_book"),
			inverseJoinColumns=@JoinColumn(name="FK_type"))
	private List<Type> types;
	
	public Book() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public int getAvailableNumber() {
		return availableNumber;
	}

	public void setAvailableNumber(int availableNumber) {
		this.availableNumber = availableNumber;
	}

	public List<Type> getTypes() {
		return types;
	}

	public void setTypes(List<Type> types) {
		this.types = types;
	}

	public void addType(Type type) {
		if(types == null) {
			types = new ArrayList<>();
		}
		types.add(type);
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", description=" + description
				+ ", availableNumber=" + availableNumber + ", types=" + types + "]";
	}
	
	
	
}
