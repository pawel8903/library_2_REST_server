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
@Table(name="type")
public class Type {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="type")
	private String type;
	
	@Column(name="shortcut")
	private String shortcut;

	@ManyToMany(mappedBy="types")
	private List<Book> books;
	
	public Type() {
		// TODO Auto-generated constructor stub
	}
	public Type(String type, String shortcut) {
		super();
		this.type = type;
		this.shortcut = shortcut;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getShortcut() {
		return shortcut;
	}

	public void setShortcut(String shortcut) {
		this.shortcut = shortcut;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public void addBook(Book theBook) {
		if(books ==null) {
			books = new ArrayList<>();
		}
		books.add(theBook);
	}
	@Override
	public String toString() {
		return "Type [id=" + id + ", type=" + type + ", shortcut=" + shortcut + "]";
	}
	
	
}
