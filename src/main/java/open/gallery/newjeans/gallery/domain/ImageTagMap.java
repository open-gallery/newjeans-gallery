package open.gallery.newjeans.gallery.domain;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
@NoArgsConstructor(access = PROTECTED)
@Entity
@Table(
    name = "IMAGE_TAG_MAP",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "primaryImageTag",
            columnNames = {"IMAGE_ID", "TAG_NAME"}
        )
    }
)
public class ImageTagMap {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID", nullable = false)
  private Long id;

  @ManyToOne
  private Image image;

  @ManyToOne
  private Tag tag;

  public static ImageTagMap of(Image image, Tag tag) {
    return ImageTagMap.builder()
        .image(image)
        .tag(tag)
        .build();
  }
}
