package org.carlos.flycommerce.Repository;

import org.carlos.flycommerce.Models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
