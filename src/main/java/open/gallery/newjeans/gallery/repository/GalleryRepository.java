package open.gallery.newjeans.gallery.repository;

import open.gallery.newjeans.gallery.domain.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GalleryRepository extends JpaRepository<Gallery, Long> {

}
