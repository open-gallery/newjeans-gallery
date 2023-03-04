package open.gallery.newjeans.gallery.repository;

import open.gallery.newjeans.gallery.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, String> {

}
