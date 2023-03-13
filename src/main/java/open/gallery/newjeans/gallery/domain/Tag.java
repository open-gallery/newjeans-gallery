package open.gallery.newjeans.gallery.domain;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
    name = "TAGS"
)
public class Tag extends BaseEntity {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "ID", nullable = false)
  private Long id;

  @Column(name = "NAME", nullable = false)
  private String name;

  @ManyToOne
  private Gallery gallery;

  public static Tag of(String name, Gallery gallery) {
    return Tag.builder()
        .name(name)
        .gallery(gallery)
        .build();
  }
}
