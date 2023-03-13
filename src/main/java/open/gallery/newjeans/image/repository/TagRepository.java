package open.gallery.newjeans.image.repository;

import open.gallery.newjeans.image.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, String> {

}
