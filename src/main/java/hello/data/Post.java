package hello.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "post")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Post {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_seq")
    @SequenceGenerator(
            name = "post_seq",
            sequenceName = "post_sequence",
            allocationSize = 20
    )
    private Integer postId;

    @Column(name = "post_content")
    private String postContent;

    @Column(name = "img")
    private String image;

    @Column(name = "likes")
    private Integer like;

    @Column(name = "dislikes")
    private Integer dislike;

    @Column(name = "post_time")
    private Timestamp postTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User owner;

//    @JsonIgnore
//    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
//    @JoinColumn(name = "sender")
//    private User sender;
//
    @JsonIgnore
    @OneToMany(
            //cascade =   CascadeType.REMOVE,
             fetch = FetchType.EAGER, mappedBy = "post")
    private List<Comment> comment;
//
//    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "post")
//    private List<Rating> ratings;


    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Integer getDislike() {
        return dislike;
    }

    public void setDislike(Integer dislike) {
        this.dislike = dislike;
    }

    public Timestamp getPostTime() {
        return postTime;
    }

    public void setPostTime(Timestamp dateDispatch) {
        this.postTime = dateDispatch;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }
}
