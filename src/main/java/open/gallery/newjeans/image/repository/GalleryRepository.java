package open.gallery.newjeans.image.repository;

import open.gallery.newjeans.image.domain.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GalleryRepository extends JpaRepository<Gallery, Long> {

}
