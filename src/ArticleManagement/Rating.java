package ArticleManagement;

public class Rating {

	private String memberFirstName;
	private String memberLastName;
	private int rating;
	private String comment;
	private String date;
	
	
	
	public Rating(String memberFirstName, String memberLastName, int rating,
			String comment, String date) {
		super();
		this.memberFirstName = memberFirstName;
		this.memberLastName = memberLastName;
		this.rating = rating;
		this.comment = comment;
		this.date = date;
	}
	
	public String getMemberFirstName() {
		return memberFirstName;
	}
	public void setMemberFirstName(String memberFirstName) {
		this.memberFirstName = memberFirstName;
	}
	public String getMemberLastName() {
		return memberLastName;
	}
	public void setMemberLastName(String memberLastName) {
		this.memberLastName = memberLastName;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
