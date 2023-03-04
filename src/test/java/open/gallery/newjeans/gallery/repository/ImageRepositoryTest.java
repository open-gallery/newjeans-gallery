package open.gallery.newjeans.gallery.repository;

import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.EntityManager;
import open.gallery.newjeans.gallery.domain.Image;
import open.gallery.newjeans.gallery.domain.ImageTagMap;
import open.gallery.newjeans.gallery.domain.Tag;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class ImageRepositoryTest {

  @Autowired
  ImageRepository imageRepository;

  @Autowired
  TagRepository tagRepository;

  @Autowired
  EntityManager em;

  @DisplayName("imageTagMap 추가 테스트")
  @Test
  void _1() {
    // given
    Image prevImage = Image.from("test_url");
    Tag tag = tagRepository.save(Tag.from("test_tag"));
    ImageTagMap imageTagMap = ImageTagMap.of(prevImage, tag);

    // when
    prevImage.addImageTag(imageTagMap);
    prevImage = imageRepository.save(prevImage);
    em.flush();
    em.clear();

    // then
    Image savedImage = imageRepository.findById(prevImage.getId()).orElseThrow(() -> new RuntimeException());
    assertThat(savedImage.getImageTagMaps().size()).isEqualTo(1);
  }

  @DisplayName("imageTagMap 삭제 테스트(고아 객체가 된 경우)")
  @Test
  void _2() {
    // given
    Image prevImage = Image.from("test_url");
    Tag tag = tagRepository.save(Tag.from("test_tag"));
    ImageTagMap imageTagMap = ImageTagMap.of(prevImage, tag);
    prevImage.addImageTag(imageTagMap);
    prevImage = imageRepository.save(prevImage);
    em.flush();
    em.clear();

    // when
    Image savedImage = imageRepository.findById(prevImage.getId()).orElseThrow(() -> new RuntimeException());
    savedImage.getImageTagMaps().remove(0);
    em.flush();
    em.clear();

    // then
    savedImage = imageRepository.findById(savedImage.getId()).orElseThrow(() -> new RuntimeException());
    assertThat(savedImage.getImageTagMaps()).isEmpty();
  }
}