package open.gallery.newjeans.image.domain;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import open.gallery.newjeans.common.BaseEntity;

@Builder(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
@NoArgsConstructor(access = PROTECTED)
@Entity
@Getter
@Table(
    name = "IMAGES",
    indexes = {
        @Index(name = "idx_uploader_id", columnList = "UPLOADER_ID"),
        @Index(name = "idx_gallery_id", columnList = "GALLERY_ID")
    }
)
public class Image extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID", nullable = false)
  private Long id;

  @Column(name = "URL", nullable = false)
  private String url;

  @Column(name = "UPLOADER_ID", nullable = false)
  private Long uploaderId;

  @Column(name = "LIKE_COUNT", columnDefinition = "bigint default 0")
  private Long likeCount;

  @Column(name = "GALLERY_ID", nullable = false)
  private Long galleryId;

  @Default
  @OneToMany(
      mappedBy = "image",
      cascade = {CascadeType.REMOVE, CascadeType.PERSIST},
      orphanRemoval = true
  )
  private List<ImageTagMap> imageTagMaps = new ArrayList<>();

  public void addImageTag(ImageTagMap imageTagMap) {
    imageTagMaps.add(imageTagMap);
  }

  public static Image from(String url, Long uploaderId, Long galleryId) {
    return Image.builder()
        .url(url)
        .uploaderId(uploaderId)
        .galleryId(galleryId)
        .build();
  }
}
