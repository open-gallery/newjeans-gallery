package open.gallery.newjeans.image.domain;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import open.gallery.newjeans.common.BaseEntity;

@Builder(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
@NoArgsConstructor(access = PROTECTED)
@Entity
@Getter
@Table(
    name = "IMAGE_TAG_MAPS",
    indexes = {
        @Index(name = "idx_image_id", columnList = "IMAGE_ID"),
        @Index(name = "idx_tag_id", columnList = "TAG_ID")
    }
)
@ToString
public class ImageTagMap extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID", nullable = false)
  private Long id;

  @Column(name = "IMAGE_ID", nullable = false)
  private Long imageId;

  @Column(name = "TAG_ID", nullable = false)
  private Long tagId;

  public static ImageTagMap of(Long imageId, Long tagId) {
    return ImageTagMap.builder()
        .imageId(imageId)
        .tagId(tagId)
        .build();
  }
}
