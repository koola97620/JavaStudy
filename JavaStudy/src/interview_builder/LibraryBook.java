package interview_builder;

import static org.junit.Assert.*;

import org.junit.Test;

class BookType {
	public static BookType FICTION;
	
}

public class LibraryBook {
	
	public static class Builder {
		private BookType bookType = BookType.FICTION;
		private String bookName;
		
		public Builder withBookType(final BookType bookType) {
			this.bookType = bookType;
			return this;
		}
		
		public Builder withBookName(final String bookName) {
			this.bookName = bookName;
			return this;
		}
		
		public LibraryBook build() {
			return new LibraryBook(bookType, bookName);
		}
		
	}
	
	private BookType bookType=BookType.FICTION;
	private String bookName;
	
	public LibraryBook(final BookType bookType , final String bookName) {
		this.bookType = bookType;
		this.bookName = bookName;
	}
	
	@Test
	public void fictionLibraryBook() {
		final LibraryBook.Builder builder = new LibraryBook.Builder();
		final LibraryBook book = builder.withBookName("war and peace").build();
		assertEquals(BookType.FICTION , book.getClass());
	}
	public static void main(String[] args) {

	}

}
