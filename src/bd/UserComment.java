package bd;

import javafx.scene.chart.PieChart;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tttt on 22.11.2016.
 */
@Entity
@Table(name = "user_comments", schema = "shop")
public class UserComment {
    private int id;
    private String text;
    private String commentDate;

    public UserComment(String text, String userName) {
        this.text = text;
        this.userName = userName;
        SimpleDateFormat format = new SimpleDateFormat("HH:mm dd.MM.yyyy");
        String date = format.format(new Date());
        this.commentDate = date;
    }

    private String userName;

    public UserComment() {
    }

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Text", nullable = true, length = 100)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "CommentDate", nullable = true, length = 50)
    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    @Basic
    @Column(name = "UserName", nullable = true, length = 50)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserComment that = (UserComment) o;

        if (id != that.id) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        if (commentDate != null ? !commentDate.equals(that.commentDate) : that.commentDate != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (commentDate != null ? commentDate.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        return result;
    }
}
