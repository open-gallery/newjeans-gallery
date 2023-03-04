package open.gallery.newjeans.gallery.domain;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
@NoArgsConstructor(access = PROTECTED)
@Entity
@Table(name = "IMAGES")
@Getter
public class Image {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID", nullable = false)
  private Long id;

  @Column(name = "URL", nullable = false)
  private String url;

  @Default
  @OneToMany(mappedBy = "image", cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
  private List<ImageTagMap> imageTagMaps = new ArrayList<>();

  public void addImageTag(ImageTagMap imageTagMap) {
    imageTagMaps.add(imageTagMap);
  }

  public static Image from(String url) {
    return Image.builder()
        .url(url)
        .build();
  }
}
