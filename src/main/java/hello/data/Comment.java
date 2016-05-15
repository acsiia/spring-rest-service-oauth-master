package hello.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_seq")
    @SequenceGenerator(
            name = "comment_seq",
            sequenceName = "comment_sequence",
            allocationSize = 20
    )
    private Integer id;

    private String comment;

//    @JsonIgnore
    @ManyToOne(
           // cascade = CascadeType.REFRESH,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "sender")
    private User sender;

   // @JsonIgnore
    @ManyToOne(
          //  cascade = CascadeType.REMOVE,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id")
    private Post post;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
