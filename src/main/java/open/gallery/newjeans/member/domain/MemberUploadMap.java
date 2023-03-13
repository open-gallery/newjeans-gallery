package open.gallery.newjeans.member.domain;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

import java.util.Objects;
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
import lombok.NoArgsConstructor;
import open.gallery.newjeans.common.BaseEntity;

@Builder(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
@NoArgsConstructor(access = PROTECTED)
@Entity
@Table(name = "MEMBER_UPLOAD_MAPS",
    indexes = {
        @Index(name = "idx_image_id", columnList = "IMAGE_ID")
    }
)
public class MemberUploadMap extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID", nullable = false)
  private Long id;

  @ManyToOne
  private Member member;

  @Column(name = "IMAGE_ID", nullable = false)
  private Long imageId;

  @Column(name = "PENDING", nullable = false, columnDefinition = "boolean default true")
  private Boolean pending;

  public static MemberUploadMap of(Member member, Long imageId) {
    return MemberUploadMap.builder()
        .member(member)
        .imageId(imageId)
        .pending(true)
        .build();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MemberUploadMap that = (MemberUploadMap) o;
    return Objects.equals(member, that.member) && Objects.equals(imageId, that.imageId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(member, imageId);
  }
}
