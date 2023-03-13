package open.gallery.newjeans.gallery.domain;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
@NoArgsConstructor(access = PROTECTED)
@Entity
@Getter
@Table(name = "GALLERIES")
public class Gallery {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", nullable = false)
  private Long id;

  @Column(name = "NAME", nullable = false)
  private String name;

  @Column(name = "URL", nullable = false)
  private String url;

  @OneToMany(
      mappedBy = "gallery",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  @Builder.Default
  Set<Tag> tags = new HashSet<>();

  @OneToMany(
      mappedBy = "gallery",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  @Builder.Default
  Set<Image> images = new HashSet<>();

  @OneToMany(
      mappedBy = "gallery",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  @Builder.Default
  Set<ImageTagMap> imageTagMaps = new HashSet<>();

  public static Gallery of(String name, String url) {
    return Gallery.builder()
        .name(name)
        .url(url)
        .build();
  }
}