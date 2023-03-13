package open.gallery.newjeans.gallery.domain;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
        @Index(name = "idx_uploader_id", columnList = "UPLOADER_ID")
    }
)
public class Image extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", nullable = false)
  private Long id;

  @Column(name = "URL", nullable = false)
  private String url;

  @Column(name = "UPLOADER_ID", nullable = false)
  private Long uploaderId;

  @Column(name = "LIKE_COUNT", columnDefinition = "bigint default 0")
  private Long likeCount;

  @ManyToOne
  private Gallery gallery;

  public static Image of(String url, Long uploaderId, Gallery gallery) {
    return Image.builder()
        .url(url)
        .uploaderId(uploaderId)
        .gallery(gallery)
        .build();
  }
}
