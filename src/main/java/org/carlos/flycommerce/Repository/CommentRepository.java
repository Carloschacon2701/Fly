package org.carlos.flycommerce.Repository;

import org.carlos.flycommerce.Models.MySql.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findAllByHotel_Id(Integer hotel_id);


    List<Comment> findAllByUser_IdAndHotel_Id(Integer user_id, Integer hotel_id);

}
