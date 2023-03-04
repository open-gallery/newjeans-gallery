package open.gallery.newjeans.gallery.domain;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "TAGS")
@Getter
public class Tag {

  @Id
  @Column(name = "NAME", nullable = false, length = 10)
  private String name;

  @Default
  @OneToMany(mappedBy = "tag")
  private List<ImageTagMap> imageTagMaps = new ArrayList<>();

  public void addImageTagMaps(ImageTagMap imageTagMap) {
    imageTagMaps.add(imageTagMap);
  }

  public static Tag from(String name) {
    return Tag.builder()
        .name(name)
        .build();
  }
}
